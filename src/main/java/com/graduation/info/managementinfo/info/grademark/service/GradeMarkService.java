package com.graduation.info.managementinfo.info.grademark.service;

import com.graduation.info.managementinfo.info.grademark.domain.GradeMarkDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:50:04
 */
public interface GradeMarkService {
	
	GradeMarkDO get(Integer id);
	
	List<GradeMarkDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(GradeMarkDO gradeMark);
	
	int update(GradeMarkDO gradeMark);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
