package com.aninstein.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/28.
 */
public interface BaseMapper {

    List<Object> selectAll() throws Exception;

    Object selectOne(Map condition)throws Exception;

    List<Object> select(Map condtion) throws Exception;

    List<Object> selectAllTable(String condtion) throws Exception;

    int insert(Object object) throws Exception;

    int update(Object object,Map condition) throws Exception;

    int delete(Object object) throws Exception;

}
