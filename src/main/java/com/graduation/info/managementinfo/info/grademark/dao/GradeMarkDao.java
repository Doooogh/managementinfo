package com.graduation.info.managementinfo.info.grademark.dao;

import com.graduation.info.managementinfo.info.grademark.domain.GradeMarkDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:50:04
 */
@Mapper
public interface GradeMarkDao {

	GradeMarkDO get(Integer id);
	
	List<GradeMarkDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(GradeMarkDO gradeMark);
	
	int update(GradeMarkDO gradeMark);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
