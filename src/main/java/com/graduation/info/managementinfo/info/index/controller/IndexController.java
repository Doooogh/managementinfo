package com.graduation.info.managementinfo.info.index.controller;

import com.graduation.info.managementinfo.info.common.entity.Tree;
import com.graduation.info.managementinfo.info.index.service.MenuTree;
import com.graduation.info.managementinfo.info.permission.domain.MenuItem;
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
import org.springframework.web.bind.annotation.ResponseBody;
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

    @Autowired
    private MenuTree menuTree;

    @GetMapping("/")
    public String index(Model model){
       /* UserDO user = (UserDO) ShiroUtils.getSubjct().getSession().getAttribute("user");
        Integer userId=user.getUserId();
        String username=user.getUsername();*/
        return "index";
    }

    @GetMapping("/getTree")
    @ResponseBody
    public MenuItem getTree(){
        return menuTree.getTreeByUserId(1);
    }

}
