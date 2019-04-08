package com.graduation.info.managementinfo.info.icon.controller;

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

import com.graduation.info.managementinfo.info.icon.domain.IconDO;
import com.graduation.info.managementinfo.info.icon.service.IconService;

/**
 * 
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-28 12:59:27
 */
 
@Controller
@RequestMapping("/icon/icon")
public class IconController {
	@Autowired
	private IconService iconService;
	
	@GetMapping()
	@RequiresPermissions("icon:icon:icon")
	String Icon(){
	    return "icon/icon/icon";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("icon:icon:icon")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<IconDO> iconList = iconService.list(query);
		int total = iconService.count(query);
		PageUtils pageUtils = new PageUtils(iconList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("icon:icon:add")
	String add(){
	    return "icon/icon/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("icon:icon:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		IconDO icon = iconService.get(id);
		model.addAttribute("icon", icon);
	    return "icon/icon/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("icon:icon:add")
	public R save( IconDO icon){
		if(iconService.save(icon)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("icon:icon:edit")
	public R update( IconDO icon){
		iconService.update(icon);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("icon:icon:remove")
	public R remove( Integer id){
		if(iconService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("icon:icon:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		iconService.batchRemove(ids);
		return R.ok();
	}
	
}
