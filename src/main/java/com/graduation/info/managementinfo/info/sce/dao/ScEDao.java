package com.graduation.info.managementinfo.info.sce.dao;

import com.graduation.info.managementinfo.info.sce.domain.ScEDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-23 16:04:14
 */
@Mapper
public interface ScEDao {

	ScEDO get(Integer id);
	
	List<ScEDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ScEDO scE);
	
	int update(ScEDO scE);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
