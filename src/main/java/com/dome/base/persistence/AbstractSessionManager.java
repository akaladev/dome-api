package com.dome.base.persistence;

import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.MappingException;
import org.hibernate.Session;
import com.dome.base.persistence.SessionManager;
import org.hibernate.Configuration;

/**
 * This class is responsible for managing and  
 * creating sessions for data access objects.
 * @author Akala Michael
 * @stereotype mi-detail
 */

public abstract class AbstractSessionManager implements SessionManager{
    
    private String configFile;
    private SessionManager sessionManager;
    
    public AbstractSessionManager(SessionManager sessionMgr){
        this.sessionManager = sessionMgr;
    }
    
    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception HibernateException
     *            if session creation fails .
     */
    @Override
    public void initializeConfigs() throws HibernateException {
       sessionManager.initializeConfigs();          
    } 

    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception HibernateException
     *            if session creation fails .
     */  
    @Override
    public Session beginSession() throws HibernateException {
      return sessionMnager.beginSession();
    }

    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception HibernateException
     *            if session creation fails .
     */ 
    @Override
    public void closeSession() throws HibernateException {
       sessionManager.closeSession();
    }

    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception DataAccessException
     *            if session creation fails .
     */
    @Override
    public void setConfig(String file) {
      this.configFile = file;
    }
    
    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception DataAccessException
     *            if session creation fails .
     */
    @Override
    public String getConfig() {
        return configFile;
    }
}