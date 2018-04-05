package com.aninstein.tool;

import com.aninstein.bean.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class InsertSql {

	String tableName;
	DBTool dbTool = new DBTool();
	Connection connection = dbTool.getConnection();
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	// 通过sql语句执行insert操作
	public int execInsertBySql(String sql) throws SQLException {
		Statement statement = connection.createStatement();
		int count = statement.executeUpdate(sql);
		return count;
	}

	// 通过sql语句批量执行insert操作
	public int[] execInsertByBatchSql(List<String> sqlList) throws SQLException {
		Statement statement = connection.createStatement();
		for (String sql : sqlList) {
			statement.addBatch(sql);
		}
		int[] count = statement.executeBatch();
		return count;
	}

	// 把list转化为数组
	public String[] returnStringToPO(List<Object> objList) {
		String[] objs = new String[objList.size()];
		for (int i = 0; i < objList.size(); i++) {
			objs[i] = String.valueOf(objList.get(i));
		}
		return objs;

	}
	/*admintablePOInsert*/
	public String getInsertAdmintablePOSql(AdmintablePO admintablePO) {
		CheckPOnotNullList checkPOnotNullList=new CheckPOnotNullList();
		List<Object> colnameList = checkPOnotNullList.getAdmintablePOColnameList(admintablePO);
		List<Object> valuesList = checkPOnotNullList.getAdmintablePOValuesList(admintablePO);
		return "INSERT INTO " + DatabaseTableNames._admintable + "(" + String.join(",", returnStringToPO(colnameList))
				+ ") VALUES ('" + String.join("','", returnStringToPO(valuesList)) + "')";
	}
	/*classtablePOInsert*/
	public String getInsertClasstablePOSql(ClasstablePO classtablePO) {
		CheckPOnotNullList checkPOnotNullList=new CheckPOnotNullList();
		List<Object> colnameList = checkPOnotNullList.getClasstablePOColnameList(classtablePO);
		List<Object> valuesList = checkPOnotNullList.getClasstablePOValuesList(classtablePO);
		return "INSERT INTO " + DatabaseTableNames._classtable + "(" + String.join(",", returnStringToPO(colnameList))
				+ ") VALUES ('" + String.join("','", returnStringToPO(valuesList)) + "')";
	}
	/*coursesPOInsert*/
	public String getInsertCoursesPOSql(CoursesPO coursesPO) {
		CheckPOnotNullList checkPOnotNullList=new CheckPOnotNullList();
		List<Object> colnameList = checkPOnotNullList.getCoursesPOColnameList(coursesPO);
		List<Object> valuesList = checkPOnotNullList.getCoursesPOValuesList(coursesPO);
		return "INSERT INTO " + DatabaseTableNames._courses + "(" + String.join(",", returnStringToPO(colnameList))
				+ ") VALUES ('" + String.join("','", returnStringToPO(valuesList)) + "')";
	}
	/*filetablePOInsert*/
	public String getInsertFiletablePOSql(FiletablePO filetablePO) {
		CheckPOnotNullList checkPOnotNullList=new CheckPOnotNullList();
		List<Object> colnameList = checkPOnotNullList.getFiletablePOColnameList(filetablePO);
		List<Object> valuesList = checkPOnotNullList.getFiletablePOValuesList(filetablePO);
		return "INSERT INTO " + DatabaseTableNames._filetable + "(" + String.join(",", returnStringToPO(colnameList))
				+ ") VALUES ('" + String.join("','", returnStringToPO(valuesList)) + "')";
	}
	/*sjtablePOInsert*/
	public String getInsertSjtablePOSql(SjtablePO sjtablePO) {
		CheckPOnotNullList checkPOnotNullList=new CheckPOnotNullList();
		List<Object> colnameList = checkPOnotNullList.getSjtablePOColnameList(sjtablePO);
		List<Object> valuesList = checkPOnotNullList.getSjtablePOValuesList(sjtablePO);
		return "INSERT INTO " + DatabaseTableNames._sjtable + "(" + String.join(",", returnStringToPO(colnameList))
				+ ") VALUES ('" + String.join("','", returnStringToPO(valuesList)) + "')";
	}
	/*studentsPOInsert*/
	public String getInsertStudentsPOSql(StudentsPO studentsPO) {
		CheckPOnotNullList checkPOnotNullList=new CheckPOnotNullList();
		List<Object> colnameList = checkPOnotNullList.getStudentsPOColnameList(studentsPO);
		List<Object> valuesList = checkPOnotNullList.getStudentsPOValuesList(studentsPO);
		return "INSERT INTO " + DatabaseTableNames._students + "(" + String.join(",", returnStringToPO(colnameList))
				+ ") VALUES ('" + String.join("','", returnStringToPO(valuesList)) + "')";
	}
	/*stuqiandaoPOInsert*/
	public String getInsertStuqiandaoPOSql(StuqiandaoPO stuqiandaoPO) {
		CheckPOnotNullList checkPOnotNullList=new CheckPOnotNullList();
		List<Object> colnameList = checkPOnotNullList.getStuqiandaoPOColnameList(stuqiandaoPO);
		List<Object> valuesList = checkPOnotNullList.getStuqiandaoPOValuesList(stuqiandaoPO);
		return "INSERT INTO " + DatabaseTableNames._stuqiandao + "(" + String.join(",", returnStringToPO(colnameList))
				+ ") VALUES ('" + String.join("','", returnStringToPO(valuesList)) + "')";
	}
	/*teachersPOInsert*/
	public String getInsertTeachersPOSql(TeachersPO teachersPO) {
		CheckPOnotNullList checkPOnotNullList=new CheckPOnotNullList();
		List<Object> colnameList = checkPOnotNullList.getTeachersPOColnameList(teachersPO);
		List<Object> valuesList = checkPOnotNullList.getTeachersPOValuesList(teachersPO);
		return "INSERT INTO " + DatabaseTableNames._teachers + "(" + String.join(",", returnStringToPO(colnameList))
				+ ") VALUES ('" + String.join("','", returnStringToPO(valuesList)) + "')";
	}
	/*titablePOInsert*/
	public String getInsertTitablePOSql(TitablePO titablePO) {
		CheckPOnotNullList checkPOnotNullList=new CheckPOnotNullList();
		List<Object> colnameList = checkPOnotNullList.getTitablePOColnameList(titablePO);
		List<Object> valuesList = checkPOnotNullList.getTitablePOValuesList(titablePO);
		return "INSERT INTO " + DatabaseTableNames._titable + "(" + String.join(",", returnStringToPO(colnameList))
				+ ") VALUES ('" + String.join("','", returnStringToPO(valuesList)) + "')";
	}

	
}
