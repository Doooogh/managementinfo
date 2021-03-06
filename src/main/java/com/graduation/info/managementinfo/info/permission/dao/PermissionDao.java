package com.graduation.info.managementinfo.info.permission.dao;

import com.graduation.info.managementinfo.info.permission.domain.PermissionDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author lilong
 * @email 1992lcg@163.com
 * @date 2019-03-20 18:54:33
 */
@Mapper
public interface PermissionDao {

	PermissionDO get(Integer id);
	
	List<PermissionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PermissionDO permission);
	
	int update(PermissionDO permission);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<PermissionDO> selectByRoles(List<Integer> roles);
}
