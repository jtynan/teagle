package de.tub.av.pe.xcapsrv.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.tub.av.pe.context.OpenPEContextManager;
import de.tub.av.pe.xcapsrv.DocumentSelector;
import de.tub.av.pe.xcapsrv.MethodNotAllowedException;
import de.tub.av.pe.xcapsrv.ParseException;
import de.tub.av.pe.xcapsrv.XCAPResult;
import de.tub.av.pe.xcapsrv.XCAPResultFactory;
import de.tub.av.pe.xcapsrv.XDMSConstants;
import de.tub.av.pe.xcapsrv.etag.ETagValidator;
import de.tub.av.pe.xcapsrv.etag.IfMatchETagValidator;
import de.tub.av.pe.xcapsrv.etag.IfNoneMatchETagValidator;


/**
 * The Class XCAPDispatchServlet is the main entry point to the user who want to work with XDMS.
 * This Servlet processes all incoming XCAP-Request messages to create, modify or delete entries in the XML-database.
 * The XCAP Dispatcher is the communication interface for XCAP. It receives XCAP requests from clients and forwards them to the corresponding XCAP Handler (e.g., GetHandler). 
 * At last, the XCAP Dispatcher sends the result, which is generated by the XCAP Handler, back to the client.
 */  

//extends HttpServlet 
public class XcapServlet extends HttpServlet{

	public static final String XcapRoot = "/openpe/xcap";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant log. */
	private static final Log log = LogFactory.getLog(XcapServlet.class);  

	/** The put handler. */
	private static PutHandler putHandler;

	/** The delete handler. */
	private static DeleteHandler deleteHandler;

	/** The get handler. */
	private static GetHandler getHandler;

	public void init(ServletConfig config) throws ServletException
	{
		OpenPEContextManager pecm = (OpenPEContextManager)config.getServletContext().getAttribute("PE_CONTEXT_MANAGER");
		putHandler = new PutHandler(pecm.getInstance());
		getHandler = new GetHandler(pecm.getInstance());
		deleteHandler = new DeleteHandler(pecm.getInstance());
		super.init(config);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setCharacterEncoding("UTF-8"); //setting character encoding to UTF-8 like specified in the xml response of XQuery Search
		PrintWriter responseWriter = response.getWriter();
		log.debug("doPost(request=" + request.toString() + ")");
		log.debug("Sorry, XCAP Server of PE is configured not to allow this funtionality.");
		// method not allowed, set right sc and allow header then send response
		response.setStatus(MethodNotAllowedException.RESPONSE_STATUS);
		response.setHeader(XDMSConstants.HEADER_ALLOW, "GET, PUT, DELETE");

		responseWriter.close();
	}

	/** 
	 * The doDelete handles all incoming HTTP-DELETE requests.
	 * 
	 * @see javax.servlet.http.HttpServlet#doDelete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse) 
	 */

	@Override
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.debug("doDelete(request=" + request.toString() + ")");

		PrintWriter responseWriter = response.getWriter();

		try {

			String mimetype = parsePrimaryType(request.getContentType());
			//parse the uri - the documentSelector contains from now on all necessary informations of the request
			DocumentSelector documentSelector = new DocumentSelector(processURIPrefix(request.getRequestURI()), request.getQueryString());

			XCAPResult result = deleteHandler.process(documentSelector, mimetype, null, null);

			// set response status
			response.setStatus(result.getStatusCode());
			// set response entity tag if provided
			if(result.getMimeType()!=null){
				response.setContentType(result.getMimeType());
			}
			// add response content
			for (Iterator<String> iterator = result.getHeaders().keySet().iterator(); iterator.hasNext();) {
				String header = (String)iterator.next();
				response.setHeader(header,result.getHeaders().get(header));
			}
			// add response body
			if(result.getBody()!=null){
				responseWriter.println(result.getBody());
			}

		} catch (ParseException e) {
			// invalid resource selector
			if(request.getQueryString() != null && !request.getQueryString().equals("")){
				log.error("Invalid resorceSelector: " + request.getRequestURI() + "?" + request.getQueryString());
			}
			else log.error("Invalid resorceSelector: " + request.getRequestURI());
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

		log.debug("doDelete(response="+response.toString()+")");

		// send to client
		responseWriter.close();
	}

