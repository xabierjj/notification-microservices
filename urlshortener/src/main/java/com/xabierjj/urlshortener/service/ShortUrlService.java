package com.xabierjj.urlshortener.service;

import com.xabierjj.urlshortener.model.ShortUrl;
import com.xabierjj.urlshortener.repository.ShortUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShortUrlService {

    private final ShortUrlRepository repository;

    public ShortUrl createShortUrl(String redirectUrl, String userId) {
        String urlKey = UUID.randomUUID().toString().substring(0, 8);
        ShortUrl shortUrl = ShortUrl.builder()
                .urlKey(urlKey)
                .redirectUrl(redirectUrl)
                .userId(userId)
                .build();
        return repository.save(shortUrl);
    }

    public Optional<ShortUrl> getByUrlKey(String urlKey) {
        return repository.findByUrlKey(urlKey);
    }
}
