package org.example.miniproject1.external;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FraudClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean isFraudulent(String email, String baseUrl) {
        String url = baseUrl + "/fraud-check?email=" + email;
        Boolean result = restTemplate.getForObject(url, Boolean.class);
        return result != null && result;
    }
}
