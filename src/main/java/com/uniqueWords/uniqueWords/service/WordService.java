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

    private final WordRep wordRep;

    @Autowired
    public WordService(WordRep wordRep){
        this.wordRep = wordRep;
    }

    public Set<Word> getByUrl(String url) {
        return wordRep.findAllByUrlValue(url);
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

    public void delete(Word word)
    {
        wordRep.delete(word);
    }
    public void delete(Long id)
    {
        wordRep.deleteById(id);
    }


}
