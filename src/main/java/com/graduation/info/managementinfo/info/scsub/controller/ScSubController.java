package com.graduation.info.managementinfo.info.scsub.controller;

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

import com.graduation.info.managementinfo.info.scsub.domain.ScSubDO;
import com.graduation.info.managementinfo.info.scsub.service.ScSubService;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:36:41
 */
 
@Controller
@RequestMapping("/scsub/scSub")
public class ScSubController {
	@Autowired
	private ScSubService scSubService;
	
	@GetMapping()
	@RequiresPermissions("scsub:scSub:scSub")
	String ScSub(){
	    return "scsub/scSub/scSub";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("scsub:scSub:scSub")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ScSubDO> scSubList = scSubService.list(query);
		int total = scSubService.count(query);
		PageUtils pageUtils = new PageUtils(scSubList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("scsub:scSub:add")
	String add(){
	    return "scsub/scSub/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("scsub:scSub:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ScSubDO scSub = scSubService.get(id);
		model.addAttribute("scSub", scSub);
	    return "scsub/scSub/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("scsub:scSub:add")
	public R save(ScSubDO scSub){
		if(scSubService.save(scSub)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("scsub:scSub:edit")
	public R update( ScSubDO scSub){
		scSubService.update(scSub);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("scsub:scSub:remove")
	public R remove( Integer id){
		if(scSubService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("scsub:scSub:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		scSubService.batchRemove(ids);
		return R.ok();
	}
	
}
