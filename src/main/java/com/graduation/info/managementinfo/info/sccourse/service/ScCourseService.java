package com.graduation.info.managementinfo.info.sccourse.service;

import com.graduation.info.managementinfo.info.sccourse.domain.ScCourseDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:41:15
 */
public interface ScCourseService {
	
	ScCourseDO get(Integer id);
	
	List<ScCourseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ScCourseDO scCourse);
	
	int update(ScCourseDO scCourse);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
