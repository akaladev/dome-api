package com.dome.base.persistence;


import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

/**
 * This interface is implemented by classes 
 * that are responsible for managing and  
 * creating sessions for data access objects.
 * @author Akala Michael
 * @stereotype mi-detail
 */

public interface SessionManager{
    
     /**
     * This is used to initialize configs and data mapings.
     *
     */
    public void initializeConfigs() throws HibernateException;
                
    
    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception HibernateException
     *            if session creation fails .
     */
    public Session beginSession() throws HibernateException;
    
    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception HibernateException
     *            if session creation fails .
     */
    public void closeSession() throws HibernateException;
    
    /**
     * This is method is  used for getting the 
     * configuration.
     */
    public void setConfig(String file);
    
     /**
     * This is method is  used for getting the 
     * configuration.
     */
    public String getConfig();
    

}