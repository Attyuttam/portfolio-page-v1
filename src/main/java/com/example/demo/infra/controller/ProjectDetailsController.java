package com.example.demo.infra.controller;

import java.util.List;

import com.example.demo.application.provider.ProjectDetails;
import com.example.demo.application.provider.ProjectDetailsProvider;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ProjectDetailsController {
    private final ProjectDetailsProvider projectDetailsProvider;
    @GetMapping(value="/api/project/details")
    public List<ProjectDetails> getAllProjectDetails() {
        log.info("Controller hit");
        return projectDetailsProvider.getAllProjectDetails();
    }
    
}
