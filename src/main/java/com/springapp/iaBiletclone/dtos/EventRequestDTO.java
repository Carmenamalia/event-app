package com.springapp.iaBiletclone.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class EventRequestDTO {

    private String eventName;
    private String description;
    private LocalDateTime date;
    private Long locationId;
    private Long categoryId;

private List<TicketRequestDTO> ticketRequestDTOS;

    public EventRequestDTO() {
    }

    public EventRequestDTO(String eventName, String description, LocalDateTime date, Long locationId, Long categoryId) {
        this.eventName = eventName;
        this.description = description;
        this.date = date;
        this.locationId = locationId;
        this.categoryId = categoryId;
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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
