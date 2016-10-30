package com.dome.base.bindings;

import com.dome.base.model.ProvincialStatus;
import java.util.List;


public interface ProvincialStatusDao{
    public List<ProvincialStatus> findByList();
    public void save(ProvincialStatus model);
} 