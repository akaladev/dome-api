package com.dome.base.bindings;

import com.dome.base.model.Animal;
import java.util.List;

public interface AnimalDao {
    public List<Animal> findByList();
    public void save(Animal animal);
}