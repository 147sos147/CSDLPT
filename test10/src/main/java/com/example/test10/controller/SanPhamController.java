package com.example.test10.controller;

import com.example.test10.model.SanPham;
import com.example.test10.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/chi_tiet_san_pham/{MaSP}")
    public ModelAndView showFromEdit(@PathVariable String MaSP) {
        SanPham sanPham = sanPhamService.getById(MaSP);
        ModelAndView modelAndView = new ModelAndView("/managerSanPham/chiTietSanPham");
        modelAndView.addObject("sanPham", sanPham);
        System.out.printf(sanPham.getMaSP());
        return modelAndView;
    }
}
