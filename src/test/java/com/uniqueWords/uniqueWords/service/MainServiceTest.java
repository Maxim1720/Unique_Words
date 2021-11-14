package com.uniqueWords.uniqueWords.service;

import com.uniqueWords.uniqueWords.entity.Word;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MainServiceTest {

    @Autowired
    MainService mainService;

    String value = "http://vk.com/";

    @Test
    void getWords() throws IOException {

        for (Word w:
                mainService.getWords(value)) {
            System.out.println(w.getText() + ":" + w.getAmount());
        }

    }
}