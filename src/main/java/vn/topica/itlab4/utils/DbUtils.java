package vn.topica.itlab4.utils;

import vn.topica.itlab4.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class has some method to process data in database
 */
public class DbUtils
{
	private static String sql;
	private static PreparedStatement pstm;
	private static Connection c;
	private static ResultSet rs;
	
	/**
	 * Map field of School from ResultSet to Object School
	 *
	 * @param rs is ResultSet
	 * @return object School get from @param rs
	 */
	private static School mappingSchool(ResultSet rs)
	{
		School s = new School();
		try
		{
			s.setSchoolId(rs.getInt(JdbcConstant.COLUMN_SCHOOL_ID));
			s.setSchoolName(rs.getString(JdbcConstant.COLUMN_SCHOOL_NAME));
			s.setSchoolDesc(rs.getString(JdbcConstant.COLUMN_SCHOOL_DESCRIPTION));
		}
		catch (SQLException e)
		{
			return null;
		}
		return s;
	}
	
	/**
	 * Get list School from database
	 *
	 * @return list School
	 * @throws SQLException while handle
	 */
	public static List<School> getListSchool() throws SQLException
	{
		sql = JdbcConstant.SELECT_ALL_SCHOOL;
		List<School> schools = new ArrayList<>();
		School s;
		c = ConnectionUtil.getConnection();
		pstm = c.prepareStatement(sql);
		rs = pstm.executeQuery();
		while (rs.next())
		{
			s = mappingSchool(rs);
			if (s != null)
			{
				schools.add(s);
			}
		}
		pstm.close();
		rs.close();
		c.close();
		return schools;
	}
	
	/**
	 * Map field of ClassOfSchool from ResultSet to Object ClassOfSchool
	 *
	 * @param rs is ResultSet
	 * @return object ClassOfSchool
	 */
	private static ClassOfSchool mappingClass(ResultSet rs)
	{
		ClassOfSchool c = new ClassOfSchool();
		try
		{
			c.setClassId(rs.getInt(JdbcConstant.COLUMN_CLASS_ID));
			c.setClassCode(rs.getString(JdbcConstant.COLUMN_CLASS_CODE));
			c.setClassDesc(rs.getString(JdbcConstant.COLUMN_CLASS_DESCRIPTION));
			c.setSchoolId(rs.getInt(JdbcConstant.COLUMN_CLASS_SCHOOL_ID));
		}
		catch (SQLException e)
		{
			return null;
		}
		return c;
	}
	
	/**
	 * Get list ClassOfSchool from database
	 *
	 * @return list ClassOfSchool
	 * @throws SQLException while handle
	 */
	public static List<ClassOfSchool> getListClass() throws SQLException
	{
		sql = JdbcConstant.SELECT_ALL_CLASS;
		List<ClassOfSchool> classes = new ArrayList<>();
		ClassOfSchool clazz;
		c = ConnectionUtil.getConnection();
		pstm = c.prepareStatement(sql);
		rs = pstm.executeQuery();
		while (rs.next())
		{
			clazz = mappingClass(rs);
			if (clazz != null)
			{
				classes.add(clazz);
			}
		}
		pstm.close();
		rs.close();
		c.close();
		return classes;
	}
	
	/**
	 * Map field of Subject from ResultSet to Object Subject
	 *
	 * @param rs is ResultSet
	 * @return Subject
	 */
	private static Subject mappingSubject(ResultSet rs)
	{
		Subject s = new Subject();
		try
		{
			s.setSubjectId(rs.getInt(JdbcConstant.COLUMN_SUBJECT_ID));
			s.setSubjectName(rs.getString(JdbcConstant.COLUMN_SUBJECT_NAME));
			s.setSubjectDesc(rs.getString(JdbcConstant.COLUMN_SUBJECT_DESCRIPTION));
			SubjectDomain domain = null;
			String str = rs.getString(JdbcConstant.COLUMN_SUBJECT_DOMAIN) == null
					? "" : rs.getString(JdbcConstant.COLUMN_SUBJECT_DOMAIN);
			switch (str)
			{
				case "BIOLOGY":
					domain = SubjectDomain.BIOLOGY;
					break;
				case "CHEMISTRY":
					domain = SubjectDomain.CHEMISTRY;
					break;
				case "GEOGRAPHY":
					domain = SubjectDomain.GEOGRAPHY;
					break;
				case "HISTORY":
					domain = SubjectDomain.HISTORY;
					break;
				case "LITERATURE":
					domain = SubjectDomain.LITERATURE;
					break;
				case "MATHEMATICS":
					domain = SubjectDomain.MATHEMATICS;
					break;
				case "PHYSICS":
					domain = SubjectDomain.PHYSICS;
					break;
			}
			s.setDomain(domain);
		}
		catch (SQLException e)
		{
			return null;
		}
		return s;
	}
	
