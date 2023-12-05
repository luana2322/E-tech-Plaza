package com.example.core_module.service;

import java.util.List;

import com.example.core_module.dto.CountryDto;
import com.example.core_module.model.Country;

public interface CountryService {
List<Country> findAll();
Country findById(Long country_id);
void deleteById(Long country_id);
Country save(CountryDto countryDto);
}
