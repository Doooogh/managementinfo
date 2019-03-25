package com.graduation.info.managementinfo.info.enrollmentguide.dao;

import com.graduation.info.managementinfo.info.enrollmentguide.domain.EnrollmentGuideDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-23 16:10:21
 */
@Mapper
public interface EnrollmentGuideDao {

	EnrollmentGuideDO get(Integer id);
	
	List<EnrollmentGuideDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EnrollmentGuideDO enrollmentGuide);
	
	int update(EnrollmentGuideDO enrollmentGuide);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
