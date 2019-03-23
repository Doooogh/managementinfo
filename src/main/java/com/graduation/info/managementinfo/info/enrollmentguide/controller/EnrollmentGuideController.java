package com.graduation.info.managementinfo.info.enrollmentguide.controller;

import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.system.utils.PageUtils;
import com.graduation.info.managementinfo.system.utils.Query;
import com.graduation.info.managementinfo.system.utils.R;
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

import com.graduation.info.managementinfo.info.enrollmentguide.domain.EnrollmentGuideDO;
import com.graduation.info.managementinfo.info.enrollmentguide.service.EnrollmentGuideService;
/**
 * 
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-23 16:10:21
 */
 
@Controller
@RequestMapping("/enrollmentguide/enrollmentGuide")
public class EnrollmentGuideController {
	@Autowired
	private EnrollmentGuideService enrollmentGuideService;
	
	@GetMapping()
	@RequiresPermissions("enrollmentguide:enrollmentGuide:enrollmentGuide")
	String EnrollmentGuide(){
	    return "enrollmentguide/enrollmentGuide/enrollmentGuide";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("enrollmentguide:enrollmentGuide:enrollmentGuide")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<EnrollmentGuideDO> enrollmentGuideList = enrollmentGuideService.list(query);
		int total = enrollmentGuideService.count(query);
		PageUtils pageUtils = new PageUtils(enrollmentGuideList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("enrollmentguide:enrollmentGuide:add")
	String add(){
	    return "enrollmentguide/enrollmentGuide/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("enrollmentguide:enrollmentGuide:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		EnrollmentGuideDO enrollmentGuide = enrollmentGuideService.get(id);
		model.addAttribute("enrollmentGuide", enrollmentGuide);
	    return "enrollmentguide/enrollmentGuide/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("enrollmentguide:enrollmentGuide:add")
	public R save( EnrollmentGuideDO enrollmentGuide){
		if(enrollmentGuideService.save(enrollmentGuide)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("enrollmentguide:enrollmentGuide:edit")
	public R update( EnrollmentGuideDO enrollmentGuide){
		enrollmentGuideService.update(enrollmentGuide);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("enrollmentguide:enrollmentGuide:remove")
	public R remove( Integer id){
		if(enrollmentGuideService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("enrollmentguide:enrollmentGuide:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		enrollmentGuideService.batchRemove(ids);
		return R.ok();
	}
	
}
