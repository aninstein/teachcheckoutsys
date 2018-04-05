package com.aninstein.mapper.Impl;

import com.aninstein.bean.SjtablePO;
import com.aninstein.dao.SjtablePODao;
import com.aninstein.mapper.SjtablePOMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/6.
 */
public class SjtablePOMapperImpl implements SjtablePOMapper {

    SjtablePODao sjtablePODao=new SjtablePODao();

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
        if(sjtablePODao.insert((SjtablePO)object)){
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
