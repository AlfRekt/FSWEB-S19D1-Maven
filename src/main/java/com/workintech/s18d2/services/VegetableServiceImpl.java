package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{
    private VegetableRepository vegetableRepository;
    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository){
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.listVegetablesByAsc();
    }

    @Override
    public Vegetable getById(Long id) {
        Optional<Vegetable> vegetable = vegetableRepository.findById(id);
        if(vegetable.isPresent()){
            return vegetable.get();
        }
        throw new RuntimeException("Id must be valid!");
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.listVegetablesByDesc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable vegetable = getById(id);
        if(vegetable != null){
            vegetableRepository.deleteById(id);
            return vegetable;
        }
        throw new RuntimeException("Id must be valid!");
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        if (
                vegetable.getName() == null ||
                        vegetable.getPrice() == null ||
                        vegetable.getIsGrownOnTree() == null
        ) {
            throw new ApiException("Check the data! Something is missing", HttpStatus.BAD_REQUEST);
        }

        return vegetableRepository.save(vegetable);
    }
}
