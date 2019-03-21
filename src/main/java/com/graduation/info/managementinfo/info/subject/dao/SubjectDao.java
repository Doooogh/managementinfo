package com.graduation.info.managementinfo.info.subject.dao;

import com.graduation.info.managementinfo.info.subject.domain.SubjectDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:54:21
 */
@Mapper
public interface SubjectDao {

	SubjectDO get(Integer id);
	
	List<SubjectDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SubjectDO subject);
	
	int update(SubjectDO subject);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
