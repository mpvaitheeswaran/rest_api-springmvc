package com.vaitheeswaran.springrestapi.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vaitheeswaran.springrestapi.model.Student;

@Service
public class StudentService {
	private List<Student> students = createStudents();
	
	
	
//	public StudentRepository(List<Student> students) {
//		students = students;
//	}

	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}
	
	public Student getStudent(int rollNo) {
		Optional<Student> matchingObject = students.stream()
				.filter(s->s.getRollNo()==rollNo)
				.findFirst();
		Student student = matchingObject.get();
		return student;
	}
	
	public void updateStudent(Student student, int rollNo){
	      for(int i=0;i<students.size();i++){
	    	  Student s=students.get(i);
	         if(s.getRollNo()==rollNo) {
	        	 students.set(i, student);
	            break;
	         }
	      }
	   }

	public List<Student> getAllStudents(){
		return students;
	}
	
	public void deleteEmployee(int rollNo){
		students.removeIf(s->s.getRollNo()==rollNo);
	}
	
	private List<Student> createStudents(){
		List<Student> students = new ArrayList<>();
		Student s1 = new Student(101,"Vaitheeswaran","BCA",21);
		Student s2 = new Student(102,"RajKumar","BE",25);
		students.add(s1);
		students.add(s2);
		return students;
	}
}
