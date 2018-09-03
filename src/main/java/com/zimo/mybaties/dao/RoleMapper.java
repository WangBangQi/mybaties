package com.zimo.mybaties.dao;

import com.zimo.mybaties.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    void add(Role role);
    Role get(@Param("roleId") Integer roleId);
    List<Role> getListByStudentRoleId(@Param("studentRoleId")Integer studentRoleId);
}
