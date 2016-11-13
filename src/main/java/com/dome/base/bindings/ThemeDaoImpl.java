package com.dome.base.bindings;

/**
 * Created by akalamichael on 11/13/16.
 */

import com.dome.base.model.Theme;
import com.dome.base.persistence.AbstractHibernateDao;

import java.util.List;

public class ThemeDaoImpl extends AbstractHibernateDao implements ThemeDao {

    public ThemeDaoImpl(){super();}
    @Override
    public List<Theme> findByList() {
        return super.findList(Theme.class);
    }

    @Override
    public void save(Theme theme) {
        super.save(theme);
    }
}
