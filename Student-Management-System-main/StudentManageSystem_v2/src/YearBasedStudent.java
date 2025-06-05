import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class YearBasedStudent extends Student implements ParticipateAcademic {

	private List<EnrolledFixedSubject> EnrolledFixedSubjects;
    private List<String> enrolledClassIds = new ArrayList<>();
	
	public YearBasedStudent(String userId, String email, String password, String fullName, String role, boolean status, String dob,
			String studentId, String major) {
		super(userId, email, password, fullName, role, status, dob, studentId, major);
		EnrolledFixedSubjects = new ArrayList<EnrolledFixedSubject>();
	}


	public String toString() {
		int completedCourse = EnrolledFixedSubjects.stream()
                .filter(EnrolledFixedSubject::isPassed)
                .mapToInt(subject -> subject.subject.creditHours)
                .sum();
        double cpa = calculateCPA();
        return String.format("%s - %s - YearBasedStudent - Completed Course: %d - CPA: %.2f",
                getFullName(), this.studentId, completedCourse, cpa);
	}

	@Override
	public void viewResult() {
		System.out.println("Choose an option:");
        System.out.println("1. View Personal Transcript");
        System.out.println("2. View Completed Subjects");

        int choice = InputUtil.getInt("Enter your choice: ");

        if (choice == 1) {
            System.out.println("Personal Transcript:");
           EnrolledFixedSubjects.stream()
                    .sorted(Comparator.comparingInt(subject -> subject.academicYear))
                    .forEach(System.out::println);
        } else if (choice == 2) {
            System.out.println("Completed Subjects:");
            EnrolledFixedSubjects.stream()
                    .filter(EnrolledFixedSubject::isPassed)
                    .forEach(System.out::println);
        } else {
            System.out.println("Invalid choice.");
        }
		
	}
	@Override
	public void viewTimeTable() {
			System.out.println("Current Semester Timetable:");
        EnrolledFixedSubjects.stream()
                .filter(subject -> subject.academicYear == getCurrentAcademicYear())
                .forEach(subject -> System.out.println(subject.classSection));
	}
	@Override
	public double calculateCPA() {
    float totalScore = 0.0f;
    int passedSubjects = 0;
    for (EnrolledFixedSubject subject : EnrolledFixedSubjects) {
        if (subject.isPassed()) {
            totalScore += subject.calculateTotalScore();
            passedSubjects++;
        }
    }
    if (passedSubjects == 0) return 0.0;
    return ((totalScore / passedSubjects)*4)/10; //chuyen ve he 4
}

	@Override
	public boolean checkGraduationRequirements() {
		int totalSubject = EnrolledFixedSubjects.stream()
                .filter(EnrolledFixedSubject::isPassed)
                .mapToInt(subject -> subject.subject.creditHours)
                .sum();

        boolean hasNoFailedSubject = EnrolledFixedSubjects.stream()
                .noneMatch(subject -> subject.status.equals("failed"));

        double cpa = calculateCPA();

        return totalSubject >= 132 && hasNoFailedSubject && cpa >= 4.0;
	}

	

	@Override
	public boolean enrollClassSection() {
		return false;
	}
	

	public List<EnrolledFixedSubject> getEnrolledFixedSubjects() {
		return EnrolledFixedSubjects;
	}

	public void setEnrolledFixedSubjects(List<EnrolledFixedSubject> enrolledFixedSubjects) {
		EnrolledFixedSubjects = enrolledFixedSubjects;
	}
    public void removeEnrolledClass(String classSectionId) {
    enrolledClassIds.remove(classSectionId);
    }
	private int getCurrentAcademicYear() {
        int CurrentAcademicYear = EnrolledFixedSubjects.stream()
            .mapToInt(subject -> subject.academicYear)
            .max()
            .orElse(0);
		return CurrentAcademicYear;		
	}
}