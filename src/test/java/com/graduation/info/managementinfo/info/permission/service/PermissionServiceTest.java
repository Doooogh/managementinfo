package com.graduation.info.managementinfo.info.permission.service;

import com.graduation.info.managementinfo.info.user.domain.UserDO;
import com.graduation.info.managementinfo.info.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceTest {


    @Autowired
    private UserService userService;

    @Test
    public void get() {
    }

    @Test
    public void list() {
        for (UserDO userDO : userService.list(new HashMap<>())) {
            System.out.println(userDO.getUsername());

        }
    }

    @Test
    public void count() {
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void batchRemove() {
    }
}