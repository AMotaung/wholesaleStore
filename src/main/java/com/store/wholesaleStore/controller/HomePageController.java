package com.store.wholesaleStore.controller;

import com.store.wholesaleStore.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String getIndex() {
        return "admin/index";
    }

    @GetMapping("/product")
    public String getProductForm(Model model, HttpServletRequest request) {

        Product p = new Product();
        model.addAttribute("product", p);

        return "admin/addproductform";

    }
}
