package com.springapp.iaBiletclone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

//TODO
//de schimbat un eventCategory sa aiba mai multe Event
//de scos relatia dintre user si city
//de modificat relatia dintre ticketCateogry si ticket: un ticketCategory are mai multe ticket
//de scos relatia dintre orders si shopping cart
//de scos relatia dintre ticket si ordor , ticket si shopping cart
//de adaguta shopping cart many to many cu ticket prin ticket item

//de adaugat order are mai multe orderItem
@Entity
public class EventCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;//concert,standup,teatru
    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference("category-event")
    private Event event;


    public EventCategory() {
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


}
