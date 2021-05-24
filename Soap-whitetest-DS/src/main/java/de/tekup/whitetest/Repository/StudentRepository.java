package de.tekup.whitetest.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import de.tekup.models.whitetest.models.Adress;
import de.tekup.models.whitetest.models.Student;

@Component
public class StudentRepository {
	
	private static final Map<Integer, Student> students = new HashMap<>();
	
	@PostConstruct
    public void initData() {
         
        Student student = new Student();
        Adress adress = new Adress();
        student.setId(1);
        student.setName("Amine");
        adress.setCity("Ariana");
        adress.setPosteCode("2000");
        adress.setStreet("Rue x");
        student.setAddress(adress);
        students.put(student.getId(), student);
         
        student = new Student();
        Adress adress2 = new Adress();
        student.setId(2);
        student.setName("Ghribi");
        adress2.setCity("tunis");
        adress2.setPosteCode("3000");
        adress2.setStreet("rue");
        student.setAddress(adress2);
        
        students.put(student.getId(), student);
         
        student = new Student();
        Adress adress3 =new Adress();
        student.setId(3);
        student.setName("Mohamed");
        adress3.setCity("gabes");
        adress3.setPosteCode("6000");
        adress3.setStreet("rue3");
        student.setAddress(adress3);
        
        students.put(student.getId(), student);
         
        student = new Student();
        Adress adress4 = new Adress();
        student.setId(4);
        student.setName("Ilyes");
        adress4.setCity("sfax");
        adress4.setPosteCode("4000");
        adress4.setStreet("street");
        student.setAddress(adress4);
        students.put(student.getId(), student);
    }
 
	
	  public Student findStudent(int id) {
	   //     Assert.notNull(id, "The Student's must not be null");
	        return students.get(id);
	    }
	  
	  public List<Student> findAllStudents(){
		 List<Student> Students = new ArrayList(students.values());
		 return Students  ;
      }
	  
	  
	  
	  
  /*  public Student findStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        return students.get(name);
    }
	*/
	
	
	
}
