package com.store.wholesaleStore.controller;

import com.store.wholesaleStore.model.Product;
import com.store.wholesaleStore.service.ProductService;
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

@RestController
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    //Adding a Product
    @PostMapping("/products/addproduct")
    public ResponseEntity<String> createProduct(@RequestBody Product product, Model model, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if(bindingResult.hasErrors()) {
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Cannot save Product");
            }catch(IOException e) {
                e.printStackTrace();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("All fields required.Make sure your input is valid.");
        }else {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);

            product.setCreatedAt(date);
            product.setModified(date);
            productService.addProduct(product);
         //   request.setAttribute("product", product);
          System.out.println(product.toString());

            return ResponseEntity.ok("Product added successfully");
        }
    }

    //Getting all Products
    @GetMapping(value = "getallproducts")
    public List<Product>getProducts(HttpServletRequest request){
        return productService.getAll();
    }

    //Getting Product by ID
    @GetMapping(value = "/getproduct/{id}")
    public Optional<Product> findProductById(@PathVariable(name = "id", required = true) int id){
        return productService.getProductById(id);
    }

    //Delete Product by ID
    @GetMapping(value = "/product/{id}/delete")
    public void removeProductById(@PathVariable(name = "id", required = true) int id){
        productService.deleteProduct(id);
    }


    //Deleting All Products
    @GetMapping(value = "/products/delete")
    public void removeAllProducts(){
         productService.deleteAllProducts();
    }

    //Paging
    @GetMapping(value = "/product/{pageNo}/{pageSize}")
    public List<Product> getPaginated(@PathVariable int pageNo, @PathVariable int pageSize){
        return productService.FindPaginated(pageNo,pageSize);
    }

}
