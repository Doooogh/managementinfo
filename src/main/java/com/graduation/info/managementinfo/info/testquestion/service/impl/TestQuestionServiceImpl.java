package com.graduation.info.managementinfo.info.testquestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.testquestion.dao.TestQuestionDao;
import com.graduation.info.managementinfo.info.testquestion.domain.TestQuestionDO;
import com.graduation.info.managementinfo.info.testquestion.service.TestQuestionService;



@Service
public class TestQuestionServiceImpl implements TestQuestionService {
	@Autowired
	private TestQuestionDao testQuestionDao;
	
	@Override
	public TestQuestionDO get(Integer id){
		return testQuestionDao.get(id);
	}
	
	@Override
	public List<TestQuestionDO> list(Map<String, Object> map){
		return testQuestionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return testQuestionDao.count(map);
	}
	
	@Override
	public int save(TestQuestionDO testQuestion){
		return testQuestionDao.save(testQuestion);
	}
	
	@Override
	public int update(TestQuestionDO testQuestion){
		return testQuestionDao.update(testQuestion);
	}
	
	@Override
	public int remove(Integer id){
		return testQuestionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return testQuestionDao.batchRemove(ids);
	}

	@Override
	public List<TestQuestionDO> getTestQuestionBySId(Integer sId) {
		return testQuestionDao.getTestQuestionBySId(sId);
	}

}
