package com.burak.studentmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student extends User {
	
	
	public Student() {
		
	}

	public Student(int id, String userName, String password, String firstName, String lastName, String email,
			 Role role, List<Course> courses) {
		super(id, userName, password, firstName, lastName, email, role, courses);
	}


	    public boolean equals(Object comparedObject) {
	    if (this == comparedObject) {
	        return true;
	    }

	    if (!(comparedObject instanceof Student)) {
	        return false;
	    }
		//da hinh down coasting
	    User comparedStudent = (Student) comparedObject;

	    if ( this.getId()== comparedStudent.getId()) {
	        return true;
	    }

	    return false;
	}
	public void checkCourse(Course course) {
		if (course == null) {
			throw new IllegalArgumentException("Course cannot be null");
		}
		if (getCourses() == null) {
			setCourses(new ArrayList<>());
		}
		if (!getCourses().contains(course)) {
			getCourses().add(course);
			course.getStudents().add(this);
		}
	}
	
	
}
