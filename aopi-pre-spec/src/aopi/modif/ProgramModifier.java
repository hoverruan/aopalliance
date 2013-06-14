
package aopi.modif;

import aopi.reflect.Code;
import aopi.reflect.CodeLocator;
import aopi.reflect.ClassLocator;
import aopi.reflect.UnitLocator;

/**
 * This interface defines all the methods that perform program
 * modification that are useful for AOP.
 *
 * <p>The modifications definitions rely on an abstract representation
 * of locators, as defined in the <code>aopi.reflect</code> package.
 *
 * @see aopi.reflect.Locator
 * @see aopi.reflect.ClassLocator
 * @see aopi.reflect.CodeLocator
 */

public interface ProgramModifier {
   
   /**
    * Adds a new implemented interface to a given class location. */ 
   Modification addInterface(ClassLocator location,
                             String newInterfaceName);

   /**
    * Sets or replaces the current superclass of a class location.
    *
    * <p>The new superclass should be a subtype of the replaced one in
    * order to maintain backward compatibility. */
   Modification setSuperClass(ClassLocator location,
                              String newSuperClassName);

   /**
    * Introduces a class to the class location.
    *
    * <p>The whole set of fields and methods are introduced into the
    * location's class, all the implemented interface of the
    * introduced class are also added as interfaces of the location's
    * class. */
   Modification addClass(ClassLocator location,String className);
   
   /**
    * Adds a new method to the class location. */
   Modification addMethod(ClassLocator location,
                          String name,
                          String[] parameterTypeNames,
                          String[] parameterNames,
                          Code body);

   /**
    * Adds a new field to the target class. */
   Modification addField(ClassLocator location,
                         String name,
                         String typeName,
                         Code initializator);
   
   /**
    * Adds some code before a given method code body.
    *
    * @param location the modification locator that can represent a
    * method invocation, a field set/get, or a constructor (at callee
    * or caller side)
    * @param beforeCode the code to be added before
    * @param before the modification that must stay before this
    * before code
    * @param after the modification that must stay after this
    * before code
    * @return the modification (can be used to place the
    * next modifications relatively to this one) */
   Modification addBeforeCode(CodeLocator location,
                              Code beforeCode,
                              Modification before, Modification after);

   /**
    * Adds some code after a given method code body.
    *
    * @param location the modification locator that can represent a
    * method invocation, a field set/get, or a constructor (at callee
    * or caller side)
    * @param afterCode the code to be added after
    * @param before the modification that must stay before this
    * after code
    * @param after the modification that must stay after this
    * after code
    * @return this modification (can be used to place the
    * next modifications relatively to this one) */
   Modification addAfterCode(CodeLocator location,
                             Code afterCode,
                             Modification before, Modification after);

   /**
    * Adds some code around a given method code body.
    *
    * @param location the modification locator that can represent a
    * method invocation, a field set/get, or a constructor (at callee
    * or caller side)
    * @param aroundCode the code to be added after
    * @param before the modification that must stay before this
    * after code
    * @param after the modification that must stay after this
    * after code
    * @return this modification (can be used to place the
    * next modifications relatively to this one) */
   Modification addAroundCode(CodeLocator location,
                              Code aroundCode,
                              Modification before, Modification after);

}

