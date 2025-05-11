package com.xabierjj.urlshortener.controller;

import com.xabierjj.urlshortener.model.ShortUrl;
import com.xabierjj.urlshortener.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/short-urls")
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    @PostMapping
    public ResponseEntity<ShortUrl> createShortUrl(@RequestParam String redirectUrl) {
        String userId = "1";
        return ResponseEntity.ok(shortUrlService.createShortUrl(redirectUrl, userId));
    }

    @GetMapping("/{urlKey}")
    public ResponseEntity<Object> redirect(@PathVariable String urlKey) {
        return shortUrlService.getByUrlKey(urlKey)
                .map(shortUrl -> ResponseEntity.status(302).header("Location", shortUrl.getRedirectUrl()).build())
                .orElse(ResponseEntity.notFound().build());
    }
}