	/**
	 * Get list Subject from database
	 *
	 * @return list Subject
	 * @throws SQLException while handle
	 */
	public static List<Subject> getListSubject() throws SQLException
	{
		sql = JdbcConstant.SELECT_ALL_SUBJECT;
		List<Subject> subjects = new ArrayList<>();
		Subject s;
		c = ConnectionUtil.getConnection();
		pstm = c.prepareStatement(sql);
		rs = pstm.executeQuery();
		while (rs.next())
		{
			s = mappingSubject(rs);
			if (s != null)
			{
				subjects.add(s);
			}
		}
		pstm.close();
		rs.close();
		c.close();
		return subjects;
	}
	
	/**
	 * Map field of Student from ResultSet to Object Student
	 *
	 * @param rs is ResultSet
	 * @return Student
	 */
	private static Student mappingStudent(ResultSet rs)
	{
		Student s = new Student();
		try
		{
			s.setStudentId(rs.getInt(JdbcConstant.COLUMN_STUDENT_ID));
			s.setStudentName(rs.getString(JdbcConstant.COLUMN_STUDENT_NAME));
			s.setStudentMobile(rs.getString(JdbcConstant.COLUMN_STUDENT_MOBILE));
			s.setClassId(rs.getInt(JdbcConstant.COLUMN_STUDENT_CLASS_ID));
		}
		catch (SQLException e)
		{
			return null;
		}
		return s;
	}
	
	/**
	 * Get list Student from database
	 *
	 * @return list Student
	 * @throws SQLException while handle
	 */
	public static List<Student> getListStudent() throws SQLException
	{
		sql = JdbcConstant.SELECT_ALL_STUDENT;
		List<Student> students = new ArrayList<>();
		Student s;
		c = ConnectionUtil.getConnection();
		pstm = c.prepareStatement(sql);
		rs = pstm.executeQuery();
		while (rs.next())
		{
			s = mappingStudent(rs);
			if (s != null)
			{
				students.add(s);
			}
		}
		pstm.close();
		rs.close();
		c.close();
		return students;
	}
	
	/**
	 * Map field of StudentSubjectRegister from ResultSet to Object StudentSubjectRegister
	 *
	 * @param rs is ResultSet
	 * @return StudentSubjectRegister
	 */
	private static StudentSubjectRegister mappingStudentSubject(ResultSet rs)
	{
		StudentSubjectRegister s = new StudentSubjectRegister();
		try
		{
			s.setId(rs.getInt(JdbcConstant.COLUMN_STUDENT_SUBJECT_REGISTER_ID));
			s.setStudentId(rs.getInt(JdbcConstant.COLUMN_STUDENT_SUBJECT_REGISTER_STUDENT_ID));
			s.setSubjectId(rs.getInt(JdbcConstant.COLUMN_STUDENT_SUBJECT_REGISTER_SUBJECT_ID));
			s.setScore(rs.getDouble(JdbcConstant.COLUMN_STUDENT_SUBJECT_REGISTER_SCORE));
		}
		catch (SQLException e)
		{
			return null;
		}
		return s;
	}
	
	/**
	 * Get list StudentSubjectRegister from database
	 *
	 * @return list StudentSubjectRegister
	 * @throws SQLException while handle
	 */
	public static List<StudentSubjectRegister> getListStudentSubjectRegister() throws SQLException
	{
		sql = JdbcConstant.SELECT_ALL_STUDENT_SUBJECT_REGISTER;
		List<StudentSubjectRegister> subjects = new ArrayList<>();
		StudentSubjectRegister s;
		c = ConnectionUtil.getConnection();
		pstm = c.prepareStatement(sql);
		rs = pstm.executeQuery();
		while (rs.next())
		{
			s = mappingStudentSubject(rs);
			if (s != null)
			{
				subjects.add(s);
			}
		}
		pstm.close();
		rs.close();
		c.close();
		return subjects;
	}
}
