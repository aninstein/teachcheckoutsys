package com.aninstein.bean;

import java.util.List;

public class StudentsPO {
    private Integer id;

    private String stuid;

    private String stuname;

    private String stuspedt;

    private String stulevel;

    private Integer stuage;

    private String stusex;

    private String stuclassid;

    private List<String> stucourses;
    
    /*students的字段名*/
    public static String _id="id";
    public static String _stuid="stuid";
    public static String _stuname="stuname";
    public static String _stuspedt="stuspedt";
    public static String _stulevel="stulevel";
    public static String _stuage="stuage";
    public static String _stusex="stusex";
    public static String _stuclassid="stuclassid";
    public static String _stucourses="stucourses";

    public Integer getId() {
        return id;
    }

    public StudentsPO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getStuid() {
        return stuid;
    }

    public StudentsPO setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
        return this;

    }

    public String getStuname() {
        return stuname;
    }

    public StudentsPO setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
        return this;

    }

    public String getStuspedt() {
        return stuspedt;
    }

    public StudentsPO setStuspedt(String stuspedt) {
        this.stuspedt = stuspedt == null ? null : stuspedt.trim();
        return this;

    }

    public String getStulevel() {
        return stulevel;
    }

    public StudentsPO setStulevel(String stulevel) {
        this.stulevel = stulevel == null ? null : stulevel.trim();
        return this;

    }

    public Integer getStuage() {
        return stuage;
    }

    public StudentsPO setStuage(Integer stuage) {
        this.stuage = stuage;
        return this;

    }

    public String getStusex() {
        return stusex;
    }

    public StudentsPO setStusex(String stusex) {
        this.stusex = stusex == null ? null : stusex.trim();
        return this;

    }

    public String getStuclassid() {
        return stuclassid;
    }

    public StudentsPO setStuclassid(String stuclassid) {
        this.stuclassid = stuclassid == null ? null : stuclassid.trim();
        return this;

    }

    public List<String> getStucourses() {
        return stucourses;
    }

    public StudentsPO setStucourses(List<String> stucourses) {
        this.stucourses = stucourses;
        return this;
    }


    @Override
    public String toString() {
        return "StudentsPO{" + "id=" + id + ", stuid='" + stuid + '\'' + ", stuname='" + stuname + '\'' + ", stuspedt='" + stuspedt + '\'' + ", stulevel='" + stulevel + '\'' + ", stuage=" + stuage + ", stusex='" + stusex + '\'' + ", stuclassid='" + stuclassid + '\'' + ", stucourses=" + stucourses + '}';
    }
}