	/**
	 * The doGet handles all incoming HTTP-GET requests.
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.debug("doGet(request=" + request.toString() + ")");

		response.setCharacterEncoding("UTF-8"); //setting character encoding to UTF-8
		PrintWriter responseWriter = response.getWriter();

		

		try {
			//parse the uri - the documentSelector contains from now on all necessary informations of the request
			DocumentSelector documentSelector = new DocumentSelector(processURIPrefix(request.getRequestURI()), request.getQueryString());

			String mimetype = parsePrimaryType(request.getContentType()); 
			
			XCAPResult result = getHandler.process(documentSelector, mimetype, null, null);

			response.setStatus(result.getStatusCode());

				// set response content type
				if(result.getMimeType()!=null){
					response.setContentType(result.getMimeType());
				}
				// add response content
				for (Iterator<String> iterator = result.getHeaders().keySet().iterator(); iterator.hasNext();) {
					String header = (String)iterator.next();
					response.setHeader(header,result.getHeaders().get(header));
				}
				if(result.getBody()!=null){
					responseWriter.println(result.getBody());
				}
			log.debug("doGet(response="+response.toString()+")");
			log.debug("doGet(response body="+result.getBody());

		} catch (ParseException e) {
			// invalid resource selector
			if(request.getQueryString() != null && !request.getQueryString().equals("")){
				log.error("Invalid resorceSelector: " + request.getRequestURI() + "?" + request.getQueryString());
			}
			else log.error("Invalid resorceSelector: " + request.getRequestURI());
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

		// send to client
		responseWriter.close();

	}

	/**
	 * The doPut handles all incoming HTTP-PUT requests.
	 * 
	 *  @see javax.servlet.http.HttpServlet#doPut(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */

	@Override
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.debug("doPut(request=" + request.toString() + ")");

		ETagValidator eTagValidator = createETagValidator(request);

		PrintWriter responseWriter = response.getWriter();

		XCAPResult result = null;

		try {
			String mimetype = parsePrimaryType(request.getContentType());

			//parse the uri - the documentSelector contains from now on all necessary informations of the request
			DocumentSelector documentSelector = new DocumentSelector(processURIPrefix(request.getRequestURI()), request.getQueryString());

			result = putHandler.process(documentSelector, mimetype, request.getInputStream(), eTagValidator);           

			// set response status
			response.setStatus(result.getStatusCode());

			// set headers contained in the XCAPResult into the Response
			String header, value;
			for (Iterator<String> iterator = result.getHeaders().keySet().iterator(); iterator.hasNext();) {
				header = (String)iterator.next();
				value = result.getHeaders().get(header);
				response.setHeader(header,value);
			}
			if(result.getBody()!=null){
				responseWriter.println(result.getBody());
			}

			log.debug("doPut(response="+response.toString()+")");
			log.debug("doPut(response body="+result.getBody());
			
			
		} catch (ParseException e) {
			// invalid resource selector
			if(request.getQueryString() != null && !request.getQueryString().equals("")){
				log.error("Invalid resorceSelector: " + request.getRequestURI() + "?" + request.getQueryString());
			}
			else log.error("Invalid resorceSelector: " + request.getRequestURI());
			result = XCAPResultFactory.newResultForOtherError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
			result = XCAPResultFactory.newResultForOtherError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		} 	

		// send to client
		responseWriter.close();
	}

	/**
	 * Parses the primary type.
	 * Example: parameter contentType is "application/resource-lists+xml;charset=UTF-8
	 * this method should return the primary content type, namely "application/resource-lists+xml" .
	 * 
	 * @param contentType the content type
	 * 
	 * @return the string
	 */

	private String parsePrimaryType(String contentType) {
		String result = null;
		if (contentType != null) {
			if (contentType.contains(";")) {
				String[] array = contentType.split(";");
				result = array[0];
			} else {
				//robin: if there is no ; in contentType, the whole one has to be returned
				result = contentType;
			}
		}
		return result;
	}


	/**
	 * Process uri prefix. If system is being tested with the Seagull, the requestURI starts with /xdms.
	 * e.g. /xdms/resource-lists/users/sip:bob@open-ims.org/index.xml. The goal of this method is to remove the prefix of the requestURI
	 * 
	 * @param requestURI the request uri
	 * 
	 * @return the string
	 */

	private String processURIPrefix(String requestURI){
		String result = requestURI;
		String root = XcapRoot;
		if(requestURI.startsWith(root)){
			result = requestURI.substring(root.length());
		}         
		return result;
	}
	
	  private ETagValidator createETagValidator(HttpServletRequest request) {
	        ETagValidator eTagValidator = null;
	        String eTag = request.getHeader(XDMSConstants.HEADER_IF_MATCH);
	        if (eTag != null) {
	            eTagValidator = new IfMatchETagValidator(eTag);
	        } else {
	            eTag = request.getHeader(XDMSConstants.HEADER_IF_NONE_MATCH);
	            if (eTag != null) {
	                eTagValidator = new IfNoneMatchETagValidator(eTag);
	            }
	        }
	        return eTagValidator;
	    }
}