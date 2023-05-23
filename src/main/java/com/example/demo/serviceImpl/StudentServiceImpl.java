package com.example.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Student;
import com.example.demo.entity.bean.StudentBean;
import com.example.demo.entity.bean.StudentResponseBean;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository repository;
	
	@Override
	public Student save(StudentBean bean) {
		
		double total = 0f + bean.getMarks1() + bean.getMarks2() + bean.getMarks3();
		Double average = total/(float)3;
		String result = "fail";
		Integer passMark = 34;
		if(bean.getMarks1() > passMark && bean.getMarks2() > passMark && bean.getMarks3() > passMark) {
			result = "pass";
		}
		bean.setTotal(total);
		bean.setAverage(average);
		bean.setResult(result);
		
		Student student = Student.build(0, bean.getFirstName(), bean.getLastName(), bean.getDob()
							, bean.getSection(), bean.getGeneder(),bean.getMarks1(), 
							bean.getMarks2(), bean.getMarks3(),bean.getTotal(),bean.getAverage(), bean.getResult());
		
		return repository.save(student);
	}

	@Override
	public StudentResponseBean update(Integer id, StudentBean bean) {
		StudentResponseBean responseBean = new StudentResponseBean();
		double total = 0f + bean.getMarks1() + bean.getMarks2() + bean.getMarks3();
		Double average = total/(float)3;
		String result = "fail";
		Integer passMark = 34;
		if(bean.getMarks1() > passMark && bean.getMarks2() > passMark && bean.getMarks3() > passMark) {
			result = "pass";
		}
		
		Optional<Student> optionalStudent = repository.findById(id);
		if(optionalStudent.isPresent()) {
			bean.setTotal(total);
			bean.setAverage(average);
			bean.setResult(result);
			Student student = optionalStudent.get();
			student.setMarks1(bean.getMarks1());
			student.setMarks2(bean.getMarks2());
			student.setMarks3(bean.getMarks3());
			student.setTotal(total);
			student.setAverage(average);
			student.setResult(result);
			responseBean.setMessage("Udated Successfully");
		}else {
			responseBean.setMessage("Not Udated Successfully");
		}
		responseBean.setStudentBean(bean);
		
		return responseBean;
	}

}
