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
        for (int i=1000;i<1500;i++)
            for (int j=300;j<400;j++) {
                studentMapper.add(new Student("123" + i+j, "天涯" + i+j, 777524356000l+i*j));
            }
    }

    @Test
    public void searchByStuNum()throws Exception{
        Student student = studentMapper.searchByStuNum("1231");
        Assert.assertNotNull(student);
        System.out.println("中间的数据");
        studentMapper.searchByStuNum("123105116");
        System.out.println("最后一条数据");
        studentMapper.searchByStuNum("123109179");

    }

    @Test
    public void searchById()throws Exception{
        Student student = studentMapper.searchById(11);
        Assert.assertNotNull(student);
        Assert.assertNotNull(student.getStudentRole());
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

    @Test
    public void listByNameLike()throws Exception{
        List<Student> students = studentMapper.listByNameLike("天涯109");
        Assert.assertNotNull(students);
        assertEquals(true,students.size()>=1);
        System.out.println("查询到的学生的个数为:"+students.size());
    }

    @Test
    public void listByName()throws Exception{
        List<Student > students = studentMapper.listByName("天涯109177");
        Assert.assertNotNull(students);
    }


    @Test
    public void listByStuNumLike()throws Exception{
        List<Student> students = studentMapper.listByStuNumLike("12310");
        Assert.assertNotNull(students);
        assertEquals(true,students.size()>=1);
        System.out.println("查询到的学生的个数为:"+students.size());
    }

    @Test
    public void getByStuNum()throws Exception{
        Student student = studentMapper.getByStuNum("123108125");
        Assert.assertNotNull(student);
    }
}