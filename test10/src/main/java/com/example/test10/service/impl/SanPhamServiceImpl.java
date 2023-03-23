package com.example.test10.service.impl;

import com.example.test10.model.SanPham;
import com.example.test10.repository.SanPhamRepository;
import com.example.test10.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Override
    public List<SanPham> findAllSanPham() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham getById(String id) {
        return sanPhamRepository.getByIdProduct(id);
    }
}
