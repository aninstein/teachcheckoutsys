package com.aninstein.service;

import com.aninstein.bean.SjtablePO;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/11.
 */
public interface ReadSjService {

    /**
     * 通过http链接读取excel
     * @param Url
     * @return
     * @throws Exception
     */
    Map<String, Object> readOneSjExcelByHttpUrl(String Url, int beginRow) throws Exception;

    /**
     * 读取试卷的excel
     * @param filePath
     * @return
     * @throws Exception
     */
    SjtablePO readOneSjExcel(String filePath,int beginRow )throws Exception;

    /**
     * 读取excel2003-2007版本的文件
     * @param filePath
     * @return
     * @throws Exception
     */
    SjtablePO readXlsSj(String filePath,int beginRow) throws Exception;

    /**
     * 读取excel2010版本的文件
     * @param filePath
     * @return
     * @throws Exception
     */
    SjtablePO readXlsxSj(String filePath,int beginRow) throws Exception;

}
