package com.aninstein.bean;

import java.util.List;

public class ClasstablePO {
    private Integer id;

    private String classid;

    private String classname;

    private String classspedt;

    private String classsubject;

    private String classteacher;

    private String classteacherid;

    private Integer classnum;

    private List<String> classstu;

    private String classtablename;
    
    /*classtable的字段名*/
    public static String _id="id";
    public static String _classid="classid";
    public static String _classname="classname";
    public static String _classspedt="classspedt";
    public static String _classnum="classnum";
    public static String _classstu="classstu";
    public static String _classtablename="classtablename";
    public static String _classsubject="classsubject";
    public static String _classteacher="classteacher";
    public static String _classteacherid="classteacherid";


    public Integer getId() {
        return id;
    }

    public ClasstablePO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getClassid() {
        return classid;
    }

    public ClasstablePO setClassid(String classid) {
        this.classid = classid;
        return this;
    }

    public String getClassname() {
        return classname;
    }

    public ClasstablePO setClassname(String classname) {
        this.classname = classname;
        return this;
    }

    public String getClassspedt() {
        return classspedt;
    }

    public ClasstablePO setClassspedt(String classspedt) {
        this.classspedt = classspedt;
        return this;
    }

    public String getClasssubject() {
        return classsubject;
    }

    public ClasstablePO setClasssubject(String classsubject) {
        this.classsubject = classsubject;
        return this;
    }

    public String getClassteacher() {
        return classteacher;
    }

    public ClasstablePO setClassteacher(String classteacher) {
        this.classteacher = classteacher;
        return this;
    }

    public Integer getClassnum() {
        return classnum;
    }

    public ClasstablePO setClassnum(Integer classnum) {
        this.classnum = classnum;
        return this;
    }

    public List<String> getClassstu() {
        return classstu;
    }

    public ClasstablePO setClassstu(List<String> classstu) {
        this.classstu = classstu;
        return this;
    }

    public String getClasstablename() {
        return classtablename;
    }

    public ClasstablePO setClasstablename(String classtablename) {
        this.classtablename = classtablename;
        return this;
    }

    public String getClassteacherid() {
        return classteacherid;
    }

    public ClasstablePO setClassteacherid(String classteacherid) {
        this.classteacherid = classteacherid;
        return this;
    }
}