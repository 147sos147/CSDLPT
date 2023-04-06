package com.example.qlbh.repository;

import com.example.qlbh.model.BillDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BillDetailsRepository extends JpaRepository<BillDetails,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into bill_details(quantity,id_bill,id_product) values (?1, ?2,?3)", nativeQuery = true)
    void createBillDetails(int quantity, int id_bill, int id_product);



    @Query(value = "SELECT * FROM bill_details inner join product " +
            "on bill_details.id_product = product.id " +
            "inner join bill on bill_details.id_bill = bill.id inner join account on  bill.id_account = account.id  where account.id = ?1 ;",nativeQuery = true)
    List<BillDetails> getListCart(int id);

    //Xóa sản phẩm theo id
    @Transactional
    @Modifying
    @Query(value = "delete bill_details from bill_details inner join product on product.id = bill_details.id_product product.id = ?1", nativeQuery = true)
    void deleteByIdProduct(int id);
}
