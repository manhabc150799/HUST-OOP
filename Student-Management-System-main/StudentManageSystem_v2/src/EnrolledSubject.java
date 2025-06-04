public class EnrolledSubject {

	public ClassSection classSection;

	public int studentId;
	
	public float midtermScore;

	public float finalScore;

	public EnrolledSubject(ClassSection classSection, int studentId, float midtermScore, float finalScore) {
		this.classSection = classSection;
		this.studentId = studentId;
		this.midtermScore = midtermScore;
		this.finalScore = finalScore;
	}

}
