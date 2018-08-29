package com.zimo.mybaties.model;

/**
 * 学生实体
 */
public class Student {
    private Integer stuId;
    private String stuNum;  //学生编号,unique
    private String name;
    private Long birthDate;

    public Student() {
    }

    public Student(String stuNum, String name, Long birthDate) {
        this.stuNum = stuNum;
        this.name = name;
        this.birthDate = birthDate;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuNum='" + stuNum + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
