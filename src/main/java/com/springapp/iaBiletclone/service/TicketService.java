package com.springapp.iaBiletclone.service;

import org.springframework.stereotype.Service;

@Service
public class TicketService {
    /*
   - Adaug o categorie de bilete pentru un eveniment (ADMIN, OWNER)
        Exemple: VIP sau General Access
     Bonus:
      fiecare categorie va avea 2 prețuri:
         -Prețul earlybird: care va fi disponibil până la o anumită dată
        - Prețul normal: care va fi disponibil imediat după earlybird
      Va trebui ca prețul să se schimbe automat la normal când va veni data schimbării (HINT: scheduler)
    -Generez un cod voucher, pentru o categorie de bilete de la un eveniment (ADMIN, OWNER)
         -Voucher-ul ar trebui să aibă:
         -Un cod
         -O dată de expirare
         -Un procent de reducere
    -Adaug un număr de bilete într-o categorie
    -Văd biletele disponibile din fiecare categorie de la un eveniment (ADMIN, OWNER, CLIENT)
    */



}
