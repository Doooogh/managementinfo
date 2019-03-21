package com.graduation.info.managementinfo.info.scsub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.scsub.dao.ScSubDao;
import com.graduation.info.managementinfo.info.scsub.domain.ScSubDO;
import com.graduation.info.managementinfo.info.scsub.service.ScSubService;



@Service
public class ScSubServiceImpl implements ScSubService {
	@Autowired
	private ScSubDao scSubDao;
	
	@Override
	public ScSubDO get(Integer id){
		return scSubDao.get(id);
	}
	
	@Override
	public List<ScSubDO> list(Map<String, Object> map){
		return scSubDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return scSubDao.count(map);
	}
	
	@Override
	public int save(ScSubDO scSub){
		return scSubDao.save(scSub);
	}
	
	@Override
	public int update(ScSubDO scSub){
		return scSubDao.update(scSub);
	}
	
	@Override
	public int remove(Integer id){
		return scSubDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return scSubDao.batchRemove(ids);
	}
	
}
