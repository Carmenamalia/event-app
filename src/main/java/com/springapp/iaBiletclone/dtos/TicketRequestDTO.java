package com.springapp.iaBiletclone.dtos;

import java.time.LocalDateTime;

public class TicketRequestDTO {


    private String ticketCategory;
    private Double normalPrice;
    private Double earlyBirdPrice;

    private LocalDateTime earlyBirdExpireDate;
    private Long quantity;

    private Long eventId;
}
