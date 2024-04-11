package com.springapp.iaBiletclone.service;

import com.springapp.iaBiletclone.dtos.EventResponseDTO;
import com.springapp.iaBiletclone.repositories.EventRepository;
import com.springapp.iaBiletclone.repositories.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private LocationRepository locationRepository;
    private EventRepository eventRepository;
    private EventResponseDTO eventResponseDTO;

    //Văd toate evenimentele dintr-o locație - ordonate după dată (ADMIN, OWNER, CLIENT)
    //Pentru fiecare eveniment, voi vrea să văd:
    //Name
    //Description
    //Date
    //minPrice
    //soldOut (true sau false)
    //Văd toate evenimentele dintr-o categorie - ordonate după dată (ADMIN, OWNER, CLIENT)
    //Văd toate evenimentele - ordonate după dată (ADMIN, OWNER, CLIENT)
    //Văd cele mai populare evenimente (ADMIN, OWNER, CLIENT)
    //Acestea vor fi evenimentele la care s-a vândut cel mai mare procentaj de bilete
    //Se vor putea vedea toate evenimentele la care s-au vândut peste 50% din bilete
    //Văd evenimentele din următoarea săptămână (ADMIN, OWNER, CLIENT)
    //Văd evenimentele care sunt aproape de sold-out (adică la care s-au vândut peste 90% din bilete)
    //Caut evenimente după nume (ADMIN, OWNER, CLIENT)

    //Adaug un eveniment în locația mea (ADMIN, OWNER)

}
