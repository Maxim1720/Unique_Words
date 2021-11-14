package com.uniqueWords.uniqueWords.util;

import com.uniqueWords.uniqueWords.entity.Word;

import java.util.*;

public class WordsCounter {

    private String[] allWords;
    private Set<Word> words;

    public WordsCounter(String text)
    {
        allWords = new TextSplitter(text).splitIntoWords();
    }
    public Set<Word> get()
    {
        calculate();
        return words;
    }


    private void calculate()
    {
        words = new HashSet<>();

        HashMap<String, Integer> hm = calculatedWordsInHashMap();

        for (String w:
             hm.keySet()) {
            Word word = new Word();
            word.setAmount(hm.get(w));
            word.setText(w);
            words.add(word);
        }

    }

    private HashMap<String,Integer> calculatedWordsInHashMap()
    {
        HashMap<String,Integer> wordsHashMap = new HashMap<>();

        for (String w:
                allWords) {
            if(wordsHashMap.containsKey(w))
            {
                wordsHashMap.replace(w,wordsHashMap.get(w)+1);
            }
            else
            {
                wordsHashMap.put(w,1);
            }
        }
        return wordsHashMap;
    }




}
