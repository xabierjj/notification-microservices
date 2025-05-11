package com.xabierjj.urlshortener.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xabierjj.urlshortener.model.ShortUrl;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
    Optional<ShortUrl> findByUrlKey(String urlKey);
}
