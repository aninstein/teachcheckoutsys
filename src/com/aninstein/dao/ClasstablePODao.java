package com.aninstein.dao;

import com.aninstein.bean.ClasstablePO;
import com.aninstein.tool.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/21.
 */
public class ClasstablePODao extends BaseDao  {

    DBTool dbTool = new DBTool();

    public List<ClasstablePO> selectClassByTeacher(String teachers) throws Exception {
        SelectSql selectSql=new SelectSql();
        GetTablePO getTablePO=new GetTablePO(DatabaseTableNames._classtable);
        selectSql.setSelect("*")
                .setTable(DatabaseTableNames._classtable)
                .setCondition(ClasstablePO._classteacherid+"='"+teachers+"' OR "+ClasstablePO._classteacher+"='"+teachers+"'");
        String sql=selectSql.getSelectSql();
        ResultSet resultSet=selectSql.execSelect(sql);
        //如果查询结果大于0
        if(resultSet.next()) {
            String json = JsonTool.resultSetToJson(resultSet);
            List<Object> objectList = getTablePO.getThePOListByTableName(json);
            return GetTablePO.objectToClasstablePO(objectList);
        }
        return null;
    }

    public ClasstablePO selectClassByCondition(Map condition) throws Exception {
        SelectSql selectSql=new SelectSql();
        GetTablePO getTablePO=new GetTablePO(DatabaseTableNames._classtable);
        selectSql.setSelect("*")
                .setTable(DatabaseTableNames._classtable)
                .setConditionList(MapTool.returnSetStringByMap(condition));
        String sql=selectSql.getSelectSql();
        ResultSet resultSet=selectSql.execSelect(sql);
        //如果查询结果大于0
        if(resultSet.next()) {
            String json = JsonTool.resultSetToJson(resultSet);
            List<Object> objectList = getTablePO.getThePOListByTableName(json);
            if(objectList.size()==1){
                return (ClasstablePO)objectList.get(0);
            }
        }
        return null;
    }

    public boolean insert(ClasstablePO classtablePO) throws SQLException {
        InsertSql insertSql=new InsertSql();
        String sql=insertSql.getInsertClasstablePOSql(classtablePO);
        int count=insertSql.execInsertBySql(sql);
        return count>0?true:false;
    }

    public boolean update(ClasstablePO classtablePO, Map<String,Object> conditionMap) throws SQLException {
        UpdateSql updateSql =new UpdateSql();
        String sql=updateSql.getUpdateClasstablePOSql(classtablePO,conditionMap);
        int count=updateSql.execUpdate(sql);
        return count>0?true:false;
    }


}
