package com.example.test10.service;

import com.example.test10.model.KhachHang;

import java.util.List;

public interface KhachHangService {
    List<KhachHang> findAllKhachHang();

    KhachHang findByKhachHang(String MaKH);

    void saveKhachHang(KhachHang khachHang);


}
