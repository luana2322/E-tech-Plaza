package com.example.core_module.service;

import java.util.List;

import com.example.core_module.model.Color;

public interface ColorService {
List<Color> findAll();
Color findById(Long id);
void deleteById(Long id);
Color save();
}
