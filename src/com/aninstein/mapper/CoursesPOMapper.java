package com.aninstein.mapper;

import com.aninstein.bean.CoursesPO;

import java.util.List;

public interface CoursesPOMapper extends BaseMapper {
	
	List<CoursesPO> getSearchCoursesByStr(String str) throws Exception;

	int batchInsert(List<CoursesPO> coursesPOList) throws Exception;

	int batchDelete(List<CoursesPO> coursesPOList) throws Exception;

	boolean isExist(String index) throws Exception;

}
