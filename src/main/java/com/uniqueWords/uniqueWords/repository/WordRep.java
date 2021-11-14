package com.uniqueWords.uniqueWords.repository;

import com.uniqueWords.uniqueWords.entity.Url;
import com.uniqueWords.uniqueWords.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.lang.NonNull;

import java.util.Optional;
import java.util.Set;

@EnableJpaRepositories
public interface WordRep extends JpaRepository<Word, Long> {
    Set<Word> findAllByUrl(Url url);
    Set<Word> findAllByUrlValue(String value);

    Optional<Word> findFirst1ByUrl_ValueEqualsIgnoreCase(@NonNull String value);



}
