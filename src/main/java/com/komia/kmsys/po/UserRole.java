package com.komia.kmsys.po;

import org.apache.ibatis.type.Alias;

@Alias("SysUserRole")
public class UserRole {
	private int id;
	private int userId;
	private int roleId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
