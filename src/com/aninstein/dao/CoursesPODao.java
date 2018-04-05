package com.aninstein.dao;

import com.aninstein.bean.CoursesPO;
import com.aninstein.tool.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CoursesPODao extends BaseDao {

	DBTool dbTool = new DBTool();

	public boolean verifyExist(String course) throws Exception {
		SelectSql selectSql = new SelectSql();

		selectSql.setSelect("*")
				.setTable(DatabaseTableNames._courses)
				.setCondition(CoursesPO._coursesid+"='" + course + "'");
		String sql = selectSql.getSelectSql();
		ResultSet resultSet = selectSql.execSelect(sql);
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

	// 查询课程名
	public List<String> selectCoursesPOCouresName(String course) throws SQLException {
		SelectSql selectSql = new SelectSql();
		GetTablePO getTablePO = new GetTablePO();

		selectSql.setSelect("*");
		selectSql.setTable(DatabaseTableNames._courses);
		selectSql.setCondition(CoursesPO._coursesname + " LIKE '%" + course + "%' OR " + CoursesPO._coursesid
				+ " LIKE '%" + course + "%'");
		String sql = selectSql.getSelectSql();

		try {
			List<String> courseList = new ArrayList<String>();
			List<Object> coursesPOList = getTablePO.getTablePOListBySql(DatabaseTableNames._courses, sql);
			for (Object object : coursesPOList) {
				CoursesPO coursesPO = (CoursesPO) object;
				courseList.add(coursesPO.getCoursesname());
			}
			return courseList;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 查询课程全信息
	public List<CoursesPO> selectCoursesPO(String course) throws SQLException {
		SelectSql selectSql = new SelectSql();
		GetTablePO getTablePO = new GetTablePO();

		selectSql.setSelect("*");
		selectSql.setTable(DatabaseTableNames._courses);
		selectSql.setCondition(CoursesPO._coursesname + " LIKE '%" + course + "%' OR " + CoursesPO._coursesid
				+ " LIKE '%" + course + "%'");
		String sql = selectSql.getSelectSql();

		try {
			List<CoursesPO> result=new ArrayList<>();
			List<Object> coursesPOList = getTablePO.getTablePOListBySql(DatabaseTableNames._courses, sql);
			for(Object object:coursesPOList){
				result.add((CoursesPO)object);
			}
			return result;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean insert(CoursesPO coursesPO) throws SQLException {
		InsertSql insertSql = new InsertSql();
		String sql = insertSql.getInsertCoursesPOSql(coursesPO);
		int count = insertSql.execInsertBySql(sql);
		return count > 0 ? true : false;
	}

	public boolean batchInsert(List<CoursesPO> CoursesPOList) throws SQLException {
		InsertSql insertSql = new InsertSql();
		List<String> sqlList = new ArrayList<String>();
		for (CoursesPO coursesPO : CoursesPOList) {
			String sql = insertSql.getInsertCoursesPOSql(coursesPO);
			sqlList.add(sql);
		}
		int[] count = insertSql.execInsertByBatchSql(sqlList);

		// 判断是否有没有插入不成功的
		return Arrays.toString(count).contains("0") ? true : false;
	}

	public boolean update(CoursesPO coursesPO, Map<String, Object> conditionMap) throws SQLException {
		UpdateSql updateSql = new UpdateSql();
		String sql = updateSql.getUpdateCoursesPOSql(coursesPO, conditionMap);
		int count = updateSql.execUpdate(sql);
		return count == 1 ? true : false;
	}

	//删除
	public boolean delete(CoursesPO coursesPO) throws SQLException {
		DeleteSql deleteSql=new DeleteSql();
		String sql=deleteSql.deleteCourseslePOSql(coursesPO);
		int count=deleteSql.execDelete(sql);
		return count>0?true:false;
	}

	//批量删除
	public boolean batchDelete(List<CoursesPO> coursesPOList) throws SQLException {
		DeleteSql deleteSql=new DeleteSql();
		List<String> sqlList=new ArrayList<String>();
		for (CoursesPO coursesPO:coursesPOList){
			String sql=deleteSql.deleteCourseslePOSql(coursesPO);
			sqlList.add(sql);
		}
		int[] count=deleteSql.execBatchDelete(sqlList);
		//判断是否有没有插入不成功的,如果包含0，证明不成功，不包含才是成功的
		return Arrays.toString(count).contains("0")?false:true;
	}

}
