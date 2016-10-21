
package com.dome.base.utils;

import java.io.PrintStream;
import com.dome.base.application.exception.ApplicationException;
import com.dome.base.application.exception.ComponentNotFoundException;
import com.dome.base.application.exception.ConfigurationException;

/**
 * This class is a untility that contains exception handling methods.
 * @author Michael Akala
 */
public class ExceptionUtil {
    /**
     * Exception handling routines write to this file.  This may be
     * redirected by assignment.
     */
    public static PrintStream err = System.err;

    /**
     * Handle exceptions by writing them to a log file
     * @param e The caught object.
     */
    public static void handleException(Throwable e) {
        handleException(null, e);
    } // handleException(Throwable)

    /**
     * Handle exceptions by writing them to a log file.
     * @param msg A message describing the situation.
     * @param e The caught object.
     */
    public static synchronized void handleException(String msg, Throwable e) {
        if (e instanceof ThreadDeath) {
            throw (ThreadDeath)e;
        } // if ThreadDeath
        if (msg==null) {
            msg = "An error occurred";
        } // if msg
        err.println(msg);

        e.printStackTrace(err);

        while (true) {
            Throwable underlier = null;
            if (e instanceof ApplicationException) {
                underlier = ((Application)e).getUnderlyingException();
            } else if (e instanceof ComponentNotFoundException) {
                underlier
                  = ((ComponentNotFoundException)e).getUnderlyingException();
            } else if (e instanceof ConfigurationException) {
                underlier = ((ConfigurationException)e).getUnderlyingException();
            }  // if
            if (underlier==null) {
                break;
            } // if underlier
            err.println("underlying exception is");
            underlier.printStackTrace(err);
            e = underlier;
        } // while
    } // handleException(String, Throwable)
} // class ExceptionUtil