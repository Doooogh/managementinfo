package com.graduation.info.managementinfo.system.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileUtilTest {

    @Test
    public void getEGuide() {
        try {
            String str=FileUtil.getEGuide("f:\\file\\eguide\\54898832-56df-4d5b-875d-c3461dbf86b02.txt");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
     /*   try {
            FileUtil.saveEGuide("sgsgsgg",1);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}