package com.graduation.info.managementinfo.info.index.controller;

import com.graduation.info.managementinfo.info.common.entity.Tree;
import com.graduation.info.managementinfo.info.common.entity.Tree1;
import com.graduation.info.managementinfo.info.index.service.MenuTree;
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
    private MenuTree menuTree;
}
