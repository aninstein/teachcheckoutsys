package com.aninstein.dao;

import com.aninstein.tool.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/22.
 */
public class BaseDao {

    DBTool dbTool = new DBTool();

    public boolean verifyExist(String table,Map<String,Object> conditionMap) throws SQLException {
        SelectSql selectSql=new SelectSql();
        selectSql.setSelect("*")
                .setTable(table)
                .setCondition(String.join(" AND ",MapTool.returnSetStringByMap(conditionMap)));

        String sql=selectSql.getSelectSql();
        ResultSet resultSet=selectSql.execSelect(sql);
        if(resultSet.next()){
            return true;
        }
        return false;
    }

    public List<Object> selectAll(String table) throws SQLException {
        SelectSql selectSql=new SelectSql();
        GetTablePO getTablePO=new GetTablePO(table);

        String sql=selectSql.getSelectAllSql(table);
        ResultSet resultSet=selectSql.execSelect(sql);
        //如果查询结果大于0
        if(resultSet.next()) {
            String json = JsonTool.resultSetToJson(resultSet);
            return getTablePO.getThePOListByTableName(json);
        }
        return null;
    }


}
