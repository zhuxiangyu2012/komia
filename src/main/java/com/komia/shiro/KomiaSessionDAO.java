package com.komia.shiro;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.komia.util.SerializableUtils;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class KomiaSessionDAO extends CachingSessionDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        String sql = "insert into sys_sessions(id, session, date) values(?,?,?)";
        jdbcTemplate.update(sql, sessionId, SerializableUtils.serialize(session),new Date());
        return session.getId();
    }
    @Override
    protected void doUpdate(Session session) {
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return; //如果会话过期/停止 没必要再更新了
        }
        String sql = "update sys_sessions set session=? , date = ? where id=?";
        jdbcTemplate.update(sql, SerializableUtils.serialize(session),new Date(), session.getId());
    }
    @Override
    protected void doDelete(Session session) {
        String sql = "delete from sys_sessions where id=?";
        jdbcTemplate.update(sql, session.getId());
    }
    @Override
    protected Session doReadSession(Serializable sessionId) {
        String sql = "select session from sys_sessions where id=?";
        List<String> sessionStrList = jdbcTemplate.queryForList(sql, String.class, sessionId);
        if(sessionStrList.size() == 0) return null;
        return SerializableUtils.deserialize(sessionStrList.get(0));
    }
}