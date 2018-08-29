package com.zimo.mybaties.dao;

import com.zimo.mybaties.dto.StudentDto;
import com.zimo.mybaties.dto.StudentDto_2;
import com.zimo.mybaties.model.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {
    @SuppressWarnings("all")
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void add() throws Exception {
        for (int i=10;i<20;i++)
        studentMapper.add(new Student("123"+i,"天涯"+i,777524356000l));
    }

    @Test
    public void searchByStuNum()throws Exception{
        Student student = studentMapper.searchByStuNum("1231");
        Assert.assertNotNull(student);
        System.out.println(student.toString());
    }

    @Test
    public void searchById()throws Exception{
        Student student = studentMapper.searchById(11);
        Assert.assertNotNull(student);
        System.out.println(student.toString());
    }

    @Test
    public void listByClassId()throws Exception{
        List<Student> students = studentMapper.listByClassId(3);
        Assert.assertNotNull(students);
        Assert.assertEquals(20,students.size());
    }

    @Test
    public void getDetailStudentByStuId()throws Exception{
        StudentDto studentDto = studentMapper.getDetailStudentByStuId(22);
        Assert.assertNotNull(studentDto);
        Assert.assertEquals("1921083145",studentDto.getClassNum());
    }

    @Test
    public void getDetailStudentByStuId_2()throws Exception{
        StudentDto studentDto_2 = studentMapper.getDetailStudentByStuId_2(22);
        Assert.assertNotNull(studentDto_2);
        Assert.assertEquals("1921083145",studentDto_2.getClassNum());
    }

    @Test
    public void getDetailStudentByStuId_3()throws Exception{
        StudentDto_2 studentDto_2 = studentMapper.getDetailStudentByStuId_3(22);
        Assert.assertNotNull(studentDto_2);
        Assert.assertNotNull(studentDto_2.getAssistant());
        Assert.assertNotNull(studentDto_2.gettClass());
        Assert.assertEquals("1315151521",studentDto_2.getAssistant().getAssistantNum());
        Assert.assertEquals("还在于是",studentDto_2.getAssistant().getName());
        Assert.assertEquals("1921083145",studentDto_2.gettClass().getClassNum());
        Assert.assertEquals("数学",studentDto_2.gettClass().getClassName());
        Assert.assertNull(studentDto_2.gettClass().getAssistant());
    }
}