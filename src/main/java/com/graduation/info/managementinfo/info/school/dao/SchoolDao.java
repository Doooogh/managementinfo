package com.graduation.info.managementinfo.info.school.dao;

import com.graduation.info.managementinfo.info.school.domain.SchoolDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:43:11
 */
@Mapper
public interface SchoolDao {

	SchoolDO get(Integer id);
	
	List<SchoolDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SchoolDO school);
	
	int update(SchoolDO school);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	String getEGuideUrlBySchoolId(Integer Id);

}
