package com.example.test10.service;

import com.example.test10.model.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> findAllSanPham();

    SanPham getById(String id);
}
