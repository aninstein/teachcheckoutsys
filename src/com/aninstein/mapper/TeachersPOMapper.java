package com.aninstein.mapper;

import com.aninstein.bean.TeachersPO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TeachersPOMapper {
	
	int teachersLogin(String user, String pwd) throws Exception;
	
	int teachersSign(String teacherId, String user, String email, String pwd) throws Exception;
	
	int teachersUpdateInfo(TeachersPO teachersPO) throws Exception;

	int teachersChangePwd(Map<String,Object> conditionMap, String newpwd) throws Exception;
	
	TeachersPO getTeacherInfo(String user) throws Exception;

	List<TeachersPO> getAllTeachers() throws SQLException;

	List<TeachersPO> getAuditingTeachers() throws Exception;

	List<TeachersPO> getTeachersByCondition(String user) throws Exception;

	int insertTeacher(TeachersPO teachersPO) throws Exception;

	int teachersBatchInsert(List<TeachersPO> teachersPOList) throws Exception;

	boolean isExist(String user) throws Exception;

	int deleteTeachers(TeachersPO teachersPO) throws Exception;

	int batchDeleteTeachers(List<TeachersPO> teachersPOList) throws Exception;

	int updateTeacher(TeachersPO teachersPO,Map<String,Object> conditionMap) throws Exception;

	List<String> existId(List<TeachersPO> teachersPOList) throws Exception;
	
}
