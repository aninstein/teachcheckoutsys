package com.aninstein.tool;

import com.aninstein.bean.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UpdateSql {

	public String tanleName;
	DBTool dbTool = new DBTool();
	Connection connection = dbTool.getConnection();

	public UpdateSql() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateSql(String tanleName) {
		super();
		this.tanleName = tanleName;
	}

	public String getTanleName() {
		return tanleName;
	}

	public void setTanleName(String tanleName) {
		this.tanleName = tanleName;
	}

	// 执行update语句
	public int execUpdate(String sql) throws SQLException {
		Statement statement = connection.createStatement();
		int count = statement.executeUpdate(sql);
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

	// 把Map的key和value转化为"key"="value"的字符串数组
	public String[] returnSetStringByMap(Map<String, Object> map) {
		String[] kvS = new String[map.size()];
		int i = 0;
		// 遍历map
		for (Map.Entry<String, Object> myMap : map.entrySet()) {
			// 所有表格中id是主键不能修改
			if (!myMap.getKey().equals("id")) {
				kvS[i] = myMap.getKey() + "='" + myMap.getValue() + "'";
				i++;
			} else {
				// 如果有id作为map，那么就把数组截去一格
				kvS = Arrays.copyOfRange(kvS, 0, kvS.length - 1);
			}
		}
		return kvS;
	}

	//转化conditionMap的函数
	public String[] returnConditionStringByMap(Map<String, Object> map) {
		String[] kvS = new String[map.size()];
		int i = 0;
		// 遍历map
		for (Map.Entry<String, Object> myMap : map.entrySet()) {
			kvS[i] = myMap.getKey() + "='" + myMap.getValue() + "'";
			i++;
		}
		return kvS;
	}

	/*admintablePOUpdate*/
	public String getUpdateAdmintablePOSql(AdmintablePO admintablePO,Map<String,Object> conditionMap) {
		CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
		Map<String, Object> map = checkPOnotNullMap.getAdmintablePOMap(admintablePO);
		return "UPDATE " + DatabaseTableNames._admintable +
				" SET "+String.join(",", returnSetStringByMap(map))+
				" WHERE "+String.join(" AND ", returnConditionStringByMap(conditionMap));
	}
	/*classtablePOUpdate*/
	public String getUpdateClasstablePOSql(ClasstablePO classtablePO,Map<String,Object> conditionMap) {
		CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
		Map<String, Object> map = checkPOnotNullMap.getClasstablePOMap(classtablePO);
		return "UPDATE " + DatabaseTableNames._classtable +
				" SET "+String.join(",", returnSetStringByMap(map))+
				" WHERE "+String.join(" AND ", returnConditionStringByMap(conditionMap));
	}
	/*coursesPOUpdate*/
	public String getUpdateCoursesPOSql(CoursesPO coursesPO,Map<String,Object> conditionMap) {
		CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
		Map<String, Object> map = checkPOnotNullMap.getCoursesPOMap(coursesPO);
		return "UPDATE " + DatabaseTableNames._courses +
				" SET "+String.join(",", returnSetStringByMap(map))+
				" WHERE "+String.join(" AND ", returnConditionStringByMap(conditionMap));
	}
	/*filetablePOUpdate*/
	public String getUpdateFiletablePOSql(FiletablePO filetablePO,Map<String,Object> conditionMap) {
		CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
		Map<String, Object> map = checkPOnotNullMap.getFiletablePOMap(filetablePO);
		return "UPDATE " + DatabaseTableNames._filetable +
				" SET "+String.join(",", returnSetStringByMap(map))+
				" WHERE "+String.join(" AND ", returnConditionStringByMap(conditionMap));
	}
	/*sjtablePOUpdate*/
	public String getUpdateSjtablePOSql(SjtablePO sjtablePO,Map<String,Object> conditionMap) {
		CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
		Map<String, Object> map = checkPOnotNullMap.getSjtablePOMap(sjtablePO);
		return "UPDATE " + DatabaseTableNames._sjtable +
				" SET "+String.join(",", returnSetStringByMap(map))+
				" WHERE "+String.join(" AND ", returnConditionStringByMap(conditionMap));
	}
	/*studentsPOUpdate*/
	public String getUpdateStudentsPOSql(StudentsPO studentsPO,Map<String,Object> conditionMap) {
		CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
		Map<String, Object> map = checkPOnotNullMap.getStudentsPOMap(studentsPO);
		return "UPDATE " + DatabaseTableNames._students +
				" SET "+String.join(",", returnSetStringByMap(map))+
				" WHERE "+String.join(" AND ", returnConditionStringByMap(conditionMap));
	}
	/*stuqiandaoPOUpdate*/
	public String getUpdateStuqiandaoPOSql(StuqiandaoPO stuqiandaoPO,Map<String,Object> conditionMap) {
		CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
		Map<String, Object> map = checkPOnotNullMap.getStuqiandaoPOMap(stuqiandaoPO);
		return "UPDATE " + DatabaseTableNames._stuqiandao +
				" SET "+String.join(",", returnSetStringByMap(map))+
				" WHERE "+String.join(" AND ", returnConditionStringByMap(conditionMap));
	}
	/*teachersPOUpdate*/
	public String getUpdateTeachersPOSql(TeachersPO teachersPO,Map<String,Object> conditionMap) {
		CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
		Map<String, Object> map = checkPOnotNullMap.getTeachersPOMap(teachersPO);
		return "UPDATE " + DatabaseTableNames._teachers +
				" SET "+String.join(",", returnSetStringByMap(map))+
				" WHERE "+String.join(" AND ", returnConditionStringByMap(conditionMap));
	}
	/*titablePOUpdate*/
	public String getUpdateTitablePOSql(TitablePO titablePO,Map<String,Object> conditionMap) {
		CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
		Map<String, Object> map = checkPOnotNullMap.getTitablePOMap(titablePO);
		return "UPDATE " + DatabaseTableNames._titable +
				" SET "+String.join(",", returnSetStringByMap(map))+
				" WHERE "+String.join(" AND ", returnConditionStringByMap(conditionMap));
	}


}
