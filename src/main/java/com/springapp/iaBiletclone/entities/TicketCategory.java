package com.springapp.iaBiletclone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class TicketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categoryType;//( VIP,GENERAL_ACCESS)

    @Column(precision = 38, scale = 2)
    private BigDecimal earlybirdPrice;

    @Column(precision = 38, scale = 2)
    private BigDecimal normalPrice;

    private LocalDateTime earlybirdEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    @JsonBackReference("event-ticketcategories")
    private Event event;

    @OneToMany(mappedBy = "ticketCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("ticketcategory-tickets")
    private Set<Ticket> tickets = new HashSet<>();

    @OneToMany(mappedBy = "ticketCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("ticketcategory-voucher")
    private Set<Voucher> vouchers = new HashSet<>();


    public TicketCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public BigDecimal getEarlybirdPrice() {
        return earlybirdPrice;
    }

    public void setEarlybirdPrice(BigDecimal earlybirdPrice) {
        this.earlybirdPrice = earlybirdPrice;
    }

    public BigDecimal getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(BigDecimal normalPrice) {
        this.normalPrice = normalPrice;
    }

    public LocalDateTime getEarlybirdEndDate() {
        return earlybirdEndDate;
    }

    public void setEarlybirdEndDate(LocalDateTime earlybirdEndDate) {
        this.earlybirdEndDate = earlybirdEndDate;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Set<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(Set<Voucher> vouchers) {
        this.vouchers = vouchers;
    }
}
