package com.dome.base.bindings;

import com.dome.base.model.NationalStatus;
import java.util.List;


public interface NationalStatusDao{
    public List<NationalStatus> findByList();
    public void save(NationalStatus model);
} 