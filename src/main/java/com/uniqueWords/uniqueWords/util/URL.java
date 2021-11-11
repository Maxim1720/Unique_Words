package com.uniqueWords.uniqueWords.util;

import javax.validation.constraints.Pattern;

public class URL {

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Pattern(regexp = "^http://([a-z0-9]-?)+\\.([a-z0-9]{2,})/$",
            message = "string does not match url format")
    private String url;


}
