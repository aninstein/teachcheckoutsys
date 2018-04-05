package com.aninstein.mapper;

import com.aninstein.bean.ClasstablePO;

import java.util.List;

/**
 * Created by Administrator on 2017/12/2.
 */
public interface ClasstablePOMapper extends BaseMapper{

    List<ClasstablePO> getClasstablePOByTeacher(String teacher)throws Exception;

}
