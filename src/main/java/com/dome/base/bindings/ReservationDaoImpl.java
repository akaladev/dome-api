package com.dome.base.bindings;

import com.dome.base.model.Reservation;
import com.dome.base.bindings.ReservationDao;
import com.dome.base.persistence.AbstractHibernateDao;
import java.util.List;

public class ReservationDaoImpl extends AbstractHibernateDao implements ReservationDao{
    
    public ReservationDaoImpl(){
        super();
    }
    @Override
    public List<Reservation> findByList() {
        return super.findList(Reservation.class);
    }
    
    @Override
    public void save(Reservation model) {
        super.save(model);
    }
}