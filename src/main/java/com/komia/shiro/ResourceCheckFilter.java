package com.komia.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class ResourceCheckFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		Subject subject = getSubject(request, response);
		String url = getPathWithinApplication(request);
		/*Session session = subject.getSession();
		if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            throw new InvalidSessionException();
        }*/
		return subject.isPermitted(url);
	}
}
