
package org.aopalliance.reflect;

/**
 * This interface represents a locator on a base program piece of
 * code.
 *
 * <p>The AOP Alliance implementation provider should provide code
 * locators implementations in order to support several kinds of code
 * locators (e.g. as the ones used in the <code>Code</code>
 * interface).
 *
 * <p>The AOP Alliance client program gets the locator by navigating
 * the base program metamodel (using the
 * {@link org.aopalliance.reflect} package) and using the
 * <code>get...Locator(...)</code> methods.
 *
 * <p>Code locators are quite different from unit locators.
 *
 * @see Code
 * @see Code#getLocator()
 * @see Code#getCallLocator(Method)
 * @see Code#getReadLocator(Field)
 * @see Code#getWriteLocator(Field)
 * @see Code#getThrowLocator(Class)
 * @see Code#getCatchLocator(Class)
 * @see Method#getCallLocator()
 * @see UnitLocator */

public interface CodeLocator extends Locator {
}



