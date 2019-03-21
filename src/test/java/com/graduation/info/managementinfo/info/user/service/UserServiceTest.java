package com.graduation.info.managementinfo.info.user.service;

import com.graduation.info.managementinfo.info.permission.domain.PermissionDO;
import com.graduation.info.managementinfo.info.user.domain.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectByUsername() {
        for (UserDO admin : userService.selectByUsername("admin")) {
            System.out.println(admin.getUsername());
        }
    }

    @Test
    public void getByUsername() {

    }

    @Test
    public void getRoles() {
        for (String admin : userService.getRoles("admin")) {
            System.out.println(admin);
        }
    }

    @Test
    public void getPermissions() {
        for (String admin : userService.getPermissions("admin")) {
            System.out.println(admin);
        }
    }

    @Test
    public void getPermissionsByUserId() {

        for (PermissionDO permissionDO : userService.getPermissionsByUserId(1)) {
            System.out.println(permissionDO.getName());
        }
    }
}