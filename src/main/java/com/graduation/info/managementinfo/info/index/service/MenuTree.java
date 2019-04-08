package com.graduation.info.managementinfo.info.index.service;

import com.graduation.info.managementinfo.info.common.entity.Tree1;
import com.graduation.info.managementinfo.info.permission.domain.MenuItem;
import com.graduation.info.managementinfo.info.permission.domain.PermissionDO;
import com.graduation.info.managementinfo.info.user.dao.UserDao;
import com.graduation.info.managementinfo.info.user.service.UserService;
import com.graduation.info.managementinfo.system.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Component
public class MenuTree {

    @Autowired
    private UserDao userDao;

    public MenuItem getTreeByUserId(Integer userId){
        System.out.println("userId为................"+userId);
        Set<PermissionDO> pers =userDao.getPermissionsByUserId(userId);
        List<Tree1<PermissionDO>> trees=new ArrayList<>();
        for (PermissionDO per : pers) {
            if(per.getType()!=2) {
                Tree1<PermissionDO> tree = new Tree1<>();
                tree.setId(per.getId() + "");
                tree.setParentId(per.getParentId() + "");
                tree.setTitle(per.getName());
                tree.setIcon(per.getImg());
                tree.setHref(per.getUrl());
                tree.setSpread(false);
                trees.add(tree);
            }else {
                continue;
            }
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
