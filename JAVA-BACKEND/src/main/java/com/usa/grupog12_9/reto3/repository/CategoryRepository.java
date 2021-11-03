package com.usa.grupog12_9.reto3.repository;

import com.usa.grupog12_9.reto3.entity.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.grupog12_9.reto3.crud.CategoryCrud;

/**
 *
 * @author GRUPO 9 G12
 * @reto RETO #3
 * 
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrud categoryCrud;
    
    public List<Category> getAll(){
        return (List<Category>) categoryCrud.findAll();
    }
    public Optional<Category> getCategoria(int id){
        return categoryCrud.findById(id);
    }
    public Category save(Category category){
        return categoryCrud.save(category);
    }
    public void delete(Category category){
        categoryCrud.delete(category);
    }
}

