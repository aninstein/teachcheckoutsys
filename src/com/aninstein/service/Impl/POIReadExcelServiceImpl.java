package com.aninstein.service.Impl;

import com.aninstein.bean.StudentsPO;
import com.aninstein.bean.TeachersPO;
import com.aninstein.dao.StudentsPODao;
import com.aninstein.dao.TeachersPODao;
import com.aninstein.en.ExcelTypeEnum;
import com.aninstein.mapper.Impl.StudentsPOMapperImpl;
import com.aninstein.mapper.Impl.TeachersPOMapperImpl;
import com.aninstein.mapper.StudentsPOMapper;
import com.aninstein.mapper.TeachersPOMapper;
import com.aninstein.po.Common;
import com.aninstein.po.POIReact;
import com.aninstein.po.POIUtil;
import com.aninstein.service.POIReadExcelService;
import com.aninstein.tool.*;
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
 * Created by Administrator on 2017/11/21.
 */
public class POIReadExcelServiceImpl implements POIReadExcelService {

    /**
     * 从Http链接中下载文件，然后再读取文件
     * @param Url
     * @param type
     * @param beginRow
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> readExcelByHttpUrl(String Url, Integer type, Integer beginRow) throws Exception {
        //先把文件下载到本地，再读取
        Map<String ,Object> stringObjectMap=new HashMap<>();
        HttpDownUtil httpDownUtil=new HttpDownUtil();
        httpDownUtil.setUrl(Url)
                .setCasualPath()
                .setFileName(httpDownUtil.getFileNameByUrl())
                .download();

        String path=httpDownUtil.getPathAndFileName();
        stringObjectMap.put("objectList",readExcelByFilePath(path, type,beginRow));
        stringObjectMap.put("filePath",path);
        return stringObjectMap;
    }

    /**
     * 读excel文件
     *
     * @param filePath//文件路径
     * @param type//文件分类
     * @return
     * @throws Exception
     */
    @Override
    public List<Object> readExcelByFilePath(String filePath, Integer type, Integer beginRow) throws Exception {

        if (filePath == null || Common.EMPTY.equals(filePath)) {
            return null;
        } else {
            String postfix = POIUtil.getPostfix(filePath);
            if (!Common.EMPTY.equals(postfix)) {
                if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {//如果是excel2003-2007
                    return readXls(filePath, type, beginRow);
                } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {//如果是excel2010
                    return readXlsx(filePath, type, beginRow);
                }
            } else {
                //不然返回文件不存在
                System.out.println(filePath + Common.NOT_EXCEL_FILE);
            }
        }
        return null;
    }

    /**
     * 读取excel2003-2007版本的文件
     *
     * @param filePath
     * @param type
     * @return
     * @throws Exception
     */
    @Override
    public List<Object> readXls(String filePath, Integer type, Integer beginRow) throws Exception {
//        System.out.println(Common.PROCESSING + filePath);
        InputStream is = new FileInputStream(filePath);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

        //存储本页
        List<Map<String, Object>> sheetList = new ArrayList<>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            //表头数据
            List<HSSFCell> cellHeaderList = new ArrayList<>();

            // 读一行,第beginRow行是表头，rowNum从beginRow+1开始是数据
            for (int rowNum = beginRow; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                // 表头一下的就是数据
                if (rowNum != beginRow && hssfRow != null) {
                    //表头数据大于0才行
                    if (cellHeaderList.size() > 0) {
                        //把数据存入list
                        Map<String, Object> map = new HashMap<>();
                        for (int i = 0; i < cellHeaderList.size(); i++) {
                            String key = cellHeaderList.get(i).getStringCellValue().trim();
                            String value = hssfRow.getCell(i).getStringCellValue().trim();
                            //不为空才插入
//                            if (!key.equals("") && !value.equals("")) {
                            map.put(key, value);
//                                numCell++;
//                            }
                        }
                        //每一个属性都有值才插入
//                        if (numCell == cellHeaderList.size()) {
                        sheetList.add(map);
//                        } else {
//                            System.out.println("第"+rowNum+"行数据有误！");
//                        }
                    } else {
                        System.out.println("没有表头！");
                    }
                } else {
                    //把表头存进来
                    int numCell = 0;
                    while (hssfRow.getCell(numCell) != null) {
                        cellHeaderList.add(hssfRow.getCell(numCell));
                        numCell++;
                    }
                }
            }
        }

