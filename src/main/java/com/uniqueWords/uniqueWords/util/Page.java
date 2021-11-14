package com.uniqueWords.uniqueWords.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Page {

    private final Document htmlDocument;

    public Page(String url) throws IOException {
        Connection connection = Jsoup.connect(url);
        htmlDocument = connection.ignoreHttpErrors(true).get();
    }
    public String text()
    {
        return htmlDocument.body().text();
    }


}
