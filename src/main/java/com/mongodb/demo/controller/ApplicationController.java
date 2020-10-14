package com.mongodb.demo.controller;

import com.mongodb.demo.model.Application;
import com.mongodb.demo.repository.ApplicationRepository;
import com.mongodb.demo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tza/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("")
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Application> getApplicationById(@PathVariable("id") String id) {
        return applicationRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Application updateApplication(@PathVariable("id") String id, @RequestBody Application application) {
        application.setId(id);
        return applicationRepository.save(application);
    }

    @PostMapping("")
    public Application addNewApplication(@RequestBody Application application) {
        return applicationRepository.save(application);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable("id") String id) {
        applicationRepository.deleteById(id);
    }

    @PostMapping("/template")
    public Application addNewApplicationByTemplate(@RequestBody Application newApp) {
        return applicationService.addNewApplicationWithTemplate(newApp);
    }

    @PutMapping("/template")
    public void updateApplicationByTemplate(@RequestBody Application app) {
        applicationService.updateApplicationWithTemplate(app);
    }

}
