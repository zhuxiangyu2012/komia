package com.komia.kmsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.komia.kmsys.po.Resource;
import com.komia.kmsys.po.Role;
import com.komia.kmsys.po.RoleResource;
import com.komia.kmsys.po.UserRole;


public interface IRoleDao {
	public void addRole(Role role);
	
	public void deleteRole(int id);
	
	public Role loadRole(int id);
	
	public void updateRole(Role role);
	
	public List<Role> getRoles();
	
	public List<Role> getUserRole(int uid);
	
	public UserRole getUserRoleByRoleId(@Param("uid") int uid,@Param("roleId") int roleId);
	
	public void addUserRole(@Param("uid") int uid,@Param("roleId") int roleId);
	
	public void deleteUserRoles(int uid);
	
	public List<Resource> getRoleResources(int roleId);
	
	public void addRoleResource(@Param("roleId") int roleId,@Param("resId") int resId);
	
	public void deleteRoleResource(@Param("roleId") int roleId,@Param("resId") int resId);
	
	public RoleResource getRoleResource(@Param("roleId") int roleId,@Param("resId") int resId);
	
}
