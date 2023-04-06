package com.example.qlbh.repository;

import com.example.qlbh.model.Account;
import com.example.qlbh.model.Bill;
import com.example.qlbh.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT * from product where name_product=:name_product", nativeQuery = true)
    Product findByProductName(@Param("name_product") String name_product);

    //Xóa sản phẩm theo id
    @Transactional
    @Modifying
    @Query(value = "DELETE product FROM product WHERE product.id = ?1", nativeQuery = true)
    void deleteByIdProduct(int id);
}
