package com.uniqueWords.uniqueWords.repository;

import com.uniqueWords.uniqueWords.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface WordRep extends JpaRepository<Word, Long> {
    List<Word> findByUrl(char[] urlPage);
}
