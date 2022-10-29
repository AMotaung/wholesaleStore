package com.store.wholesaleStore.controller;

import com.store.wholesaleStore.model.Discount;
import com.store.wholesaleStore.model.Product;
import com.store.wholesaleStore.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@Controller
public class DiscountController {

    @Autowired
    DiscountService discountService;

    //Adding a discount
    @PostMapping(value = "/adddiscount")
    public ResponseEntity<String> createDiscount(@RequestBody Discount discount, Model model, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response){

        if(bindingResult.hasErrors()){
            try{
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Cannot save discount");
            }catch (IOException e){
                e.printStackTrace();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("All fields required.Make sure your input is valid.");
        } else{

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date=dtf.format(now);

            discount.setCreatedAt(date);
            discount.setModifiedAt(date);
            discountService.addDiscount(discount);
            return  ResponseEntity.ok("Successfully Added discount");
        }
    }

    // Getting all Discounts
    @GetMapping(value = "/getalldiscounts")
    public List<Discount> getDiscounts(HttpServletRequest request){
        return discountService.getAll();
    }

    //Getting discount by id
    @GetMapping(value = "/getdiscount/{id}")
    public Optional<Discount> findDiscountById(@PathVariable(name = "id", required = true) int id, HttpServletRequest request){
        return discountService.getDiscountById(id);
    }

    //Getting Products by a discount
    @GetMapping(value = "/getdiscount/{id}/products")
    public List<Product> getProductsByDiscount(@PathVariable int id){
        Optional<Discount> discount = discountService.getDiscountById(id);

        if(discount.isPresent()){
            Discount newDiscount = discount.get();
            return newDiscount.getProducts();
        }
        return null;
    }

    //Deleting discount by Id
    @GetMapping(value = "/discount/{id}/delete")
    public void removeDiscountById(@PathVariable int id, HttpServletRequest request){
         discountService.deleteDiscount(id);
    }

    @GetMapping(value = "/discount/delete")
    public void removeAllDiscounts(){
        discountService.deleteAllDiscounts();;
    }
}
