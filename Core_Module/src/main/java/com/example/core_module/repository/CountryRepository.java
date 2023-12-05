package com.example.core_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core_module.model.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}
