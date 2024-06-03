package com.springapp.iaBiletclone.repositories;

import org.springframework.stereotype.Repository;
import com.springapp.iaBiletclone.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
