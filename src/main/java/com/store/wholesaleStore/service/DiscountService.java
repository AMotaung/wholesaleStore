package com.store.wholesaleStore.service;

import com.store.wholesaleStore.dao.DiscountDao;
import com.store.wholesaleStore.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {
    @Autowired
    DiscountDao discountDao;

    //Add Discount
    public Discount addDiscount(@RequestBody Discount discount){
        return discountDao.save(discount);
    }

    //Get All Discounts
    public List<Discount> getAll(){
        return (List<Discount>) discountDao.findAll();
    }

    //Get Discount By Id
    public Optional<Discount> getDiscountById(int Id){
        return discountDao.findById(Id);
    }

    //Deleting discount by Id
    public void deleteDiscount(int id){
        discountDao.deleteById(id);
    }

    //Deleting all Discounts
    public void deleteAllDiscounts(){
        discountDao.deleteAll();
    }
}
