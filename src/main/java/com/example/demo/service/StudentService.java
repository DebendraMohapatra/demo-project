package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.bean.StudentBean;
import com.example.demo.entity.bean.StudentResponseBean;

public interface StudentService {

	public Student save(StudentBean bean);

	public StudentResponseBean update(Integer id, StudentBean bean);
}
