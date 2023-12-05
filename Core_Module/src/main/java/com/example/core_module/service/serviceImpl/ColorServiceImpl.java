package com.example.core_module.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.model.Color;
import com.example.core_module.repository.ColorRepository;
import com.example.core_module.service.ColorService;
@Service
public class ColorServiceImpl implements ColorService{
@Autowired
private ColorRepository colorRepository;
	@Override
	public List<Color> findAll() {
		List<Color> list=new ArrayList<>();
		list=colorRepository.findAll();
		return list;
	}

	@Override
	public Color findById(Long id) {
		Color color=colorRepository.findById(id).get();
		return color;
	}

	@Override
	public void deleteById(Long id) {
			colorRepository.deleteById(id);
	}

	@Override
	public Color save() {
		// TODO Auto-generated method stub
		return null;
	}

}
