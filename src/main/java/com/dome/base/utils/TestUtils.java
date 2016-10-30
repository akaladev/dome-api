package com.dome.base.utils;
import com.dome.base.bindings.ColorDao;
import com.dome.base.bindings.ColorDaoImpl;
import com.dome.base.model.Color;

public class TestUtils {
    public static void main(String args[]){
        ColorDao dao = new ColorDaoImpl();
        Color model = new Color();
        model.setName("green");
        dao.save(model);
    }
}