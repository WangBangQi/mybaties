package com.zimo.mybaties.dao;

import com.zimo.mybaties.model.StudentRole;

public interface StudentRoleMapper {
    void add(StudentRole studentRole);

    StudentRole get(Integer studentRoleId);
}
