package com.springapp.iaBiletclone.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

//TODO
//de schimbat un eventCategory sa aiba mai multe Event
//de scos relatia dintre user si city
//de modificat relatia dintre ticketCateogry si ticket: un ticketCategory are mai multe ticket
//de scos relatia dintre orders si shopping cart
//de scos relatia dintre ticket si ordor , ticket si shopping cart
//de adaguta shopping cart many to many cu ticket prin ticket item

//de adaugat order are mai multe orderItem
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;//concert,standup,teatru

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("category-event")
    private List<Event> events;


    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
