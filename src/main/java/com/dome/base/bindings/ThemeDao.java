package com.dome.base.bindings;

import com.dome.base.model.Theme;

import java.util.List;

/**
 * Created by akalamichael on 11/13/16.
 */
public interface ThemeDao {
    public List<Theme> findByList();
    public void save(Theme theme);

}
