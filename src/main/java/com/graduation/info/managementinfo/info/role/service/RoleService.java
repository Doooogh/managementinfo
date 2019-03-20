package com.graduation.info.managementinfo.info.role.service;

import com.graduation.info.managementinfo.info.role.domain.RoleDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lilong
 * @email 1992lcg@163.com
 * @date 2019-03-20 18:51:42
 */
public interface RoleService {
	
	RoleDO get(Integer roleId);
	
	List<RoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RoleDO role);
	
	int update(RoleDO role);
	
	int remove(Integer roleId);
	
	int batchRemove(Integer[] roleIds);
}
