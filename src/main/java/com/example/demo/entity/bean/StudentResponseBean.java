package com.example.demo.entity.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentResponseBean {
	
	private String message;
	
	private StudentBean studentBean;
	

}
