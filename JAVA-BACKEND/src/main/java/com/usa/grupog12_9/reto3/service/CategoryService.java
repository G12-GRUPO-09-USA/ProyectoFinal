package com.usa.grupog12_9.reto3.service;

import com.usa.grupog12_9.reto3.entity.Category;
import com.usa.grupog12_9.reto3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author GRUPO 9 G12
 * @reto RETO #3
 * 
 */

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoriaRepository;
    
    public List<Category> getAll(){
        return categoriaRepository.getAll();
    }
    
    public Optional<Category> getCategoria(int id){
        return categoriaRepository.getCategoria(id);
    }
    
    public Category save(Category cat){
        if(cat.getId()==null){
            return categoriaRepository.save(cat);
        }
        else{
        Optional<Category> paux=categoriaRepository.getCategoria(cat.getId());
        if(paux.isEmpty()){
            return categoriaRepository.save(cat);
        }
        else{
            return cat;
        }
        }
    }
    
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>save=categoriaRepository.getCategoria(category.getId());
            if(!save.isEmpty()){
                if(category.getName()!=null){
                    save.get().setName(category.getName());                 
                }
                if(category.getDescription()!=null){
                    save.get().setDescription(category.getDescription());
                }                
                return categoriaRepository.save(save.get());
            }
        }
        return category;
    }
        
    public boolean delete(int id){
        Optional<Category> categoria=getCategoria(id);
        if(!categoria.isEmpty()){
            categoriaRepository.delete(categoria.get());
            return true;
        }
        return false;
    }    
}

