package com.aninstein.dao;

import com.aninstein.bean.TeachersPO;
import com.aninstein.en.TeachersStatuEnum;
import com.aninstein.tool.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TeachersPODao extends BaseDao  {
	
	DBTool dbTool=new DBTool();
	
	public boolean verifyUser(String user) throws Exception {
		SelectSql selectSql=new SelectSql();
		
		selectSql.setSelect("*");
		selectSql.setTable(DatabaseTableNames._teachers);
		selectSql.setCondition(TeachersPO._teacheremail+"='"+user+"' OR "
								+TeachersPO._teacherusername+"='"+user+"' OR "
								+TeachersPO._teacherid+"='"+user+"'");
		String sql=selectSql.getSelectSql();
		ResultSet resultSet=selectSql.execSelect(sql);
		if(resultSet.next()){
			return true;
		}
		return false;
	}
		
	public TeachersPO selectTeachersPOByEmail(String user) throws SQLException {
		SelectSql selectSql=new SelectSql();
		GetTablePO getTablePO=new GetTablePO();
		
		selectSql.setSelect("*");
		selectSql.setTable(DatabaseTableNames._teachers);
		selectSql.setCondition(TeachersPO._teacheremail+"='"+user+"' OR "
				+TeachersPO._teacherusername+"='"+user+"' OR "
				+TeachersPO._teacherid+"='"+user+"'");
		String sql=selectSql.getSelectSql();
		
		try {
			TeachersPO teachersPO=(TeachersPO) getTablePO.getTablePOBySql(selectSql.getTable(), sql);
			return teachersPO;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<TeachersPO> selectAllTeachers() throws SQLException {
		List<TeachersPO> teachersPOList=new ArrayList<>();
		SelectSql selectSql=new SelectSql();
		GetTablePO getTablePO=new GetTablePO(DatabaseTableNames._teachers);

		String sql = selectSql.getSelectAllSql(DatabaseTableNames._teachers);
		ResultSet resultSet=selectSql.execSelect(sql);
		//如果查询结果大于0
		if(resultSet.next()) {
			String json = JsonTool.resultSetToJson(resultSet);
			List<Object> objectList = getTablePO.getThePOListByTableName(json);
			for (Object object : objectList) {
				TeachersPO teachersPO = (TeachersPO) object;
				teachersPOList.add(teachersPO);
			}
			return teachersPOList;
		}
		return null;
	}

	public List<TeachersPO> selectTeachersByCondition(String condition) throws Exception {
		List<TeachersPO> teachersPOList=new ArrayList<>();
		SelectSql selectSql=new SelectSql();
		GetTablePO getTablePO=new GetTablePO(DatabaseTableNames._teachers);
		selectSql.setAndOr("OR")
				.setSelect("*")
				.setTable(DatabaseTableNames._teachers)
				.setTableAllCondition(condition);
		String sql=selectSql.getSelectSql();
		ResultSet resultSet=selectSql.execSelect(sql);
		//如果查询结果大于0
		if(resultSet.next()) {
			String json = JsonTool.resultSetToJson(resultSet);
			List<Object> objectList = getTablePO.getThePOListByTableName(json);
			for (Object object : objectList) {
				TeachersPO teachersPO = (TeachersPO) object;
				teachersPOList.add(teachersPO);
			}
			return teachersPOList;
		}
		return null;
	}

	public List<TeachersPO> selectAuditingTeachers() throws Exception {
		List<TeachersPO> teachersPOList=new ArrayList<>();
		SelectSql selectSql=new SelectSql();
		GetTablePO getTablePO=new GetTablePO(DatabaseTableNames._teachers);
		selectSql.setSelect("*")
				.setTable(DatabaseTableNames._teachers)
				.setCondition(TeachersPO._teacherstatu+" = '"+ TeachersStatuEnum.Auditing.ordinal() +"'");
		String sql=selectSql.getSelectSql();
		ResultSet resultSet=selectSql.execSelect(sql);
		//如果查询结果大于0
		if(resultSet.next()) {
			String json = JsonTool.resultSetToJson(resultSet);
			List<Object> objectList = getTablePO.getThePOListByTableName(json);
			for (Object object : objectList) {
				TeachersPO teachersPO = (TeachersPO) object;
				teachersPOList.add(teachersPO);
			}
			return teachersPOList;
		}
		return null;
	}

	public List<String> existId(String[] idS) throws SQLException {
		List<String> existIds=new ArrayList<>();
		//获取一个内容相同的数组
		String[] theId=ArrayTool.getOneEqualContainStringArr(TeachersPO._teacherid,idS.length);
		//条件字符串
		String[] conditionStr=ArrayTool.getSetStringByStringArr(theId,idS);
		SelectSql selectSql=new SelectSql();
		selectSql.setAndOr("OR");
		selectSql.setSelect(TeachersPO._teacherid);
		selectSql.setTable(DatabaseTableNames._teachers);
		selectSql.setConditionList(conditionStr);

		String sql=selectSql.getSelectSql();

		ResultSet resultSet=selectSql.execSelect(sql);
		while (resultSet.next()){
			existIds.add(resultSet.getString(TeachersPO._teacherid));
		}
		return existIds;
	}

	/**
	 * 根据id列表搜索
	 * @param idList
	 * @return
	 * @throws SQLException
	 */
	public List<TeachersPO> selectByIdList(List<String> idList) throws SQLException {
		List<TeachersPO> existTeacher=new ArrayList<>();
		GetTablePO getTablePO=new GetTablePO(DatabaseTableNames._teachers);
		String[] theStuid=ArrayTool.getOneEqualContainStringArr(TeachersPO._teacherid,idList.size());
		String[] conditionStr=ArrayTool.getSetStringByStringArr(theStuid, (String[]) idList.toArray(new String[idList.size()]));
		SelectSql selectSql=new SelectSql();
		selectSql.setAndOr("OR")
				.setSelect("*")
				.setTable(DatabaseTableNames._teachers)
				.setConditionList(conditionStr);
		String sql=selectSql.getSelectSql();
		ResultSet resultSet=selectSql.execSelect(sql);
		return GetTablePO.objectToTeachersPO(getTablePO.getThePOListByTableName(JsonTool.resultSetToJson(resultSet)));

	}
	
	public boolean insert(TeachersPO teachersPO) throws SQLException {
		InsertSql insertSql=new InsertSql();
		String sql=insertSql.getInsertTeachersPOSql(teachersPO);
		int count=insertSql.execInsertBySql(sql);
		return count>0?true:false;
	}
	
	public boolean batchInsert(List<TeachersPO> teachersPOList) throws SQLException {
		InsertSql insertSql=new InsertSql();
		List<String> sqlList=new ArrayList<String>();
		for(TeachersPO teachersPO:teachersPOList){
			String sql=insertSql.getInsertTeachersPOSql(teachersPO);
			sqlList.add(sql);
		}
		int[] count=insertSql.execInsertByBatchSql(sqlList);

		//判断是否有没有插入不成功的,如果包含0，证明不成功，不包含才是成功的
		return Arrays.toString(count).contains("0")?false:true;
	}
	
	public boolean update(TeachersPO teachersPO,Map<String,Object> conditionMap) throws SQLException {
		UpdateSql updateSql=new UpdateSql();
		String sql=updateSql.getUpdateTeachersPOSql(teachersPO, conditionMap);
		int count=updateSql.execUpdate(sql);
		return count==1?true:false;
	}

	//删除
	public boolean delete(TeachersPO teachersPO) throws SQLException {
		DeleteSql deleteSql=new DeleteSql();
		String sql=deleteSql.deleteTeacherslePOSql(teachersPO);
		int count=deleteSql.execDelete(sql);
		return count>0?true:false;
	}

	//批量删除
	public boolean batchDelete(List<TeachersPO> teachersPOList) throws SQLException {
		DeleteSql deleteSql=new DeleteSql();
		List<String> sqlList=new ArrayList<String>();
		for (TeachersPO teachersPO:teachersPOList){
			String sql=deleteSql.deleteTeacherslePOSql(teachersPO);
			sqlList.add(sql);
		}
		int[] count=deleteSql.execBatchDelete(sqlList);
		//判断是否有没有插入不成功的,如果包含0，证明不成功，不包含才是成功的
		return Arrays.toString(count).contains("0")?false:true;
	}

}
