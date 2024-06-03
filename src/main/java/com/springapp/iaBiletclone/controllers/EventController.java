package com.springapp.iaBiletclone.controllers;

import com.springapp.iaBiletclone.dtos.EventRequestDTO;
import com.springapp.iaBiletclone.dtos.EventResponseDTO;
import com.springapp.iaBiletclone.entities.Event;
import com.springapp.iaBiletclone.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/event")
public class EventController {


    //TODO
    //addCity v
    //addLocation (intr-un city) v
    //addEventCategory v
    //addTicketCateogory
    //addEvent (intr-o locatie)
    //adaugi cu tot cu tickete din anumite category
    //in event eventreqeustdto, pe langa detaliile eventului, o sa ai o lista de TicketRequestDTO (care are normalPrice, earlybirdprice, quantity, cateogory, etc.)
    //addTicket to shopping cart
    //se va genera un nou ticketItem care va fi legat de ticket si de shopping cart
    //din ticket se scade 1 din cantitate

    //addorder
    //pentru un utilzator se iau ticketitemurile din shopping cartul lui, se sterg si se construiesc order items
    //

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;

    }

    //Adaug un eveniment în locația mea (ADMIN, OWNER)
    @PostMapping("/")
    public ResponseEntity<Event> addEvent(@RequestBody EventRequestDTO eventRequestDTO) {
        Event addedEvent = eventService.addEventToLocation(eventRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedEvent);
    }

    //Văd toate evenimentele dintr-o locație - ordonate după dată (ADMIN, OWNER, CLIENT)
    @GetMapping("/{locationId}")
    public ResponseEntity<List<EventResponseDTO>> getAllEventsFromLocation(@PathVariable Long locationId) {
        List<EventResponseDTO> events = eventService.getAllEventsFromLocation(locationId);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    //Văd toate evenimentele dintr-o categorie - ordonate după dată (ADMIN, OWNER, CLIENT)
    @GetMapping("/category/{categoryId}")
    public List<EventResponseDTO> getAllEventsByCategory(@PathVariable Long categoryId) {
        return eventService.getAllEventsByCategory(categoryId);
    }

    //Văd toate evenimentele - ordonate după dată (ADMIN, OWNER, CLIENT)
    @GetMapping
    public List<EventResponseDTO> getAllEvents() {
        return eventService.getAllEvents();
    }

    //Văd cele mai populare evenimente (ADMIN, OWNER, CLIENT)
    @GetMapping("/popular")
    public List<EventResponseDTO> getMostPopularEvents() {
        return eventService.getMostPopularEvents();
    }

    //Văd evenimentele din următoarea săptămână (ADMIN, OWNER, CLIENT)
    @GetMapping("/next-week")
    public List<EventResponseDTO> getEventsForNextWeek() {
        return eventService.getEventsForNextWeek();
    }

    //Văd evenimentele care sunt aproape de sold-out (adică la care s-au vândut peste 90% din bilete)
    @GetMapping("/almost-sold-out")
    public List<EventResponseDTO> getAlmostSoldOutEvents() {
        return eventService.getAlmostSoldOutEvents();
    }

    //Caut evenimente după nume (ADMIN, OWNER, CLIENT)
    @GetMapping("/search")
    public List<EventResponseDTO> searchEventsByName(@RequestParam String name) {
        return eventService.searchEventsByName(name);
    }
}

