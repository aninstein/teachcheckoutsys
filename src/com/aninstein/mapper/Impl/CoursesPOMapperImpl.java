package com.aninstein.mapper.Impl;

import com.aninstein.bean.CoursesPO;
import com.aninstein.dao.CoursesPODao;
import com.aninstein.mapper.CoursesPOMapper;
import com.aninstein.tool.DatabaseTableNames;
import com.aninstein.tool.GetTablePO;

import java.util.List;
import java.util.Map;

public class CoursesPOMapperImpl implements CoursesPOMapper {

	CoursesPODao coursesPODao=new CoursesPODao();

	@Override
	public List<CoursesPO> getSearchCoursesByStr(String str) throws Exception {
		return coursesPODao.selectCoursesPO(str);
	}

	@Override
	public List<Object> selectAll() throws Exception {
		return coursesPODao.selectAll(DatabaseTableNames._courses);
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
		return GetTablePO.POtoObjectList(coursesPODao.selectCoursesPO(condtion));
	}

	@Override
	public int insert(Object object) throws Exception {
		boolean isIn=coursesPODao.insert((CoursesPO)object);
		if(isIn){
			return 200;
		}else {
			return 500;
		}
	}

	@Override
	public int batchInsert(List<CoursesPO> coursesPOList) throws Exception {
		return 0;
	}

	@Override
	public int update(Object object, Map condition) throws Exception {
		return 0;
	}

	@Override
	public int delete(Object object) throws Exception {
		CoursesPO coursesPO=(CoursesPO)object;
		boolean isDel=coursesPODao.delete(coursesPO);
		if(isDel){
			return 200;
		}else {
			return 500;
		}
	}

	@Override
	public int batchDelete(List<CoursesPO> coursesPOList) throws Exception {
		boolean isDel=coursesPODao.batchDelete(coursesPOList);
		if(isDel){
			return 200;
		}else {
			return 500;
		}
	}

	@Override
	public boolean isExist(String index) throws Exception {
		return coursesPODao.verifyExist(index);
	}
}
