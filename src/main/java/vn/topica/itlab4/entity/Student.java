package vn.topica.itlab4.entity;

public class Student
{
	private int studentId;
	private String studentName;
	private String studentMobile;
	private int classId;
	
	public int getStudentId()
	{
		return studentId;
	}
	
	public void setStudentId(int studentId)
	{
		this.studentId = studentId;
	}
	
	public String getStudentName()
	{
		return studentName;
	}
	
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	
	public String getStudentMobile()
	{
		return studentMobile;
	}
	
	public void setStudentMobile(String studentMobile)
	{
		this.studentMobile = studentMobile;
	}
	
	public int getClassId()
	{
		return classId;
	}
	
	public void setClassId(int classId)
	{
		this.classId = classId;
	}
	
	@Override
	public String toString()
	{
		return "Student[ID=" + studentId + ";Name='" + studentName
				+ "';Mobile='" + studentMobile + "';ClassID='" + classId + "']";
	}
}
