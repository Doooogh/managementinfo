package com.graduation.info.managementinfo.info.videodatabase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.videodatabase.dao.VideoDatabaseDao;
import com.graduation.info.managementinfo.info.videodatabase.domain.VideoDatabaseDO;
import com.graduation.info.managementinfo.info.videodatabase.service.VideoDatabaseService;



@Service
public class VideoDatabaseServiceImpl implements VideoDatabaseService {
	@Autowired
	private VideoDatabaseDao videoDatabaseDao;
	
	@Override
	public VideoDatabaseDO get(Integer id){
		return videoDatabaseDao.get(id);
	}
	
	@Override
	public List<VideoDatabaseDO> list(Map<String, Object> map){
		return videoDatabaseDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return videoDatabaseDao.count(map);
	}
	
	@Override
	public int save(VideoDatabaseDO videoDatabase){
		return videoDatabaseDao.save(videoDatabase);
	}
	
	@Override
	public int update(VideoDatabaseDO videoDatabase){
		return videoDatabaseDao.update(videoDatabase);
	}
	
	@Override
	public int remove(Integer id){
		return videoDatabaseDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return videoDatabaseDao.batchRemove(ids);
	}
	
}
