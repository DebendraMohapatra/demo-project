package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.entity.bean.StudentBean;
import com.example.demo.entity.bean.StudentResponseBean;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<Student> save(@Valid @RequestBody StudentBean bean) {
		
		Student student = studentService.save(bean);
		
		return ResponseEntity.ok(student);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<StudentResponseBean> update(@PathVariable(required = true) Integer id,@RequestBody StudentBean bean) {
		
		StudentResponseBean student = studentService.update(id,bean);
		
		return ResponseEntity.ok(student);
	}

}
