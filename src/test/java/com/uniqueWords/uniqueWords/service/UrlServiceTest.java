package com.uniqueWords.uniqueWords.service;

import com.uniqueWords.uniqueWords.entity.Url;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UrlServiceTest {

    String url = "http://vk.com/";

    @Autowired
    UrlService urlService;

    @Test
    void save() {
        Url url = new Url(this.url);
        urlService.save(url);
    }

    @Test
    void getByUrl() {
        urlService.getByUrl(url);
    }

    @Test
    void exists() {
        urlService.exists(url);
    }
}