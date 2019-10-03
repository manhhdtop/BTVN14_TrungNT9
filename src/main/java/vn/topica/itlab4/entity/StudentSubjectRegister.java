package vn.topica.itlab4.entity;

public class StudentSubjectRegister
{
	private int id;
	private int studentId;
	private int subjectId;
	private Double score;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getSubjectId()
	{
		return subjectId;
	}
	
	public void setSubjectId(int subjectId)
	{
		this.subjectId = subjectId;
	}
	
	public int getStudentId()
	{
		return studentId;
	}
	
	public void setStudentId(int studentId)
	{
		this.studentId = studentId;
	}
	
	public Double getScore()
	{
		return score;
	}
	
	public void setScore(Double score)
	{
		this.score = score;
	}
	
	
	@Override
	public String toString()
	{
		return "StudentSubject[ID= " + id + "; StudentID=" + studentId
				+ "; SubjectID=" + subjectId + "; Score=" + score + "]";
	}
}
