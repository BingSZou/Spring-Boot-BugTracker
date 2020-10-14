package com.mongodb.demo.repository;

import com.mongodb.client.MongoDatabase;
import com.mongodb.demo.model.Release;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends MongoRepository<Release, String> {
}
