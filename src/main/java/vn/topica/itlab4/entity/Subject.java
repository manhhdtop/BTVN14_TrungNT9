package vn.topica.itlab4.entity;

public class Subject
{
	
	private String subjectName;
	private int subjectId;
	private String subjectDesc;
	private SubjectDomain domain;
	
	public String getSubjectName()
	{
		return subjectName;
	}
	
	public void setSubjectName(String subjectName)
	{
		this.subjectName = subjectName;
	}
	
	public int getSubjectId()
	{
		return subjectId;
	}
	
	public void setSubjectId(int subjectId)
	{
		this.subjectId = subjectId;
	}
	
	public String getSubjectDesc()
	{
		return subjectDesc;
	}
	
	public void setSubjectDesc(String subjectDesc)
	{
		this.subjectDesc = subjectDesc;
	}
	
	public SubjectDomain getDomain()
	{
		return domain;
	}
	
	public void setDomain(SubjectDomain domain)
	{
		this.domain = domain;
	}
	
	@Override
	public String toString()
	{
		return "Subject[ID=" + subjectId + ";Name='"
				+ subjectName + "';Domain='" + domain + "']";
	}
}
