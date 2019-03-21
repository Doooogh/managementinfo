package com.graduation.info.managementinfo.info.major.dao;

import com.graduation.info.managementinfo.info.major.domain.MajorDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:52:03
 */
@Mapper
public interface MajorDao {

	MajorDO get(Integer id);
	
	List<MajorDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MajorDO major);
	
	int update(MajorDO major);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
