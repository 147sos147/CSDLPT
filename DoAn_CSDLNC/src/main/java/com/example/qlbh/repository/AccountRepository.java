package com.example.qlbh.repository;

import com.example.qlbh.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    // Tìm email
    @Query(value = "SELECT * from account where email=:email", nativeQuery = true)
    Account findUserByEmail(@Param("email") String email);


    // Tìm Role của accout
    @Query(
            value = "SELECT role.role_name from account_role " +
                    " inner join account on account.id = account_role.id_account " +
                    " inner join role on role.id = account_role.id_role where account.email=:email "
            , nativeQuery = true
    )
    String findRoleNameByEmail(@Param("email") String email);


    // Thêm role cho account
    @Transactional
    @Modifying
    @Query(value = "insert into account_role(id_account, id_role) values (?1, ?2)", nativeQuery = true)
    void createAccountRole(int accountId, int roleId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `account` (`email`, `password`, `full_name`, `number_phone`, `address`) VALUES (?1,?2, ?3,?4,?5)",nativeQuery = true)
    void createAccount(String email,String password , String full_name,String number_phone , String address);


}
