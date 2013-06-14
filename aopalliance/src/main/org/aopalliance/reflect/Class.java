
package org.aopalliance.reflect;

/**
 * This element represents classes in the base program. */

public interface Class extends ProgramUnit {

   /**
    * Returns the class locator that corresponds to this class.
    *
    * <p>This method returns exactly the same result as
    * <code>ProgramUnit.getLocator()</code> but with a more precise
    * type (<code>ClassLocator</code> instead of
    * <code>UnitLocator</code>).
    *
    * @see ProgramUnit#getLocator() */
   ClassLocator getClassLocator();

   /**
    * Gets the class's full name. */
   String getName();

   /**
    * Gets the fields of this class (including superclass fields). */
   Field[] getFields();

   /**
    * Gets the fields declared by this class. */
   Field[] getDeclaredFields();

   /**
    * Gets the methods of this class (including superclass
    * methods). */
   Method[] getMethods();

   /**
    * Gets the methods declared by this class. */
   Method[] getDeclaredMethods();

   /**
    * Gets the superclass of this class. */
   Class getSuperclass();

   /**
    * Gets all the interfaces implemented by this class. */
   Class[] getInterfaces();

}
