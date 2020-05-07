package com.komia.kmsys.dao;

import java.util.List;

import com.komia.kmsys.po.Resource;
import com.komia.kmsys.po.Role;
import com.komia.kmsys.po.User;

public interface IUserDao {
	public void unlock(int uid);
	
	public void lock(User u);
	
	public void addFailcnt(int uid);
	
	public void addUser(User u);
	
	public List<Role> getRoleListByUserId(int uid);
	
	public List<User> getAllUsers();
	
	public List<User> getUsersByRoleId(int rid);
	
	public User getUserByUserId(String uid);
	
	public User getUserByUserName(String username);
	
	public List<Resource> getResourceByUserId(int uid);
}
