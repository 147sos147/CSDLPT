package com.example.test10.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "San_Pham")
public class SanPham {
    @Id
    private  String MaSP ;
    private String Ten_SP;
    private float Gia;

    public SanPham() {
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public String getTen_SP() {
        return Ten_SP;
    }

    public void setTen_SP(String ten_SP) {
        Ten_SP = ten_SP;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float gia) {
        Gia = gia;
    }
}
