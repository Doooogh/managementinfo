package com.graduation.info.managementinfo.info.sccourse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.sccourse.dao.ScCourseDao;
import com.graduation.info.managementinfo.info.sccourse.domain.ScCourseDO;
import com.graduation.info.managementinfo.info.sccourse.service.ScCourseService;



@Service
public class ScCourseServiceImpl implements ScCourseService {
	@Autowired
	private ScCourseDao scCourseDao;
	
	@Override
	public ScCourseDO get(Integer id){
		return scCourseDao.get(id);
	}
	
	@Override
	public List<ScCourseDO> list(Map<String, Object> map){
		return scCourseDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return scCourseDao.count(map);
	}
	
	@Override
	public int save(ScCourseDO scCourse){
		return scCourseDao.save(scCourse);
	}
	
	@Override
	public int update(ScCourseDO scCourse){
		return scCourseDao.update(scCourse);
	}
	
	@Override
	public int remove(Integer id){
		return scCourseDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return scCourseDao.batchRemove(ids);
	}
	
}
