package com.graduation.info.managementinfo.info.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.school.dao.SchoolDao;
import com.graduation.info.managementinfo.info.school.domain.SchoolDO;
import com.graduation.info.managementinfo.info.school.service.SchoolService;



@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolDao schoolDao;
	
	@Override
	public SchoolDO get(Integer id){
		return schoolDao.get(id);
	}
	
	@Override
	public List<SchoolDO> list(Map<String, Object> map){
		return schoolDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return schoolDao.count(map);
	}
	
	@Override
	public int save(SchoolDO school){
		return schoolDao.save(school);
	}
	
	@Override
	public int update(SchoolDO school){
		return schoolDao.update(school);
	}
	
	@Override
	public int remove(Integer id){
		return schoolDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return schoolDao.batchRemove(ids);
	}
	
}