        GetTablePO getTablePO = new GetTablePO(DatabaseTableNames.getPOtypeByType(type));
        String POjson = MapTool.getJsonByListToMap(sheetList);
        System.out.println(POjson);
        List<Object> objectList = getTablePO.getThePOListByTableName(POjson);
        return objectList;
    }

    /**
     * 读取excel2010版本的文件
     *
     * @param filePath
     * @param type
     * @return
     * @throws Exception
     */
    @Override
    public List<Object> readXlsx(String filePath, Integer type, Integer beginRow) throws Exception {
//        System.out.println(Common.PROCESSING + filePath);
        InputStream is = new FileInputStream(filePath);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);

        //存储本页
        List<Map<String, Object>> sheetList = new ArrayList<>();
        // 读本页
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            //表头数据
            List<XSSFCell> cellHeaderList = new ArrayList<>();
            // 读本一行,第beginRow行是表头，rowNum从beginRow+1开始是数据
            for (int rowNum = beginRow; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (rowNum != beginRow && xssfRow != null) {
                    if (cellHeaderList.size() > 0) {
                        //把数据存入list
                        Map<String, Object> map = new HashMap<>();
                        for (int i = 0; i < cellHeaderList.size(); i++) {
                            String key = cellHeaderList.get(i).getStringCellValue().trim();
                            String value = xssfRow.getCell(i).getStringCellValue().trim();
                            //不为空才插入
//                            if (!key.equals("") && !value.equals("")) {
                                map.put(key, value);
//                                numCell++;
//                            }
                        }
                        //每一个属性都有值才插入
//                        if (numCell == cellHeaderList.size()) {
                            sheetList.add(map);
//                        } else {
//                            System.out.println("第"+rowNum+"行数据有误！");
//                        }
                    } else {
                        System.out.println("没有表头！");
                    }

                } else {
                    //把表头存进来
                    int numCell = 0;
                    while (xssfRow.getCell(numCell) != null) {
                        cellHeaderList.add(xssfRow.getCell(numCell));
                        numCell++;
                    }
                }
            }
        }

        GetTablePO getTablePO = new GetTablePO(DatabaseTableNames.getPOtypeByType(type));
        String POjson = MapTool.getJsonByListToMap(sheetList);
        System.out.println(POjson);
        List<Object> objectList = getTablePO.getThePOListByTableName(POjson);
        return objectList;
    }

    /**
     * 功能未完成函数
     * @param objectList
     * @param type
     * @return
     * @throws Exception
     */
    @Override
    public POIReact saveDataBaseByType(List<Object> objectList, Integer type) throws Exception {

        POIReact poiReact=new POIReact();
        StudentsPODao studentsPODao=new StudentsPODao();
        TeachersPODao teachersPODao=new TeachersPODao();

        if(type==ExcelTypeEnum.classroom.ordinal()){

        }else if(type==ExcelTypeEnum.course.ordinal()){

        }else if(type==ExcelTypeEnum.sj.ordinal()){

        }else if(type==ExcelTypeEnum.student.ordinal()){
            StudentsPOMapper studentsPOMapper=new StudentsPOMapperImpl();

            //获取到列表里
            List<StudentsPO> studentsPOList= GetTablePO.objectToStudentsPO(objectList);
            //获取已经存在的id
            List<String> existIds=studentsPOMapper.existStuid(studentsPOList);

            //把已存在的同学用k-v的形式存在map里
            Map<String,Object> stringStudentsPOMap=new HashMap<>();
            if(existIds.size()>0){
                List<StudentsPO> existStudents=studentsPODao.selectByStuidList(existIds);
                for (int i=0;i<existIds.size();i++) {
                    stringStudentsPOMap.put(existIds.get(i),existStudents.get(i));
                }
                poiReact.setReturnMag(String.join(",",existIds));
            }
            //存到全局变量里
            POIReact.setMap(stringStudentsPOMap);

            //已经存在的人就不要再插入了
            List<StudentsPO> newstudentsPOList=new ArrayList<>();
            //遍历表中所有条目
            for(StudentsPO studentsPO:studentsPOList){
                if(!stringStudentsPOMap.containsKey(studentsPO.getStuid())){
                    //因为存入表格时候，List需要加上""
                    studentsPO.setStucourses(ListTool.listToList(studentsPO.getStucourses()));
                    newstudentsPOList.add(studentsPO);
                }
            }
            int isIns=studentsPOMapper.batchInsertStudent(newstudentsPOList);
            if(isIns==200){
                poiReact.setExistNum(existIds.size())
                        .setIsOkNum(newstudentsPOList.size())
                        .setStatu(200);
            }else {
                poiReact.setExistNum(existIds.size())
                        .setStatu(500);
            }

        }else if(type==ExcelTypeEnum.teacher.ordinal()){
            TeachersPOMapper teachersPOMapper=new TeachersPOMapperImpl();

            //获取excel信息到列表里
            List<TeachersPO> teachersPOList= GetTablePO.objectToTeachersPO(objectList);

            //获取已经存在的id
            List<String> existIds=teachersPOMapper.existId(teachersPOList);

            //把已存在的同学用k-v的形式存在map里
            Map<String,Object> stringStudentsPOMap=new HashMap<>();
            if(existIds.size()>0){
                List<TeachersPO> existTeachers=teachersPODao.selectByIdList(existIds);
                for (int i=0;i<existIds.size();i++) {
                    stringStudentsPOMap.put(existIds.get(i),existTeachers.get(i));
                }
                //把已经存在的id存到回传变量里面
                poiReact.setReturnMag(String.join(",",existIds));
            }
            //存到全局变量里
            POIReact.setMap(stringStudentsPOMap);

            List<TeachersPO> newteahcersPOList=new ArrayList<>();
            //遍历表中所有条目
            for(TeachersPO teachersPO:teachersPOList){
                if(!stringStudentsPOMap.containsKey(teachersPO.getTeacherid())){
                    teachersPO.setTeachercourse(ListTool.listToList(teachersPO.getTeachercourse()));
                    teachersPO.setTeacherclass(ListTool.listToList(teachersPO.getTeacherclass()));
                    newteahcersPOList.add(teachersPO);
                }
            }
            int isIns=teachersPOMapper.teachersBatchInsert(newteahcersPOList);
            if(isIns==200){
                poiReact.setExistNum(existIds.size())
                        .setIsOkNum(newteahcersPOList.size())
                        .setStatu(200);
            }else {
                poiReact.setExistNum(existIds.size())
                        .setStatu(500);
            }

        }else {

        }
        return poiReact;
    }
}
