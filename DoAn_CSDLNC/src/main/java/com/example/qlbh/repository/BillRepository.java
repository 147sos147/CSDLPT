package com.example.qlbh.repository;

import com.example.qlbh.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into bill(total,id_account) values (?1, ?2)", nativeQuery = true)
    void createBill(float total, int id_account);

    @Query(value = "SELECT MAX(id) FROM bill ;", nativeQuery = true)
    int getBillMax();


}
