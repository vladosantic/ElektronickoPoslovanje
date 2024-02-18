package ba.sum.fsre.elektronickoPoslovanje.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SlackNotifier {

    @Value("${slack.url}")
    private String slackUrl;

    @Value("${slack.bearer.token}")
    private String slackBearerToken;

    public void sendToSlack(String channel, String text) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + slackBearerToken); // Add Bearer token to the headers

        // Create the request body
        String requestBody = "{\"channel\":\"" + channel + "\",\"text\":\"" + text + "\"}";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Send the request to Slack API
        ResponseEntity<String> response = restTemplate.exchange(slackUrl, HttpMethod.POST, entity, String.class);

        // Check the response if needed
        HttpStatus statusCode = (HttpStatus) response.getStatusCode();
        if (statusCode != HttpStatus.OK) {
            // Handle error if necessary
            System.out.println("Error occurred: " + response.getBody());
        }
    }
}
