package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private List<Category> categories=new ArrayList<>();

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {

        categoryRepository.save(category);

    }

    @Override
    public String deleteCategory(Long categoryId) {
//        List<Category> categories=categoryRepository.findAll();
        Category category =categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
//        Category category=categories.stream()
//                .filter(c->c.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
//        if(category==null)
//            return "Category not found";


        categoryRepository.delete(category);
        return "Category with categoryId: "+categoryId+" delete successfully";
    }



    @Override
    public Category updateCategory(Category category, Long categoryId) {
//        List<Category> categories=categoryRepository.findAll();//this is to fetch all the categories but need the particular id which we need to update so for that instead of .findAll() will use findById() method
//        Optional<Category> savedCategoryOptional=categoryRepository.findById(categoryId);
        Category savedCategory=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
        category.setCategoryId(categoryId);
        savedCategory=categoryRepository.save(category);
        return savedCategory;
//        Optional<Category> optionalCategory=categories.stream()
//                .filter(c->c.getCategoryId().equals(categoryId))
//                .findFirst();
//        if(optionalCategory.isPresent()){
//            Category existingCategory=optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            Category savedCategory=categoryRepository.save(existingCategory);
//            return savedCategory;
//        }
//        else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found");
//        }


    }
}
