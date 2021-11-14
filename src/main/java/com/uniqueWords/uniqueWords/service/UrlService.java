package com.uniqueWords.uniqueWords.service;

import com.uniqueWords.uniqueWords.entity.Url;
import com.uniqueWords.uniqueWords.repository.UrlRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private UrlRep urlRep;

    public void save(Url url) {
        urlRep.save(url);
    }

    public Url getByUrl(String url) {
        return urlRep.findByValue(url).get();
    }

    public boolean exists(String url)
    {
        return urlRep.findByValue(url).isPresent();
    }


}
