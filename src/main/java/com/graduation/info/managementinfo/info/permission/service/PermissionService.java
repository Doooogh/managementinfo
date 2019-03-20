package com.graduation.info.managementinfo.info.permission.service;

import com.graduation.info.managementinfo.info.permission.domain.PermissionDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lilong
 * @email 1992lcg@163.com
 * @date 2019-03-20 18:54:33
 */
public interface PermissionService {
	
	PermissionDO get(Integer id);
	
	List<PermissionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PermissionDO permission);
	
	int update(PermissionDO permission);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
