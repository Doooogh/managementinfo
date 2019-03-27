package com.graduation.info.managementinfo.info.index.controller;

import com.graduation.info.managementinfo.info.common.entity.Tree;
import com.graduation.info.managementinfo.info.index.service.MenuTree;
import com.graduation.info.managementinfo.info.permission.domain.MenuItem;
import com.graduation.info.managementinfo.info.permission.domain.PermissionDO;
import com.graduation.info.managementinfo.info.permission.service.PermissionService;
import com.graduation.info.managementinfo.info.role.service.RoleService;
import com.graduation.info.managementinfo.info.school.service.SchoolService;
import com.graduation.info.managementinfo.info.testquestion.service.TestQuestionService;
import com.graduation.info.managementinfo.info.user.domain.UserDO;
import com.graduation.info.managementinfo.info.user.service.UserService;
import com.graduation.info.managementinfo.info.videodatabase.service.VideoDatabaseService;
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

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private TestQuestionService testQuestionService;

    @Autowired
    private VideoDatabaseService videoDatabaseService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/index")
    public String index(Model model){
       UserDO user= (UserDO) ShiroUtils.getSubjct().getSession().getAttribute("user");
        String username=user.getUsername();
        model.addAttribute("username",username);
        return "index";
    }

    @GetMapping("/getTree")
    @ResponseBody
    public MenuItem getTree(){
        return menuTree.getTreeByUserId(1);
    }

    @GetMapping("/main")
    public String getHome(Model model){
        Map<String,Object> map=new HashMap();
        UserDO user= (UserDO) ShiroUtils.getSubjct().getSession().getAttribute("user");
        String username=user.getUsername();
        List<Integer> roleIds = user.getRoleIds();
      /*  List<String> roleNames=new ArrayList<>();
        for (Integer roleId : roleIds) {
            String roleName=roleService.get(roleId).getName();
            roleNames.add(roleName);
        }*/
        Integer schoolNum=schoolService.count(map);
        Integer testquestionNum = testQuestionService.count(map);
//        Integer videoNum=videoDatabaseService.count(map);
        model.addAttribute("username",username);
        model.addAttribute("schoolNum",schoolNum);
        model.addAttribute("testquestionNum",testquestionNum);
//        model.addAttribute("videoNum",videoNum);
//        model.addAttribute("roleNames",roleNames);
        return "page/main";
    }


}
