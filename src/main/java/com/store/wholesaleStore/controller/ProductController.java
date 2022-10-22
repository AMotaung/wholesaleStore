package com.store.wholesaleStore.controller;

import com.store.wholesaleStore.model.Product;
import com.store.wholesaleStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("/products/addproduct")
    public String createProduct(Product product, Model model, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if(bindingResult.hasErrors()) {
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Cannot save Product");
            }catch(IOException e) {
                e.printStackTrace();
            }
            return "products/addproduct";
        }else {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);

            product.setCreatedAt(date);
            product.setModified(date);

            productService.addProduct(product);
            request.setAttribute("product", product);
            return "";
        }
    }

}
