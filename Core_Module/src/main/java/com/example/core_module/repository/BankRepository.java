package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Bank;
@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

}
