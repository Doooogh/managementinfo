package com.graduation.info.managementinfo.info.school.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.enrollmentguide.domain.EnrollmentGuideDO;
import com.graduation.info.managementinfo.info.enrollmentguide.service.EnrollmentGuideService;
import com.graduation.info.managementinfo.system.utils.FileUtil;
import com.graduation.info.managementinfo.system.utils.PageUtils;
import com.graduation.info.managementinfo.system.utils.Query;
import com.graduation.info.managementinfo.system.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduation.info.managementinfo.info.school.domain.SchoolDO;
import com.graduation.info.managementinfo.info.school.service.SchoolService;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:43:11
 */
 
@Controller
@RequestMapping("/school/school")
public class SchoolController {
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private EnrollmentGuideService enrollmentGuideService;
	
	@GetMapping()
	@RequiresPermissions("school:school:school")
	String School(){
	    return "school/school/school";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("school:school:school")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SchoolDO> schoolList = schoolService.list(query);
		int total = schoolService.count(query);
		PageUtils pageUtils = new PageUtils(schoolList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("school:school:add")
	String add(){
	    return "school/school/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("school:school:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SchoolDO school = schoolService.get(id);
		model.addAttribute("school", school);
	    return "school/school/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("school:school:add")
	public R save(SchoolDO school){
		if(schoolService.save(school)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("school:school:edit")
	public R update( SchoolDO school){
		schoolService.update(school);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("school:school:remove")
	public R remove( Integer id){
		if(schoolService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("school:school:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		schoolService.batchRemove(ids);
		return R.ok();
	}

	@GetMapping("/lookEnrollmentGuide/{id}")
	public String lookEnrollmentGuide(@PathVariable("id") Integer id,Model model){
		model.addAttribute("id",id);
		return "school/school/enrollmentGuide";
	}

	@GetMapping("/getEnrollmentGuide")
	@ResponseBody
	public String getEnrollmentGuide(Integer id){
		EnrollmentGuideDO enrollmentGuide=schoolService.getEGuideBySchool(id);
		if(enrollmentGuide==null){
			return "没有进行编辑";
		}else{
			String url=enrollmentGuide.getUrl();
			try {
				String content=FileUtil.getEGuide(url);
				return content;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	@GetMapping("/editEnrollmentGuide/{id}")
	public String editEnrollmentGuide(@PathVariable("id") Integer id,Model model){
		String url=schoolService.getEGuideUrlBySchoolId(id);
		if(StringUtils.isNotBlank(url)){
			try {
				String content=FileUtil.getEGuide(url);
				model.addAttribute("content",content);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("id",id);
		return "school/school/editEnrollmentGuide";
	}



}
