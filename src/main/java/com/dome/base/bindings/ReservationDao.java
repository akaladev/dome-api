package com.dome.base.bindings;

import com.dome.base.model.Reservation;
import java.util.List;


public interface ReservationDao{
    public List<Reservation> findByList();
    public void save(Reservation model);
} 