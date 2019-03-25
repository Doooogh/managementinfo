package com.graduation.info.managementinfo.info.sce.controller;

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

import com.graduation.info.managementinfo.info.sce.domain.ScEDO;
import com.graduation.info.managementinfo.info.sce.service.ScEService;


/**
 * 
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-23 16:04:14
 */
 
@Controller
@RequestMapping("/sce/scE")
public class ScEController {
	@Autowired
	private ScEService scEService;
	
	@GetMapping()
	@RequiresPermissions("sce:scE:scE")
	String ScE(){
	    return "sce/scE/scE";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sce:scE:scE")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ScEDO> scEList = scEService.list(query);
		int total = scEService.count(query);
		PageUtils pageUtils = new PageUtils(scEList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sce:scE:add")
	String add(){
	    return "sce/scE/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sce:scE:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ScEDO scE = scEService.get(id);
		model.addAttribute("scE", scE);
	    return "sce/scE/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sce:scE:add")
	public R save( ScEDO scE){
		if(scEService.save(scE)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sce:scE:edit")
	public R update( ScEDO scE){
		scEService.update(scE);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sce:scE:remove")
	public R remove( Integer id){
		if(scEService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sce:scE:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		scEService.batchRemove(ids);
		return R.ok();
	}
	
}
