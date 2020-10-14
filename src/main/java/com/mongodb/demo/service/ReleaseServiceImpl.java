package com.mongodb.demo.service;

import com.mongodb.demo.model.Release;
import com.mongodb.demo.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService{
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ReleaseRepository releaseRepository;

    @Override
    public void updateReleaseByTemplate(Release release) {
        mongoTemplate.save(release);
    }

    @Override
    public void deleteReleaseByTemplate(String id) {
        releaseRepository.deleteById(id);
    }

    @Override
    public List<Release> getReleaseByTicketStatus(String status) {
        return null;
    }

    @Override
    public void insert(Release release) {
        mongoTemplate.insert(release);
    }

    @Override
    public double getReleaseCost(String name) {
        Release thisRelease = null;
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        thisRelease = mongoTemplate.findOne(query, Release.class);


        if (thisRelease != null) {
            return thisRelease.getCosts();
        }
        return 0;
    }
}
