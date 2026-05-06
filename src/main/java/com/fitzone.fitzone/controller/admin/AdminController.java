package com.fitzone.fitzone.controller.admin;

import com.fitzone.fitzone.service.ProductService;
import com.fitzone.fitzone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView homeAdmin() {
        return new ModelAndView("/admin/admin")
                .addObject("userQuantity", userService.countUsers())
                .addObject("productQuantity", productService.countProduct())
                .addObject("productSales", productService.getProductSale());
    }
}
