package de.tekup.whitetest.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import de.tekup.models.whitetest.models.Exam;
import de.tekup.models.whitetest.models.Student;

@Component
public class ExamRepository {
	
	private static final Map<String, Exam> exams = new HashMap<>();

	@PostConstruct
    public void initData() {
		
		Exam exam = new Exam();
		exam.setCode("1Z0-808");
		exam.setName("OCA Java");
		exams.put(exam.getCode(), exam);
		
		
		exam = new Exam();
		exam.setCode("1Z0-813");
		exam.setName("OCP Java");
		exams.put(exam.getCode(), exam);
        
		exam = new Exam();
		exam.setCode("N°97085");
		exam.setName("AWS Solutions Architect");
		
		exams.put(exam.getCode(), exam);
		
	}

	public Exam findExam(String code) {
        Assert.notNull(code, "The Student's must not be null");
        return exams.get(code);
    }
	
	public List<Exam> findAllExams() {
	  List<Exam> Exams = new ArrayList(exams.values());
	  return Exams; 
	}

}
