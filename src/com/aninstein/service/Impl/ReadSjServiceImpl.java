package com.aninstein.service.Impl;

import com.aninstein.bean.QuestionPO;
import com.aninstein.bean.SjtablePO;
import com.aninstein.po.Common;
import com.aninstein.po.POIUtil;
import com.aninstein.service.ReadSjService;
import com.aninstein.tool.HttpDownUtil;
import com.aninstein.tool.MapTool;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/11.
 */
public class ReadSjServiceImpl implements ReadSjService {

    public ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public Map<String, Object> readOneSjExcelByHttpUrl(String Url, int beginRow) throws Exception {
        //先把文件下载到本地，再读取
        Map<String ,Object> stringObjectMap=new HashMap<>();
        HttpDownUtil httpDownUtil=new HttpDownUtil();
        httpDownUtil.setUrl(Url)
                .setCasualPath()
                .setFileName(httpDownUtil.getFileNameByUrl())
                .download();

        String path=httpDownUtil.getPathAndFileName();
        stringObjectMap.put("sjtable",readOneSjExcel(path,beginRow));
        stringObjectMap.put("filePath",path);
        return stringObjectMap;
    }

    @Override
    public SjtablePO readOneSjExcel(String filePath, int beginRow) throws Exception {
        if (filePath == null || Common.EMPTY.equals(filePath)) {
            return null;
        } else {
            String postfix = POIUtil.getPostfix(filePath);
            if (!Common.EMPTY.equals(postfix)) {
                if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {//如果是excel2003-2007
                    return readXlsSj(filePath, beginRow);
                } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {//如果是excel2010
                    return readXlsxSj(filePath, beginRow);
                }
            } else {
                //不然返回文件不存在
                System.out.println(filePath + Common.NOT_EXCEL_FILE);
            }
        }
        return null;
    }

    @Override
    public SjtablePO readXlsSj(String filePath, int beginRow) throws Exception {
        //先把文件化成字符流
        InputStream is = new FileInputStream(filePath);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

        SjtablePO sjtablePO=new SjtablePO();

        //存储本页
        Map<String, Object> sheetMap = new HashMap<>();
        List<Map<String, Object>> questionList=new ArrayList<>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }

            //问题的表头数据
            List<HSSFCell> QuestionHeaderList = new ArrayList<>();
            boolean isQuestion=false;
            // 读一行,第beginRow行是表头，rowNum从beginRow+1开始是数据
            for (int rowNum = beginRow; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);//行数取一行行

                if(!hssfRow.getCell(0).getStringCellValue().equals(Common.Q_START)&&!isQuestion){//如果不在问题开始结束范围内，就取第一个和第二个
                    String key=hssfRow.getCell(1).getStringCellValue().trim();
                    String value=hssfRow.getCell(2).getStringCellValue().trim();
                    sheetMap.put(key,value);
                }else if (hssfRow.getCell(0).getStringCellValue().equals(Common.Q_END)){//表示问题结束,退出循环
                    isQuestion=false;
                    break;
                }else if(isQuestion){//在问题内的内容
                    if(QuestionHeaderList.size()>0){
                        Map<String, Object> map = new HashMap<>();
                        //选项列表
                        List<String> answers=new ArrayList<>();
                        for (int i = 0;hssfRow.getCell(i)!=null&&!hssfRow.getCell(i).getStringCellValue().equals("") ; i++) {
                            String key = QuestionHeaderList.get(i).getStringCellValue().trim();
                            String value = hssfRow.getCell(i).getStringCellValue().trim();
                            //把选项放进list中
                            if(key.equals(QuestionPO._answers)){
                                answers.add(value);
                                //更新list
                                map.put(key,answers);
                            }else {
                                //不然就以Key value形式存储
                                map.put(key,value);
                            }

                        }
                        questionList.add(map);//把当前问题存入问题列表
                    }
                } else {
                    isQuestion=true;//表示已经进入到问题列表里面
                    rowNum+=2;//行数加2,到达另外一个
                    hssfRow = hssfSheet.getRow(rowNum);
                    //把表头存进来
                    int numCell = 0;
                    while (hssfRow.getCell(numCell) != null) {
                        QuestionHeaderList.add(hssfRow.getCell(numCell));
                        numCell++;
                    }
                }
            }
        }
        sheetMap.put(SjtablePO._sjcontain,questionList);
        String json=objectMapper.writeValueAsString(sheetMap);
        System.out.println(json);
        return objectMapper.readValue(json,SjtablePO.class);
    }

    @Override
    public SjtablePO readXlsxSj(String filePath, int beginRow) throws Exception {
        //先把文件化成字符流
        InputStream is = new FileInputStream(filePath);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

        SjtablePO sjtablePO=new SjtablePO();

        //存储本页
        List<Map<String, Object>> sheetList = new ArrayList<>();
        //问题列表
        List<Map<String,Object>> questionList=new ArrayList<>();
        // 读本页
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }

            //表头数据
            List<XSSFCell> QuestionHeaderList = new ArrayList<>();
            boolean isQuestion=false;

            // 读一行,第beginRow行是表头，rowNum从beginRow+1开始是数据
            for (int rowNum = beginRow; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);//行数取一行行

                if(!xssfRow.getCell(0).getStringCellValue().equals(Common.Q_START)&&!isQuestion){//如果不在问题开始结束范围内，就取第一个和第二个
                    Map<String,Object> map= MapTool.getOneConditionMap(xssfRow.getCell(1).getStringCellValue(),xssfRow.getCell(2).getStringCellValue());
                    sheetList.add(map);
                }else if (xssfRow.getCell(0).getStringCellValue().equals(Common.Q_END)) {//表示问题结束
                    isQuestion = false;
                    break;
                } else if(isQuestion){//在问题内的内容
                    if(QuestionHeaderList.size()>0){
                        Map<String, Object> map = new HashMap<>();
                        List<String> answers=new ArrayList<>();
                        for (int i = 0;xssfRow.getCell(i)!=null&&!xssfRow.getCell(i).getStringCellValue().equals("") ; i++) {
                            String key = QuestionHeaderList.get(i).getStringCellValue().trim();
                            String value = xssfRow.getCell(i).getStringCellValue().trim();
                            //把选项放进list中
                            if(key.equals(QuestionPO._answers)){
                                answers.add(value);
                                //更新list
                                map.put(key,answers);
                            }else {
                                //不然就以Key value形式存储
                                map.put(key,value);
                            }
                        }
                        questionList.add(map);//把当前问题存入问题列表
                    }
                }else {
                    isQuestion=true;//表示已经进入到问题列表里面
                    rowNum+=2;//行数加2,到达另外一个
                    xssfRow = xssfSheet.getRow(rowNum);
                    //把表头存进来
                    int numCell = 0;
                    while (xssfRow.getCell(numCell) != null) {
                        QuestionHeaderList.add(xssfRow.getCell(numCell));
                        numCell++;
                    }
                }
            }
        }

        sheetList.add(MapTool.getOneConditionMap(SjtablePO._sjcontain,questionList));

        String json=MapTool.getJsonByListToMap(sheetList);
        System.out.println(json);
        return objectMapper.readValue(json,SjtablePO.class);
    }
}
