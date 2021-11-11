package com.uniqueWords.uniqueWords.correctObjects;

import javax.validation.constraints.Pattern;

public class URL {

    @Pattern(regexp = "^http://([a-z0-9]-?)+\\.([a-z0-9]{2,})/$",
            message = "string does not match url format")
    private String url;

    public URL(String url)
    {
        this.url = url;
    }
    public URL()
    {

    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }



}
