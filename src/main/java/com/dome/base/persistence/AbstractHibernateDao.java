package com.dome.base.persistence;
import com.dome.base.persistence.AbstractSessionManager;
import com.dome.base.persistence.HibernateSessionManager;
import com.dome.base.application.Application;
import com.dome.base.application.exception.DataAccessException;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import java.util.List;
import java.text.MessageFormat;
import java.io.Serializable;


public abstract class AbstractHibernateDao extends AbstractSessionManager {
    
    private HibernateSessionManager sessionManager;
    
    public AbstractHibernateDao(){
        
    }

    
    /**
	 * Find entity model by id.
     *
	 */
    
    public Object find(Class<? extends Object> entityClass, Serializable id){
      Session session = null;
		try {
			session = sessionManager.beginSession();
			return session.load(entityClass, id);
		} catch (Exception e) {
			throw new DataAccessException(entityClass.getClass(), e);
		} finally {
			if (null != session) {
				try {
					this.closeSession(session);
				} catch (HibernateException e) {
					e.printStackTrace();
				}
			}
		}  
    }
    
    /**
	 * Find entity list.
     * @param entityClass
	 */
    
    public <T> List<T> findList(Class<? extends Object> entityClass){
      Session session = null;
		try {
			session = sessionManager.beginSession();
            Query query = session.createQuery(MessageFormat.format("from {0}",entityClass.getName().toUpperCase()));
            return query.list();
            
		} catch (Exception e) {
			throw new DataAccessException(entityClass.getClass(), e);
		} finally {
			if (null != session) {
				try {
					this.closeSession(session);
				} catch (HibernateException e) {
					e.printStackTrace();
				}
			}
		}  
    }
    
    
    /**
	 * Saves an entity.
	 * @param entity
	 * Entity object.
	 */
	public void save(Object entity) throws DataAccessException {
		Session session = null;

		try {
			session = sessionManager.beginSession();
			session.saveOrUpdate(entity);
			session.flush();
		} catch(Exception e) {
			throw new DataAccessException(entity.getClass(), e);
		}  finally {
			if (null != session) {
				try {
					this.closeSession(session);
				} catch (HibernateException e) {
					e.printStackTrace();
				}
			}
		}
	}
    
    
    /**
	 * Deletes entity.
	 * @param entity
	 * Entity object.
	 */
	public void delete(Object entity) throws DataAccessException {
		Session session = null;
		try {
			session = sessionManager.beginSession();
			session.delete(entity);
			session.flush();
		} catch (Exception e) {
			throw new DataAccessException(entity.getClass(), e);
		} finally {
			if (null != session) {
				try {
					this.closeSession(session);
				} catch (HibernateException e) {
					e.printStackTrace();
				}
			}
		}
	}

    
    /**
	 * Close Hibernate Session.
     *
	 */
	private void closeSession(Session session) throws HibernateException {

			this.sessionManager.closeSession(session);
	}
    
    
}