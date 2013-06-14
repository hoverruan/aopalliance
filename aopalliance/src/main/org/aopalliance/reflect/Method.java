
package org.aopalliance.reflect;

/**
 * This represents a method of a class. */

public interface Method extends Member {

   /**
    * This locator contains all the points in the program that call
    * this method.
    *
    * <p>Note that this code locator corresponds to the client-side
    * call event (equiv. to
    * <code>this.getLocator(USER_SIDE)</code>. To get the server-side
    * equivalent locator, one must write
    * <code>this.getBody().getLocator()</code> or
    * <code>this.getLocator(PROVIDER_SIDE)</code>.
    *
    * <p>It is a very invasive feature since it designates all the
    * calling points in all the classes of the application. To only
    * designate the calling points in a given client method, one
    * should write
    * <code>aClientMethod.getBody().getCallLocator(this)</code>.
    *
    * @see Code#getLocator()
    * @see Code#getCallLocator(Method) */
   CodeLocator getCallLocator();

   /**
    * A full version of {@link #getCallLocator()}.
    *
    * @param side USER_SIDE || PROVIDER_SIDE 
    * @see #getCallLocator() */
   CodeLocator getCallLocator(int side);
   

   /**
    * Returns the body of the current method. */
   Code getBody();
   
}
