package com.uniqueWords.uniqueWords.controller;

import com.uniqueWords.uniqueWords.entity.Word;
import com.uniqueWords.uniqueWords.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Set;

@Controller
@RequestMapping("/unique_words")
public class UniqueWordsController {

    MainService mainService;

    @Autowired
    public UniqueWordsController(MainService mainService)
    {
        this.mainService = mainService;
    }

    @GetMapping
    public ResponseEntity get(@RequestParam String url) {

        ResponseEntity responseEntity;
        try {
            Set<Word> wordList = mainService.getWords(url);
            responseEntity = ResponseEntity.ok(wordList);
        } catch (IOException | IllegalArgumentException e) {
            responseEntity = ResponseEntity.badRequest().body("incorrect url:\n" + e.getMessage());
        }
        return responseEntity;
    }
}
