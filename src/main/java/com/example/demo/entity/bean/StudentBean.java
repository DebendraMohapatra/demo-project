package com.example.demo.entity.bean;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "build")
@Data
@NoArgsConstructor
public class StudentBean {
	
	private Integer id;
	
	@Size(min=3, message= "Length of the first name should be greater than three")
	@NotBlank(message = "First name Should not be empty")
	private String firstName;

	@Size(min=3, message= "Length of the last name should be greater than three")
	@NotBlank(message = "Last name Should not be empty")
	private String lastName;
	
	@NotBlank(message = "Date of Birth Should not be empty")
	private String dob;
	
	@Pattern(regexp = "(?:a|A|b|B|c|C)$", message = "Section should be A or B or C")
	private String section;
	
	@Pattern(regexp = "(?:m|M|f|F|)$", message = "Gender should be M or F")
	private String geneder; 
	
	@Min(0)
	@Max(100)
	@NotNull(message = "Mark1 must not be null")
	private Double marks1;
	
	@Min(0)
	@Max(100)
	@NotNull(message = "Mark2 must not be null")
	private Double marks2;
	
	@Min(0)
	@Max(100)
	@NotNull(message = "Mark3 must not be null")
	private Double marks3;
	
	private Double total;
	
	private Double average;
	
	private String result;
	



}
