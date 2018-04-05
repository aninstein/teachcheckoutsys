package com.aninstein.mapper.Impl;

import com.aninstein.bean.ClasstablePO;
import com.aninstein.dao.ClasstablePODao;
import com.aninstein.mapper.ClasstablePOMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/2.
 */
public class ClasstablePOMapperImpl implements ClasstablePOMapper {

    ClasstablePODao classtablePODao=new ClasstablePODao();

    @Override
    public List<Object> selectAll() throws Exception {
        return null;
    }

    @Override
    public Object selectOne(Map condition) throws Exception {
        return classtablePODao.selectClassByCondition(condition);
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
        ClasstablePO classtablePO=(ClasstablePO)object;
        boolean isIn=classtablePODao.insert(classtablePO);
        if(isIn){
            return 200;
        }else {
            return 500;
        }
    }

    @Override
    public int update(Object object, Map condition) throws Exception {
        boolean isUp=classtablePODao.update((ClasstablePO)object,condition);
        if(isUp){
            return 200;
        }else {
            return 500;
        }
    }

    @Override
    public int delete(Object object) throws Exception {
        return 0;
    }

    @Override
    public List<ClasstablePO> getClasstablePOByTeacher(String teacher) throws Exception {
        return classtablePODao.selectClassByTeacher(teacher);
    }
}
