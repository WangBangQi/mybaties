package com.zimo.mybaties.dao;

import com.zimo.mybaties.constants.StudentRoleEnum;
import com.zimo.mybaties.model.StudentRole;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRoleMapperTest {
    @Autowired
    StudentRoleMapper studentRoleMapper;
    @Test
    public void add() throws Exception {
    }

    @Test
    public void get() throws Exception {
        StudentRole studentRole = studentRoleMapper.get(1);
        Assert.assertNotNull(studentRole);
        assertEquals(StudentRoleEnum.NORMAL.getValue(),studentRole.getStudentRoleEnum());
        assertNotNull("没有查询到roles",studentRole.getRoles());

    }

}