package com.springapp.iaBiletclone.service;

import com.springapp.iaBiletclone.dtos.TicketRequestDTO;
import com.springapp.iaBiletclone.dtos.TicketResponseDTO;
import com.springapp.iaBiletclone.entities.Ticket;
import com.springapp.iaBiletclone.entities.TicketCategory;
import com.springapp.iaBiletclone.repositories.TicketCategoryRepository;
import com.springapp.iaBiletclone.repositories.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    /*
    -Generez un cod voucher, pentru o categorie de bilete de la un eveniment (ADMIN, OWNER)
         -Voucher-ul ar trebui să aibă:
         -Un cod
         -O dată de expirare
         -Un procent de reducere
    */
    private TicketRepository ticketRepository;
    private TicketCategoryRepository ticketCategoryRepository;
    private ModelMapper modelMapper;

    @Autowired
    public TicketService(TicketRepository ticketRepository, TicketCategoryRepository ticketCategoryRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
        this.modelMapper = modelMapper;
    }

    //Adaug un număr de bilete într-o categorie
    @Transactional
    public TicketResponseDTO addTicket(TicketRequestDTO ticketRequestDTO) {
        Ticket ticket = modelMapper.map(ticketRequestDTO, Ticket.class);
        TicketCategory ticketCategory = ticketCategoryRepository.findById(ticketRequestDTO.getTicketCategoryId())
                .orElseThrow(() -> new RuntimeException("TicketCategory not found"));
        ticket.setTicketCategory(ticketCategory);
        Ticket savedTicket = ticketRepository.save(ticket);
        return modelMapper.map(savedTicket, TicketResponseDTO.class);
    }

    //Văd biletele disponibile din fiecare categorie de la un eveniment
    public List<TicketResponseDTO> getAllTicketsForEvent(Long eventId) {
        List<Ticket> tickets = ticketRepository.findByTicketCategory_Event_Id(eventId);
        return tickets.stream()
                .map(ticket -> modelMapper.map(ticket, TicketResponseDTO.class))
                .collect(Collectors.toList());
    }

}
