package com.zimo.mybaties.dao;

import com.zimo.mybaties.dto.StudentDto;
import com.zimo.mybaties.dto.StudentDto_2;
import com.zimo.mybaties.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Student Mapper接口
 */
public interface StudentMapper {
    void add(Student student);

    Student searchByStuNum(@Param("stuNum") String stuNum);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<Student> listByNameLike(@Param("name") String name);
    List<Student> listByName(@Param("name")String name);

    List<Student> listByStuNumLike(@Param("stuNum")String stuNum);
    Student getByStuNum(@Param("stuNum")String stuNum);

    Student searchById(@Param("stuId")Integer stuId);

    StudentDto getDetailStudentByStuId(@Param("stuId")Integer stuId);

    StudentDto_2 getDetailStudentByStuId_3(@Param("stuId")Integer stuId);

    List<Student> listByClassId(@Param("classId") Integer classId);

    StudentDto getDetailStudentByStuId_2(@Param("stuId")Integer stuId);


}
