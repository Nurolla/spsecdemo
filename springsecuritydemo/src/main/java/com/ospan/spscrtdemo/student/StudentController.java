package com.ospan.spscrtdemo.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {	
	private static final List<Student> STUDENTS = Arrays.asList(
			new Student(1,"James Bone"),
			new Student(2,"Maria Jones"),
			new Student(3,"Anna Smith"));

	@GetMapping(path="{studentId}")
	public Student getStudent(@PathVariable("studentId")Integer StudentId) {
		return STUDENTS.stream()
				.filter(student->StudentId.equals(student.getStudentId()))
				.findFirst()
				.orElseThrow(()->new IllegalStateException("Student"+StudentId+" does not exist"));

	}

}
