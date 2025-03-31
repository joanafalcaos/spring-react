package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/info")
@CrossOrigin(origins = "*")
public class MainController {
    
    @GetMapping
    public String info() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://dog.ceo/api/breeds/image/random";
        
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        return response.getBody();
    }
}
