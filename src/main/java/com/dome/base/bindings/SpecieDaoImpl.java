package com.dome.base.bindings;

import com.dome.base.model.Specie;
import com.dome.base.bindings.SpecieDao;
import com.dome.base.persistence.AbstractHibernateDao;
import java.util.List;

public class SpecieDaoImpl extends AbstractHibernateDao implements SpecieDao{
    
    public SpecieDaoImpl(){
        super();
    }
    @Override
    public List<Specie> findByList() {
        return super.findList(Specie.class);
    }
    
    @Override
    public void save(Specie model) {
        super.save(model);
    }
}