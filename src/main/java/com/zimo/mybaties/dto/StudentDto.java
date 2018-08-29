package com.zimo.mybaties.dto;

public class StudentDto {
    private Integer stuId;
    private String stuNum;  //学生编号,unique
    private String studentName;
    private Long birthDate;
    private String classNum;
    private String className;

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

    @Override
    public String toString() {
        return "StudentDto{" +
                "stuId=" + stuId +
                ", stuNum='" + stuNum + '\'' +
                ", studentName='" + studentName + '\'' +
                ", birthDate=" + birthDate +
                ", classNum='" + classNum + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
