package com.aninstein.tool;

import com.aninstein.bean.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GetTablePO {

    private String tableName;

    DBTool dbTool = new DBTool();
    Connection connection = dbTool.getConnection();

    public GetTablePO() {
    }

    public GetTablePO(String tableName) {
        this.tableName = tableName;
    }

    public Object getNewPO() {
        if (this.tableName.equals("admintable")) {
            return new AdmintablePO();
        } else if (this.tableName.equals("classtable")) {
            return new ClasstablePO();
        } else if (this.tableName.equals("courses")) {
            return new CoursesPO();
        } else if (this.tableName.equals("sjtable")) {
            return new SjtablePO();
        } else if (this.tableName.equals("students")) {
            return new StudentsPO();
        } else if (this.tableName.equals("stuqiandao")) {
            return new StuqiandaoPO();
        } else if (this.tableName.equals("teachers")) {
            return new TeachersPO();
        } else if (this.tableName.equals("titable")) {
            return new TitablePO();
        }
        return null;
    }

    public Object getNewPOByTablename(String table) {
        if (table.equals("admintable")) {
            return new AdmintablePO();
        } else if (table.equals("classtable")) {
            return new ClasstablePO();
        } else if (table.equals("courses")) {
            return new CoursesPO();
        } else if (table.equals("sjtable")) {
            return new SjtablePO();
        } else if (table.equals("students")) {
            return new StudentsPO();
        } else if (table.equals("stuqiandao")) {
            return new StuqiandaoPO();
        } else if (table.equals("teachers")) {
            return new TeachersPO();
        } else if (table.equals("titable")) {
            return new TitablePO();
        }
        return null;
    }

    public Object getThePOByTableName(String json) {//确定只有一个返回值的用这个
        List<Object> listObject = getThePOListByTableName(json);
        if (listObject.size() == 1) {
            return listObject.get(0);
        }
        return new Exception("查询结果不唯一！");
    }

    public List<Object> getThePOListByTableName(String json) {//返回一个列表的
        ObjectMapper objectMapper = new ObjectMapper();
        /**
         *  AdminTablePO
         ClassTableTbPO
         CoursesPO
         SjTablePO
         StudentsPO
         StuQiandaoPO
         TeachersPO
         TiTablePO
         */
        try {
            if (this.tableName.equals("admintable")) {
                return objectMapper.readValue(json, new TypeReference<List<AdmintablePO>>() {
                });
            } else if (this.tableName.equals("classtable")) {
                return objectMapper.readValue(json, new TypeReference<List<ClasstablePO>>() {
                });
            } else if (this.tableName.equals("courses")) {
                return objectMapper.readValue(json, new TypeReference<List<CoursesPO>>() {
                });
            } else if (this.tableName.equals("sjtable")) {
                return objectMapper.readValue(json, new TypeReference<List<SjtablePO>>() {
                });
            } else if (this.tableName.equals("students")) {
                return objectMapper.readValue(json, new TypeReference<List<StudentsPO>>() {
                });
            } else if (this.tableName.equals("stuqiandao")) {
                return objectMapper.readValue(json, new TypeReference<List<StuqiandaoPO>>() {
                });
            } else if (this.tableName.equals("teachers")) {
                return objectMapper.readValue(json, new TypeReference<List<TeachersPO>>() {
                });
            } else if (this.tableName.equals("titable")) {
                return objectMapper.readValue(json, new TypeReference<List<TitablePO>>() {
                });
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public Object getTablePOBySql(String tableName, String sql) throws SQLException, JsonProcessingException {
        setTableName(tableName);//把表名赋值给成员变量
        //初始化所需工具

        //进行查表操作
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        String objectPoJson = JsonTool.resultSetToJson(resultSet);

        return getThePOByTableName(objectPoJson);
    }

    public List<Object> getTablePOListBySql(String tableName, String sql) throws SQLException, JsonProcessingException {
        setTableName(tableName);//把表名赋值给成员变量

        //初始化所需工具

        //进行查表操作
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        String objectPoJson = JsonTool.resultSetToJson(resultSet);

        return getThePOListByTableName(objectPoJson);
    }

    //把ListPO变成ListObjectS
    public static List<Object> POtoObjectList(List list){
        List<Object> objectList=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            objectList.add((Object)list.get(i));
        }
        return objectList;
    }

    /**
     * 一下是把ObjectList转为PO的函数
     */
    /* Object to admintablePO */
    public static List<AdmintablePO> objectToAdmintablePO(List<Object> objectList) {
        List<AdmintablePO> list=new ArrayList<>();
        for (Object object:objectList){
            list.add((AdmintablePO) object);
        }
        return list;
    }
    /* Object to classtablePO */
    public static List<ClasstablePO> objectToClasstablePO(List<Object> objectList) {
        List<ClasstablePO> list=new ArrayList<>();
        for (Object object:objectList){
            list.add((ClasstablePO) object);
        }
        return list;
    }
    /* Object to coursesPO */
    public static List<CoursesPO> objectToCoursesPO(List<Object> objectList) {
        List<CoursesPO> list=new ArrayList<>();
        for (Object object:objectList){
            list.add((CoursesPO) object);
        }
        return list;
    }
    /* Object to filetablePO */
    public static List<FiletablePO> objectToFiletablePO(List<Object> objectList) {
        List<FiletablePO> list=new ArrayList<>();
        for (Object object:objectList){
            list.add((FiletablePO) object);
        }
        return list;
    }
    /* Object to sjtablePO */
    public static List<SjtablePO> objectToSjtablePO(List<Object> objectList) {
        List<SjtablePO> list=new ArrayList<>();
        for (Object object:objectList){
            list.add((SjtablePO) object);
        }
        return list;
    }
    /* Object to studentsPO */
    public static List<StudentsPO> objectToStudentsPO(List<Object> objectList) {
        List<StudentsPO> list=new ArrayList<>();
        for (Object object:objectList){
            list.add((StudentsPO) object);
        }
        return list;
    }
    /* Object to stuqiandaoPO */
    public static List<StuqiandaoPO> objectToStuqiandaoPO(List<Object> objectList) {
        List<StuqiandaoPO> list=new ArrayList<>();
        for (Object object:objectList){
            list.add((StuqiandaoPO) object);
        }
        return list;
    }
    /* Object to teachersPO */
    public static List<TeachersPO> objectToTeachersPO(List<Object> objectList) {
        List<TeachersPO> list=new ArrayList<>();
        for (Object object:objectList){
            list.add((TeachersPO) object);
        }
        return list;
    }
    /* Object to titablePO */
    public static List<TitablePO> objectToTitablePO(List<Object> objectList) {
        List<TitablePO> list=new ArrayList<>();
        for (Object object:objectList){
            list.add((TitablePO) object);
        }
        return list;
    }



    /**
     * 以下是getting和setting
     *
     * @return
     */
    public String getTableName() {
        return tableName;
    }

    public GetTablePO setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }
}
