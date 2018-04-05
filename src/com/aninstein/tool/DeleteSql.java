package com.aninstein.tool;

import com.aninstein.bean.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/20.
 */
public class DeleteSql {

    String tableName;
    DBTool dbTool = new DBTool();
    Connection connection = dbTool.getConnection();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    //通过sql语句执行delete
    public int execDelete(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(sql);
        return count;
    }

    //通过sql语句执行batchdelete
    public int[] execBatchDelete(List<String> sqlList) throws SQLException {
        Statement statement = connection.createStatement();
        for(String sql:sqlList){
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

    // 把Map的key和value转化为"key"="value"的字符串数组
    public String[] returnKVString(Map<String, Object> map) {
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

    /*admintablePODelete*/
    public String deleteAdmintablelePOSql(AdmintablePO admintablePO) {
        CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
        Map<String, Object> map = checkPOnotNullMap.getAdmintablePOMap(admintablePO);
        return "DELETE FROM "+DatabaseTableNames._admintable+"  WHERE "+String.join(",",returnKVString(map));
    }
    /*classtablePODelete*/
    public String deleteClasstablelePOSql(ClasstablePO classtablePO) {
        CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
        Map<String, Object> map = checkPOnotNullMap.getClasstablePOMap(classtablePO);
        return "DELETE FROM "+DatabaseTableNames._classtable+"  WHERE "+String.join(",",returnKVString(map));
    }
    /*coursesPODelete*/
    public String deleteCourseslePOSql(CoursesPO coursesPO) {
        CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
        Map<String, Object> map = checkPOnotNullMap.getCoursesPOMap(coursesPO);
        return "DELETE FROM "+DatabaseTableNames._courses+"  WHERE "+String.join(",",returnKVString(map));
    }
    /*filetablePODelete*/
    public String deleteFiletablelePOSql(FiletablePO filetablePO) {
        CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
        Map<String, Object> map = checkPOnotNullMap.getFiletablePOMap(filetablePO);
        return "DELETE FROM "+DatabaseTableNames._filetable+"  WHERE "+String.join(",",returnKVString(map));
    }
    /*sjtablePODelete*/
    public String deleteSjtablelePOSql(SjtablePO sjtablePO) {
        CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
        Map<String, Object> map = checkPOnotNullMap.getSjtablePOMap(sjtablePO);
        return "DELETE FROM "+DatabaseTableNames._sjtable+"  WHERE "+String.join(",",returnKVString(map));
    }
    /*studentsPODelete*/
    public String deleteStudentslePOSql(StudentsPO studentsPO) {
        CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
        Map<String, Object> map = checkPOnotNullMap.getStudentsPOMap(studentsPO);
        return "DELETE FROM "+DatabaseTableNames._students+"  WHERE "+String.join(",",returnKVString(map));
    }
    /*stuqiandaoPODelete*/
    public String deleteStuqiandaolePOSql(StuqiandaoPO stuqiandaoPO) {
        CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
        Map<String, Object> map = checkPOnotNullMap.getStuqiandaoPOMap(stuqiandaoPO);
        return "DELETE FROM "+DatabaseTableNames._stuqiandao+"  WHERE "+String.join(",",returnKVString(map));
    }
    /*teachersPODelete*/
    public String deleteTeacherslePOSql(TeachersPO teachersPO) {
        CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
        Map<String, Object> map = checkPOnotNullMap.getTeachersPOMap(teachersPO);
        return "DELETE FROM "+DatabaseTableNames._teachers+"  WHERE "+String.join(",",returnKVString(map));
    }
    /*titablePODelete*/
    public String deleteTitablelePOSql(TitablePO titablePO) {
        CheckPOnotNullMap checkPOnotNullMap = new CheckPOnotNullMap();
        Map<String, Object> map = checkPOnotNullMap.getTitablePOMap(titablePO);
        return "DELETE FROM "+DatabaseTableNames._titable+"  WHERE "+String.join(",",returnKVString(map));
    }

}
