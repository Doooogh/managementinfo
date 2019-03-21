package com.graduation.info.managementinfo.info.school.service;

import com.graduation.info.managementinfo.info.school.domain.SchoolDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:43:11
 */
public interface SchoolService {
	
	SchoolDO get(Integer id);
	
	List<SchoolDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SchoolDO school);
	
	int update(SchoolDO school);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
