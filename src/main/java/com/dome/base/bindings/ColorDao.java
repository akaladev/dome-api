package com.dome.base.bindings;

import com.dome.base.model.Color;
import java.util.List;


public interface ColorDao{
    public List<Color> findByList();
    public void save(Color color);
} 