package com.vaitheeswaran.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vaitheeswaran.springrestapi.model.Student;
import com.vaitheeswaran.springrestapi.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/students")
	public List<Student> getStudents(){
		return studentService.getAllStudents();
	}
	
	@RequestMapping("/students/{id}")
	   public Student getStudent(@PathVariable("id") int id){
	      return studentService.getStudent(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/students")
	 public void addEmployee(@RequestBody Student newStudent){
		studentService.addStudent(newStudent);
	 }
	
	@RequestMapping(method = RequestMethod.PUT,value="/students/{id}")
	public void updateEmployee(@RequestBody Student student, @PathVariable int id){
		studentService.updateStudent(student, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/students/{id}")
	public void deleteEmployee(@PathVariable int id){
		studentService.deleteEmployee(id);
	}
	   
}
