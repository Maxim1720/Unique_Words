package com.uniqueWords.uniqueWords.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "word")
@Entity
public class Word {
    @JsonIgnore
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "value_url")
    @Getter
    @Setter
    private Url url;

    @Getter
    @Setter
    @Column(name = "amount")
    private Integer amount;

    @Getter
    @Setter
    @Column(name = "text", length = 50)
    private String text;
}