package com.uniqueWords.uniqueWords.repository;

import com.uniqueWords.uniqueWords.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRep extends JpaRepository<Url, Long> {
    Optional<Url> findByValue(String value);
}
