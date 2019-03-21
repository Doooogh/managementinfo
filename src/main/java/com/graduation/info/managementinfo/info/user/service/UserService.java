package com.graduation.info.managementinfo.info.user.service;

import com.graduation.info.managementinfo.info.common.entity.Tree;
import com.graduation.info.managementinfo.info.permission.domain.PermissionDO;
import com.graduation.info.managementinfo.info.user.domain.UserDO;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * @author lilong
 * @email 1992lcg@163.com
 * @date 2019-03-20 18:46:02
 */
public interface UserService {
	
	UserDO get(Integer userId);
	
	List<UserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserDO user);
	
	int update(UserDO user);
	
	int remove(Integer userId);
	
	int batchRemove(Integer[] userIds);

	List<UserDO> selectByUsername(String username);

	UserDO getByUsername(String username);

	Set<String> getRoles(String username);

	Set<String> getPermissions(String username);

	Set<PermissionDO> getPermissionsByUserId(Integer userId);

	List<Tree<PermissionDO>> getTree(Set<PermissionDO> permissions);
}
