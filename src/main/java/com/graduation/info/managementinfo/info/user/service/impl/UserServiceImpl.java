package com.graduation.info.managementinfo.info.user.service.impl;

import com.graduation.info.managementinfo.info.permission.domain.PermissionDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.graduation.info.managementinfo.info.user.dao.UserDao;
import com.graduation.info.managementinfo.info.user.domain.UserDO;
import com.graduation.info.managementinfo.info.user.service.UserService;



@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDO get(Integer userId){
		return userDao.get(userId);
	}
	
	@Override
	public List<UserDO> list(Map<String, Object> map){
		return userDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userDao.count(map);
	}
	
	@Override
	public int save(UserDO user){
		return userDao.save(user);
	}
	
	@Override
	public int update(UserDO user){
		return userDao.update(user);
	}
	
	@Override
	public int remove(Integer userId){
		return userDao.remove(userId);
	}
	
	@Override
	public int batchRemove(Integer[] userIds){
		return userDao.batchRemove(userIds);
	}

	@Override
	public List<UserDO> selectByUsername(String username) {
		return null;
	}

	@Override
	public UserDO getByUsername(String username) {
		return null;
	}

	@Override
	public Set<String> getRoles(String username) {
		return null;
	}

	@Override
	public Set<String> getPermissions(String username) {
		return null;
	}

	@Override
	public Set<PermissionDO> getPermissionsByUserId(Integer userId) {
		return null;
	}

}
