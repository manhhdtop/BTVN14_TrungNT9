package vn.topica.itlab4.entity;

public class School
{
	private String schoolName;
	private int schoolId;
	private String schoolDesc;
	
	public String getSchoolName()
	{
		return schoolName;
	}
	
	public void setSchoolName(String schoolName)
	{
		this.schoolName = schoolName;
	}
	
	public int getSchoolId()
	{
		return schoolId;
	}
	
	public void setSchoolId(int schoolId)
	{
		this.schoolId = schoolId;
	}
	
	public String getSchoolDesc()
	{
		return schoolDesc;
	}
	
	public void setSchoolDesc(String schoolDesc)
	{
		this.schoolDesc = schoolDesc;
	}
	
	@Override
	public String toString()
	{
		return "School[ID=" + schoolId + "; Name='" + schoolName
				+ "'; Description='" + schoolDesc + "']";
	}
}
