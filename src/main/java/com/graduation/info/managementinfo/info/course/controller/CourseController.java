package com.graduation.info.managementinfo.info.course.controller;

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

import com.graduation.info.managementinfo.info.course.domain.CourseDO;
import com.graduation.info.managementinfo.info.course.service.CourseService;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:47:45
 */
 
@Controller
@RequestMapping("/course/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping()
	@RequiresPermissions("course:course:course")
	String Course(){
	    return "course/course/course";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("course:course:course")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CourseDO> courseList = courseService.list(query);
		int total = courseService.count(query);
		PageUtils pageUtils = new PageUtils(courseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("course:course:add")
	String add(){
	    return "course/course/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("course:course:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		CourseDO course = courseService.get(id);
		model.addAttribute("course", course);
	    return "course/course/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("course:course:add")
	public R save(CourseDO course){
		if(courseService.save(course)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("course:course:edit")
	public R update( CourseDO course){
		courseService.update(course);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("course:course:remove")
	public R remove( Integer id){
		if(courseService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("course:course:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		courseService.batchRemove(ids);
		return R.ok();
	}
	
}
