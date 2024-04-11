package com.springapp.iaBiletclone.repositories;

import com.springapp.iaBiletclone.entities.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<EventCategory,Long> {
}
