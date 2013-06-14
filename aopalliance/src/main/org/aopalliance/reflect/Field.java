
package org.aopalliance.reflect;

/**
 * This represents a field of a class. */

public interface Field extends Member {

   /**
    * Same as <code>getReadLocator(USER_SIDE)</code>.
    *
    * @see #getReadLocator(int) */
   CodeLocator getReadLocator();

   /**
    * This methods returns the points where the current field is read.
    *
    * <p>There are two different behaviors for this method depending
    * on the side of the locator. At the user side, the locator
    * designates all the points in methods bodies where the field is
    * read (similarly to <code>Code.getReadLocator(Field)</code>). At
    * the provider side, it really may depend on the implementor
    * choice (e.g. it can return a locator on the body of the field's
    * getter).
    *
    * <p>In Java, the user side is most of the time used so that you
    * can use the method <code>getReadLocator()</code>.
    *
    * @param side USER_SIDE || PROVIDER_SIDE 
    * @see #getReadLocator() */
   CodeLocator getReadLocator(int side);

   /**
    * Same as <code>getWriteLocator(USER_SIDE)</code>.
    *
    * @see #getWriteLocator(int) */
   CodeLocator getWriteLocator();

   /**
    * This methods returns the points where the current field is
    * written.
    *
    * <p>There are two different behaviors for this method depending
    * on the side of the locator. At the user side, the locator
    * designates all the points in methods bodies where the field is
    * written (similarly to <code>Code.getWriteLocator(Field)</code>). At
    * the provider side, it really may depend on the implementor
    * choice (e.g. it can return a locator on the body of the field's
    * setter).
    *
    * <p>In Java, the user side is most of the time used so that you
    * can use the method <code>getWriteLocator()</code>.
    *
    * @param side USER_SIDE || PROVIDER_SIDE 
    * @see #getWriteLocator() */
   CodeLocator getWriteLocator(int side);

}
