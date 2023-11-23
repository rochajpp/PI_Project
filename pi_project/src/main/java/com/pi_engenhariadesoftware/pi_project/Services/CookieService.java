package com.pi_engenhariadesoftware.pi_project.Services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieService {
    public static void setCookie(HttpServletResponse response, String key, String value, int seconds) throws IOException{
        Cookie cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
        cookie.setMaxAge(seconds);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request, String key) throws UnsupportedEncodingException{
        String value = null;

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (key.equals(cookie.getName())) {
                    value = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    break;
                }
            }
        }
        return value;
    }
}
