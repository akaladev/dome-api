
package com.dome.base.utils;

import java.util.Collection;

/**
 * Assertion utility class that assists in validating arguments.
 *
 * <p>Useful for identifying programmer errors early and clearly at runtime.
 *
 * <p>For example, if the contract of a public method states it does not
 * allow {@code null} arguments, {@code Contract} can be used to validate that
 * contract. Doing this clearly indicates a contract violation when it
 * occurs and protects the class's invariants.
 *
 * <p>Typically used to validate method arguments rather than configuration
 * properties, to check for cases that are usually programmer errors rather
 * than configuration errors. In contrast to configuration initialization
 * code, there is usually no point in falling back to defaults in such methods.
 * @author Akala Michael
 */
public abstract class Contract {


	/**
	 * Contract a boolean expression, throwing an {@code IllegalArgumentException}
	 * if the expression evaluates to {@code false}.
	 * <pre class="code">Contract.isExpressionTrue(i &gt; 0, "The value must be greater than zero");</pre>
	 * @param expression a boolean expression
	 * @param message the exception message to use if the assertion fails
	 * @throws IllegalArgumentException if {@code expression} is {@code false}
	 */
	public static void isExpressionTrue(boolean expression, String message) {
		if (!expression) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * Contract a boolean expression, throwing an {@code IllegalArgumentException}
	 * if the expression evaluates to {@code false}.
	 * <pre class="code">Contract.isExpressionTrue(i &gt; 0);</pre>
	 * @param expression a boolean expression
	 * @throws IllegalArgumentException if {@code expression} is {@code false}
	 */
	public static void isExpressionTrue(boolean expression) {
		isExpressionTrue(expression, "[Assertion failed] - this expression must be true");
	}

	/**
	 * Contract that an object is {@code null}.
	 * <pre class="code">Contract.isNull(value, "The value must be null");</pre>
	 * @param object the object to check
	 * @param message the exception message to use if the assertion fails
	 * @throws IllegalArgumentException if the object is not {@code null}
	 */
	public static void isNull(Object object, String message) {
		if (object != null) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * Contract that an object is {@code null}.
	 * <pre class="code">Contract.isNull(value);</pre>
	 * @param object the object to check
	 * @throws IllegalArgumentException if the object is not {@code null}
	 */
	public static void isNull(Object object) {
		isNull(object, "[Assertion failed] - the object argument must be null");
	}
    
	/**
	 * Contract that an object is not {@code null}.
	 * <pre class="code">Contract.notNull(clazz, "The class must not be null");</pre>
	 * @param object the object to check
	 * @param message the exception message to use if the assertion fails
	 * @throws IllegalArgumentException if the object is {@code null}
	 */
	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * Contract that an object is not {@code null}.
	 * <pre class="code">Contract.notNull(clazz);</pre>
	 * @param object the object to check
	 * @throws IllegalArgumentException if the object is {@code null}
	 */
	public static void notNull(Object object) {
		notNull(object, "[Assertion failed] - this argument is required; it must not be null");
	}

	/**
	 * Contract that an array contains no {@code null} elements.
	 * <p>Note: Does not complain if the array is empty!
	 * <pre class="code">Contract.noNullElements(array, "The array must contain non-null elements");</pre>
	 * @param array the array to check
	 * @param message the exception message to use if the assertion fails
	 * @throws IllegalArgumentException if the object array contains a {@code null} element
	 */
	public static void noNullElements(Object[] array, String message) {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					throw new IllegalArgumentException(message);
				}
			}
		}
	}

	/**
	 * Contract that an array contains no {@code null} elements.
	 * <p>Note: Does not complain if the array is empty!
	 * <pre class="code">Contract.noNullElements(array);</pre>
	 * @param array the array to check
	 * @throws IllegalArgumentException if the object array contains a {@code null} element
	 */
	public static void noNullElements(Object[] array) {
		noNullElements(array, "[Assertion failed] - this array must not contain any null elements");
	}


	/**
	 * Contract a boolean expression, throwing an {@code IllegalStateException}
	 * if the expression evaluates to {@code false}.
	 * <p>Call {@link #isTrue} if you wish to throw an {@code IllegalArgumentException}
	 * on an assertion failure.
	 * <pre class="code">Contract.state(id == null, "The id property must not already be initialized");</pre>
	 * @param expression a boolean expression
	 * @param message the exception message to use if the assertion fails
	 * @throws IllegalStateException if {@code expression} is {@code false}
	 */
	public static void state(boolean expression, String message) {
		if (!expression) {
			throw new IllegalStateException(message);
		}
	}

	/**
	 * Contract a boolean expression, throwing an {@link IllegalStateException}
	 * if the expression evaluates to {@code false}.
	 * <p>Call {@link #isTrue} if you wish to throw an {@code IllegalArgumentException}
	 * on an assertion failure.
	 * <pre class="code">Contract.state(id == null);</pre>
	 * @param expression a boolean expression
	 * @throws IllegalStateException if {@code expression} is {@code false}
	 */
	public static void state(boolean expression) {
		state(expression, "[Assertion failed] - this state invariant must be true");
	}
    
    public static String getBeanId(Class<? extends Object> componentClass){
        String className = componentClass.getSimpleName();
        return className.substring(0, 1).toLowerCase() + className.substring(1) +"DaoImpl";
    }

}
