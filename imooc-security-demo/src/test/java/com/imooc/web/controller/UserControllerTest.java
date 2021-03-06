package com.imooc.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void query() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
        ;
    }

    @Test
    public void fun1() {
        System.out.println(System.currentTimeMillis());
    }


    @Test
    public void update() throws Exception {
        Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        log.info("【now={}】", date.getTime());

        String content = "{\"username\":\"zhy\",\"id\":\"111\",\"birthday\":1529180256918}\t";

        String result = mockMvc
                .perform(put("/user/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();

        log.info("【result={}】", result);
    }

    @Test
    public void deleteTest() throws Exception {
        mockMvc.perform(delete("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }
}