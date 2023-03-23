package com.example.test10.controller;


import com.example.test10.model.KhachHang;
import com.example.test10.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;



    @GetMapping("/listKH")
    public ModelAndView getIndex(){

        List<KhachHang> khachHangs =khachHangService.findAllKhachHang();


        ModelAndView modelAndView = new ModelAndView("managerKhachHang/listKhachHang","khachHang",khachHangs);



        return modelAndView;
    }

    @GetMapping("/dangKy")
    public  String FromThemKH(Model model){
        model.addAttribute("khachHang",new KhachHang());
        return "/layout/dangKy";
    }

    @PostMapping("/them")
    public String Them(KhachHang khachHang){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(khachHang.getMat_Khau());
        khachHang.setMat_Khau(encodedPassword);
        khachHangService.saveKhachHang(khachHang);
        return "redirect:/login";
    }
}
