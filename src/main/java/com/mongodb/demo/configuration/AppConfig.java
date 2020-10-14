package com.mongodb.demo.configuration;

import com.mongodb.ClientSessionOptions;
import com.mongodb.client.*;
import com.mongodb.connection.ClusterDescription;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

//import com.keysoft.mongodb.listeners.ReleaseCascadeConvertMongoEventListener;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost");
    }
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "trackzilla");
    }
/*

    @Bean
    public ReleaseCascadeConvertMongoEventListener releaseCascadingMongoEventListener() {
        return new ReleaseCascadeConvertMongoEventListener();
    }*/
}
