package com.example.demo.web;

import com.example.demo.service.SampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    private final SampleService service;

    public SampleController(SampleService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok(service.getGreeting());
    }
}
