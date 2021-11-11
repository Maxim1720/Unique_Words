package com.uniqueWords.uniqueWords.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSplitter {

    Pattern corrWordsRep;
    Matcher textMatcher;

    public TextSplitter(String text)
    {
        corrWordsRep = Pattern.compile(
                "(\\p{javaLetter}+)"+
                        "|(\\p{javaDigit}+)");

        textMatcher = corrWordsRep.matcher(text);
    }

    public String[] split()
    {
        ArrayList<String> tempStrs = new ArrayList<>();
        while (textMatcher.find())
        {
            tempStrs.add(textMatcher.group());
        }
        String[] words = new String[tempStrs.size()];
        int i=0;
        for (String s:tempStrs
        ) {
            words[i++] = s;
        }
        return words;
    }
}
