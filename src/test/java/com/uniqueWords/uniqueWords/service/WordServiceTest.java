package com.uniqueWords.uniqueWords.service;

import com.uniqueWords.uniqueWords.entity.Word;
import org.apache.logging.log4j.util.Chars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WordServiceTest {

    @Autowired
    WordService wordService;

    @Test
    void getAllByUrl() {
        char[] charArray = "http://vk.com/".toCharArray();

        try {
            for (Word w:
                 wordService.getAllByUrl(charArray)) {
                Assertions.assertNotNull(w);
                System.out.println(w.getText()+":"+w.getCount());
            }
            wordService.getAllByUrl(charArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}