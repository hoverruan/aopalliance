
package aopi.weaving;

import aopi.core.Aspect;
import aopi.core.AspectElement;

/**
 * This interface represents a dynamic weaver for dynamic AOP.
 *
 * <p>In dynamic AOP, aspects can be removed or reconfigured at
 * runtime. */

public interface DynamicWeaver extends Weaver {

   /**
    * Unweaves a currently woven aspect. */
   void unweave(Aspect aspect);

   /**
    * Unweaves a currently applied aspect element.
    *
    * <p>This feature allows finer grained unweaving. */
   void unweave(AspectElement aspectElement);

   /**
    * Reloads a given aspect (its definition and/or configuration
    * might have changed since it has been last woven or reloaded). */
   void reload(Aspect aspect);

   /**
    * Reloads a given aspect element. */
   void reload(AspectElement aspectElement);

}
