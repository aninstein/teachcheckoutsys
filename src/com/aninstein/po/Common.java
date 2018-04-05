package com.aninstein.po;

/**
 * Created by Administrator on 2017/11/21.
 */
public class Common {

    public static final String DOWNFILEPATH = "F:\\Git\\myGithublibrary\\teachcheckoutsys\\web\\WEB-INF\\down\\";//2003-2007
    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";//2003-2007
    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";//2010
    public static final String EMPTY = "";
    public static final String POINT = ".";
    public static final String LIB_PATH = "lib";
    public static final String NOT_EXCEL_FILE = " : Not the Excel file!";
    public static final String PROCESSING = "Processing...";
    public static final String Q_START="start";
    public static final String Q_END="end";

    public String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
