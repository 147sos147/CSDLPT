package com.example.test10.service.impl;

import com.example.test10.model.KhachHang;
import com.example.test10.repository.KhachHangRepository;
import com.example.test10.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> findAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang findByKhachHang(String MaKH) {
        return khachHangRepository.findById(MaKH).orElse(null);
    }

    @Override
    public void saveKhachHang(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }
}
