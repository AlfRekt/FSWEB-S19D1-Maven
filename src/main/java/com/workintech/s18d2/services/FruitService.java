package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    Fruit getById(Long id);
    List<Fruit> getByPriceAsc();
    List<Fruit> getByPriceDesc();
    List<Fruit> searchByName(String name);
    Fruit delete(Long id);
    Fruit save(Fruit fruit);
}
