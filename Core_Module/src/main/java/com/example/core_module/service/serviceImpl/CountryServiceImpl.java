package com.example.core_module.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.dto.CountryDto;
import com.example.core_module.model.Country;
import com.example.core_module.repository.CountryRepository;
import com.example.core_module.service.CountryService;
@Service
public class CountryServiceImpl implements CountryService {
@Autowired
private CountryRepository countryRepository;
	@Override
	public List<Country> findAll() {
		List<Country> list=new  ArrayList<>();
		list=countryRepository.findAll();
		return list;
	}

	@Override
	public Country findById(Long country_id) {
		Country country=countryRepository.findById(country_id).get();
		return country;
	}

	@Override
	public void deleteById(Long country_id) {
		countryRepository.deleteById(country_id);
	}

	@Override
	public Country save(CountryDto countryDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
