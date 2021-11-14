package com.uniqueWords.uniqueWords.service;

import com.uniqueWords.uniqueWords.entity.Word;
import com.uniqueWords.uniqueWords.repository.WordRep;
import com.uniqueWords.uniqueWords.util.Page;
import com.uniqueWords.uniqueWords.util.WordsCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;

@Service
class WordService {

    private WordRep wordRep;
    private WordsCounter wordsCounter;

    @Autowired
    public WordService(WordRep wordRep){
        this.wordRep = wordRep;
    }

    public Set<Word> getByUrl(String url) throws IOException {

        wordsCounter = new WordsCounter(new Page(url).text());
        Set<Word> words;
        if(exists(url))
        {
            words = wordRep.findAllByUrlValue(url);
        }
        else{
            words = wordsCounter.get();
        }
        return words;
    }


    public boolean exists(String url)
    {
        return wordRep.findFirst1ByUrl_ValueEqualsIgnoreCase(url).isPresent();
    }

    public void save(Word word) {
        wordRep.save(word);
    }

    public void saveAll(Set<Word> words) {
        wordRep.saveAll(words);
    }

}
