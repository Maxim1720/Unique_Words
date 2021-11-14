package com.uniqueWords.uniqueWords.service;

import com.uniqueWords.uniqueWords.entity.Url;
import com.uniqueWords.uniqueWords.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;

@Service
public class MainService {

    private final UrlService urlService;
    private final WordService wordService;

    private Url url;
    private Set<Word> words;

    @Autowired
    public MainService(
            UrlService urlService,
            WordService wordService){
        this.urlService = urlService;
        this.wordService = wordService;
    }

    public Set<Word> getWords(String url) throws IOException {

        words = wordService.getByUrl(url);

        if (!urlExists(url)) {
            createUrl(url);
            setWordsToUrl();
            setUrlToWords();
            saveUrlAndWords();
        }

        return words;
    }

    private boolean urlExists(String url)
    {
        return urlService.exists(url);
    }

    private void createUrl(String url)
    {
        this.url = new Url(url);
    }
    private void setWordsToUrl()
    {
        this.url.setWords(words);
    }
    private void setUrlToWords()
    {
        for (Word w:
             words) {
            w.setUrl(url);
        }
    }

    private void saveUrlAndWords()
    {
        urlService.save(url);
        wordService.saveAll(words);

    }
}
