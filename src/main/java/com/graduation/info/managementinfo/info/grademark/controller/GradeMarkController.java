package com.graduation.info.managementinfo.info.grademark.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.grademark.domain.GradeMarkVo;
import com.graduation.info.managementinfo.info.major.domain.MajorDO;
import com.graduation.info.managementinfo.info.major.service.MajorService;
import com.graduation.info.managementinfo.info.school.service.SchoolService;
import com.graduation.info.managementinfo.system.utils.PageUtils;
import com.graduation.info.managementinfo.system.utils.Query;
import com.graduation.info.managementinfo.system.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
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

import com.graduation.info.managementinfo.info.grademark.domain.GradeMarkDO;
import com.graduation.info.managementinfo.info.grademark.service.GradeMarkService;
/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:50:04
 */
 
@Controller
@RequestMapping("/grademark/gradeMark")
public class GradeMarkController {
	@Autowired
	private GradeMarkService gradeMarkService;

	@Autowired
	private MajorService majorService;

	@Autowired
	private SchoolService schoolService;

	
	@GetMapping()
	@RequiresPermissions("grademark:gradeMark:gradeMark")
	String GradeMark(Integer scId,Model model){
		model.addAttribute("scId",scId);
	    return "grademark/gradeMark/gradeMark";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("grademark:gradeMark:gradeMark")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GradeMarkDO> gradeMarkList = gradeMarkService.list(query);
		List<GradeMarkVo> gradeMarkVos=new ArrayList<>();
		for (GradeMarkDO gradeMarkDO : gradeMarkList) {
			GradeMarkVo gradeMarkVo=new GradeMarkVo();
			Integer gardeMarkId=gradeMarkDO.getId();
			String schoolName=schoolService.get(gradeMarkDO.getScId()).getName();
			String majorName=majorService.get(gardeMarkId).getName();
			BeanUtils.copyProperties(gradeMarkDO,gradeMarkVo);
			gradeMarkVo.setMajor(majorName);
			gradeMarkVos.add(gradeMarkVo);
		}
		int total = gradeMarkService.count(query);
		PageUtils pageUtils = new PageUtils(gradeMarkVos, total);
		return pageUtils;
	}

	
	@GetMapping("/add/{id}")
	@RequiresPermissions("grademark:gradeMark:add")
	String add(@PathVariable("id") Integer id,Model model){
		model.addAttribute("scId",id);
	    return "grademark/gradeMark/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("grademark:gradeMark:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		GradeMarkDO gradeMark = gradeMarkService.get(id);
		String majorName=majorService.get(gradeMark.getMId()).getName();
		model.addAttribute("gradeMark", gradeMark);
		model.addAttribute("majorName", majorName);
	    return "grademark/gradeMark/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("grademark:gradeMark:add")
	public R save(GradeMarkDO gradeMark,String majorName){
		MajorDO majorDO=new MajorDO();
		majorDO.setName(majorName);
		int a=majorService.save(majorDO);
		Integer majorId=majorDO.getId();
		if(a>0) {
			gradeMark.setMId(majorId);
			if (gradeMarkService.save(gradeMark) > 0) {
				return R.ok();
			}
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("grademark:gradeMark:edit")
	public R update( GradeMarkDO gradeMark){
		gradeMarkService.update(gradeMark);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("grademark:gradeMark:remove")
	public R remove( Integer id){
		if(gradeMarkService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("grademark:gradeMark:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		gradeMarkService.batchRemove(ids);
		return R.ok();
	}
	
}
