package com.zimo.mybaties.service.redis;

import com.zimo.mybaties.dao.StudentMapper;
import com.zimo.mybaties.dto.StudentDto_2;
import com.zimo.mybaties.model.Student;
import com.zimo.mybaties.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClientTest {

    @Autowired
    RedisClient redisClient;

    @Autowired
    StudentService studentService;

    @Test
    public void setStr() throws Exception {
        StudentDto_2 student  = studentService.getStudentDetail_2ByStuId(22);
        Assert.assertNotNull(student);
        String key = createKey(student);
        System.out.println(key);
        redisClient.setStr(key,student,2000*1000);
        StudentDto_2 value = (StudentDto_2) redisClient.getStr(key);
        Assert.assertNotNull(value);
        Assert.assertEquals(true,redisClient.hasKey(key));
//        Thread.sleep(20*1000);
//        Assert.assertEquals(false,redisClient.hasKey(key));

    }

    @Test
    public void getStr() throws Exception {
        StudentDto_2 value = (StudentDto_2) redisClient.getStr(createKey(studentService.getStudentDetail_2ByStuId(22)));
        Assert.assertNotNull("竟然空了",value);
        assertEquals(StudentDto_2.class.getName(),value.getClass().getName());
        assertEquals("12310",value.getStuNum());
        assertEquals(Long.valueOf(777524356000l),value.getBirthDate());
    }

    @Test
    public void del() throws Exception {

    }

    private String createKey(StudentDto_2 student){
        return buildKey(student.getClass(),student.getStuId(),student.getStudentName(),student.getStuNum());
    }

    private <T> String buildKey(Class<T> t,Object ... args){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(t.getName());
        for (Object param:args){
            stringBuilder.append(param);
        }
        return stringBuilder.toString();
    }

}