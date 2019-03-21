package com.graduation.info.managementinfo.info.sccourse.dao;

import com.graduation.info.managementinfo.info.sccourse.domain.ScCourseDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:41:15
 */
@Mapper
public interface ScCourseDao {

	ScCourseDO get(Integer id);
	
	List<ScCourseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ScCourseDO scCourse);
	
	int update(ScCourseDO scCourse);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
