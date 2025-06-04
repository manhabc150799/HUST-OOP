package com.burak.studentmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher extends User implements Grading {
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role_id")
	private Role role;
	
	@OneToMany(mappedBy="teacher", fetch=FetchType.EAGER)
	private List<Course> courses;

	public Teacher(int id, String userName, String password, String firstName, String lastName, String email, Role role,
			List<Course> courses) {
		
		super(id, userName, password, firstName, lastName, email, role, courses);
	}

	@Override
	//nhap diem cho sinh vien
	public void enterGrade(GradeDetails gradeDetails, Integer gradeOne, Integer gradeTwo, Integer gradeThree) {
        if (gradeDetails != null) {
            gradeDetails.setGradeOne(gradeOne);
            gradeDetails.setGradeTwo(gradeTwo);
            gradeDetails.setGradeThree(gradeThree);
        }
	}
	
	public void checkCourse(Course course) {
		if (course == null) {
			throw new IllegalArgumentException("Course cannot be null");
		}
		if (courses == null) {
			courses = new ArrayList<>();
		}
		if (!courses.contains(course)) {
			courses.add(course);
			course.setTeacher(this);
		}
	}

    


}
