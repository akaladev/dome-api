package com.dome.base.application.exception;

/**
 * Indicates that a persistent operation failed
 * @author Akala Michael
 */
public class DataAccessException extends ApplicationException {

    /** Serial version UID */
	private static final long serialVersionUID = 1L;
	
	private Object id;
	private Class<?> entityClass;
	
	public DataAccessException(Object aId, Class<?> aEntityClass) {
		super("Operation failed for entity "+aEntityClass.getName()+" with id: "+aId);
		this.id = aId;
		this.entityClass = aEntityClass;
	}

	public DataAccessException(Object aId, Class<?> aEntityClass, Exception aException) {
		super("Operation failed for entity "+aEntityClass.getName()+" with id: "+
				aId, aException);
		this.id = aId;
		this.entityClass = aEntityClass;
	}
	
	public DataAccessException(Class<?> aEntityClass) {
		super("Operation failed for entity "+aEntityClass.getName());
		this.entityClass = aEntityClass;
	}

	public DataAccessException(Class<?> aEntityClass, Exception aException) {
		super("Operation failed for entity "+aEntityClass.getName(), aException);
		this.entityClass = aEntityClass;
	}
	
	/**
	 * @return Returns the entityClass.
	 */
	public Class<?> getEntityClass() {
		return entityClass;
	}

	/**
	 * @return Returns the id.
	 */
	public Object getId() {
		return id;
	}
    
}
