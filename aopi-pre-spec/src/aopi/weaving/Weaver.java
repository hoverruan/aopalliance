
package aopi.weaving;

import aopi.core.Aspect;
import aopi.core.WeavingRule;

/**
 * This interface represents a weaver in an AO system.
 *
 * <p>A weaver is the sofware component which is responsible for
 * taking all the aspects and composing then to the base program. To
 * be AOPI-compliant, this weaver should use the
 * <code>aopi.modif.ProgramModifier</code> interface.
 *
 * @see aopi.modif.ProgramModifier  */

public interface Weaver {

   /**
    * Weaves a given aspect to the program. */
   void weave(Aspect aspect);   
   
   /**
    * Get all the aspects handled by this weaver. */
   Aspect getAspects();

   /**
    * Returns the list of all the global weaving rules.
    *
    * <p>This has to be further investigated and specified. */ 
   WeavingRule[] getWeavingRules();
}

