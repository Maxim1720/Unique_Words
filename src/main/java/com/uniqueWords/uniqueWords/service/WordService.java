package com.uniqueWords.uniqueWords.service;

import com.uniqueWords.uniqueWords.entity.Word;
import com.uniqueWords.uniqueWords.repository.WordRep;
import com.uniqueWords.uniqueWords.util.WordsCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Service
public class WordService {


    WordRep wordRep;

    WordsCounter wordsCounter;

    @Autowired
    public WordService(WordRep wordRep){
        this.wordRep = wordRep;
        wordsCounter = new WordsCounter();
    }
    public void save(Word word) {
        wordRep.save(word);
    }

    public void delete(char[] url) {
        //wordRep.deleteById(url);
    }

    public void saveAll(Set<Word> words) {
        wordRep.saveAll(words);
    }

    public List<Word> getAllByUrl(char[] url) throws IOException {

        List<Word> words;

        if(urlExists(url))
        {
            words = wordRep.findByUrl(url);
        }
        else
        {
            wordsCounter.setUrl(String.valueOf(url));
            words = wordsCounter.count();
            wordRep.saveAll(words);
        }
        return words;
    }

    private boolean urlExists(char[] url)
    {
        return !wordRep.findByUrl(url).isEmpty();
    }
}
