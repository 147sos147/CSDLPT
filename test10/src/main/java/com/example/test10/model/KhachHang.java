package com.example.test10.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Khach_Hang")
public class KhachHang {

    @Id
    private String MaKH ;

    private String Ho_Ten;

    private String Email;

    private String Mat_Khau;

    private String Dia_Chi;

    private String So_DT;


    public KhachHang() {
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getHo_Ten() {
        return Ho_Ten;
    }

    public void setHo_Ten(String ho_Ten) {
        Ho_Ten = ho_Ten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMat_Khau() {
        return Mat_Khau;
    }

    public void setMat_Khau(String mat_Khau) {
        Mat_Khau = mat_Khau;
    }

    public String getDia_Chi() {
        return Dia_Chi;
    }

    public void setDia_Chi(String dia_Chi) {
        Dia_Chi = dia_Chi;
    }

    public String getSo_DT() {
        return So_DT;
    }

    public void setSo_DT(String so_DT) {
        So_DT = so_DT;
    }


}
