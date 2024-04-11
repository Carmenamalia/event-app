package com.springapp.iaBiletclone.controllers;

import com.springapp.iaBiletclone.dtos.EventRequestDTO;
import com.springapp.iaBiletclone.dtos.EventResponseDTO;
import com.springapp.iaBiletclone.entities.City;
import com.springapp.iaBiletclone.entities.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    //TODO
    //addCity
    //addLocation (intr-un city)
    //addEventCategory
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



//    @GetMapping("/")
//    public ResponseEntity<Event> addEvent(@RequestBody EventRequestDTO eventRequestDTO) {
//
//    }


}
