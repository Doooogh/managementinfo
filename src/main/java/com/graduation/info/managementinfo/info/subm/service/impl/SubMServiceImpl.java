package com.graduation.info.managementinfo.info.subm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.subm.dao.SubMDao;
import com.graduation.info.managementinfo.info.subm.domain.SubMDO;
import com.graduation.info.managementinfo.info.subm.service.SubMService;



@Service
public class SubMServiceImpl implements SubMService {
	@Autowired
	private SubMDao subMDao;
	
	@Override
	public SubMDO get(Integer id){
		return subMDao.get(id);
	}
	
	@Override
	public List<SubMDO> list(Map<String, Object> map){
		return subMDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return subMDao.count(map);
	}
	
	@Override
	public int save(SubMDO subM){
		return subMDao.save(subM);
	}
	
	@Override
	public int update(SubMDO subM){
		return subMDao.update(subM);
	}
	
	@Override
	public int remove(Integer id){
		return subMDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return subMDao.batchRemove(ids);
	}
	
}
