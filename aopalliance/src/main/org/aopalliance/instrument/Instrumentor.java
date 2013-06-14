
package org.aopalliance.instrument;

import org.aopalliance.reflect.Code;
import org.aopalliance.reflect.Class;
import org.aopalliance.reflect.CodeLocator;
import org.aopalliance.reflect.ClassLocator;
import org.aopalliance.reflect.UnitLocator;

/**
 * This interface defines all the methods that perform program
 * instrumentations that are useful for AOP.
 *
 * <p>The modifications definitions rely on an abstract representation
 * of locators, as defined in the {@link org.aopalliance.reflect}
 * package.
 *
 * @see org.aopalliance.reflect.Locator
 * @see org.aopalliance.reflect.ClassLocator
 * @see org.aopalliance.reflect.CodeLocator */

public interface Instrumentor {

   /**
    * Creates a new class.
    *
    * @return the locator that corresponds to the newly created class
    */
   ClassLocator createClass(String name) throws InstrumentationError;   

   /**
    * Adds a new implemented interface to a given class location.
    *
    * @return the object that corresponds to this instrumentation
    * @throws InstrumentationError if something went wrong with this
    * instrumentation
    * @see #undo(Instrumentation) */
   Instrumentation addInterface(ClassLocator location,
                                String newInterfaceName)
      throws InstrumentationError;

   /**
    * Sets or replaces the current superclass of a class location.
    *
    * <p>The new superclass should be a subtype of the replaced one in
    * order to maintain backward compatibility.
    *
    * @return the object that corresponds to this instrumentation
    * @throws InstrumentationError if something went wrong with this
    * instrumentation
    * @see #undo(Instrumentation) */
   Instrumentation setSuperClass(ClassLocator location,
                                 String newSuperClassName)
      throws InstrumentationError;

   /**
    * Introduces a class into the class location (mixin).
    *
    * <p>Similarely to a mixin, the whole set of fields and methods
    * are introduced into the location's class, all the implemented
    * interface of the introduced class are also added as interfaces
    * of the location's class.
    *
    * @return the object that corresponds to this instrumentation
    * @throws InstrumentationError if something went wrong with this
    * instrumentation
    * @see #undo(Instrumentation) */
   Instrumentation addClass(ClassLocator location,String className)
      throws InstrumentationError;
   
   /**
    * Adds a new method to the class location.
    *
    * @return the object that corresponds to this instrumentation
    * @throws InstrumentationError if something went wrong with this
    * instrumentation
    * @see #undo(Instrumentation) */
   Instrumentation addMethod(ClassLocator location,
                             String name,
                             String[] parameterTypeNames,
                             String[] parameterNames,
                             Code body)
      throws InstrumentationError;

   /**
    * Adds a new field to the target class.
    *
    * @return the object that corresponds to this instrumentation
    * @throws InstrumentationError if something went wrong with this
    * instrumentation
    * @see #undo(Instrumentation) */
   Instrumentation addField(ClassLocator location,
                            String name,
                            String typeName,
                            Code initializator)
      throws InstrumentationError;
   
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
    * @return the object that corresponds to this instrumentation
    * @throws InstrumentationError if something went wrong with this
    * instrumentation
    * @see #undo(Instrumentation) */
   Instrumentation addBeforeCode(CodeLocator location,
                                 Code beforeCode,
                                 Instrumentation before,
                                 Instrumentation after)
      throws InstrumentationError;

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
    * @return the object that corresponds to this instrumentation
    * @throws InstrumentationError if something went wrong with this
    * instrumentation
    * @see #undo(Instrumentation) */
   Instrumentation addAfterCode(CodeLocator location,
                                Code afterCode,
                                Instrumentation before,
                                Instrumentation after)
      throws InstrumentationError;

   /**
    * Adds some code around a given method code body.
    *
    * <p>An around code is a code that calls a <i>proceed</i> method
    * one or several times. When the proceed method is invoked, the
    * location is executed (for compile approched, the proceed method
    * call is subsituted by the location).
    *
    * <p>The proceed method name is parameterized by the
    * <code>proceedMethodName</code> argument (can be
    * <code>proceed</code>, <code>invokeNext</code>,
    * <code>runNext</code>, etc).
    *
    * <p>Note that if the around code does not call the proceed
    * method, then the around instrumentation is similar to a
    * replacement of the location. This is not aspect-safe but can be
    * useful in some instrumentation process to build AO systems.
    *
    * @param location the modification locator that can represent a
    * method invocation, a field set/get, or a constructor (at callee
    * or caller side)
    * @param aroundCode the code to be added after
    * @param proceedMethodName the name of the proceed method
    * @param before the modification that must stay before this
    * after code
    * @param after the modification that must stay after this
    * after code
    * @return the object that corresponds to this instrumentation
    * @throws InstrumentationError if something went wrong with this
    * instrumentation
    * @see #undo(Instrumentation) */
   Instrumentation addAroundCode(CodeLocator location,
                                 Code aroundCode,
                                 String proceedMethodName,
                                 Instrumentation before, 
                                 Instrumentation after)
      throws InstrumentationError;

   /**
    * Cancels an instrumentation.
    *
    * @param instrumentation the instrumentation to cancel
    *
    * @throws UndoNotSupportedException when the implementation does
    * not support instrumentation cancellation for the given
    * instrumentation */
   void undo(Instrumentation instrumentation) 
      throws UndoNotSupportedException;

}

