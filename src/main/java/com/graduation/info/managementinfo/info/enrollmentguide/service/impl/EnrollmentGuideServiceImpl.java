package com.graduation.info.managementinfo.info.enrollmentguide.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.enrollmentguide.dao.EnrollmentGuideDao;
import com.graduation.info.managementinfo.info.enrollmentguide.domain.EnrollmentGuideDO;
import com.graduation.info.managementinfo.info.enrollmentguide.service.EnrollmentGuideService;



@Service
public class EnrollmentGuideServiceImpl implements EnrollmentGuideService {
	@Autowired
	private EnrollmentGuideDao enrollmentGuideDao;
	
	@Override
	public EnrollmentGuideDO get(Integer id){
		return enrollmentGuideDao.get(id);
	}
	
	@Override
	public List<EnrollmentGuideDO> list(Map<String, Object> map){
		return enrollmentGuideDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return enrollmentGuideDao.count(map);
	}
	
	@Override
	public int save(EnrollmentGuideDO enrollmentGuide){
		return enrollmentGuideDao.save(enrollmentGuide);
	}
	
	@Override
	public int update(EnrollmentGuideDO enrollmentGuide){
		return enrollmentGuideDao.update(enrollmentGuide);
	}
	
	@Override
	public int remove(Integer id){
		return enrollmentGuideDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return enrollmentGuideDao.batchRemove(ids);
	}
	
}
