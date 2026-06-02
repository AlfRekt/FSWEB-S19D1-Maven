package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    Vegetable getById(Long id);
    List<Vegetable> getByPriceAsc();
    List<Vegetable> getByPriceDesc();
    List<Vegetable> searchByName(String name);
    Vegetable delete(Long id);
    Vegetable save(Vegetable vegetable);
}
