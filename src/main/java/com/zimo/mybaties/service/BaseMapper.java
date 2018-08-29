package com.zimo.mybaties.service;

import com.zimo.mybaties.dao.AssistantMapper;
import com.zimo.mybaties.dao.StudentMapper;
import com.zimo.mybaties.dao.TClassMapper;

import javax.annotation.Resource;

public class BaseMapper {
    @Resource
    public StudentMapper studentMapper;

    @Resource
    public AssistantMapper assistantMapper;

    @Resource
    public TClassMapper tClassMapper;
}
