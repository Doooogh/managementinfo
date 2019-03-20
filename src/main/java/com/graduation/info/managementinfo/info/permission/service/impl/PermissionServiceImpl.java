package com.graduation.info.managementinfo.info.permission.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.permission.dao.PermissionDao;
import com.graduation.info.managementinfo.info.permission.domain.PermissionDO;
import com.graduation.info.managementinfo.info.permission.service.PermissionService;



@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	public PermissionDO get(Integer id){
		return permissionDao.get(id);
	}
	
	@Override
	public List<PermissionDO> list(Map<String, Object> map){
		return permissionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return permissionDao.count(map);
	}
	
	@Override
	public int save(PermissionDO permission){
		return permissionDao.save(permission);
	}
	
	@Override
	public int update(PermissionDO permission){
		return permissionDao.update(permission);
	}
	
	@Override
	public int remove(Integer id){
		return permissionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return permissionDao.batchRemove(ids);
	}
	
}
