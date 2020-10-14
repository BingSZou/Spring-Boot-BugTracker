package com.mongodb.demo.controller;

import com.mongodb.demo.model.Ticket;
import com.mongodb.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/tza/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    // ************** Methods for Tickets *************************
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Ticket> getTicketById(@PathVariable("id") String id) {
        return ticketRepository.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Ticket addNewApplication(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Ticket updateApplication(@PathVariable("id") String id, @RequestBody Ticket ticket) {
        ticket.setId(id);
        return ticketRepository.save(ticket);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTicket(@PathVariable("id") String id) {
        ticketRepository.deleteById(id);
    }
    /*
        @GetMapping("/tickets/name/{name}")
        public List<Ticket> findByName(@PathVariable("name") String name) {
            return ticketRepository.findByName(name);
        }
    */
    @GetMapping("/title/{title}")
    public List<Ticket> findByTitle(@PathVariable("title") String title) {
        return ticketRepository.findByTitle(title);
    }

    @GetMapping("/AppId/{AppId}")
    public List<Ticket> findByAppId(@PathVariable("AppId") String AppId) {
        return ticketRepository.findByAppId(AppId);
    }

    @GetMapping("/status/{status}")
    public List<Ticket> findByStatus(@PathVariable("status") String status) {
        return ticketRepository.findByStatus(status);
    }

    @GetMapping("/count")
    public Long countOpenTickets() {
        Stream<Ticket> stream = ticketRepository.streamByStatus("Open");
        Long count = stream.count();
        stream.close();
        return count;
    }

}
