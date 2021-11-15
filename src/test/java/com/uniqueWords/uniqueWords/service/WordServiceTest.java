package com.uniqueWords.uniqueWords.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class WordServiceTest {

    @Autowired
    WordService wordService;


    @Test
    void getByUrl() {
        String url = "http://vk.com/";

        Assertions.assertNotNull(wordService.getByUrl(url));
        Assertions.assertDoesNotThrow(()->wordService.getByUrl(url));

    }
}