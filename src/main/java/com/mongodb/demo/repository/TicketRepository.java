package com.mongodb.demo.repository;

import com.mongodb.demo.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {
 //   List<Ticket> findByName(String name);
    List<Ticket> findByTitle(String title);
    List<Ticket> findByAppId(String appId);

    List<Ticket> findByStatus(String status);
    Stream<Ticket> streamByStatus(String status);
    @Query("{status: ?0}")
    Stream<Ticket> findAllByCustomQueryAndStream(String status);
}
