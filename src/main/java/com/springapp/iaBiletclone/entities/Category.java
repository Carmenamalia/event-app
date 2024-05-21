package com.springapp.iaBiletclone.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(nullable = false)
    private String categoryName;//concert,standup,teatru

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("category-events")
    private Set<Event> events = new HashSet<>();


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

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
