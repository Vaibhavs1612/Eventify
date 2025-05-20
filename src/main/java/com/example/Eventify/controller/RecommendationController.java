package com.example.Eventify.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import com.example.Eventify.Dto.EventDTO;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class RecommendationController {

    @GetMapping("/recommend/{title}")
    public ResponseEntity<List<EventDTO>> getRecommendations(@PathVariable String title) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:5001/recommend?title=" + UriUtils.encode(title, StandardCharsets.UTF_8);

        try {
            ResponseEntity<EventDTO[]> response = restTemplate.getForEntity(url, EventDTO[].class);
            return ResponseEntity.ok(Arrays.asList(response.getBody()));
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }
}
