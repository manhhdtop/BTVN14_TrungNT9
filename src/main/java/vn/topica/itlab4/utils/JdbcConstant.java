package vn.topica.itlab4.utils;

/**
 * This class init some const for connect and process database
 */
class JdbcConstant
{
	// JDBC config
	static final String DB_NAME = "itlab4";
	static final String HOST = "localhost";
	static final int PORT = 3306;
	static final String USERNAME = "root";
	static final String PASSWORD = "";
	
	// Table name
	private static final String TABLE_SCHOOL = "school";
	private static final String TABLE_CLASS = "class";
	private static final String TABLE_STUDENT = "student";
	private static final String TABLE_SUBJECT = "subject";
	private static final String TABLE_STUDENT_SUBJECT_REGISTER =
			"student_subject";
	
	// Column of table school
	static final String COLUMN_SCHOOL_ID = "id";
	static final String COLUMN_SCHOOL_NAME = "name";
	static final String COLUMN_SCHOOL_DESCRIPTION = "description";
	
	// Column of table class
	static final String COLUMN_CLASS_ID = "id";
	static final String COLUMN_CLASS_CODE = "code";
	static final String COLUMN_CLASS_DESCRIPTION = "description";
	static final String COLUMN_CLASS_SCHOOL_ID = "school_id";
	
	// Column of table student
	static final String COLUMN_STUDENT_ID = "id";
	static final String COLUMN_STUDENT_NAME = "name";
	static final String COLUMN_STUDENT_MOBILE = "mobile";
	static final String COLUMN_STUDENT_CLASS_ID = "class_id";
	
	// Column of table subject
	static final String COLUMN_SUBJECT_ID = "id";
	static final String COLUMN_SUBJECT_NAME = "name";
	static final String COLUMN_SUBJECT_DESCRIPTION = "description";
	static final String COLUMN_SUBJECT_DOMAIN = "domain";
	
	// Column of table student subject
	static final String COLUMN_STUDENT_SUBJECT_REGISTER_ID = "id";
	static final String COLUMN_STUDENT_SUBJECT_REGISTER_STUDENT_ID = "student_id";
	static final String COLUMN_STUDENT_SUBJECT_REGISTER_SUBJECT_ID = "subject_id";
	static final String COLUMN_STUDENT_SUBJECT_REGISTER_SCORE = "score";
	
	// Table School
	static final String SELECT_ALL_SCHOOL = "SELECT * FROM `" + TABLE_SCHOOL + "`";
	
	// Table Class
	static final String SELECT_ALL_CLASS =
			"SELECT * FROM `" + TABLE_CLASS + "`";
	
	// Table student
	static final String SELECT_ALL_STUDENT =
			"SELECT * FROM `" + TABLE_STUDENT + "`";
	
	// Table subject
	static final String SELECT_ALL_SUBJECT = "SELECT * FROM `" + TABLE_SUBJECT + "`";
	
	// Table student subject register
	static final String SELECT_ALL_STUDENT_SUBJECT_REGISTER = "SELECT " +
			"* FROM `" + TABLE_STUDENT_SUBJECT_REGISTER + "` WHERE `"
			+ COLUMN_STUDENT_SUBJECT_REGISTER_ID + "`";
}
