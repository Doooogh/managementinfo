package com.graduation.info.managementinfo.info.sce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.sce.dao.ScEDao;
import com.graduation.info.managementinfo.info.sce.domain.ScEDO;
import com.graduation.info.managementinfo.info.sce.service.ScEService;



@Service
public class ScEServiceImpl implements ScEService {
	@Autowired
	private ScEDao scEDao;
	
	@Override
	public ScEDO get(Integer id){
		return scEDao.get(id);
	}
	
	@Override
	public List<ScEDO> list(Map<String, Object> map){
		return scEDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return scEDao.count(map);
	}
	
	@Override
	public int save(ScEDO scE){
		return scEDao.save(scE);
	}
	
	@Override
	public int update(ScEDO scE){
		return scEDao.update(scE);
	}
	
	@Override
	public int remove(Integer id){
		return scEDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return scEDao.batchRemove(ids);
	}
	
}
