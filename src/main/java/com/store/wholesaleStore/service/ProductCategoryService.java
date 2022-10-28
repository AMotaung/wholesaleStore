package com.store.wholesaleStore.service;

import com.store.wholesaleStore.dao.ProductCategoryDao;
import com.store.wholesaleStore.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    ProductCategoryDao categoryDao;

    public ProductCategory addCategory(@RequestBody ProductCategory category){
        return categoryDao.save(category);
    }

    public List<ProductCategory> getAll(){
        return (List<ProductCategory>) categoryDao.findAll();
    }

    public Optional<ProductCategory> getCategoryById(int Id){
        return categoryDao.findById(Id);
    }

    public void deleteCategory(int id){
        categoryDao.deleteById(id);
    }

    public void deleteAllCategory(){
        categoryDao.deleteAll();
    }
}
