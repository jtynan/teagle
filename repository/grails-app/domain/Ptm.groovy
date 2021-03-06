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
 *  A Ptm or Panlab Testbed Manager is a software component that is deployed in the Panlab partner's
 *  testbed to provide access to and management of their resources within the panlabs network.
 */

class Ptm extends ManagementApplication{

    String url
    String legacyUrl

    Organisation provider

    static hasMany = [
    	resourceSpecs: ResourceSpec,
	supportedResources: ResourceSpec
       ]

    static constraints = {
    	legacyUrl(nullable:true)
    }
}
