package com.springapp.iaBiletclone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.Set;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "shoppingcart", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("shoppingcart-ticketitems")
    private Set<TicketItem> ticketItems;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference("user-shoppingcart")
    @JoinColumn(name = "user_id", nullable = false)
//nullable = false: Asigură că fiecare coș de cumpărături este asociat unui utilizator (nu poate exista un coș de cumpărături fără utilizator)
    private User user;

    public ShoppingCart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<TicketItem> getTicketItems() {
        return ticketItems;
    }

    public void setTicketItems(Set<TicketItem> ticketItems) {
        this.ticketItems = ticketItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
