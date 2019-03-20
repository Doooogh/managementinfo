package com.graduation.info.managementinfo.info.user.controller;

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

import com.graduation.info.managementinfo.info.user.domain.UserDO;
import com.graduation.info.managementinfo.info.user.service.UserService;

/**
 * 
 * 
 * @author lilong
 * @email 1992lcg@163.com
 * @date 2019-03-20 18:46:02
 */
 
@Controller
@RequestMapping("/user/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping()
	@RequiresPermissions("user:user:user")
	String User(){
	    return "user/user/user";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("user:user:user")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserDO> userList = userService.list(query);
		int total = userService.count(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("user:user:add")
	String add(){
	    return "user/user/add";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("user:user:edit")
	String edit(@PathVariable("userId") Integer userId,Model model){
		UserDO user = userService.get(userId);
		model.addAttribute("user", user);
	    return "user/user/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("user:user:add")
	public R save( UserDO user){
		if(userService.save(user)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("user:user:edit")
	public R update( UserDO user){
		userService.update(user);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("user:user:remove")
	public R remove( Integer userId){
		if(userService.remove(userId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("user:user:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] userIds){
		userService.batchRemove(userIds);
		return R.ok();
	}
	
}
