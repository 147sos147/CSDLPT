package com.example.test10.repository;

import com.example.test10.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface KhachHangRepository  extends JpaRepository<KhachHang, String> {
    @Query("SELECT u FROM KhachHang u WHERE u.Email = ?1")
    public KhachHang findByEmail(String email);
}
