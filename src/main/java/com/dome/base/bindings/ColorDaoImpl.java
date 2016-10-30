package com.dome.base.bindings;

import com.dome.base.model.Color;
import com.dome.base.persistence.AbstractHibernateDao;
import java.util.List;

public class ColorDaoImpl extends AbstractHibernateDao implements ColorDao{
    
    public ColorDaoImpl(){
        super();
    }
    @Override
    public List<Color> findByList() {
        return super.findList(this.getClass());
    }
}