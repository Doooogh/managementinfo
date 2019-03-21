package com.graduation.info.managementinfo.info.subject.controller;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.system.utils.PageUtils;
import com.graduation.info.managementinfo.system.utils.Query;
import com.graduation.info.managementinfo.system.utils.R;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduation.info.managementinfo.info.subject.domain.SubjectDO;
import com.graduation.info.managementinfo.info.subject.service.SubjectService;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:54:21
 */
 
@Controller
@RequestMapping("/subject/subject")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping()
	@RequiresPermissions("subject:subject:subject")
	String Subject(){
	    return "subject/subject/subject";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("subject:subject:subject")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SubjectDO> subjectList = subjectService.list(query);
		int total = subjectService.count(query);
		PageUtils pageUtils = new PageUtils(subjectList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("subject:subject:add")
	String add(){
	    return "subject/subject/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("subject:subject:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SubjectDO subject = subjectService.get(id);
		model.addAttribute("subject", subject);
	    return "subject/subject/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("subject:subject:add")
	public R save(SubjectDO subject){
		if(subjectService.save(subject)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("subject:subject:edit")
	public R update( SubjectDO subject){
		subjectService.update(subject);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("subject:subject:remove")
	public R remove( Integer id){
		if(subjectService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("subject:subject:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		subjectService.batchRemove(ids);
		return R.ok();
	}


}
