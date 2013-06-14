
package org.aopalliance.reflect;

/**
 * This interface represents a specific unit locator for base program
 * classes.
 *
 * <p>For instance, this locator can represent a given class, or a
 * given classes set (e.g. all the classes of a given package or all
 * the classes that implement a given interface).
 *
 * @see ProgramUnit#getLocator()
 * @see Class#getClassLocator() */

public interface ClassLocator extends UnitLocator {
}



