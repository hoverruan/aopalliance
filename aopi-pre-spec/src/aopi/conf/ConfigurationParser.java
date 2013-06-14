
package aopi.conf;

import aopi.core.Aspect;

/**
 * This interface represents an aspect configuration parser.
 */

public interface ConfigurationParser {

   /**
    * Parses the configuration descriptor for a given aspect. */
   void parse(Object configurationDescriptor,Aspect aspect);

}
