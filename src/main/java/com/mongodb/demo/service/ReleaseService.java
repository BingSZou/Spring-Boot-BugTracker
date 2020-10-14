package com.mongodb.demo.service;

import com.mongodb.demo.model.Release;

import java.util.List;

public interface ReleaseService {
    void updateReleaseByTemplate(Release release);
    void deleteReleaseByTemplate(String id);
    List<Release> getReleaseByTicketStatus(String status);
    void insert(Release release);
    double getReleaseCost(String id);
}
