package com.zimo.mybaties.dao;

import com.zimo.mybaties.model.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {
    @Resource
    RoleMapper roleMapper;
    @Test
    public void add() throws Exception {
        save();
    }

    public void save(){
        Role role = new Role();
        role.setRoleName("student_monitor");
        role.setRoleDesc("普通学生");
        roleMapper.add(role);
    }
    @Test
    public void get() throws Exception {

        Assert.assertNotNull("role Id is null ",1);
        Assert.assertNotNull("role not insert into mysql",roleMapper.get(1));
    }

    @Test
    public void getListByStudentRoleId()throws Exception{
        List<Role> roles  = roleMapper.getListByStudentRoleId(2);
        Assert.assertNotNull(roles);
        assertEquals(2,roles.size());
    }
}