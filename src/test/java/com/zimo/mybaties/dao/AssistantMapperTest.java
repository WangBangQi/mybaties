package com.zimo.mybaties.dao;

import com.zimo.mybaties.model.Assistant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssistantMapperTest {
    @SuppressWarnings("all")
    @Resource
    AssistantMapper assistantMapper;
    @Test
    public void insert() throws Exception {
        Assistant assistant = new Assistant();
        assistant.setAssistantNum("1315151521");
        assistant.setName("还在于是");
        assistantMapper.insert(assistant);
        Assert.assertNotNull(assistant.getAssistantId());
    }

    @Test
    public void searchByAssistantId()throws Exception{
        Assert.assertNotNull(assistantMapper.searchByAssId(1));
    }

}