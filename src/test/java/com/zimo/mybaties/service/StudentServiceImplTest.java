package com.zimo.mybaties.service;

import com.zimo.mybaties.dto.student.StudentCacheDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void getStudentDetail_2ByStuId() throws Exception {
        Assert.assertNotNull(studentService.getStudentDetail_2ByStuId(22));

    }

    @Test
    public void addNewStudent() throws Exception {
    }

    @Test
    public void insertCache()throws Exception{
        String accessToken = "31oitn3knjsncfajoijpt13png3i-0iaf";
        String refreshToken = "agqgqgqjqgnlkngwjoiqgw";
        String stuNum = "asgq1251";
        StudentCacheDto cacheDto = new StudentCacheDto();
        cacheDto.setAccess_token(accessToken);
        cacheDto.setRefresh_token(refreshToken);
        cacheDto.setStudentNum(stuNum);
        studentService.insertCache(cacheDto);
        StudentCacheDto getValue = studentService.getCache(stuNum);
        Assert.assertNotNull("没有获取到缓存",getValue);
        Assert.assertEquals("accessToken error",accessToken,getValue.getAccess_token());
        Assert.assertEquals("refreshToken error",refreshToken,getValue.getRefresh_token());
    }

    @Test
    public void getCache()throws Exception{

    }

}