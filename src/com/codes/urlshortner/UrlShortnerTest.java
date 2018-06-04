package com.codes.urlshortner;

import org.junit.Test;

import static org.junit.Assert.*;

public class UrlShortnerTest {
    @Test
    public void test() {
        UrlShortner url = new UrlShortner();
        System.out.println("sam");
        String shotUrl = url.getShotUrl("www.facebook.com");
        String longeUrl = url.retrievLongeUrl(shotUrl);
        assertEquals("www.facebook.com", longeUrl);
    }

}