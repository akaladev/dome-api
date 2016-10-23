package com.dome.base.application.exception;

/**
 * Indicates that a component was not found in the
 * Ioc container
 * @author Akala Michael
 */
public class ComponentNotFoundException extends ApplicationException {

	/** Serial version UID */
	private static final long serialVersionUID = 1L;

	/** Component name */
    private String component;

	/**
     * Construct with component name.
     *
	 * @param aComponent Component id.
	 */
	public ComponentNotFoundException(final String component) {
		super("Component not found: " + component);
        this.component = component;
	}

	/**
     * Construct with component name and cause.
     * 
	 * @param aComponent Component id.
	 * @param aCause Throwable cause.
	 */
	public ComponentNotFoundException(final String component, final Throwable cause) {
		super("Component not found: " + component, cause);
        this.component = component;
	}

	/**
	 * @return Returns the component id.
	 */
	public String getComponent() {
		return this.component;
	}
}