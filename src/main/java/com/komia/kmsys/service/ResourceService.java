package com.komia.kmsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.komia.kmsys.dao.IResourceDao;
import com.komia.kmsys.po.Resource;

@Service
public class ResourceService {
	@Autowired
	private IResourceDao resourceDao;
	
	public void add(Resource res) {
		// TODO Auto-generated method stub

	}

	public void update(Resource res) {
		// TODO Auto-generated method stub

	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public Resource load(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Resource> getResources() {
		return resourceDao.getResources();
	}

	public List<Resource> getResourcesByUid(int uid) {
		return resourceDao.getResourcesByUid(uid);
	}

}
