package com.graduation.info.managementinfo.info.videodatabase.dao;

import com.graduation.info.managementinfo.info.videodatabase.domain.VideoDatabaseDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-26 15:01:05
 */
@Mapper
public interface VideoDatabaseDao {

	VideoDatabaseDO get(Integer id);
	
	List<VideoDatabaseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(VideoDatabaseDO videoDatabase);
	
	int update(VideoDatabaseDO videoDatabase);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
