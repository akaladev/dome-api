package com.dome.base.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import java.io.InputStream;
import java.util.Properties;
import com.dome.base.persistence.SessionManager;
import com.dome.base.application.exception.ConfigurationException;


/**
 * This class is responsible for managing and  
 * creating sessions for data access objects.
 * @author Akala Michael
 * @stereotype mi-detail
 */

public class HibernateSessionManager implements SessionManager{
    
    private String configFile;
    private SessionFactory sessionFactory;
    
    public HibernateSessionManager() throws ConfigurationException{
        
        InputStream propertiesStream = null;
        String resourceName = null;
        try {
            resourceName = "/conf/application/local.properties";
            Class thisClass = HibernateSessionManager.class;
            propertiesStream
              = thisClass.getResourceAsStream(resourceName);
            if (propertiesStream==null) {
                String msg;
                msg = "unable to open file " + resourceName;
                throw new ConfigurationException(msg);
            } // if
            Properties configProperties = new Properties();
            configProperties.load(propertiesStream);
            String datasourceProperty = "datasource.config.path";
            String datasourceConfigPath
              = (String)configProperties.get(datasourceProperty);
            if (datasourceConfigPath==null) {
                String msg;
                msg = datasourceProperty + " is not specified.";
                throw new ConfigurationException(msg);
            }
            initializeConfigs(datasourceConfigPath);
        } catch (Exception e) {
            throw new ConfigurationException(toString(), e);
        } finally {
            if (propertiesStream!=null) {
                try {
                    propertiesStream.close();
                } catch (Exception  e) {
                    String msg
                      = "Exception thrown while closing "
                      + resourceName;
                     throw new ConfigurationException(msg, e);
                } // try
            } // if
        } // try
    }
    
    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception HibernateException
     *            if session creation fails .
     */
    @Override
    public void initializeConfigs(String file) throws HibernateException {
       Configuration conf = new Configuration();
        
       if (null != file) {
            this.configFile = file;
			conf.configure(this.configFile);
       }
       this.sessionFactory = conf.buildSessionFactory();     
    } 

    /**
	 * Returns a Hibernate session in the current thread context.
	 * 
	 * @return Hibernate session, null if no open session in this context.
	 */
	 public Session getSession() {
		try {
			return this.getSessionFactory().getCurrentSession();
		}
		catch(Exception e) {
			return null;
		}
	}
    
    
    /**
	 * Returns the Hibernate session factory.
	 * 
	 * @return Session factory.
	 * @throws HibernateException Thrown when factory creation fails.
	 */
	private synchronized SessionFactory getSessionFactory() throws HibernateException {
		if(null == this.sessionFactory) {
			this.initializeConfigs(configFile);
		}
		return this.sessionFactory;
	}
    
    
    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception HibernateException
     *            if session creation fails .
     */  
    @Override
    public Session beginSession() throws HibernateException {
        Session session = this.getSession();

		if (null != session) {
			return session;
		}

		SessionFactory sessionFactory = this.getSessionFactory();
	    session = sessionFactory.openSession();
		return session;
    }

    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception HibernateException
     *            if session creation fails .
     */ 
    @Override
    public void closeSession(Session session) throws HibernateException {
      Session currentSession = this.getSession();
		
        if (null != currentSession && currentSession != session) {
			throw new HibernateException("Unable To Close Current Session");
		}
		
		if (null == session) {
			return;
		}
		
		if (session.isOpen()) {
			session.close();
		}
    }

    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception HibernateException
     *            if session creation fails .
     */
    @Override
    public void setConfig(String file) {
      this.configFile = file;
    }
    
    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception HibernateException
     *            if session creation fails .
     */
    @Override
    public String getConfig() {
        return configFile;
    }
     
    
}