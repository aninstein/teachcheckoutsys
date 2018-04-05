package com.aninstein.dao;

import com.aninstein.bean.StudentsPO;
import com.aninstein.tool.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/22.
 */
public class StudentsPODao extends BaseDao {

    DBTool dbTool=new DBTool();
    ObjectMapper objectMapper=new ObjectMapper();

    //找到已经存在学号
    public List<String> existStuid(String[] stuidS) throws SQLException {
        List<String> existId=new ArrayList<>();
        //获取一个内容相同的数组
        String[] theStuid=ArrayTool.getOneEqualContainStringArr(StudentsPO._stuid,stuidS.length);
        //条件字符串
        String[] conditionStr=ArrayTool.getSetStringByStringArr(theStuid,stuidS);
        SelectSql selectSql=new SelectSql();
        selectSql.setAndOr("OR");
        selectSql.setSelect(StudentsPO._stuid);
        selectSql.setTable(DatabaseTableNames._students);
        selectSql.setConditionList(conditionStr);

        String sql=selectSql.getSelectSql();

        ResultSet resultSet=selectSql.execSelect(sql);
        while (resultSet.next()){
            existId.add(resultSet.getString(StudentsPO._stuid));
        }
        return existId;
    }

    //通过学号找到学生
    public List<StudentsPO> selectByStuidList(List<String> stuidList) throws Exception{
        List<StudentsPO> existStudent=new ArrayList<>();
        GetTablePO getTablePO=new GetTablePO(DatabaseTableNames._students);
        String[] theStuid=ArrayTool.getOneEqualContainStringArr(StudentsPO._stuid,stuidList.size());
        String[] conditionStr=ArrayTool.getSetStringByStringArr(theStuid, (String[]) stuidList.toArray(new String[stuidList.size()]));
        SelectSql selectSql=new SelectSql();
        selectSql.setAndOr("OR");
        selectSql.setSelect("*");
        selectSql.setTable(DatabaseTableNames._students);
        selectSql.setConditionList(conditionStr);
        String sql=selectSql.getSelectSql();
        ResultSet resultSet=selectSql.execSelect(sql);
        return GetTablePO.objectToStudentsPO(getTablePO.getThePOListByTableName(JsonTool.resultSetToJson(resultSet)));
    }

    //通过学号找到学生
    public StudentsPO selectByStuid(String stuid) throws Exception{
        SelectSql selectSql=new SelectSql();
        GetTablePO getTablePO=new GetTablePO(DatabaseTableNames._students);
        selectSql.setSelect("*");
        selectSql.setTable(DatabaseTableNames._students);
        selectSql.setCondition(StudentsPO._stuid+"='"+stuid+"'");
        ResultSet resultSet=selectSql.execSelect(selectSql.getSelectSql());
        return (StudentsPO)getTablePO.getThePOByTableName(JsonTool.resultSetToJson(resultSet));
    }

    //查找全部学生
    public List<StudentsPO> selectAll() throws SQLException {
        List<StudentsPO> studentsPOS=new ArrayList<>();
        SelectSql selectSql=new SelectSql();
        GetTablePO getTablePO=new GetTablePO(DatabaseTableNames._students);

        String sql = selectSql.getSelectAllSql(DatabaseTableNames._students);
        ResultSet resultSet=selectSql.execSelect(sql);
        //如果查询结果大于0
        if(resultSet.next()) {
            String json = JsonTool.resultSetToJson(resultSet);
            List<Object> objectList = getTablePO.getThePOListByTableName(json);
            for (Object object : objectList) {
                StudentsPO studentsPO = (StudentsPO) object;
                studentsPOS.add(studentsPO);
            }
            return studentsPOS;
        }
        return null;
    }

    //按照条件查找全表
    public List<StudentsPO> selectByCondition(String condition) throws Exception {
        List<StudentsPO> studentsPOS=new ArrayList<>();
        SelectSql selectSql=new SelectSql();
        GetTablePO getTablePO=new GetTablePO(DatabaseTableNames._students);
        selectSql.setAndOr("OR")
                .setSelect("*")
                .setTable(DatabaseTableNames._students)
                .setTableAllCondition(condition);
        String sql=selectSql.getSelectSql();
        ResultSet resultSet=selectSql.execSelect(sql);
        //如果查询结果大于0
        if(resultSet.next()) {
            String json = JsonTool.resultSetToJson(resultSet);
            List<Object> objectList = getTablePO.getThePOListByTableName(json);
            for (Object object : objectList) {
                StudentsPO studentsPO = (StudentsPO) object;
                studentsPOS.add(studentsPO);
            }
            return studentsPOS;
        }
        return null;
    }

    //更新学生
    public boolean update(StudentsPO studentsPO, Map<String,Object> conditionMap) throws SQLException {
        UpdateSql updateSql =new UpdateSql();
        String sql=updateSql.getUpdateStudentsPOSql(studentsPO,conditionMap);
        int count=updateSql.execUpdate(sql);
        return count>0?true:false;
    }

    public boolean insert(StudentsPO studentsPO) throws SQLException {
        InsertSql insertSql=new InsertSql();
        String sql=insertSql.getInsertStudentsPOSql(studentsPO);
        int count=insertSql.execInsertBySql(sql);
        return count>0?true:false;
    }

    public boolean batchInsert(List<StudentsPO> studentsPOList) throws SQLException {
        InsertSql insertSql=new InsertSql();
        List<String> sqlList=new ArrayList<String>();
        for(StudentsPO studentsPO:studentsPOList){
            String sql=insertSql.getInsertStudentsPOSql(studentsPO);
            sqlList.add(sql);
        }
        int[] count=insertSql.execInsertByBatchSql(sqlList);

        //判断是否有没有插入不成功的,如果包含0，证明不成功，不包含才是成功的
        return Arrays.toString(count).contains("0")?false:true;
    }

    public boolean delete(StudentsPO studentsPO) throws SQLException {
        DeleteSql deleteSql=new DeleteSql();
        String sql=deleteSql.deleteStudentslePOSql(studentsPO);
        int count=deleteSql.execDelete(sql);
        return count>0?true:false;
    }

    public boolean batchDelete(List<StudentsPO> studentsPOList) throws SQLException {
        DeleteSql deleteSql=new DeleteSql();
        List<String> sqlList=new ArrayList<String>();
        for (StudentsPO studentsPO:studentsPOList){
            String sql=deleteSql.deleteStudentslePOSql(studentsPO);
            sqlList.add(sql);
        }
        int[] count=deleteSql.execBatchDelete(sqlList);
        //判断是否有没有插入不成功的,如果包含0，证明不成功，不包含才是成功的
        return Arrays.toString(count).contains("0")?false:true;
    }

}
