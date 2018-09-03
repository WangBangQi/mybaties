package com.zimo.mybaties.controller;


import com.zimo.mybaties.annoation.Access;
import com.zimo.mybaties.annoation.Token;
import com.zimo.mybaties.dao.StudentMapper;
import com.zimo.mybaties.dto.StudentDto_2;
import com.zimo.mybaties.model.Student;
import com.zimo.mybaties.service.StudentServiceImpl;
import com.zimo.mybaties.util.Result;
import com.zimo.mybaties.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/student")
public class StudentController {

    @SuppressWarnings("all")
    @Resource
    StudentMapper studentMapper;
    @Autowired
    StudentServiceImpl studentServiceImpl;

    @RequestMapping("/get")
    public Result searchByNum(@RequestParam("stuNum")String stuNum){
        Student student = studentMapper.searchByStuNum(stuNum);
        return ResultUtil.success(student,"获取学生信息");
    }

    @RequestMapping(value = "/{stu_id}")
    public Result searchById(@PathVariable("stu_id")Integer studentId){
        return ResultUtil.success(studentServiceImpl.getStudentDetail_2ByStuId(studentId),"获取学生信息");
    }

    @RequestMapping("/id")
    public Result getById(@RequestParam("stuId")Integer stuId){
        StudentDto_2 studentDto_2 = studentMapper.getDetailStudentByStuId_3(stuId);
        return ResultUtil.success(studentDto_2,"获取学生信息");
    }

    @Access(permission = "student_eat")
    @RequestMapping("/eat/{stuId}")
    public Result eat(@PathVariable("stuId")Integer stuId){
        return ResultUtil.success();
    }

}
