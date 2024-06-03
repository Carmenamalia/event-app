package com.springapp.iaBiletclone.service;


import com.springapp.iaBiletclone.repositories.ShoppingCartRepository;
import com.springapp.iaBiletclone.repositories.TicketItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    //Adaug în coș unul sau mai multe bilete dintr-o anumită categorie a unui eveniment (ADMIN, OWNER, CLIENT)
    //Bonus 1:
    //La cumpărare, pot adăuga un cod voucher care să îmi reducă prețul biletului
    //Bonus 2:
    //Fiecare bilet va deveni indisponibil (pentru ceilalți), o dată adăugat în coș, pentru 15 minute (practic va fi rezervat pentru tine), însă dacă nu faci comanda în 15 minute, biletul se va șterge automat din coș
    //Șterg din coș un bilet (ADMIN, OWNER, CLIENT)
    //Văd coșul meu de cumpărături (ADMIN, OWNER, CLIENT)
    private ShoppingCartRepository shoppingCartRepository;
    private TicketItemRepository ticketItemRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, TicketItemRepository ticketItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.ticketItemRepository = ticketItemRepository;
    }

//    public void addTicketToCart(TicketRequestDTO ticketRequestDTO) {
//        ShoppingCart cart = shoppingCartRepository.findByUser(user);
//        TicketItem ticketItem = ticketItemRepository.findByShoppingCartAndTicket(cart, ticket);
//
//        if (ticketItem == null) {
//            ticketItem = new TicketItem();
//            ticketItem.setShoppingCart(cart);
//            ticketItem.setTicket(ticket);
//            ticketItem.setQuantity(quantity);
//        } else {
//            ticketItem.setQuantity(ticketItem.getQuantity() + quantity);
//        }
//
//        ticketItemRepository.save(ticketItem);
//    }
}
