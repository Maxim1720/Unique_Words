package com.uniqueWords.uniqueWords.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniqueWords.uniqueWords.entity.Word;
import com.uniqueWords.uniqueWords.util.URL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.Charset;
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
        url.setUrl("http://vk.com/");
    }

    @Test
    void get() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/unique_words/").
                        content(objectMapper.writeValueAsBytes(url)).
                        contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String responseContent = mvcResult.getResponse().getContentAsString();
        List<Word> words = objectMapper.readValue(responseContent,
                new TypeReference<>() {});

        File file = new File("test.txt");
        FileWriter fileWriter = new FileWriter(file);

        for (Word w:
             words) {
            fileWriter.write(w.getText() + ":" + w.getCount());
            fileWriter.write("\n");
            System.out.println(w.getText() + ":" + w.getCount());
        }
        fileWriter.close();
    }
}