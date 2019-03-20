package com.graduation.info.managementinfo.info.permission.controller;

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

import com.graduation.info.managementinfo.info.permission.domain.PermissionDO;
import com.graduation.info.managementinfo.info.permission.service.PermissionService;


/**
 * 
 * 
 * @author lilong
 * @email 1992lcg@163.com
 * @date 2019-03-20 18:54:33
 */
 
@Controller
@RequestMapping("/permission/permission")
public class PermissionController {
	@Autowired
	private PermissionService permissionService;
	
	@GetMapping()
	@RequiresPermissions("permission:permission:permission")
	String Permission(){
	    return "permission/permission/permission";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("permission:permission:permission")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PermissionDO> permissionList = permissionService.list(query);
		int total = permissionService.count(query);
		PageUtils pageUtils = new PageUtils(permissionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("permission:permission:add")
	String add(){
	    return "permission/permission/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("permission:permission:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		PermissionDO permission = permissionService.get(id);
		model.addAttribute("permission", permission);
	    return "permission/permission/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("permission:permission:add")
	public R save(PermissionDO permission){
		if(permissionService.save(permission)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("permission:permission:edit")
	public R update( PermissionDO permission){
		permissionService.update(permission);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("permission:permission:remove")
	public R remove( Integer id){
		if(permissionService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("permission:permission:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		permissionService.batchRemove(ids);
		return R.ok();
	}
	
}
