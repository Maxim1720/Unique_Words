package com.uniqueWords.uniqueWords.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniqueWords.uniqueWords.correctObjects.URL;
import com.uniqueWords.uniqueWords.entity.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.List;

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

    URL url;

    @BeforeEach
    private void init()
    {
        url = new URL();
        url.setUrl("https://simbirsoft.ru/");
    }

    @Test
    void get() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/unique_words/").
                        param("url", url.getUrl())
                        /*content(objectMapper.writeValueAsBytes(url.getUrl())).
                        contentType(MediaType.APPLICATION_JSON)*/
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String responseContent = mvcResult.getResponse().getContentAsString();
        List<Word> words = objectMapper.readValue(responseContent,
                new TypeReference<>() {});

        for (Word w:
             words) {
            System.out.println(w.getText() + ":" + w.getAmount());
        }
    }
}