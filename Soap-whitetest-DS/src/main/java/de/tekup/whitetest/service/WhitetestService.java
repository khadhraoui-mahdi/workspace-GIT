package de.tekup.whitetest.service;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.models.whitetest.models.Exam;
import de.tekup.models.whitetest.models.Student;
import de.tekup.models.whitetest.models.StudentRequest;
import de.tekup.models.whitetest.models.WhiteTestResponse;
import de.tekup.whitetest.Repository.ExamRepository;
import de.tekup.whitetest.Repository.StudentRepository;

@Service
public class WhitetestService {
	private StudentRepository StudentRepository;
	private ExamRepository examRepository;
	
    @Autowired
    public WhitetestService(StudentRepository StudentRepository , ExamRepository ExamRepository) {
        this.StudentRepository = StudentRepository;
        this.examRepository= ExamRepository;
    }
	
	public WhiteTestResponse getWhiteTest(StudentRequest studentReq) throws DatatypeConfigurationException {

			WhiteTestResponse response = new WhiteTestResponse();
		List<String> badrequests = response.getBadRequests(); 
		Student student  = StudentRepository.findStudent(studentReq.getStudentId());
		Exam exam = examRepository.findExam(studentReq.getExamCode());
        if((student == null)  || (exam ==null)){
        if(student == null) 
        	badrequests.add("Wrong student id");
        if(exam == null)
        	badrequests.add("wrong exam code");
        	
        //return response;
        	
        }else {
        	response.setStudent(student);
        	
            response.setExam(exam);	
            
         	
            GregorianCalendar gr = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gr.add(gr.DAY_OF_MONTH, 7);
            XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gr);

    		response.setDate(cal);
           
        }
        return response;
	}

  

}

