package com.aninstein.mapper.Impl;

import com.aninstein.bean.StudentsPO;
import com.aninstein.dao.StudentsPODao;
import com.aninstein.mapper.StudentsPOMapper;
import com.aninstein.tool.DatabaseTableNames;
import com.aninstein.tool.MapTool;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/22.
 */
public class StudentsPOMapperImpl implements StudentsPOMapper {

    StudentsPODao studentsPODao=new StudentsPODao();

    @Override
    public boolean isExistStudent(String stuNo) throws Exception {
        Map<String,Object> map=MapTool.getOneConditionMap(StudentsPO._stuid,stuNo);
        return studentsPODao.verifyExist(DatabaseTableNames._students,map);
    }

    @Override
    public List<String> existStuid(List<StudentsPO> studentsPOList) throws Exception {
        String[] stuidS=new String[studentsPOList.size()];
        for (int i=0;i<studentsPOList.size();i++){
            stuidS[i]=studentsPOList.get(i).getStuid();
        }
        return studentsPODao.existStuid(stuidS);
    }

    @Override
    public List<StudentsPO> getAllStudent() throws Exception {
        return studentsPODao.selectAll();
    }

    @Override
    public List<StudentsPO> getStudent(String condition) throws Exception {
        return studentsPODao.selectByCondition(condition);
    }

    @Override
    public List<StudentsPO> getStudentByStuids(String[] stuids) throws Exception {
        return studentsPODao.selectByStuidList(Arrays.asList(stuids));
    }

    @Override
    public int updateStudent(StudentsPO studentsPO, Map<String, Object> condiMap) throws Exception {
        boolean isUp=studentsPODao.update(studentsPO,condiMap);
        if(isUp){
            return 200;
        }else {
            return 500;
        }
    }

    @Override
    public int insertStudent(StudentsPO studentsPO) throws Exception {

        boolean isIn=studentsPODao.insert(studentsPO);
        if(isIn){
            return 200;
        }else {
            return 500;
        }
    }

    @Override
    public int batchInsertStudent(List<StudentsPO> studentsPOList) throws Exception {
        boolean isIn=studentsPODao.batchInsert(studentsPOList);
        if(isIn){
            return 200;
        }else {
            return 500;
        }
    }

    @Override
    public int deletStudent(StudentsPO studentsPO) throws Exception {
        boolean isDe=studentsPODao.delete(studentsPO);
        if(isDe){
            return 200;
        }else {
            return 500;
        }
    }

    @Override
    public int batchDeletStudent(List<StudentsPO> studentsPOList) throws Exception {
        boolean isDel=studentsPODao.batchDelete(studentsPOList);
        if (isDel){
            return 200;
        }else {
            return 500;
        }
    }

}
