package com.springapp.iaBiletclone.service;

import com.springapp.iaBiletclone.dtos.TicketCategoryRequestDTO;
import com.springapp.iaBiletclone.dtos.TicketCategoryResponseDTO;
import com.springapp.iaBiletclone.entities.Event;
import com.springapp.iaBiletclone.entities.TicketCategory;
import com.springapp.iaBiletclone.repositories.EventRepository;
import com.springapp.iaBiletclone.repositories.TicketCategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketCategoryService {
    // Adaug o categorie de bilete pentru un eveniment (ADMIN, OWNER)
    //        Exemple: VIP sau General Access
    //     Bonus:
    //      fiecare categorie va avea 2 prețuri:
    //         -Prețul earlybird: care va fi disponibil până la o anumită dată
    //        - Prețul normal: care va fi disponibil imediat după earlybird
    //      Va trebui ca prețul să se schimbe automat la normal când va veni data schimbării (HINT: scheduler)

    private TicketCategoryRepository ticketCategoryRepository;
    private EventRepository eventRepository;
    private ModelMapper modelMapper;

    @Autowired
    public TicketCategoryService(TicketCategoryRepository ticketCategoryRepository, EventRepository eventRepository, ModelMapper modelMapper) {
        this.ticketCategoryRepository = ticketCategoryRepository;
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    // Adaug o categorie de bilete pentru un eveniment (ADMIN, OWNER)
    @Transactional
    public TicketCategoryResponseDTO addTicketCategory(TicketCategoryRequestDTO ticketCategoryRequestDTO) {
        TicketCategory ticketCategory = modelMapper.map(ticketCategoryRequestDTO, TicketCategory.class);
        Event event = eventRepository.findById(ticketCategoryRequestDTO.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));
        ticketCategory.setEvent(event);
        ticketCategory.setCurrentPrice(ticketCategory.getEarlybirdPrice());
        TicketCategory savedTicketCategory = ticketCategoryRepository.save(ticketCategory);
        return modelMapper.map(savedTicketCategory, TicketCategoryResponseDTO.class);
    }

    public List<TicketCategoryResponseDTO> getTicketCategoriesByEvent(Long eventId) {
        List<TicketCategory> categories = ticketCategoryRepository.findByEventId(eventId);
        return categories.stream()
                .map(category -> modelMapper.map(category, TicketCategoryResponseDTO.class))
                .collect(Collectors.toList());
    }

    public void updateTicketPrices() {
        List<TicketCategory> categories = ticketCategoryRepository.findAll();
        LocalDateTime now = LocalDateTime.now();

        for (TicketCategory category : categories) {
            if (category.getEarlybirdEndDate().isBefore(now)) {
                category.setCurrentPrice(category.getNormalPrice());
                ticketCategoryRepository.save(category);
            }
        }
    }


}
