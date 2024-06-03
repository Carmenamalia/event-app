package com.springapp.iaBiletclone.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketCategoryRequestDTO {

    private String categoryType;
    private BigDecimal earlyBirdPrice;
    private BigDecimal normalPrice;
    private LocalDateTime earlyBirdEndDate;
    private Long eventId;

    public TicketCategoryRequestDTO() {}

    public TicketCategoryRequestDTO(Long eventId, LocalDateTime earlyBirdEndDate, BigDecimal normalPrice, BigDecimal earlyBirdPrice, String categoryType) {
        this.eventId = eventId;
        this.earlyBirdEndDate = earlyBirdEndDate;
        this.normalPrice = normalPrice;
        this.earlyBirdPrice = earlyBirdPrice;
        this.categoryType = categoryType;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public BigDecimal getEarlyBirdPrice() {
        return earlyBirdPrice;
    }

    public void setEarlyBirdPrice(BigDecimal earlyBirdPrice) {
        this.earlyBirdPrice = earlyBirdPrice;
    }

    public BigDecimal getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(BigDecimal normalPrice) {
        this.normalPrice = normalPrice;
    }

    public LocalDateTime getEarlyBirdEndDate() {
        return earlyBirdEndDate;
    }

    public void setEarlyBirdEndDate(LocalDateTime earlyBirdEndDate) {
        this.earlyBirdEndDate = earlyBirdEndDate;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
