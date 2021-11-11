package com.uniqueWords.uniqueWords.service;

import com.uniqueWords.uniqueWords.entity.Word;
import com.uniqueWords.uniqueWords.util.URL;
import com.uniqueWords.uniqueWords.util.WordsCounter;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@SpringBootTest
class WordsCounterTest {

    WordsCounter wordsCounter;
    String url = "http://vk.com/";

    @BeforeEach
    public void init()
    {
        wordsCounter = new WordsCounter(url);
    }

    @Test
    void setUrl() {
        wordsCounter = new WordsCounter(url);
    }

    @Test
    void count() {
        try {
            for (Word w:
                 wordsCounter.count()) {
                System.out.println(w.getText()+":"+w.getCount());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testOnConnecting() {

        Assertions.assertDoesNotThrow(()->connect("https://downdetector.ru/"));
        Assertions.assertDoesNotThrow(()->connect("https://github.com/"));
        Assertions.assertDoesNotThrow(()->connect("https://www.my-chords.net/pornofilmy/127311-pornofilmy-uzhoe-gore.html"));
        Assertions.assertDoesNotThrow(()->connect("https://www.youtube.com/"));
    }

    void connect(String url)
    {
        wordsCounter.setUrl(url);
        wordsCounter.connect();
    }

    @Test
    void testRegex()
    {
        url = "http://dwa-ddd3-21234234w.com/";
        Pattern pattern = Pattern.compile(
                "^http://([a-z0-9]-?)+\\.([a-z0-9]{2,})/$");
        Matcher matcher = pattern.matcher(url);

        while (matcher.find())
        {
            System.out.println(matcher.group());
        }
    }
}