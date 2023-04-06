package com.example.qlbh.controller;

import com.example.qlbh.model.BillDetails;
import com.example.qlbh.model.Branch;
import com.example.qlbh.model.Product;
import com.example.qlbh.repository.BillDetailsRepository;
import com.example.qlbh.repository.BillRepository;
import com.example.qlbh.repository.BranchRepository;
import com.example.qlbh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ProductService productService;


    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillDetailsRepository billDetailsRepository;


    @ModelAttribute("branch")
    public Iterable<Branch> branches() {
        List<Branch> branch = branchRepository.findAll();
        return branch;
    }
    @GetMapping("/product-list")
    public ModelAndView index(){
        return new ModelAndView("product/listProduct","product",productService.getAllProduct());
    }

    @GetMapping("/product-list-manager")
    public ModelAndView productManager(){
        return new ModelAndView("product/list_manager_product","product",productService.getAllProduct());
    }

    @GetMapping("/product-details/{id}")
    public ModelAndView view(@PathVariable int id) {
        //        hiển thị thông tin sản phẩm theo MaSP
        Product product = productService.getByIdProduct(id);
        ModelAndView modelAndView = new ModelAndView("/product/product_details","billDetails",new BillDetails());
        modelAndView.addObject("products",product);
        return modelAndView;
    }

    @PostMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable int id){

//        billDetailsRepository.deleteByIdProduct(id);
//        productService.deleteProductById(id);
        return "redirect:/product-list-manager";
    }

    @GetMapping("/create-product")
    public ModelAndView FromCreateProduct() {
        ModelAndView modelAndView = new ModelAndView("/product/create", "productFrom", new Product());
        return modelAndView;
    }



    @PostMapping("/create")
    public String create(Product product){
        productService.save(product);
        return "redirect:/index";
    }
}
