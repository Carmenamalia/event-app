package com.springapp.iaBiletclone.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketCategoryResponseDTO {

    private Long id;
    private String categoryType;
    private BigDecimal currentPrice;
    private BigDecimal earlyBirdPrice;
    private BigDecimal normalPrice;
    private LocalDateTime earlyBirdEndDate;
    private Long eventId;

    public TicketCategoryResponseDTO() {
    }

    public TicketCategoryResponseDTO(Long id, String categoryType, BigDecimal currentPrice, BigDecimal earlyBirdPrice, BigDecimal normalPrice, LocalDateTime earlyBirdEndDate, Long eventId) {
        this.id = id;
        this.categoryType = categoryType;
        this.currentPrice = currentPrice;
        this.earlyBirdPrice = earlyBirdPrice;
        this.normalPrice = normalPrice;
        this.earlyBirdEndDate = earlyBirdEndDate;
        this.eventId = eventId;
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

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
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
