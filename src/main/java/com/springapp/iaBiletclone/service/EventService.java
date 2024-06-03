package com.springapp.iaBiletclone.service;

import com.springapp.iaBiletclone.dtos.EventRequestDTO;
import com.springapp.iaBiletclone.dtos.EventResponseDTO;
import com.springapp.iaBiletclone.entities.Category;
import com.springapp.iaBiletclone.entities.Event;
import com.springapp.iaBiletclone.entities.Location;
import com.springapp.iaBiletclone.repositories.CategoryRepository;
import com.springapp.iaBiletclone.repositories.EventRepository;
import com.springapp.iaBiletclone.repositories.LocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private LocationRepository locationRepository;
    private EventRepository eventRepository;
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    @Autowired
    public EventService(LocationRepository locationRepository, EventRepository eventRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.locationRepository = locationRepository;
        this.eventRepository = eventRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    //Adaug un eveniment în locația mea (ADMIN, OWNER)
    @Transactional
    public Event addEventToLocation(EventRequestDTO eventRequestDTO) {
        Location location = locationRepository.findById(eventRequestDTO.getLocationId()).orElseThrow(() -> new RuntimeException("Location not found"));
        Category category = categoryRepository.findById(eventRequestDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        Event newEvent = modelMapper.map(eventRequestDTO, Event.class);

        newEvent.setLocation(location);
        newEvent.setCategory(category);
        eventRepository.save(newEvent);
        return newEvent;
    }

    //Văd toate evenimentele dintr-o locație - ordonate după dată (ADMIN, OWNER, CLIENT)
       //Pentru fiecare eveniment, voi vrea să văd:
          //Name
          //Description
          //Date
          //minPrice
          //soldOut (true sau false)

    public List<EventResponseDTO> getAllEventsFromLocation(Long locationId) {
        List<Event> events = eventRepository.findByLocationIdOrderByDateAsc(locationId);
        return events.stream()
                .map(event -> modelMapper.map(event, EventResponseDTO.class))
                .collect(Collectors.toList());
    }
    //Văd toate evenimentele dintr-o categorie - ordonate după dată (ADMIN, OWNER, CLIENT)
    public List<EventResponseDTO> getAllEventsByCategory(Long categoryId) {
        List<Event> events = eventRepository.findAllByCategoryIdOrderByDate(categoryId);
        return events.stream()
                .map(event -> modelMapper.map(event, EventResponseDTO.class))
                .collect(Collectors.toList());
    }

    //Văd toate evenimentele - ordonate după dată (ADMIN, OWNER, CLIENT)
    public List<EventResponseDTO> getAllEvents() {
        List<Event> events = eventRepository.findAllOrderByDate();
        return events.stream()
                .map(event -> modelMapper.map(event, EventResponseDTO.class))
                .collect(Collectors.toList());
    }

    //Văd cele mai populare evenimente (ADMIN, OWNER, CLIENT)
    //Acestea vor fi evenimentele la care s-a vândut cel mai mare procentaj de bilete
    //Se vor putea vedea toate evenimentele la care s-au vândut peste 50% din bilete
    public List<EventResponseDTO> getMostPopularEvents() {
        List<Event> events = eventRepository.findAllOver50PercentTicketsSold();
        return events.stream()
                .map(event -> modelMapper.map(event, EventResponseDTO.class))
                .collect(Collectors.toList());
    }

    //Văd evenimentele din următoarea săptămână (ADMIN, OWNER, CLIENT)
    public List<EventResponseDTO> getEventsForNextWeek() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextWeek = now.plusWeeks(1);
        List<Event> events = eventRepository.findAllBetweenDates(now, nextWeek);
        return events.stream()
                .map(event -> modelMapper.map(event, EventResponseDTO.class))
                .collect(Collectors.toList());
    }

    //Văd evenimentele care sunt aproape de sold-out (adică la care s-au vândut peste 90% din bilete)
    public List<EventResponseDTO> getAlmostSoldOutEvents() {
        List<Event> events = eventRepository.findAllAlmostSoldOut();
        return events.stream()
                .map(event -> modelMapper.map(event, EventResponseDTO.class))
                .collect(Collectors.toList());
    }

    //Caut evenimente după nume (ADMIN, OWNER, CLIENT)
    public List<EventResponseDTO> searchEventsByName(String name) {
        List<Event> events = eventRepository.findByEventNameContainingOrderByDate(name);
        return events.stream()
                .map(event -> modelMapper.map(event, EventResponseDTO.class))
                .collect(Collectors.toList());
    }

}
