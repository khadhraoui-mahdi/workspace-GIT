package de.tekup.whitetest.endpoint;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.models.whitetest.models.StudentRequest;
import de.tekup.models.whitetest.models.WhiteTestResponse;
import de.tekup.whitetest.service.WhitetestService;


@Endpoint
public class WhitetestEndPoint {
	
	public static final String nameSpace="http://www.tekup.de/whitetest";
	@Autowired
	WhitetestService service;
	
	@PayloadRoot(namespace = nameSpace, localPart = "StudentRequest")
	@ResponsePayload
	public WhiteTestResponse getWhiteTest(@RequestPayload StudentRequest customerRequest) throws DatatypeConfigurationException {
		return service.getWhiteTest(customerRequest);
	}
	
 
}
