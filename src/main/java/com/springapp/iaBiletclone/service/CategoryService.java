package com.springapp.iaBiletclone.service;

import com.springapp.iaBiletclone.dtos.CategoryRequestDTO;
import com.springapp.iaBiletclone.entities.Category;
import com.springapp.iaBiletclone.entities.Event;
import com.springapp.iaBiletclone.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //Adaug o nouă categorie de evenimente (ADMIN)
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }


    //Văd toate categoriile de evenimente (ADMIN, OWNER, CLIENT)

    public List<Category> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    // Șterg o categorie de evenimente (ADMIN)
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.delete(category);
    }


    //Șterg o categorie de evenimente (ADMIN)
}
