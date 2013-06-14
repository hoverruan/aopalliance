
package org.aopalliance.instrument;

/**
 * The exception that is raised when the client program tries to undo
 * an instrumentation and when current implementation does not support
 * it.
 *
 * <p>Undoing is implemented by the {@link
 * Instrumentor#undo(Instrumentation)} method.
 *
 * @see Instrumentor */

public class UndoNotSupportedException extends Exception {
   
   /**
    * Sets a generic exception message for an instrumentation. */
   public UndoNotSupportedException(Instrumentation instrumentation) {
      super("Undo not supported for instrumentation: " + instrumentation);
   }
   
}

