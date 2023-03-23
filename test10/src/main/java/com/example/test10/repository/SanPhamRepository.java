package com.example.test10.repository;

import com.example.test10.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,String> {

    @Query(value = "SELECT * FROM san_pham  WHERE MaSP=:MaSP", nativeQuery = true)
    SanPham getByIdProduct(@Param("MaSP")String MaSP);
}
