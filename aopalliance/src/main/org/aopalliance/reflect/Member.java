
package org.aopalliance.reflect;

/**
 * This interface represents a class member.
 *
 * <p>A member can be a field, a method, or a constructor. */

public interface Member extends ProgramUnit {

   /**
    * A constant to denote the program side that uses this member. */
   int USER_SIDE=0;
   /**
    * A constant to denote the program side that provides this
    * member. */
   int PROVIDER_SIDE=1;

   /**
    * Gets the class that declares this member. */
   Class getDeclaringClass();

   /**
    * The member's name. */
   String getName();

   /**
    * The modifiers value. */
   int getModifiers();
   
}
