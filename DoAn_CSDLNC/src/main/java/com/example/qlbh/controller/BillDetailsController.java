package com.example.qlbh.controller;

import com.example.qlbh.model.Account;

import com.example.qlbh.model.BillDetails;
import com.example.qlbh.model.Product;
import com.example.qlbh.repository.AccountRepository;
import com.example.qlbh.repository.BillDetailsRepository;
import com.example.qlbh.repository.BillRepository;
import com.example.qlbh.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BillDetailsController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BillDetailsRepository billDetailsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BillRepository billRepository;
    @PostMapping("/add-bill")
    public ModelAndView addProduct( @ModelAttribute("billDetails") BillDetails billDetails,@ModelAttribute("products") Product product){
        Product product1 = productRepository.findByProductName(product.getName_product());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account =accountRepository.findUserByEmail(userDetails.getUsername());
        System.out.printf("Id bill :" + billDetails.getId() + "   Account : " + account.getEmail() + "   product : " + product.getName_product());
        billRepository.createBill(billDetails.getQuantity()*6000,account.getId());
        billDetailsRepository.createBillDetails(billDetails.getQuantity(),billRepository.getBillMax(),product1.getId());

        ModelAndView modelAndView = new ModelAndView("redirect:/index");
        return modelAndView;
    }

    @GetMapping("/detail-cart")
    public ModelAndView getDetailCart(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account =accountRepository.findUserByEmail(userDetails.getUsername());

        List<BillDetails> billDetails = billDetailsRepository.getListCart(account.getId());
        for(BillDetails mh:billDetails){
            System.out.printf( mh.getProduct().getName_product());
        }
        ModelAndView modelAndView = new ModelAndView("/homePages/cart","bill",billDetails);

        return modelAndView;
    }

}
