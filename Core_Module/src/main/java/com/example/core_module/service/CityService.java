package com.example.core_module.service;

import java.util.List;

import com.example.core_module.dto.CityDto;
import com.example.core_module.model.City;

public interface CityService {
List<City> findAll();
City findById(Long city_id);
void deleteById(Long city_id);
List<City> findBycountry_id(Long country_id);
City save(CityDto cityDto);
}
