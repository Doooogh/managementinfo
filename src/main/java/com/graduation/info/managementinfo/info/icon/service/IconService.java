package com.graduation.info.managementinfo.info.icon.service;

import com.graduation.info.managementinfo.info.icon.domain.IconDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-28 12:59:27
 */
public interface IconService {
	
	IconDO get(Integer id);
	
	List<IconDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(IconDO icon);
	
	int update(IconDO icon);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
