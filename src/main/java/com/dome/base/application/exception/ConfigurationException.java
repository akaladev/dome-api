package com.dome.base.application.exception;

/**
 * Indicates that a component was not found in the
 * Ioc container
 * @author Akala Michael
 */
public class ConfigurationException extends ApplicationException {

	/** Serial version UID */
	private static final long serialVersionUID = 1L;

	/** Component name */
    private String config;

	/**
     * Construct with component name.
     *
	 * @param aComponent Component id.
	 */
	public ConfigurationException(final String configMsg) {
		super("Configuration: " + configMsg);
        this.config = configMsg;
	}

	/**
     * Construct with component name and cause.
     * 
	 * @param aComponent Component id.
	 * @param aCause Throwable cause.
	 */
	public ConfigurationException(final String configMsg, final Throwable cause) {
		super("Configuration " + configMsg, cause);
        this.config = configMsg;
	}
}