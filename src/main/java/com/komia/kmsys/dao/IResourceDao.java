package com.komia.kmsys.dao;

import java.util.List;

import com.komia.kmsys.po.Resource;


public interface IResourceDao {
	/**
	 * 获取所有资源
	 * @return
	 */
	public List<Resource> getResources();
	
	/**
	 * 根据用户ID获取资源
	 * @return
	 */
	public List<Resource> getResourcesByUid(int uid);
	
	/**
	 * 根据用户ID获取权限资源
	 * @return
	 */
	public List<Resource> getPermissionsByUid(int uid);
}
