package com.aninstein.service;

import com.aninstein.po.POIReact;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/21.
 */
public interface POIReadExcelService {

    Map<String, Object> readExcelByHttpUrl(String Url, Integer type, Integer beginRow) throws Exception;

    /**
     * 读excel文件
     * @param filePath//文件路径
     * @param type//文件分类
     * @return
     * @throws Exception
     */
    List<Object> readExcelByFilePath(String filePath,Integer type,Integer beginRow) throws Exception;

    /**
     * 读取excel2003-2007版本的文件
     * @param filePath
     * @param type
     * @return
     * @throws Exception
     */
    List<Object> readXls(String filePath,Integer type,Integer beginRow) throws Exception;

    /**
     * 读取excel2010版本的文件
     * @param filePath
     * @param type
     * @return
     * @throws Exception
     */
    List<Object> readXlsx(String filePath,Integer type,Integer beginRow) throws Exception;

    /**
     * 把从excel表格中读到的数据存入到数据库中
     * @param objectList
     * @param type
     * @return
     * @throws Exception
     */
    POIReact saveDataBaseByType(List<Object> objectList, Integer type)throws Exception;

}
