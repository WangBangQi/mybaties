package com.zimo.mybaties.service;

import com.zimo.mybaties.dto.StudentDto_2;
import com.zimo.mybaties.dto.student.StudentCacheDto;
import com.zimo.mybaties.model.Student;

import java.util.List;

public interface StudentService {

    StudentDto_2 getStudentDetail_2ByStuId(Integer stuId);

    void insertCache(StudentCacheDto cacheDto);

    List<Student> searchByName(String name);
    List<Student> searchLikeName(String name);

    StudentCacheDto getCache(Student student);
    StudentCacheDto getCache(String studentNum);

    void removeCache(String studentNum);
}
