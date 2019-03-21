package com.graduation.info.managementinfo.info.subject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.subject.dao.SubjectDao;
import com.graduation.info.managementinfo.info.subject.domain.SubjectDO;
import com.graduation.info.managementinfo.info.subject.service.SubjectService;



@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectDao subjectDao;
	
	@Override
	public SubjectDO get(Integer id){
		return subjectDao.get(id);
	}
	
	@Override
	public List<SubjectDO> list(Map<String, Object> map){
		return subjectDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return subjectDao.count(map);
	}
	
	@Override
	public int save(SubjectDO subject){
		return subjectDao.save(subject);
	}
	
	@Override
	public int update(SubjectDO subject){
		return subjectDao.update(subject);
	}
	
	@Override
	public int remove(Integer id){
		return subjectDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return subjectDao.batchRemove(ids);
	}
	
}
