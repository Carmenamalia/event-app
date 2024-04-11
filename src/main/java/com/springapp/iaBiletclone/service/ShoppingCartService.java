package com.springapp.iaBiletclone.service;

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
}
