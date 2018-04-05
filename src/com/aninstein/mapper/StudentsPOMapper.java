package com.aninstein.mapper;

import com.aninstein.bean.StudentsPO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/22.
 */
public interface StudentsPOMapper {

    boolean isExistStudent(String stuNo) throws Exception;

    List<String> existStuid(List<StudentsPO> studentsPOList) throws Exception;

    List<StudentsPO> getAllStudent() throws Exception;

    List<StudentsPO> getStudent(String condition) throws Exception;

    List<StudentsPO> getStudentByStuids(String[] stuids) throws Exception;

    int updateStudent(StudentsPO studentsPO, Map<String,Object> condiMap) throws Exception;

    int insertStudent(StudentsPO studentsPO) throws Exception;

    int batchInsertStudent(List<StudentsPO> studentsPOList) throws Exception;

    int deletStudent(StudentsPO studentsPO) throws Exception;

    int batchDeletStudent(List<StudentsPO> studentsPOList) throws Exception;

}
