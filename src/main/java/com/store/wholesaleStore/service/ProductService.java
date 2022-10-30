package com.store.wholesaleStore.service;

import com.store.wholesaleStore.dao.ProductDao;
import com.store.wholesaleStore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    //Creating a Product
    public Product addProduct(@RequestBody Product product){
        return productDao.save(product);
    }

    //Get all products
    public List<Product> getAll(){
        return productDao.findAll();
    }

    //Get Product by Id
    public Optional<Product> getProductById(int productId){
        return productDao.findById(productId);
    }

    //Deleting a Product
    public void deleteProduct(int productId){
        productDao.deleteById(productId);
    }

    //Deeleing all products
    public void deleteAllProducts(){
        productDao.deleteAll();
    }

    //Paging
    public List<Product> FindPaginated(int pageNo, int pageSize){
        Pageable paging = PageRequest.of(pageNo -1, pageSize);
        Page<Product> pagedResult = productDao.findAll(paging);
        return pagedResult.toList();
    }
}
