package com.zimo.mybaties.service;

import com.zimo.mybaties.constants.TokenConstants;
import com.zimo.mybaties.dto.StudentDto_2;
import com.zimo.mybaties.dto.student.StudentCacheDto;
import com.zimo.mybaties.model.Student;
import com.zimo.mybaties.service.redis.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl extends BaseMapper implements StudentService{

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Resource
    private RedisClient redisClient;

    @Override
    public StudentDto_2 getStudentDetail_2ByStuId(Integer stuId){
        logger.info("查询学生，学生ID是：{}",stuId);
        logger.debug("查询学生，学生ID是：{}",stuId);
        logger.error("查询学生，学生ID是：{}",stuId);
        logger.warn("查询学生，学生ID是：{}",stuId);
        return studentMapper.getDetailStudentByStuId_3(stuId);
    }

    @Override
    public void insertCache(StudentCacheDto cacheDto) {
        String key = createCacheKey(cacheDto.getStudentNum());
        redisClient.hSet(key,cacheDto);
    }

    @Override
    public StudentCacheDto getCache(Student student) {
        return student==null?null:getCache(student.getStuNum());
    }

    @Override
    public StudentCacheDto getCache(String studentNum) {
        if (studentNum == null) return null;
        String key = createCacheKey(studentNum);
        return redisClient.hGet(key,StudentCacheDto.class);
    }

    @Override
    public void removeCache(String studentNum) {
        String key = createCacheKey(studentNum);
        redisClient.delete(key);
    }

    @Override
    public List<Student> searchByName(String name) {
        return null;
    }

    @Override
    public List<Student> searchLikeName(String name) {
        return null;
    }

    private String createCacheKey(String studentNum){
        return TokenConstants.CACHE_STUDENT_KEY+studentNum;
    }
}
