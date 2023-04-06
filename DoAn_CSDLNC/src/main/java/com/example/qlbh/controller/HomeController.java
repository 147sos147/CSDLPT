package com.example.qlbh.controller;


import com.example.qlbh.repository.ProductRepository;
import com.example.qlbh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    //login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(Model model){
        return new ModelAndView("homePages/login");
    }


    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index","product",productService.getAllProduct());
    }
}
