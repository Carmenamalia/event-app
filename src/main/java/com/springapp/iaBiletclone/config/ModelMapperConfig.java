package com.springapp.iaBiletclone.config;

import com.springapp.iaBiletclone.dtos.EventRequestDTO;
import com.springapp.iaBiletclone.dtos.EventResponseDTO;
import com.springapp.iaBiletclone.dtos.TicketRequestDTO;
import com.springapp.iaBiletclone.dtos.TicketResponseDTO;
import com.springapp.iaBiletclone.entities.Event;
import com.springapp.iaBiletclone.entities.Ticket;
import com.springapp.iaBiletclone.entities.TicketCategory;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        configureEventMappings(modelMapper);
        configureTicketMappings(modelMapper);
        //configureUserMappings(modelMapper);
        // Adaugă alte configurații de mapare aici

        return modelMapper;
    }

    private void configureEventMappings(ModelMapper modelMapper) {
        modelMapper.typeMap(Event.class, EventResponseDTO.class).addMappings(mapper -> {
            mapper.map(Event::getEventName, EventResponseDTO::setEventName);
            mapper.map(Event::getDescription, EventResponseDTO::setDescription);
            mapper.map(Event::getDate, EventResponseDTO::setDate);
            mapper.map(event -> event.getTicketCategories().stream()
                    .map(TicketCategory::getEarlybirdPrice)
                    .min(BigDecimal::compareTo)
                    .orElse(BigDecimal.ZERO), EventResponseDTO::setMinPrice);
            mapper.map(Event::isSoldOut, EventResponseDTO::setSoldOut);
        });

        modelMapper.typeMap(EventRequestDTO.class, Event.class).addMappings(mapper -> {
            mapper.map(EventRequestDTO::getEventName, Event::setEventName);
            mapper.map(EventRequestDTO::getDescription, Event::setDescription);
            mapper.map(EventRequestDTO::getDate, Event::setDate);
            // Alte mapări dacă este necesar
        });
    }

    private void configureTicketMappings(ModelMapper modelMapper) {
        modelMapper.typeMap(Ticket.class, TicketResponseDTO.class).addMappings(mapper -> {
            mapper.map(Ticket::getPrice, TicketResponseDTO::setPrice);
            mapper.map(Ticket::getTicketStatus, TicketResponseDTO::setTicketStatus);
            mapper.map(Ticket::getTotalTickets, TicketResponseDTO::setTotalTickets);
            mapper.map(Ticket::getSoldTickets, TicketResponseDTO::setSoldTickets);
            // Alte mapări dacă este necesar
        });

        modelMapper.typeMap(TicketRequestDTO.class, Ticket.class).addMappings(mapper -> {
            mapper.map(TicketRequestDTO::getPrice, Ticket::setPrice);
            mapper.map(TicketRequestDTO::getTicketStatus, Ticket::setTicketStatus);
            mapper.map(TicketRequestDTO::getTotalTickets, Ticket::setTotalTickets);
            // Alte mapări dacă este necesar
        });
    }

//    private void configureUserMappings(ModelMapper modelMapper) {
//        modelMapper.typeMap(User.class, UserResponseDto.class).addMappings(mapper -> {
//            mapper.map(User::getUsername, UserResponseDto::setUsername);
//            mapper.map(User::getEmail, UserResponseDto::setEmail);
//            // Alte mapări dacă este necesar
//        });
//
//        modelMapper.typeMap(UserRequestDto.class, User.class).addMappings(mapper -> {
//            mapper.map(UserRequestDto::getUsername, User::setUsername);
//            mapper.map(UserRequestDto::getEmail, User::setEmail);
//            mapper.map(UserRequestDto::getPassword, User::setPassword);
//            // Alte mapări dacă este necesar
//        });
//    }
}
