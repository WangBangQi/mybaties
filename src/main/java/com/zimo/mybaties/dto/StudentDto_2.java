package com.zimo.mybaties.dto;

import com.zimo.mybaties.model.Assistant;
import com.zimo.mybaties.model.TClass;

public class StudentDto_2 {
    private Integer stuId;
    private String stuNum;  //学生编号,unique
    private String studentName;
    private Long birthDate;
    private TClass tClass;
    private Assistant assistant;

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

    public TClass gettClass() {
        return tClass;
    }

    public void settClass(TClass tClass) {
        this.tClass = tClass;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }
}
