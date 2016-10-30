package com.dome.base.bindings;

import com.dome.base.model.NationalStatus;
import com.dome.base.bindings.NationalStatusDao;
import com.dome.base.persistence.AbstractHibernateDao;
import java.util.List;

public class NationalStatusDaoImpl extends AbstractHibernateDao implements NationalStatusDao{
    
    public NationalStatusDaoImpl(){
        super();
    }
    @Override
    public List<NationalStatus> findByList() {
        return super.findList(NationalStatus.class);
    }
    
    @Override
    public void save(NationalStatus model) {
        super.save(model);
    }
}