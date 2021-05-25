package de.tekup.invoke.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.invoke.client.service.SoapClient;
import de.tekup.models.whitetest.models.StudentRequest;
import de.tekup.models.whitetest.models.WhiteTestResponse;

@Controller
public class whiteTestController {

	
	@Autowired
	private SoapClient client;
	
	
	@GetMapping("/check/test/")
	public String studentForm(Model model ) {
		StudentRequest request = new StudentRequest();
		model.addAttribute("request", request);
		return "request";
	}
	
	@PostMapping("/check/test/")
	public String webServiceResponse(@ModelAttribute ("request") StudentRequest request , Model model) {
		WhiteTestResponse response  = client.getTestStatus(request);
		model.addAttribute("response", response);
		return "response";
		
	}
}
