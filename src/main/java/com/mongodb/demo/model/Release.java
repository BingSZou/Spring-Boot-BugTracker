package com.mongodb.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import java.util.List;

@Document
public class Release {

    @Id
    private String id;
    private String name;
    private String description;
    private List<Ticket> tickets;
    private LocalDate releaseDate;

    @Transient
    private double costs=90;

    public Release() {

    }

    public Release(String name, String description, List<Ticket> tickets, LocalDate releaseDate) {
        this.name = name;
        this.description = description;
        this.tickets = tickets;
        this.releaseDate = releaseDate;

        this.costs = 89.90;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getCosts() {
        return costs;
    }

    public void setCosts(double costs) {
        this.costs = 89.90;
    }
}
