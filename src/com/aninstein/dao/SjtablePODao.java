package com.aninstein.dao;


import com.aninstein.bean.SjtablePO;
import com.aninstein.tool.DeleteSql;
import com.aninstein.tool.InsertSql;
import com.aninstein.tool.UpdateSql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/6.
 */
public class SjtablePODao extends BaseDao {


    public boolean update(SjtablePO sjtablePO, Map<String,Object> conditionMap) throws SQLException {
        UpdateSql updateSql =new UpdateSql();
        String sql=updateSql.getUpdateSjtablePOSql(sjtablePO,conditionMap);
        int count=updateSql.execUpdate(sql);
        return count>0?true:false;
    }

    public boolean insert(SjtablePO sjtablePO) throws SQLException {
        InsertSql insertSql=new InsertSql();
        String sql=insertSql.getInsertSjtablePOSql(sjtablePO);
        int count=insertSql.execInsertBySql(sql);
        return count>0?true:false;
    }

    public boolean batchInsert(List<SjtablePO> sjtablePOList) throws SQLException {
        InsertSql insertSql=new InsertSql();
        List<String> sqlList=new ArrayList<String>();
        for(SjtablePO sjtablePO:sjtablePOList){
            String sql=insertSql.getInsertSjtablePOSql(sjtablePO);
            sqlList.add(sql);
        }
        int[] count=insertSql.execInsertByBatchSql(sqlList);

        //判断是否有没有插入不成功的,如果包含0，证明不成功，不包含才是成功的
        return Arrays.toString(count).contains("0")?false:true;
    }

    public boolean delete(SjtablePO sjtablePO) throws SQLException {
        DeleteSql deleteSql=new DeleteSql();
        String sql=deleteSql.deleteSjtablelePOSql(sjtablePO);
        int count=deleteSql.execDelete(sql);
        return count>0?true:false;
    }

    public boolean batchDelete(List<SjtablePO> sjtablePOList) throws SQLException {
        DeleteSql deleteSql=new DeleteSql();
        List<String> sqlList=new ArrayList<String>();
        for (SjtablePO sjtablePO:sjtablePOList){
            String sql=deleteSql.deleteSjtablelePOSql(sjtablePO);
            sqlList.add(sql);
        }
        int[] count=deleteSql.execBatchDelete(sqlList);
        //判断是否有没有插入不成功的,如果包含0，证明不成功，不包含才是成功的
        return Arrays.toString(count).contains("0")?false:true;
    }

}
