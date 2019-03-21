package com.graduation.info.managementinfo.info.subm.controller;

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

import com.graduation.info.managementinfo.info.subm.domain.SubMDO;
import com.graduation.info.managementinfo.info.subm.service.SubMService;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 22:45:43
 */
 
@Controller
@RequestMapping("/subm/subM")
public class SubMController {
	@Autowired
	private SubMService subMService;
	
	@GetMapping()
	@RequiresPermissions("subm:subM:subM")
	String SubM(){
	    return "subm/subM/subM";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("subm:subM:subM")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SubMDO> subMList = subMService.list(query);
		int total = subMService.count(query);
		PageUtils pageUtils = new PageUtils(subMList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("subm:subM:add")
	String add(){
	    return "subm/subM/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("subm:subM:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SubMDO subM = subMService.get(id);
		model.addAttribute("subM", subM);
	    return "subm/subM/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("subm:subM:add")
	public R save(SubMDO subM){
		if(subMService.save(subM)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("subm:subM:edit")
	public R update( SubMDO subM){
		subMService.update(subM);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("subm:subM:remove")
	public R remove( Integer id){
		if(subMService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("subm:subM:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		subMService.batchRemove(ids);
		return R.ok();
	}
	
}
