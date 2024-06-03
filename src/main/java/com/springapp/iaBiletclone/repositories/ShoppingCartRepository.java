package com.springapp.iaBiletclone.repositories;

import com.springapp.iaBiletclone.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

    Optional<ShoppingCart> findByUser_Id(Long userId);
}
