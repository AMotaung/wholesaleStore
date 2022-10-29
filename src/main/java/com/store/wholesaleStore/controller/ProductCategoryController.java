package com.store.wholesaleStore.controller;

import com.store.wholesaleStore.model.Product;
import com.store.wholesaleStore.model.ProductCategory;
import com.store.wholesaleStore.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
public class ProductCategoryController {

    @Autowired
    ProductCategoryService categoryService;

    //Add a Product Category
    @PostMapping(value = "/addcategory")
    public ResponseEntity<String> createCategory(@RequestBody ProductCategory category, Model model, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response){

        if(bindingResult.hasErrors()){
            try{
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Cannot save category");
            } catch (IOException e){
                e.printStackTrace();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("All fields required.Make sure your input is valid.");
        } else{

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);

            category.setCreatedAt(date);
            category.setModifiedAt(date);

            categoryService.addCategory(category);
            System.out.println(category.toString());

            return ResponseEntity.ok("Product Category added successfully");
        }

    }


    //Return All Categories
    @GetMapping(value = "/getallcategories")
    public List<ProductCategory> getAllCategories (HttpServletRequest req){

        return categoryService.getAll();
    }

    //Return Product Category By Id
    @GetMapping(value = "/getcategory/{id}")
    public Optional<ProductCategory> getProductCategoryById(@PathVariable(name = "id", required = true) int id, HttpServletRequest request){

        return categoryService.getCategoryById(id);
    }

    //Returning Product by a Category
    @GetMapping("/getcategory/{id}/products")
    public List<Product> getProductsByCategory(@PathVariable(name = "id", required = true) int id){
        Optional<ProductCategory> productCategory = categoryService.getCategoryById(id);

        if(productCategory.isPresent()){
            ProductCategory newCategory = productCategory.get();
            List<Product> products = newCategory.getProducts();
            return products;
        }
        return null;
    }

    //Deleting Category by Id
    @GetMapping(value = "/category/{id}/delete")
    public void removingCategoryById(@PathVariable(name = "id") int id){
        categoryService.deleteCategory(id);
    }

    //Deleting all Categories
    @GetMapping(value = "/category/delete")
    public void removingAllCategories(){
        categoryService.deleteAllCategory();
    }
}
