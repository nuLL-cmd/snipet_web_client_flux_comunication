package com.automatodev.sendrequestjava.controller;

import java.time.Duration;

import com.automatodev.sendrequestjava.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping("byId/{id}")
    public ResponseEntity<?> fetchById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(service.fetchById(id).blockOptional(Duration.ofSeconds(30)).orElse(null));

    }
}
