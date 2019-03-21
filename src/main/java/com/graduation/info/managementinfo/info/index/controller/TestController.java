package com.graduation.info.managementinfo.info.index.controller;

import com.graduation.info.managementinfo.info.common.entity.Tree;
import com.graduation.info.managementinfo.info.common.entity.Tree1;
import com.graduation.info.managementinfo.info.permission.domain.MenuItem;
import com.graduation.info.managementinfo.info.permission.domain.PermissionDO;
import com.graduation.info.managementinfo.info.permission.service.PermissionService;
import com.graduation.info.managementinfo.info.user.service.UserService;
import com.graduation.info.managementinfo.system.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Controller("tests")
public class TestController {
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/testTree")
    public MenuItem test(){
        Set<PermissionDO> pers =userService.getPermissionsByUserId(1);
        List<Tree1<PermissionDO>> trees=new ArrayList<>();
        for (PermissionDO per : pers) {
            Tree1<PermissionDO> tree=new Tree1<>();
            tree.setId(per.getId()+"");
            tree.setParentId(per.getParentId()+"");
            tree.setTitle(per.getName());
            tree.setIcon(per.getImg());
            tree.setHref(per.getUrl());
            tree.setSpread(false);
            trees.add(tree);
        }
        List<Tree1<PermissionDO>> tree1s = BuildTree.buildList1(trees, "0");

        MenuItem item=new MenuItem();
        item.setContentManagement(tree1s);
        List<Tree1<PermissionDO>> memberCenterList=new ArrayList<>();
        Tree1<PermissionDO> memberCenter=new Tree1<>();
        memberCenter.setTitle("用户中心");
        memberCenter.setIcon("&#xe612;");
        memberCenter.setHref("用户中心");
        memberCenter.setSpread(false);
        memberCenterList.add(memberCenter);
        List<Tree1<PermissionDO>> systemeSttingList=new ArrayList<>();
        Tree1<PermissionDO> systemeSttings=new Tree1<>();
        systemeSttings.setTitle("用户中心");
        systemeSttings.setIcon("&#xe612;");
        systemeSttings.setHref("用户中心");
        systemeSttings.setSpread(false);
        systemeSttingList.add(systemeSttings);
        List<Tree1<PermissionDO>> seraphApiList=new ArrayList<>();
        Tree1<PermissionDO> seraphApi=new Tree1<>();
        seraphApi.setTitle("用户中心");
        seraphApi.setIcon("&#xe612;");
        seraphApi.setHref("用户中心");
        seraphApi.setSpread(false);
        seraphApiList.add(seraphApi);
        item.setMemberCenter(memberCenterList);
        item.setSystemeSttings(systemeSttingList);
        item.setSeraphApi(seraphApiList);
        return item;
    }
}
