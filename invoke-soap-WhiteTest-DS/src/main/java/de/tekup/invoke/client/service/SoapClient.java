package de.tekup.invoke.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import de.tekup.models.whitetest.models.ExamsDisponibleResponse;
import de.tekup.models.whitetest.models.ExamsRequest;
import de.tekup.models.whitetest.models.StudentRequest;
import de.tekup.models.whitetest.models.WhiteTestResponse;

@Service
public class SoapClient {
	
	private WebServiceTemplate template;
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	public WhiteTestResponse getTestStatus(StudentRequest request) {
		template = new WebServiceTemplate(marshaller);
		WhiteTestResponse response = (WhiteTestResponse) template.marshalSendAndReceive("http://localhost:8080/ws",request);
		return response;
	}
	
	public ExamsDisponibleResponse getExams(ExamsRequest examreq) {
		template = new WebServiceTemplate(marshaller);
		ExamsDisponibleResponse response = (ExamsDisponibleResponse) template.marshalSendAndReceive("http://localhost:8080/ws", examreq);
		return response;
	}
	
	
	
	
	
	
	
}
