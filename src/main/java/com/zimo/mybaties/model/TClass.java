package com.zimo.mybaties.model;

import java.io.Serializable;
import java.util.List;

/**
 * 班级
 */
public class TClass implements Serializable{
    private Integer classId;
    private String classNum;  //班级编号
    private String className;   //班级名称
    private List<Student> students; //班级的学生
    private Assistant assistant;    //辅导员

    public TClass() {
    }

    public TClass(String classNum, String className) {
        this.classNum = classNum;
        this.className = className;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
