package com.nutzycraft.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class GoogleAuthService {

    private static final String GOOGLE_TOKEN_INFO_URL = "https://oauth2.googleapis.com/tokeninfo?id_token=";
    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> verifyToken(String idToken) {
        try {
            // Validate token against Google's server
            // Returns a Map with keys like "email", "name", "aud", etc.
            Map<String, Object> payload = restTemplate.getForObject(GOOGLE_TOKEN_INFO_URL + idToken, Map.class);

            String aud = (String) payload.get("aud");
            if (!"395279487546-l48b8apos5dpa0fctvltp6hhsfl10o83.apps.googleusercontent.com".equals(aud)) {
                throw new RuntimeException("Invalid Client ID in Token");
            }

            return payload;
        } catch (Exception e) {
            throw new RuntimeException("Invalid Google Token");
        }
    }
}
