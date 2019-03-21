package com.graduation.info.managementinfo.info.subm.service;

import com.graduation.info.managementinfo.info.subm.domain.SubMDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:45:43
 */
public interface SubMService {
	
	SubMDO get(Integer id);
	
	List<SubMDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SubMDO subM);
	
	int update(SubMDO subM);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
