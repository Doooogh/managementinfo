package com.graduation.info.managementinfo.info.index.controller;

import com.graduation.info.managementinfo.info.common.entity.Tree;
import com.graduation.info.managementinfo.info.permission.domain.PermissionDO;
import com.graduation.info.managementinfo.info.permission.service.PermissionService;
import com.graduation.info.managementinfo.info.user.domain.UserDO;
import com.graduation.info.managementinfo.info.user.service.UserService;
import com.graduation.info.managementinfo.system.utils.BuildTree;
import com.graduation.info.managementinfo.system.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.text.normalizer.NormalizerBase;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller()
//@RequestMapping("/index")
public class IndexController {
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserService userService;

/*    @RequestMapping("/index")
    public String index(Model model){
        UserDO user= (UserDO) ShiroUtils.getSubjct().getSession().getAttribute("user");
        String username=user.getUsername();
        Integer userId=user.getUserId();
        System.out.println("用户名为："+username+"-----ID为："+userId);
        Set<PermissionDO> permissionsSets = userService.getPermissionsByUserId(userId);
        List<Tree<PermissionDO>> trees = BuildTree.buildList(userService.getTree(permissionsSets),"0");
        model.addAttribute("trees",trees);
        model.addAttribute("username",username);
        return "/index2";
    }
    */

    @GetMapping("/")
    public String index(Model model){
        List<PermissionDO> permissions=permissionService.list(new HashMap<>());
        Set<PermissionDO> set=new HashSet<>(permissions);
//        Set<PermissionDO> permissionsSets = userService.getPermissionsByUserId(userId);
        List<Tree<PermissionDO>> trees = BuildTree.buildList(userService.getTree(set),"0");
        model.addAttribute("trees",trees);
        return "index";
    }

}
