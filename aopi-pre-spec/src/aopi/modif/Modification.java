
package aopi.modif;

import aopi.reflect.Locator;

/**
 * This interface represents a modification on the base program.
 *
 * <p>The program modifier implementation should return a modification
 * instance for each modification which is performed.
 *
 * @see ProgramModifier */

public interface Modification {

   /** Interface adding modification type. */
   int ADD_INTERFACE=0;
   /** Superclass setting modification type. */
   int SET_SUPERCLASS=1;
   /** Class adding modification type. */
   int ADD_CLASS=2;
   /** Before code modification type. */
   int ADD_BEFORE_CODE=3;
   /** After code adding modification type. */
   int ADD_AFTER_CODE=4;
   /** Metadata adding modification type. */
   int ADD_METADATA=5;

   /**
    * Returns the location of this modification. */
   Locator getLocation();
   
   /**
    * Gets the modification type.
    *
    * @return ADD_INTERFACE | SET_SUPERCLASS | ADD_CLASS |
    * ADD_AFTER_CODE | ADD_BEFORE_CODE | ADD_AROUND_CODE |
    * ADD_METADATA */
   int getType();

}

