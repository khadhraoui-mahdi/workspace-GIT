package de.tekup.whitetest.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.models.whitetest.models.Exam;
import de.tekup.models.whitetest.models.ExamsDisponibleResponse;
import de.tekup.models.whitetest.models.ExamsRequest;
import de.tekup.whitetest.Repository.ExamRepository;
import de.tekup.whitetest.Repository.StudentRepository;


@Service
public class ExamsService {
	private StudentRepository StudentRepository;
	private ExamRepository examRepository;
	
	
	 @Autowired
	    public ExamsService(StudentRepository StudentRepository , ExamRepository ExamRepository) {
	        this.StudentRepository = StudentRepository;
	        this.examRepository= ExamRepository;
	    } 
	 
	 
	 public ExamsDisponibleResponse getAllExams(ExamsRequest request){
		 ExamsDisponibleResponse response = new ExamsDisponibleResponse();
	    	 List<Exam> exams = examRepository.findAllExams();
	    	 
	    	 System.err.println("exams :"+exams);
	    	 List<Exam> exam = response.getExams();

	    	 for(Exam e : exams) {
	    		 exam.add(e);
	    		 
	    	 }
	    	  response.setNumber(request.getNumber());
	             return response;
	     }

}
