package com.springapp.iaBiletclone.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class EventRequestDTO {

    //locationId(name?)
    //cityId(name?)
    private String eventName;
    private LocalDateTime date;//?

    Long locationId;
    Long eventCategoryId;

    List<TicketRequestDTO> tickets;



    public EventRequestDTO() {
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
