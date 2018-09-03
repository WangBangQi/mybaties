package com.zimo.mybaties.model;

import com.zimo.mybaties.constants.StudentRoleEnum;

import java.util.List;

public class StudentRole {
    private Integer id;
    private String name;
    private Integer studentRoleEnum;
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentRoleEnum() {
        return studentRoleEnum;
    }

    public void setStudentRoleEnum(Integer studentRoleEnum) {
        this.studentRoleEnum = studentRoleEnum;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
