package com.graduation.info.managementinfo.info.scsub.service;

import com.graduation.info.managementinfo.info.scsub.domain.ScSubDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:36:41
 */
public interface ScSubService {
	
	ScSubDO get(Integer id);
	
	List<ScSubDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ScSubDO scSub);
	
	int update(ScSubDO scSub);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
