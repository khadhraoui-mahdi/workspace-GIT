package de.tekup.invoke.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.invoke.client.service.SoapClient;
import de.tekup.models.whitetest.models.ExamsDisponibleResponse;
import de.tekup.models.whitetest.models.ExamsRequest;
import de.tekup.models.whitetest.models.StudentRequest;
import de.tekup.models.whitetest.models.WhiteTestResponse;

@Controller
public class ExamsController {
	
	@Autowired
	private SoapClient client;

	@GetMapping("/Exams")
	public String studentForm(Model model ) {
		ExamsRequest requestexams = new ExamsRequest();
		model.addAttribute("requestexams", requestexams);
		return "request-exams";
	}

	
	@PostMapping("/Exams")
	public String webServiceResponse(@ModelAttribute ("requestexams") ExamsRequest requestexams , Model model) {
		ExamsDisponibleResponse responseexam  = client.getExams(requestexams);
		model.addAttribute("responseexam", responseexam);
		return "response-exams";
		
	}

}