package com.example.core_module.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.dto.CityDto;
import com.example.core_module.model.City;
import com.example.core_module.repository.CityRepository;
import com.example.core_module.service.CityService;
@Service
public class CityServiceImpl implements CityService {
@Autowired
private CityRepository cityRepository;
	@Override
	public List<City> findAll() {
		List<City> list=new ArrayList<>();
		list=cityRepository.findAll();
		return list;
	}

	@Override
	public City findById(Long city_id) {
		City city=cityRepository.findById(city_id).get();
		return city;
	}

	@Override
	public void deleteById(Long city_id) {
		cityRepository.deleteById(city_id);
	}

	@Override
	public List<City> findBycountry_id(Long country_id) {
		List<City> list=new ArrayList<>();
		list=cityRepository.findBycountry_id(country_id);
		return list;
		
	}

	@Override
	public City save(CityDto cityDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
