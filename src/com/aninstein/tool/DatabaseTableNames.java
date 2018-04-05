package com.aninstein.tool;

import com.aninstein.en.ExcelTypeEnum;

public class DatabaseTableNames {
	public static String _admintable="admintable";
	public static String _classtable="classtable";
	public static String _courses="courses";
	public static String _sjtable="sjtable";
	public static String _students="students";
	public static String _stuqiandao="stuqiandao";
	public static String _teachers="teachers";
	public static String _titable="titable";
	public static String _filetable="filetable";

	public static String getPOtypeByType(Integer type) {
		if (type == ExcelTypeEnum.teacher.ordinal()) {
			return DatabaseTableNames._teachers;
		} else if (type == ExcelTypeEnum.classroom.ordinal()) {
			return DatabaseTableNames._classtable;
		} else if (type == ExcelTypeEnum.course.ordinal()) {
			return DatabaseTableNames._courses;
		} else if (type == ExcelTypeEnum.sj.ordinal()) {
			return DatabaseTableNames._sjtable;
		} else if (type == ExcelTypeEnum.student.ordinal()) {
			return DatabaseTableNames._students;
		} else {
			return null;
		}
	}

}
