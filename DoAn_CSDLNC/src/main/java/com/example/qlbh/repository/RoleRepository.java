package com.example.qlbh.repository;


import com.example.qlbh.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Query(value = "select * from role where  role_name=:role_name",nativeQuery = true)
    Role getByNameRole(@Param("role_name") String role_name);

}
