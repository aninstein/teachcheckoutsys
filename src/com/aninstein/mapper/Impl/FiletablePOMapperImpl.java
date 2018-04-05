package com.aninstein.mapper.Impl;

import com.aninstein.bean.FiletablePO;
import com.aninstein.dao.FiletablePODao;
import com.aninstein.mapper.FiletablePOMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/28.
 */
public class FiletablePOMapperImpl implements FiletablePOMapper {

    FiletablePODao filetablePODao=new FiletablePODao();

    @Override
    public List<Object> selectAll() throws Exception {
        return null;
    }

    @Override
    public Object selectOne(Map condition) throws Exception {
        return null;
    }

    @Override
    public List<Object> select(Map condtion) throws Exception {
        return null;
    }

    @Override
    public List<Object> selectAllTable(String condtion) throws Exception {
        return null;
    }

    @Override
    public int insert(Object object) throws Exception {
        boolean isIn=filetablePODao.insert((FiletablePO)object);
        if(isIn){
            return 200;
        }else {
            return 500;
        }
    }

    @Override
    public int update(Object object, Map condition) throws Exception {
        return 0;
    }

    @Override
    public int delete(Object object) throws Exception {
        return 0;
    }

}
