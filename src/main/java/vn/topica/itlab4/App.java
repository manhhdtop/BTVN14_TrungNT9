package vn.topica.itlab4;

import vn.topica.itlab4.entity.*;
import vn.topica.itlab4.utils.DbUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Main class
 */
public class App
{
	private static String space1 = "---------------------------------------";
	private static String space2 = "=======================================";
	private static String space3 = "+++++++++++++++++++++++++++++++++++++++";
	
	public static void main(String[] args)
	{
		List<School> schools = null;
		List<ClassOfSchool> classes = null;
		List<Student> students = null;
		List<Subject> subjects = null;
		List<StudentSubjectRegister> subjectRegisters = null;
		
		/*
		 * Load list from database to list School, ClassOfSchool, Student,
		 * Subject, StudentSubjectRegister
		 */
		try
		{
			schools = DbUtils.getListSchool();
			classes = DbUtils.getListClass();
			students = DbUtils.getListStudent();
			subjects = DbUtils.getListSubject();
			subjectRegisters = DbUtils.getListStudentSubjectRegister();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		if (schools == null || classes == null || students == null ||
				subjects == null || subjectRegisters == null)
		{
			System.err.println("Get error!!!!");
		}
		else
		{
			List<ClassOfSchool> finalClasses = classes;
			List<Student> finalStudents = students;
			List<Subject> finalSubjects = subjects;
			List<StudentSubjectRegister> finalSubjectRegisters = subjectRegisters;
			
			/*
			 * Ex 1: Sum of student of a school
			 */
			System.out.println("List schools and student of this school:");
			schools.forEach(s -> {
				int count = finalClasses.stream()
						.filter(c -> c.getSchoolId() == s.getSchoolId())
						.mapToInt(c -> (int) finalStudents.stream()
								.filter(student -> student.getClassId() == c.getClassId())
								.count()).sum();
				System.out.println(space2);
				System.out.println(s + " - Sum student: " + count);
			});
			
			/*
			 * Ex 2: Average of student of a school
			 */
			System.out.println(space1);
			System.out.println("Average score of subject:");
			schools.forEach(school -> {
				System.out.println(space2);
				System.out.println(school);
				finalSubjects.forEach(subject -> {
					double avg = finalClasses.stream()
							.filter(c -> c.getSchoolId() == school.getSchoolId())
							.mapToDouble(c -> finalStudents.stream()
									.filter(student -> student.getClassId() == c.getClassId())
									.mapToDouble(student -> finalSubjectRegisters.stream()
											.filter(subjectRegister -> subjectRegister.getStudentId() == student.getStudentId() &&
													subjectRegister.getSubjectId() == subject.getSubjectId())
											.mapToDouble(StudentSubjectRegister::getScore)
											.filter(value -> value != 0)
											.summaryStatistics().getAverage())
									.filter(value -> value != 0)
									.summaryStatistics().getAverage())
							.filter(value -> value != 0)
							.summaryStatistics().getAverage();
					if (avg != 0)
					{
						avg = (double) Math.round(avg * 100) / 100;
						System.out.println(subject + " - Average=" + avg);
					}
				});
			});
			
			/*
			 * Ex 3: Get class has max average score of a school
			 */
			System.out.println(space1);
			System.out.println("Get class has max average score of a school:");
			schools.forEach(s -> {
				System.out.println(space2);
				System.out.println(s);
				double max = finalClasses.stream()
						.filter(clazz -> clazz.getSchoolId() == s.getSchoolId())
						.collect(Collectors.toList())
						.stream().mapToDouble(clazz -> {
									double avg = finalStudents.stream()
											.filter(student -> student.getClassId() == clazz.getClassId())
											.mapToDouble(student -> finalSubjectRegisters.stream()
													.filter(subjectRegister -> subjectRegister.getStudentId() == student.getStudentId())
													.mapToDouble(StudentSubjectRegister::getScore)
													.summaryStatistics().getAverage())
											.summaryStatistics().getAverage();
									avg = (double) Math.round(avg * 100) / 100;
									System.out.println(clazz + " - Average = " + avg);
									return avg;
								}
						).max().orElse(0);
				System.out.println("Max average = " + max);
			});
			
			/*
			 * Ex 4: Get 10 best student and 10 worst student of subject
			 */
			System.out.println(space1);
			System.out.println("Get 10 best student and 10 worst student of subject:");
			finalSubjects.forEach(subject -> {
				System.out.println(space2);
				System.out.println(subject);
				System.out.println("List 10 best student of subject:");
				finalSubjectRegisters.stream()
						.filter(subjectRegister -> subject.getSubjectId() == subjectRegister.getSubjectId())
						.sorted((s1, s2) -> s2.getScore().compareTo(s1.getScore()))
						.limit(10).collect(Collectors.toList())
						.forEach(subjectRegister -> finalStudents.stream()
								.filter(student -> student.getStudentId() == subjectRegister.getStudentId())
								.limit(1)
								.forEach(student -> System.out.println(student + " - Score=" + subjectRegister.getScore())));
				System.out.println(space3);
				System.out.println("List 10 worst student of subject:");
				finalSubjectRegisters.stream()
						.filter(subjectRegister -> subject.getSubjectId() == subjectRegister.getSubjectId())
						.sorted(Comparator.comparing(StudentSubjectRegister::getScore))
						.limit(10).collect(Collectors.toList())
						.forEach(subjectRegister -> finalStudents.stream()
								.filter(student -> student.getStudentId() == subjectRegister.getStudentId())
								.limit(1).forEach(student -> System.out.println(student + " - Score=" + subjectRegister.getScore())));
			});
			
			/*
			 * Ex 5: Get the highest average of domain
			 */
			System.out.println(space1);
			System.out.println("The highest average of domain:");
			List<SubjectDomain> domains = Arrays.asList(SubjectDomain.values());
			domains.forEach(domain -> {
				System.out.println(space2);
				System.out.println(domain);
				double max = finalClasses.stream().mapToDouble(c -> {
					double avg = finalStudents.stream()
							.filter(student -> student.getClassId() == c.getClassId())
							.mapToDouble(student -> finalSubjects.stream()
									.filter(subject -> subject.getDomain() == domain)
									.mapToDouble(subject -> finalSubjectRegisters.stream()
											.filter(subjectRegister -> subjectRegister.getSubjectId() == subject.getSubjectId() &&
													subjectRegister.getStudentId() == student.getStudentId())
											.mapToDouble(StudentSubjectRegister::getScore)
											.filter(value -> value != 0)
											.summaryStatistics().getAverage())
									.filter(value -> value != 0)
									.summaryStatistics().getAverage())
							.filter(value -> value != 0)
							.summaryStatistics().getAverage();
					avg = (double) Math.round(avg * 100) / 100;
					System.out.println(c + " - Average=" + avg);
					return avg;
				}).max().orElse(-1);
				System.out.println("Max average = " + max);
			});
			
			/*
			 * Ex 6: Get the highest score of domain of school
			 */
			System.out.println(space1);
			System.out.println("The highest score of domain of school:");
			schools.forEach(school -> {
				System.out.println(space2);
				System.out.println(school);
				domains.forEach(domain -> {
					List<StudentSubjectRegister> registerList = finalClasses.stream()
							.filter(c -> c.getSchoolId() == school.getSchoolId())
							.map(c -> finalStudents.stream()
									.filter(student -> student.getClassId() == c.getClassId())
									.map(student -> finalSubjects.stream()
											.filter(subject -> subject.getDomain() == domain)
											.map(subject -> finalSubjectRegisters.stream()
													.filter(subjectRegister -> subject.getSubjectId() == subjectRegister.getSubjectId() &&
															subjectRegister.getStudentId() == student.getStudentId())
													.collect(Collectors.toList()))
											.collect(Collectors.toList()).get(0))
									.collect(Collectors.toList()).get(0))
							.collect(Collectors.toList()).get(0);
					double max = registerList.stream().mapToDouble(StudentSubjectRegister::getScore)
							.max().orElse(0);
					double count =
							registerList.stream().mapToDouble(StudentSubjectRegister::getScore)
									.count();
					System.out.println(domain + " - Max score = " + max);
					System.out.println(domain + " - Max student = " + count);
				});
			});
		}
	}
}

