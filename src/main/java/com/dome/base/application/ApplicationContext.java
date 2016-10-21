package com.dome.base.application;

import com.dome.base.application.exception.ComponentNotFoundApplicationException;

/**
 * it gives access to objects 
 * through dependency injection
 * wraps around an Ioc container.
 * @author Akala Michael
 */
public interface ApplicationContext {

    /**
     * Gets a component from context. The component may or may
     * not be the same object for each call. 
     * @param name Name of component.
     * @return Component instance (can be singleton).
     * 
     * @throws ComponentNotFoundApplicationException Thrown if 
     *      component is not found with given name.
     */
    public Object getComponent(String name) throws ComponentNotFoundApplicationException;
    
}
