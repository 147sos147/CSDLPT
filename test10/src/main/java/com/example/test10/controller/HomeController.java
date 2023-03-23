package com.example.test10.controller;

import com.example.test10.model.SanPham;
import com.example.test10.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/trangChu")
    public ModelAndView getAllSanPham()
    {
        List<SanPham> sanPhams = sanPhamService.findAllSanPham();

        ModelAndView modelAndView = new ModelAndView("/layout/trangChu" ,"sanPhams",sanPhams);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(Model model){
        return new ModelAndView("layout/dangNhap");
    }

    @GetMapping("/menu")
    public String menu(){
        return "/layout/menu";
    }
}
