package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Bank_Account;

@Repository
public interface Bank_AccountRepository extends JpaRepository<Bank_Account, Long> {

}
