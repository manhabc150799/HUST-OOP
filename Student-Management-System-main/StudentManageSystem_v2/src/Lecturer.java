import java.util.ArrayList;
import java.util.List;

public class Lecturer extends User implements ParticipateAcademic {

	private String lecturerId;

	private String department;

	private List<ClassSection> assignedClasses;
	private List<String> assignedClassIds = new ArrayList<>(); //them
	private List<Schedule> schedules;
	
	

	public Lecturer(String userId, String email, String password, String fullName, String role, boolean status, String dob,
			String lecturerId, String department) {
		super(userId, email, password, fullName, role, status, dob);
		this.lecturerId = lecturerId;
		this.department = department;
		this.assignedClasses = new ArrayList<ClassSection>();
	}

	public void enterScore() {
		
	}

	public void viewTeachingSchedule() {

	}

	//Getters and Setters
	
	public String getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(String lecturerId) {
		this.lecturerId = lecturerId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<ClassSection> getAssignedClasses() {
		return assignedClasses;
	}

	public void setAssignedClasses(List<ClassSection> assignedClasses) {
		this.assignedClasses = assignedClasses;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
	//Xem lich day
	@Override
    public void viewTimeTable() {
    System.out.println("Teaching Schedule:");
    if (schedules == null || schedules.isEmpty()) {
        System.out.println("No teaching schedule available.");
        return;
    }
    schedules.stream()
        .forEach(schedule -> System.out.println(
            "Day: " + schedule.dayOfWeek +
            ", Time: " + schedule.startTime + " - " + schedule.endTime +
            ", Room: " + schedule.room
        ));
}

@Override
//Xem danh sach sinh vien lop minh day
public void viewResult() {
    System.out.println("Student Results for Your Classes:");
    List<ClassSection> classes = getAssignedClasses();
    if (classes == null || classes.isEmpty()) {
        System.out.println("No assigned classes.");
        return;
    }
    for (ClassSection classSection : classes) {
        System.out.println("Class: " + classSection.toString());
        List<Student> students = classSection.enrolledStudents; // hoặc classSection.getEnrolledStudents() nếu có getter
        if (students == null || students.isEmpty()) {
            System.out.println("  No students in this class.");
            continue;
        }
        for (Student student : students) {
            System.out.println("  Student: " + student.getFullName() + " - ID: " + student.getStudentId());
        }
    }}
	

    public void addAssignedClass(String classSectionId ) {
    if (!assignedClassIds.contains(classSectionId)) {
        assignedClassIds.add(classSectionId);
     }
    }

    public void removeAssignedClass(String classSectionId) {
    assignedClassIds.remove(classSectionId);
    }

    public List<String> getAssignedClassIds() {
    return assignedClassIds;
    }

}
