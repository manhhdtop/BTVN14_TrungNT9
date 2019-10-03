package vn.topica.itlab4.entity;

public class ClassOfSchool
{
	private int classId;
	private String classCode;
	private String classDesc;
	private int schoolId;
	
	public int getClassId()
	{
		return classId;
	}
	
	public void setClassId(int classId)
	{
		this.classId = classId;
	}
	
	public String getClassCode()
	{
		return classCode;
	}
	
	public void setClassCode(String classCode)
	{
		this.classCode = classCode;
	}
	
	public String getClassDesc()
	{
		return classDesc;
	}
	
	public void setClassDesc(String classDesc)
	{
		this.classDesc = classDesc;
	}
	
	public int getSchoolId()
	{
		return schoolId;
	}
	
	public void setSchoolId(int schoolId)
	{
		this.schoolId = schoolId;
	}
	
	@Override
	public String toString()
	{
		return "Class[ID=" + classId + ";Code='" + classCode + "';SchoolID=" + schoolId + "]";
	}
}
