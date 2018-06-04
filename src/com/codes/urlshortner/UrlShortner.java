package com.codes.urlshortner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UrlShortner {
    private final Map<String, String> urlDB;

    public UrlShortner() {
        urlDB = new HashMap<>();
    }

    public String getShotUrl(String longUrl) {
        String shortUrl = UUID.randomUUID().toString();
        urlDB.put(shortUrl, longUrl);
        return shortUrl;
    }

    public String retrievLongeUrl(String shortUrl) {
        return urlDB.get(shortUrl);
    }
}
