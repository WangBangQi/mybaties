package com.zimo.mybaties.service;

import com.sun.org.apache.bcel.internal.generic.FNEG;
import com.zimo.mybaties.dao.StudentMapper;
import com.zimo.mybaties.dto.StudentDto_2;
import com.zimo.mybaties.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentService extends BaseMapper {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentDto_2 getStudentDetail_2ByStuId(Integer stuId){
        logger.info("查询学生，学生ID是：{}",stuId);
        logger.debug("查询学生，学生ID是：{}",stuId);
        logger.error("查询学生，学生ID是：{}",stuId);
        logger.warn("查询学生，学生ID是：{}",stuId);
        return studentMapper.getDetailStudentByStuId_3(stuId);
    }


    public void addNewStudent(String name,Long birthDate){
        Student student = new Student();
        student.setBirthDate(birthDate);
        student.setName(name);

    }





}
