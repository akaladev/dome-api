package com.dome.base.bindings;

import com.dome.base.model.Color;
import com.dome.base.model.Specie;

import java.util.List;


public interface ColorDao{
    public List<Color> findByList();
    public void save(Color color);
    public Color find(long id);
} 