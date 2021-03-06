// Generated by Grails v1.2.1

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
 * Modified to load initial datasets.
 *
 */

import org.codehaus.groovy.grails.commons.GrailsApplication
import grails.util.GrailsUtil

class BootStrap {

     def fixtureLoader

     def init = { servletContext ->
        if (GrailsUtil.environment == GrailsApplication.ENV_DEVELOPMENT) {
                fixtureLoader.load("states")
                fixtureLoader.load("people")
                fixtureLoader.load("resources")
        }

        else if (GrailsUtil.environment == GrailsApplication.ENV_PRODUCTION){
            if (!Person.findByUserName("root")){
                fixtureLoader.load("states")
                fixtureLoader.load("people")
                fixtureLoader.load("resources")
            }
        }

        // Staging Repository
        else if ((GrailsUtil.environment != GrailsApplication.ENV_DEVELOPMENT) && (GrailsUtil.environment != GrailsApplication.ENV_PRODUCTION) && (GrailsUtil.environment != GrailsApplication.ENV_TEST)){
            fixtureLoader.load("dummy_user")
            fixtureLoader.load("states")
        }
     }
     def destroy = {
     }
}


