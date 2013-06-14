
package org.aopalliance.reflect;

/**
 * This represents a piece of code in the program.
 *
 * <p>It is formed of a set of instructions and can be implemented at
 * bytecode or source-code level.
 *
 * <p>Typically, a code in the program comes from method bodies (it
 * can be init methods (instance or static) or regular methods
 * (instance or static) with any kind of visibility modifiers (public,
 * protected, private).
 *
 * <p>So, this class allows the client to retrieve code locators on
 * instructions within this code. This locators shall be used
 * conjointly whith an {@link org.aopalliance.instrument.Instrumentor}
 * implementation in order to perform aspetual transformations of the
 * program (before/after/around type).
 *
 * <p>The {@link #getLocator} method returns the locator for the whole
 * method and can be used to implement callee-side transformations
 * before/after/around the callee method.
 *
 * <p>The other set of locating methods returns locators that allows
 * the client to implement caller-side transformations (e.g. when the
 * code accesses a field or calls a method).
 *
 * @see org.aopalliance.instrument.Instrumentor
 * @see CodeLocator
 * @see Method#getBody() */

public interface Code {

   /**
    * Returns the code locator that corresponds to this code.
    *
    * <p>For instance, if a code is a set of instructions called
    * <code>code</code>, then the locator will designate
    * <code>&lt;code&gt;</code>. 
    *
    * <p> This locator is typically used to locate a whole method body.
    *
    * @see Method#getBody() */
   CodeLocator getLocator();

   /**
    * Returns a call locator for the given callee method.
    *
    * <p>For instance, a call locator for method <code>m()</code> 
    * designates the parts between <code>&lt;&gt;</code> in the
    * following code.
    *
    * <pre class=code>
    * [...]
    * aLocalVariable.&lt;m()&gt;;
    * [...]
    * aMethodParameter.&lt;m()&gt;;
    * [...]
    * aField.&lt;m()&gt;;
    * [...]
    * &lt;m()&gt; // when m is a method of the class the current code belongs to
    * [...]
    * </pre>
    *
    * <p>If the given method is a static method, the locator follows
    * the same principles, as for constructors. For instance if the
    * current method is the <code>init</code> method of class
    * <code>C</code>:
    *
    * <pre class=code>
    * [...]
    * aVar = &lt;new C()&gt;;
    * [...]
    * </pre>
    *
    * @param calleeMethod the method that is called from the current
    * code */
   CodeLocator getCallLocator(Method calleeMethod);

   /**
    * Returns a field reading locator in the current body.
    *
    * <p>For instance, a field read locator for field <code>f</code>
    * designates the parts between <code>&lt;&gt;</code> in the
    * following code.
    *
    * <pre>
    * [...]
    * &lt;f&gt;.m();
    * [...]
    * aVarOrFieldOrParam = &lt;f>;
    * [...]
    * </pre>
    *
    * @param readField the field that is read from the current code */
   CodeLocator getReadLocator(Field readField);

   /**
    * Returns a field writing locator in the current body.
    *
    * <p>For instance, a field write locator for field <code>f</code>
    * designates the parts between <code>&lt;&gt;</code> in the
    * following code.
    *
    * <pre>
    * [...]
    * &lt;f=&gt; aVarOrFieldOrParam;
    * [...]
    * </pre>
    *
    * @param writtenField the field that is written from the current
    * code */
   CodeLocator getWriteLocator(Field writtenField);

   /**
    * Returns a exception throwing locator in the current body.
    *
    * <p>For instance, an exception throw locator for exception of
    * type <code>E</code> designates the parts between
    * <code>&lt;&gt;</code> in the following code.
    *
    * <pre>
    * [...]
    * &lt;throw&gt; new E();
    * [...]
    * throw new AnotherExceptionType();
    * [...]
    * </pre>
    *
    * @param exceptionType the type of the throwed exception */
   CodeLocator getThrowLocator(Class exceptionType);

   /**
    * Returns a exception catching locator in the current body.
    *
    * <p>For instance, an exception catch locator for exception of
    * type <code>E</code> designates the parts between
    * <code>&lt;&gt;</code> in the following code.
    *
    * <pre>
    * [...]
    * try {
    *   [...]
    * } catch(E e1) {
    *   &lt;[...]&gt;
    * } catch(AnotherExceptionType e2) { [...] };
    * [...]
    * </pre>
    *
    * @param exceptionType the type of the throwed exception */
   CodeLocator getCatchLocator(Class exceptionType);
   
}
