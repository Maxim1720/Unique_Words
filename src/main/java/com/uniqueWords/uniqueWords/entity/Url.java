package com.uniqueWords.uniqueWords.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@Table(name = "url")
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NaturalId
    @Column(name = "value", nullable = false)
    private String value;

    @OneToMany(mappedBy = "url", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Word> words;

    public Url(String value)
    {
        this.value = value;
    }
    public Url(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Set<Word> getWords() {
        return words;
    }

    public void setWords(Set<Word> words) {
        this.words = words;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}