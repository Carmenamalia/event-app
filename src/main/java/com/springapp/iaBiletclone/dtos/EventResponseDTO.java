package com.springapp.iaBiletclone.dtos;

import java.time.LocalDateTime;

public class EventResponseDTO {

    private String eventName;
    private String description;
    private LocalDateTime date;
    private Double minPrice;
    private boolean soldOut;

    public EventResponseDTO() {
    }
    public EventResponseDTO(String eventName, String description,LocalDateTime date, Double minPrice, boolean soldOut) {
        this.eventName = eventName;
        this.description = description;
        this.minPrice = minPrice;
        this.date = date;
        this.soldOut = soldOut;

    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    @Override
    public String toString() {
        return "EventResponseDTO{" +
                "eventName='" + eventName + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", minPrice=" + minPrice +
                ", soldOut=" + soldOut +
                '}';
    }
}
