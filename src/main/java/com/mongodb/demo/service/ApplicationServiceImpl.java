package com.mongodb.demo.service;

import com.mongodb.demo.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Application addNewApplicationWithTemplate(Application newApplication) {
        return mongoTemplate.insert(newApplication);
    }

    @Override
    public void updateApplicationWithTemplate(Application application) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(application.getName() ));
        Update update = new Update();
        update.set("name", "Trainer");
        mongoTemplate.updateFirst(query, update, Application.class);
    }
}
