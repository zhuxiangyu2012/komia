package com.komia.kmsys.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.komia.kmsys.dao.IRoleDao;
import com.komia.kmsys.po.Role;
import com.komia.kmsys.po.UserRole;

@Service
public class RoleService {
	
	@Autowired
	private IRoleDao roleDao;
	
	
	public void add(Role role) {
		roleDao.addRole(role);
	}

	public void delete(int id) {
		roleDao.deleteRole(id);
	}

	public Role load(int id) {
		return roleDao.loadRole(id);
	}

	public List<Role> getRoles() {
		return roleDao.getRoles();
	}

	public List<Role> getUserRoles(int uid) {
		return roleDao.getUserRole(uid);
	}

	public UserRole getUserRole(int uid, int roleId) {
		return roleDao.getUserRoleByRoleId(uid, roleId);
	}

	public void addUserRole(int uid, int roleId) {
		roleDao.addUserRole(uid, roleId);
	}

	public void deleteUserRole(int uid, int roleId) {
	}

}
