package com.zimo.mybaties.controller;

import com.zimo.mybaties.dao.StudentMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.PrintWriter;

import static org.junit.Assert.*;

@WebMvcTest
public class StudentControllerTest {
    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mvc;

    @MockBean
    StudentMapper studentMapper;

    @Test
    public void searchByNum() throws Exception {
        String uri = "/student/get";
        mvc.perform(MockMvcRequestBuilders.get(uri));

    }

}