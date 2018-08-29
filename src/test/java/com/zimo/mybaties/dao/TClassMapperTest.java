package com.zimo.mybaties.dao;

import com.zimo.mybaties.model.TClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.TCKind;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TClassMapperTest {

    @SuppressWarnings("all")
    @Resource
    private TClassMapper tClassMapper;

    @Test
    public void insert() throws Exception {
        TClass tClass = new TClass("1921083145","数学");
        tClassMapper.insert(tClass);
        Assert.assertNotNull("新增的数据，不会自动赋值id值给tclass的id",tClass.getClassId());
        System.out.println("新增的ID："+tClass.getClassId());
    }


    @Test
    public void searchByClassNum()throws Exception{
        TClass tClass = tClassMapper.searchByClassNum("1921083145");
        Assert.assertNotNull("查询classNum=1921083145结果为null",tClass);
        Assert.assertEquals("不为null的参数classId为null了",(Integer) 3,tClass.getClassId());
        Assert.assertEquals("数学",tClass.getClassName());
        Assert.assertEquals("1921083145",tClass.getClassNum());
        Assert.assertNotNull("没有查询到Assistant",tClass.getAssistant());
        Assert.assertEquals("查询到的Assistant期望值不符合","1315151521",tClass.getAssistant().getAssistantNum());

        Assert.assertNotNull(tClass.getStudents());
        Assert.assertEquals(20,tClass.getStudents().size());

    }

    @Test
    public void searchById()throws Exception{
        TClass tClass = tClassMapper.searchById(3);
        Assert.assertNotNull(tClass);
        Assert.assertEquals("1921083145",tClass.getClassNum());

    }
}