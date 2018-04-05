package com.aninstein.dao;

import com.aninstein.bean.FiletablePO;
import com.aninstein.tool.InsertSql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public class FiletablePODao extends BaseDao {

    public boolean insert(FiletablePO filetablePO) throws SQLException {
        InsertSql insertSql=new InsertSql();
        String sql=insertSql.getInsertFiletablePOSql(filetablePO);
        int count=insertSql.execInsertBySql(sql);
        return count>0?true:false;
    }

    public boolean batchInsert(List<FiletablePO> filetablePOList) throws SQLException {
        InsertSql insertSql=new InsertSql();
        List<String> sqlList=new ArrayList<String>();
        for(FiletablePO filetablePO:filetablePOList){
            String sql=insertSql.getInsertFiletablePOSql(filetablePO);
            sqlList.add(sql);
        }
        int[] count=insertSql.execInsertByBatchSql(sqlList);

        //判断是否有没有插入不成功的,如果包含0，证明不成功，不包含才是成功的
        return Arrays.toString(count).contains("0")?false:true;
    }

}
