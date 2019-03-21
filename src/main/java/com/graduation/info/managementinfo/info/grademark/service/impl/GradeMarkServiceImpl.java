package com.graduation.info.managementinfo.info.grademark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.grademark.dao.GradeMarkDao;
import com.graduation.info.managementinfo.info.grademark.domain.GradeMarkDO;
import com.graduation.info.managementinfo.info.grademark.service.GradeMarkService;



@Service
public class GradeMarkServiceImpl implements GradeMarkService {
	@Autowired
	private GradeMarkDao gradeMarkDao;
	
	@Override
	public GradeMarkDO get(Integer id){
		return gradeMarkDao.get(id);
	}
	
	@Override
	public List<GradeMarkDO> list(Map<String, Object> map){
		return gradeMarkDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return gradeMarkDao.count(map);
	}
	
	@Override
	public int save(GradeMarkDO gradeMark){
		return gradeMarkDao.save(gradeMark);
	}
	
	@Override
	public int update(GradeMarkDO gradeMark){
		return gradeMarkDao.update(gradeMark);
	}
	
	@Override
	public int remove(Integer id){
		return gradeMarkDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return gradeMarkDao.batchRemove(ids);
	}
	
}
