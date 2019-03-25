package com.graduation.info.managementinfo.info.school.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolServiceTest {

    @Autowired
    private SchoolService schoolService;
    @Test
    public void getEGuideUrlBySchoolId() {
        String url=schoolService.getEGuideUrlBySchoolId(2);
        System.out.println(url);
    }
}