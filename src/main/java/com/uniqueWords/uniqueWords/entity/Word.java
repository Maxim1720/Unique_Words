package com.uniqueWords.uniqueWords.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(generator = "wordSeqPK")
    @Column(name = "id_word", nullable = false)
    private Long id;

    @NotNull(message = "url can't be null")
    @JsonIgnore
    @Column(name = "url_page", nullable = false, length = 1200)
    private char[] url;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "text")
    String text;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Column(name = "count")
    private int count;

    public char[] getUrl() {
        return url;
    }

    public void setUrl(char[] url) {
        this.url = url;
    }
}
