package com.springapp.iaBiletclone.repositories;

import com.springapp.iaBiletclone.entities.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCategoryRepository extends JpaRepository<TicketCategory,Long> {
}
