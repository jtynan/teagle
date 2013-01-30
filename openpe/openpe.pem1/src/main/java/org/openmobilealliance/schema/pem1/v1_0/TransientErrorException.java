
package org.openmobilealliance.schema.pem1.v1_0;

import javax.xml.ws.WebFault;
import org.openmobilealliance.wsdl.pem1.v1_0.faults.ServiceExceptionType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "serviceException", targetNamespace = "http://www.openmobilealliance.org/wsdl/PEM1/v1_0/faults")
public class TransientErrorException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ServiceExceptionType faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public TransientErrorException(String message, ServiceExceptionType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public TransientErrorException(String message, ServiceExceptionType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.openmobilealliance.wsdl.pem1.v1_0.faults.ServiceExceptionType
     */
    public ServiceExceptionType getFaultInfo() {
        return faultInfo;
    }

}
