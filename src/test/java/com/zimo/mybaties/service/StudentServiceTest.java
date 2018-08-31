package com.zimo.mybaties.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;
    @Test
    public void getStudentDetail_2ByStuId() throws Exception {
        Assert.assertNotNull(studentService.getStudentDetail_2ByStuId(22));

    }

    @Test
    public void addNewStudent() throws Exception {
    }

}