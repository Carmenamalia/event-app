package com.springapp.iaBiletclone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double normalPrice;
    private Double earlyBirdPrice;

    private LocalDateTime earlyBirdExpireDate;
    private Long quantity;
    @ManyToMany(mappedBy = "tickets", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference("tickets-ticketCategories")
    private Set<TicketCategory> ticketCategories;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference("ticket-event")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "shoppingcart_id")
    @JsonBackReference("tickets-shoppingcart")
    private ShoppingCart shoppingCart;

    @OneToOne(mappedBy = "ticket", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("ticket-voucher")
    private Voucher voucher;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference("order-ticket")
    private Order order;

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(Double normalPrice) {
        this.normalPrice = normalPrice;
    }

    public Double getEarlyBirdPrice() {
        return earlyBirdPrice;
    }

    public void setEarlyBirdPrice(Double earlyBirdPrice) {
        this.earlyBirdPrice = earlyBirdPrice;
    }

    public LocalDateTime getEarlyBirdExpireDate() {
        return earlyBirdExpireDate;
    }

    public void setEarlyBirdExpireDate(LocalDateTime earlyBirdExpireDate) {
        this.earlyBirdExpireDate = earlyBirdExpireDate;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public Set<TicketCategory> getTicketCategories() {
        return ticketCategories;
    }

    public void setTicketCategories(Set<TicketCategory> ticketCategories) {
        this.ticketCategories = ticketCategories;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
