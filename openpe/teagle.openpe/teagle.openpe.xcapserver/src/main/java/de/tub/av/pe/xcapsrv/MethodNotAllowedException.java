/*
 * Copyright (C) 2009 FhG FOKUS, Institute for Open Communication Systems
 *
 * This file is part of the FOKUS XDMS - an XML Document Management Server
 * 
 * The FOKUS XDMS is proprietary software that is licensed
 * under the FhG FOKUS "SOURCE CODE LICENSE for FOKUS Open IMS COMPONENTS".
 * You should have received a copy of the license along with this 
 * program; if not, write to Fraunhofer Institute FOKUS, Kaiserin-
 * Augusta Allee 31, 10589 Berlin, GERMANY 
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * It has to be noted that this software is not intended to become 
 * or act as a product in a commercial context! It is a PROTOTYPE
 * IMPLEMENTATION for IMS technology testing and IMS application 
 * development for research purposes, typically performed in IMS 
 * test-beds. See the attached license for more details. 
 *
 * For a license to use this software under conditions
 * other than those described here, please contact Fraunhofer FOKUS 
 * via e-mail at the following address:
 *     info@open-ims.org
 *
 */

package de.tub.av.pe.xcapsrv;

import java.util.Map;

public class MethodNotAllowedException extends RequestException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final int RESPONSE_STATUS = 405;
    private Map<String, String> responseHeaders = null;

    public MethodNotAllowedException(Map<String, String> responseHeaders) {
        if (responseHeaders == null) {
            throw new IllegalArgumentException("responseHeaders can't be null");
        }
        this.responseHeaders = responseHeaders;
    }

    public int getResponseStatus() {
        return RESPONSE_STATUS;
    }

    public String getResponseContent() {
        return null;
    }

    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }
}
