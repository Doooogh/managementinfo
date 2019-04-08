package com.graduation.info.managementinfo.info.icon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.icon.dao.IconDao;
import com.graduation.info.managementinfo.info.icon.domain.IconDO;
import com.graduation.info.managementinfo.info.icon.service.IconService;



@Service
public class IconServiceImpl implements IconService {
	@Autowired
	private IconDao iconDao;
	
	@Override
	public IconDO get(Integer id){
		return iconDao.get(id);
	}
	
	@Override
	public List<IconDO> list(Map<String, Object> map){
		return iconDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return iconDao.count(map);
	}
	
	@Override
	public int save(IconDO icon){
		return iconDao.save(icon);
	}
	
	@Override
	public int update(IconDO icon){
		return iconDao.update(icon);
	}
	
	@Override
	public int remove(Integer id){
		return iconDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return iconDao.batchRemove(ids);
	}
	
}
