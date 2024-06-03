package com.springapp.iaBiletclone.config;

import com.springapp.iaBiletclone.service.TicketCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerConfig {


    private TicketCategoryService ticketCategoryService;

    @Autowired
    public SchedulerConfig(TicketCategoryService ticketCategoryService) {
        this.ticketCategoryService = ticketCategoryService;
    }

    @Scheduled(cron = "0 0 * * * ?") // Rulează la fiecare oră
    public void scheduleTicketPriceUpdate() {
        ticketCategoryService.updateTicketPrices();
    }

}
