package com.uniqueWords.uniqueWords.controller;

import com.uniqueWords.uniqueWords.entity.Word;
import com.uniqueWords.uniqueWords.service.WordService;
import com.uniqueWords.uniqueWords.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/unique_words")
public class UniqueWordsController {

    @Autowired
    private WordService wordService;

    @GetMapping
    public ResponseEntity get(@Valid @RequestBody URL url) {

        ResponseEntity responseEntity;
        try {
            List<Word> wordList = wordService.getAllByUrl(url.getUrl().toCharArray());
            responseEntity = ResponseEntity.ok(wordList);
        } catch (IOException e) {
            responseEntity = ResponseEntity.badRequest().body("incorrect url");
        }
        return responseEntity;
    }
}
