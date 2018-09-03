package com.zimo.mybaties.dto.student;

import com.zimo.mybaties.model.StudentRole;

public class StudentPermissionDto {
    private Integer stuId;
    private String stuNum;  //学生编号,unique
    private String studentName;
    private Long birthDate;
    private StudentRole studentRole;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public StudentRole getStudentRole() {
        return studentRole;
    }

    public void setStudentRole(StudentRole studentRole) {
        this.studentRole = studentRole;
    }
}
