package com.zimo.mybaties.service;

import com.zimo.mybaties.dao.StudentMapper;
import com.zimo.mybaties.dto.StudentDto_2;
import com.zimo.mybaties.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentService extends BaseMapper {

    public StudentDto_2 getStudentDetail_2ByStuId(Integer stuId){
        return studentMapper.getDetailStudentByStuId_3(stuId);
    }


    public void addNewStudent(String name,Long birthDate){
        Student student = new Student();
        student.setBirthDate(birthDate);
        student.setName(name);

    }





}
