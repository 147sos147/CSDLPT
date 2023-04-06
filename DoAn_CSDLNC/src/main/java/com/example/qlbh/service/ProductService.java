package com.example.qlbh.service;

import com.example.qlbh.model.Product;

import java.util.List;

public interface ProductService {

    // danh sách sản phẩm
    List<Product> getAllProduct();

    // Lấy sản phẩm theo id
    Product getByIdProduct(int id);

    void deleteProductById(int id);

    void save(Product product);
}
