public class EnrolledFixedSubject extends EnrolledSubject {

	public FixedSubject subject;

	public int academicYear;

	public double examScore;

	public String status;
	
	

	public EnrolledFixedSubject(ClassSection classSection, int studentId, FixedSubject subject, int academicYear,
			double examScore, String status) {
		super(classSection, studentId); 
		this.subject = subject;
		this.academicYear = academicYear;
		this.examScore = examScore;
		this.status = status;
	}
	
	public boolean isPassed() {
		return examScore > 5;
	}
	public float calculateTotalScore() {
        return Math.round(examScore * 10) / 10.0f; // Làm tròn đến số thập phân thứ nhất
    }
	
	public String toString() {
		return "EnrolledFixedSubject{" +
	            "subject=" + subject.subjectName +
	            ", academicYear='" + academicYear + '\'' +
	            ", examScore=" + examScore +
	            ", status='" + (isPassed() ? "Passed" : "Failed") + '\'' +
	            '}';
	}
	
}
