package com.dome.base.repository;

import com.dome.base.utils.Contract;
import com.dome.base.persistence.AbstractHibernateDao;
import com.dome.base.application.exception.ComponentNotFoundException;
import com.dome.base.application.Application;
import java.util.List;

public class BaseRepository {



    public static <I> List<I> findList(Class<? extends Object> entityClass){
        try{
             String beanId = Contract.getBeanId(entityClass);
             AbstractHibernateDao dao = (AbstractHibernateDao) Application.getComponent(beanId);
             return dao.findList(entityClass);
            
        }catch(ComponentNotFoundException exp ){
             exp.printStackTrace();    
        }
        return null;
    }
    
    public static <T>  void save(T model, Class<? extends Object> entityClass){
        try{
            String beanId = Contract.getBeanId(entityClass);
            AbstractHibernateDao dao = (AbstractHibernateDao) Application.getComponent(beanId);
            dao.save(model);

        }catch(ComponentNotFoundException exp ){
            exp.printStackTrace();
        }

    }
}