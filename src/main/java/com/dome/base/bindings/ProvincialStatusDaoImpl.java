package com.dome.base.bindings;

import com.dome.base.model.NationalStatus;
import com.dome.base.model.ProvincialStatus;
import com.dome.base.bindings.ProvincialStatusDao;
import com.dome.base.persistence.AbstractHibernateDao;
import java.util.List;

public class ProvincialStatusDaoImpl extends AbstractHibernateDao implements ProvincialStatusDao{
    
    public ProvincialStatusDaoImpl(){
        super();
    }
    @Override
    public List<ProvincialStatus> findByList() {
        return super.findList(ProvincialStatus.class);
    }
    
    @Override
    public void save(ProvincialStatus model) {
        super.save(model);
    }

    @Override
    public ProvincialStatus find(long id) {
        return  (ProvincialStatus) super.find(ProvincialStatus.class, id);
    }
}