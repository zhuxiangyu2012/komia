package com.komia.shiro;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

public class UrlPermissionResolver implements PermissionResolver {

	@Override
	public Permission resolvePermission(String permissionStr) {
		if(permissionStr.startsWith("/")) {
			return new UrlPermission(permissionStr);
		}
		return new WildcardPermission(permissionStr);
	}

}
