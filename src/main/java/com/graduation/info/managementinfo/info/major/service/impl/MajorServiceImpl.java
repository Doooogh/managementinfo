package com.graduation.info.managementinfo.info.major.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.major.dao.MajorDao;
import com.graduation.info.managementinfo.info.major.domain.MajorDO;
import com.graduation.info.managementinfo.info.major.service.MajorService;



@Service
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorDao majorDao;
	
	@Override
	public MajorDO get(Integer id){
		return majorDao.get(id);
	}
	
	@Override
	public List<MajorDO> list(Map<String, Object> map){
		return majorDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return majorDao.count(map);
	}
	
	@Override
	public int save(MajorDO major){
		return majorDao.save(major);
	}
	
	@Override
	public int update(MajorDO major){
		return majorDao.update(major);
	}
	
	@Override
	public int remove(Integer id){
		return majorDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return majorDao.batchRemove(ids);
	}
	
}
