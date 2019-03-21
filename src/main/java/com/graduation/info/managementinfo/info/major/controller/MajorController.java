package com.graduation.info.managementinfo.info.major.controller;

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

import com.graduation.info.managementinfo.info.major.domain.MajorDO;
import com.graduation.info.managementinfo.info.major.service.MajorService;


/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:52:03
 */
 
@Controller
@RequestMapping("/major/major")
public class MajorController {
	@Autowired
	private MajorService majorService;
	
	@GetMapping()
	@RequiresPermissions("major:major:major")
	String Major(){
	    return "major/major/major";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("major:major:major")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MajorDO> majorList = majorService.list(query);
		int total = majorService.count(query);
		PageUtils pageUtils = new PageUtils(majorList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("major:major:add")
	String add(){
	    return "major/major/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("major:major:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		MajorDO major = majorService.get(id);
		model.addAttribute("major", major);
	    return "major/major/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("major:major:add")
	public R save( MajorDO major){
		if(majorService.save(major)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("major:major:edit")
	public R update( MajorDO major){
		majorService.update(major);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("major:major:remove")
	public R remove( Integer id){
		if(majorService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("major:major:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		majorService.batchRemove(ids);
		return R.ok();
	}
	
}
