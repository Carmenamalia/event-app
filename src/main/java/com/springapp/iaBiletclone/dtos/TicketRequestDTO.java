package com.springapp.iaBiletclone.dtos;

import com.springapp.iaBiletclone.entities.TicketStatus;

import java.math.BigDecimal;


public class TicketRequestDTO {



    private BigDecimal price;

    private TicketStatus ticketStatus;
    private int totalTickets;
    private Long ticketCategoryId;


    public TicketRequestDTO() {}

    public TicketRequestDTO(BigDecimal price, TicketStatus ticketStatus, int totalTickets, Long ticketCategoryId) {
        this.price = price;
        this.ticketStatus = ticketStatus;
        this.totalTickets = totalTickets;
        this.ticketCategoryId = ticketCategoryId;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public Long getTicketCategoryId() {
        return ticketCategoryId;
    }

    public void setTicketCategoryId(Long ticketCategoryId) {
        this.ticketCategoryId = ticketCategoryId;
    }
}
