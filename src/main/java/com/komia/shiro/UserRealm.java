package com.komia.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.komia.kmsys.po.Resource;
import com.komia.kmsys.po.Role;
import com.komia.kmsys.po.User;
import com.komia.kmsys.service.UserService;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User) principals.getPrimaryPrincipal();
		List<Role> roles = this.userService.getRoleListByUserId(user.getId());
		List<String> roleStrs = new ArrayList<String>();
		if(roles != null&& roles.size()>0) {
			for (Role role : roles) {
				roleStrs.add(role.getSn());
			}
		}
		
		List<Resource> resources = this.userService.getResourceByUserId(user.getId());
		List<String> permissions = new ArrayList<String>();
		
		for (Resource res : resources) {
			permissions.add(res.getUrl());
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(new HashSet<String>(roleStrs));
		info.setStringPermissions(new HashSet<String>(permissions));
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = token.getPrincipal().toString();
		String password = new String((char[])token.getCredentials());
		
		User user = this.userService.login(username, password);//登录获取用户信息
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		info.setCredentialsSalt(ByteSource.Util.bytes(user.getUsername()));
		return info;
	}

	@Override
	protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		User user = (User) principals.getPrimaryPrincipal();
		SimplePrincipalCollection spc = new SimplePrincipalCollection(user.getUsername(), getName());
		super.clearCachedAuthorizationInfo(spc);
	}
}
