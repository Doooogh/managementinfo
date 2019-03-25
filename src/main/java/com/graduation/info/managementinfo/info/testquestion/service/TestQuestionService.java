package com.graduation.info.managementinfo.info.testquestion.service;

import com.graduation.info.managementinfo.info.testquestion.domain.TestQuestionDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-25 14:22:48
 */
public interface TestQuestionService {
	
	TestQuestionDO get(Integer id);
	
	List<TestQuestionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TestQuestionDO testQuestion);
	
	int update(TestQuestionDO testQuestion);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<TestQuestionDO> getTestQuestionBySId(Integer sId);

}
