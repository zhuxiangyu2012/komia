package com.komia.kmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.komia.kmsys.po.Resource;
import com.komia.kmsys.po.Role;
import com.komia.kmsys.po.User;
import com.komia.kmsys.vo.UserSearchVo;

public interface IUserDao {
	public void unlock(int uid);
	
	public void lock(User u);
	
	public void addFailcnt(int uid);
	
	public void addUser(User u);
	
	public List<Role> getRoleListByUserId(int uid);
	
	public List<User> getUsers(@Param("userSearch")UserSearchVo userSearch,@Param("pageSize") int pageSize,@Param("offset") int offset);
	
	public int getUsersCount(@Param("userSearch")UserSearchVo userSearch);
	
	public List<User> getUsersByRoleId(int rid);
	
	public User getUserByUserId(String uid);
	
	public User getUserByUserName(String username);
	
	public List<Resource> getResourceByUserId(int uid);
}
