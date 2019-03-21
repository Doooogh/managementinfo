package com.graduation.info.managementinfo.info.sccourse.controller;

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

import com.graduation.info.managementinfo.info.sccourse.domain.ScCourseDO;
import com.graduation.info.managementinfo.info.sccourse.service.ScCourseService;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:41:15
 */
 
@Controller
@RequestMapping("/sccourse/scCourse")
public class ScCourseController {
	@Autowired
	private ScCourseService scCourseService;

	@GetMapping()
	@RequiresPermissions("sccourse:scCourse:scCourse")
	String ScCourse(){
	    return "sccourse/scCourse/scCourse";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sccourse:scCourse:scCourse")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ScCourseDO> scCourseList = scCourseService.list(query);
		int total = scCourseService.count(query);
		PageUtils pageUtils = new PageUtils(scCourseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sccourse:scCourse:add")
	String add(){
	    return "sccourse/scCourse/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sccourse:scCourse:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ScCourseDO scCourse = scCourseService.get(id);
		model.addAttribute("scCourse", scCourse);
	    return "sccourse/scCourse/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sccourse:scCourse:add")
	public R save(ScCourseDO scCourse){
		if(scCourseService.save(scCourse)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sccourse:scCourse:edit")
	public R update( ScCourseDO scCourse){
		scCourseService.update(scCourse);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sccourse:scCourse:remove")
	public R remove( Integer id){
		if(scCourseService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sccourse:scCourse:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		scCourseService.batchRemove(ids);
		return R.ok();
	}
	
}
