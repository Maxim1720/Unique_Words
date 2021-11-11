package com.uniqueWords.uniqueWords.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.uniqueWords.uniqueWords.entity.Word;
import com.uniqueWords.uniqueWords.util.URL;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest
class UniqueWordsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UniqueWordsController uniqueWordsController;

    @Autowired
    ObjectMapper objectMapper;

    String url;
    URL url_;

    @BeforeEach
    private void init()
    {
        url = "http://vk.com/";
        url_ = new URL();
        url_.setUrl(url);
    }

    @Test
    void get() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/unique_words").
                        param("url", url)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String responseContent = mvcResult.getResponse().getContentAsString();

        List<Word> words = objectMapper.readValue(responseContent,
                new TypeReference<>() {});

        for (Word w:
             words) {
            System.out.println(w.getText() + ":" + w.getCount());
        }
    }
}