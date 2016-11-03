package com.dome.base.bindings;

import com.dome.base.model.Color;
import com.dome.base.bindings.ColorDao;
import com.dome.base.persistence.AbstractHibernateDao;
import java.util.List;

public class ColorDaoImpl extends AbstractHibernateDao implements ColorDao{
    
    public ColorDaoImpl(){
        super();
    }
    @Override
    public List<Color> findByList() {
        return super.findList(Color.class);
    }
    
    @Override
    public void save(Color color) {
        super.save(color);
    }

    @Override
    public Color find(long id) {
       return  (Color) super.find(Color.class, id);
    }
}