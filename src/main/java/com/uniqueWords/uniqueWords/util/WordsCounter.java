package com.uniqueWords.uniqueWords.util;

import com.uniqueWords.uniqueWords.entity.Word;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.*;

public class WordsCounter {

    private String url;
    private TextSplitter textSplitter;
    private Document htmlDocument;
    private List<Word> words;
    private HashMap<String, Integer> wordsMap;
    private Connection connection;

    public WordsCounter(){}
    public WordsCounter(String url){
        this.url = url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public List<Word> count() throws IOException {
        connect();
        init();
        calculateUniques();
        fill();
        return words;
    }

    public void connect()
    {
        connection = Jsoup.connect(url);
    }

    private void init() throws IOException {
        htmlDocument = connection.get();
        textSplitter = new TextSplitter(htmlDocument.body().text());
        words = new ArrayList<>();
        wordsMap = new HashMap<>();
    }

    private void calculateUniques()
    {
        for (String str:
                textSplitter.split()) {
            if (wordsMap.containsKey(str)) {
                wordsMap.replace(str, wordsMap.get(str) + 1);
            } else {
                wordsMap.put(str, 1);
            }
        }
    }

    private void fill()
    {
        for (String str: wordsMap.keySet()) {
            Word w = new Word();
            w.setUrl(url.toCharArray());
            w.setText(str);
            w.setCount(wordsMap.get(str));

            words.add(w);
        }
    }



}