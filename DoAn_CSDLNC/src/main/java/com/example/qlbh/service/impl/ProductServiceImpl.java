package com.example.qlbh.service.impl;

import com.example.qlbh.model.Product;
import com.example.qlbh.repository.ProductRepository;
import com.example.qlbh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getByIdProduct(int id) {
        return productRepository.getReferenceById(id);
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteByIdProduct(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
