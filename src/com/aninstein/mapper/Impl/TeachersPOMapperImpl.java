package com.aninstein.mapper.Impl;

import com.aninstein.bean.TeachersPO;
import com.aninstein.dao.TeachersPODao;
import com.aninstein.en.TeachersStatuEnum;
import com.aninstein.mapper.TeachersPOMapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeachersPOMapperImpl implements TeachersPOMapper {

	TeachersPODao teachersPODao=new TeachersPODao();

	@Override
	public int teachersLogin(String user,String pwd) throws Exception {
		
		if(teachersPODao.verifyUser(user)){
			TeachersPO teachersPO=teachersPODao.selectTeachersPOByEmail(user);
			if(pwd.equals(teachersPO.getTeacherpwd())){
				if(teachersPO.getTeacherstatu()==TeachersStatuEnum.Normal.ordinal()||teachersPO.getTeacherstatu()==TeachersStatuEnum.Admin.ordinal()){
					return teachersPO.getTeacherstatu();//如果正确，直接返回该教师的身份
				}else{
					return 409;//未审核通过
				}
			}else{
				return 403;//密码错误
			}
		}else{
			return 404;//未找到该用户
		}
	}

	@Override
	public int teachersSign(String teacherId, String user,String email,String pwd) throws Exception{
		if(!teachersPODao.verifyUser(teacherId)&&!teachersPODao.verifyUser(user)&&!teachersPODao.verifyUser(email)){
			TeachersPO teachersPO=new TeachersPO();
			teachersPO.setTeacherid(teacherId);
			teachersPO.setTeacherusername(user);
			teachersPO.setTeacheremail(email);
			teachersPO.setTeacherpwd(pwd);
			teachersPO.setTeacherstatu(TeachersStatuEnum.Auditing.ordinal());
			boolean isInsert=teachersPODao.insert(teachersPO);
			if(isInsert){
				return 200;//成功
			} else {
				return 400;//插入失败
			}
		}else{
			return 415;//用户名冲突
		}
	}

	@Override
	public TeachersPO getTeacherInfo(String user) throws Exception{
		return teachersPODao.selectTeachersPOByEmail(user);
	}

	@Override
	public int teachersUpdateInfo(TeachersPO teachersPO) throws Exception{
		Map<String,Object> conditionMap =new HashMap<String, Object>();
		conditionMap.put(TeachersPO._teacherid, teachersPO.getTeacherid());
		
		//修改
		boolean updateOk=teachersPODao.update(teachersPO, conditionMap);
		if(updateOk){
			return 200;//成功
		}else{
			return 500;//出错
		}		
	}

	/**
	 * 改密码
	 * @return
	 * @throws Exception
	 */
	@Override
	public int teachersChangePwd(Map<String,Object> conditionMap,String newpwd) throws Exception {
		TeachersPO teachersPO=new TeachersPO();
		teachersPO.setTeacherpwd(newpwd);
		//修改
		boolean updateOk=teachersPODao.update(teachersPO, conditionMap);
		if(updateOk){
			return 200;//成功
		}else{
			return 500;//出错
		}

	}

	/**
	 * 获取数据库所有教师的列表
	 * @return
	 */
	@Override
	public List<TeachersPO> getAllTeachers() throws SQLException {
		return teachersPODao.selectAllTeachers();
	}

	@Override
	public List<TeachersPO> getAuditingTeachers() throws Exception {
		return teachersPODao.selectAuditingTeachers();
	}

	/**
	 * 搜索教师通过条件
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<TeachersPO> getTeachersByCondition(String user) throws Exception {
		return teachersPODao.selectTeachersByCondition(user);
	}

	/**
	 * 插入教师
	 * @param teachersPO
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insertTeacher(TeachersPO teachersPO) throws Exception {
		boolean isIn=teachersPODao.insert(teachersPO);
		if(isIn){
			return 200;
		}else {
			return 500;
		}
	}

	/**
	 * 批量插入
	 * @param teachersPOList
	 * @return
	 * @throws Exception
	 */
	@Override
	public int teachersBatchInsert(List<TeachersPO> teachersPOList) throws Exception {
		boolean isIn=teachersPODao.batchInsert(teachersPOList);
		if(isIn){
			return 200;
		}else {
			return 500;
		}
	}

	/**
	 * 检查是否存在
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean isExist(String user) throws Exception {
		return teachersPODao.verifyUser(user);
	}

	/**
	 * 删除教师表中的数据
	 * @param teachersPO
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteTeachers(TeachersPO teachersPO) throws Exception {
		boolean isDel=teachersPODao.delete(teachersPO);
		if(isDel){
			return 200;
		}else{
			return 500;
		}
	}

	@Override
	public int batchDeleteTeachers(List<TeachersPO> teachersPOList) throws Exception {
		boolean isDel=teachersPODao.batchDelete(teachersPOList);
		if (isDel){
			return 200;
		}else {
			return 500;
		}
	}

	@Override
	public int updateTeacher(TeachersPO teachersPO,Map<String,Object> conditionMap) throws Exception {
		boolean idUp=teachersPODao.update(teachersPO,conditionMap);
		if (idUp){
			return 200;
		}else {
			return 500;
		}
	}

	@Override
	public List<String> existId(List<TeachersPO> teachersPOList) throws Exception {
		String[] idS=new String[teachersPOList.size()];
		for (int i=0;i<teachersPOList.size();i++){
			idS[i]=teachersPOList.get(i).getTeacherid();
		}
		return teachersPODao.existId(idS);
	}

}
