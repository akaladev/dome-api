package com.dome.base.bindings;

import com.dome.base.model.Specie;
import java.util.List;


public interface SpecieDao{
    public List<Specie> findByList();
    public void save(Specie model);
    public Specie find(long id);
} 