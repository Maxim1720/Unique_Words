package com.uniqueWords.uniqueWords.service;

import com.uniqueWords.uniqueWords.entity.Word;
import com.uniqueWords.uniqueWords.util.Page;
import com.uniqueWords.uniqueWords.util.WordsCounter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;

@Service
class WordsCounterService {
    public Set<Word> getByUrl(String url) throws IOException {
        return new WordsCounter(new Page(url).text()).get();
    }
}
