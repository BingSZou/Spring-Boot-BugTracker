package com.mongodb.demo.controller;

import com.mongodb.demo.model.Release;
import com.mongodb.demo.repository.ReleaseRepository;
import com.mongodb.demo.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tza/releases")
public class ReleaseController {
    @Autowired
    private ReleaseRepository releaseRepository;

    @Autowired
    private ReleaseService releaseService;

    // ************** Methods for Releases *************************
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Release> getAllReleases() {
        return releaseRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Release> getReleaseId(@PathVariable("id") String id) {
        return releaseRepository.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Release addNewRelease(@RequestBody Release release) {
        return releaseRepository.save(release);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Release updateRelease(@PathVariable("id") String id, @RequestBody Release release) {
        release.setId(id);
        return releaseRepository.save(release);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRelease(@PathVariable("id") String id) {
        releaseRepository.deleteById(id);
    }

    @RequestMapping(value ="/releases/tickets", method = RequestMethod.PUT)
    public void addNewReleaseWTickets(@RequestBody Release release) {
        releaseService.insert(release);
    }

    @GetMapping("/costs/{id}")
    public double getReleaseCost(@PathVariable("id") String id) {
        return releaseService.getReleaseCost(id);
    }
}