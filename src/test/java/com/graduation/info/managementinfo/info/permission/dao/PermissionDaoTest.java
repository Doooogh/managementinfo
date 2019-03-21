package com.graduation.info.managementinfo.info.permission.dao;

import com.graduation.info.managementinfo.info.permission.domain.PermissionDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionDaoTest {

    @Autowired
    private PermissionDao permissionDao;

    @Test
    public void list() {
        for (PermissionDO permissionDO : permissionDao.list(new HashMap<>())) {
            System.out.println(permissionDO.getName());
        }
    }

    @Test
    public void test111(){
        String time="2019-12-21T";
        System.out.println( LocalDateTime.parse(time));


    }
}