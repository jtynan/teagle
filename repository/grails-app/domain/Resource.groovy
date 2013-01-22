/**
 * </copyright>
 *
 * 2008-2010 © Waterford Institute of Technology (WIT),
 *              TSSG, EU FP7 ICT Panlab.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * author: Shane Fox, Eamonn Power
 *
 * </copyright>
 *
 *  Resource is the base class of all testbed resources.
 */

class Resource {

    /**
     *  The name of the resource
     */
    String commonName

    /**
     *  A description of the resource.
     */
    String description

    

    static mapping = {
        tablePerHierarchy false
    }
    
    static constraints = {
        commonName(blank:false)

    }
}
