package com.uniqueWords.uniqueWords.service;

import com.uniqueWords.uniqueWords.entity.Word;
import com.uniqueWords.uniqueWords.util.Page;
import com.uniqueWords.uniqueWords.util.WordsCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WordsCounterTest {

    WordsCounter wordsCounter;
    String url = "https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D1%82%D0%BE%D0%BA%D0%BE%D0%BB_%D0%BF%D0%B5%D1%80%D0%B5%D0%B4%D0%B0%D1%87%D0%B8_%D0%B4%D0%B0%D0%BD%D0%BD%D1%8B%D1%85";

    File file;
    BufferedReader bufferedReader;

    @BeforeEach
    public void init() throws FileNotFoundException {
        file = new File("src/main/resources/static/web_pages");
        bufferedReader = new BufferedReader(new FileReader(file));

        wordsCounter = new WordsCounter(url);
    }

    @Test
    void setUrl() {
        Assertions.assertDoesNotThrow(()->wordsCounter = new WordsCounter(url));
    }

    @Test
    void count() {

        Assertions.assertDoesNotThrow(this::tryCount);
    }

    void tryCount(){
        for (Word w:
                wordsCounter.get()) {
            System.out.println(w.getText()+":"+w.getAmount());
        }
    }


    @Test
    void testOnConnecting() throws IOException {

        while (bufferedReader.ready())
        {
            String line = bufferedReader.readLine();
            System.out.println(line);
            Assertions.assertDoesNotThrow(()->connect(line));
        }
    }

    void connect(String url) throws IOException {
        wordsCounter = new WordsCounter(url);
        Page page = new Page(url);
    }

    @Test
    void testRegex()
    {
        url = "https://proglib.io/p/25-java-regex";
        Pattern pattern = Pattern.compile(
                "^[a-z]{3,5}://(\\p{Alnum}-?)+\\.(\\p{Alnum}{2,})([\\p{Alnum}/=?&_%.]-?)*$");
        Matcher matcher = pattern.matcher(url);

        while (matcher.find())
        {
            System.out.println(matcher.group());
        }
    }
}