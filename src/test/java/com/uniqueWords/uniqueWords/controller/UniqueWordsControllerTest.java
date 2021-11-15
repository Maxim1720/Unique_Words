package com.uniqueWords.uniqueWords.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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


import java.io.*;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class UniqueWordsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UniqueWordsController uniqueWordsController;

    @Autowired
    ObjectMapper objectMapper;

    File pages;
    BufferedReader fileReader;

    @BeforeEach
    private void init() throws FileNotFoundException {
        pages = new File("src/main/resources/static/web_pages");
        fileReader = new BufferedReader(new FileReader(pages));
    }

    @Test
    void get() throws Exception {

        while (fileReader.ready())
        {
            String line = fileReader.readLine();
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/unique_words/").
                            param("url", line)
            ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
            System.out.println(line);
        }

        /*String responseContent = mvcResult.getResponse().getContentAsString();
            List<Word> words = objectMapper.readValue(responseContent,
                    new TypeReference<>() {});*/
        /*for (Word w:
             words) {
            System.out.println(w.getText() + ":" + w.getAmount());
        }*/
    }
}