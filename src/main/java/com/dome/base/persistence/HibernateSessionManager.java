package com.dome.base.persistence;

import java.io.File;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.cfg.Configuration;
import net.sf.hibernate.SessionFactory;
import com.dome.base.utils.Contract;

/**
 * This class is responsible for managing and  
 * creating sessions for data access objects.
 * @author Akala Michael
 * @stereotype mi-detail
 */

public class HibernateSessionManager implements SessionManager{
    
    private String configFile;
    private SessionFactory sessionFactory;
    
    public HibernateSessionManager(String file){
       this.setConfig(file);
    }
    
    /**
     * This is used to create and initializes sessions
     * for data access objects.
     * @exception HibernateException
     *            if session creation fails .
     */
    @Override
    public void initializeConfigs() throws HibernateException {
       Configuration conf = new Configuration();
        
       if (null != this.configFile) {
			conf.configure(this.configFile);
       }   
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
			this.initializeConfigs();
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