package com.dome.base.utils;
import com.dome.base.bindings.ColorDao;
import com.dome.base.application.Application;
import com.dome.base.application.exception.ComponentNotFoundException;

public class TestUtils {
    public static void main(String args[]){
        Application application = new Application();
        try {

            ColorDao dao = (ColorDao) application.getComponent("colorDaoImpl");
            System.out.println(dao.findByList().get(0).getName());
        }catch(ComponentNotFoundException exp){
            exp.printStackTrace();
        }
    }
}