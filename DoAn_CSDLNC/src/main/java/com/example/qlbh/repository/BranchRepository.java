package com.example.qlbh.repository;


import com.example.qlbh.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {


}
