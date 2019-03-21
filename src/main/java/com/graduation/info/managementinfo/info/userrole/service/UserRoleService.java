package com.graduation.info.managementinfo.info.userrole.service;

import com.graduation.info.managementinfo.info.userrole.domain.UserRoleDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lilong
 * @email 1992lcg@163.com
 * @date 2019-03-20 18:57:28
 */
public interface UserRoleService {
	
	UserRoleDO get(Integer id);
	
	List<UserRoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserRoleDO userRole);
	
	int update(UserRoleDO userRole);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<Integer> selectRoleIdByUserId(Integer userId);
}
