package com.aninstein.bean;

import java.util.List;

public class CoursesPO {
    private Integer id;

    private String coursesid;

    private String coursesname;

    private List<String> coursesmajor;

    private Double coursesgrade;

    private String coursesteacher;

    private Integer coursesstunum;

    private String coursesplace;

    private String coursestime;

    public String coursesweek;
    
    /*courses的字段名*/
    public static String _id="id";
    public static String _coursesid="coursesid";
    public static String _coursesname="coursesname";
    public static String _coursesmajor="coursesmajor";
    public static String _coursesgrade="coursesgrade";
    public static String _coursesteacher="coursesteacher";
    public static String _coursesstunum="coursesstunum";
    public static String _coursesplace="coursesplace";
    public static String _coursestime="coursestime";
    public static String _coursesweek="coursesweek";

    public Integer getId() {
        return id;
    }

    public CoursesPO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCoursesid() {
        return coursesid;
    }

    public CoursesPO setCoursesid(String coursesid) {
        this.coursesid = coursesid;
        return this;
    }

    public String getCoursesname() {
        return coursesname;
    }

    public CoursesPO setCoursesname(String coursesname) {
        this.coursesname = coursesname;
        return this;
    }

    public List<String> getCoursesmajor() {
        return coursesmajor;
    }

    public CoursesPO setCoursesmajor(List<String> coursesmajor) {
        this.coursesmajor = coursesmajor;
        return this;
    }

    public Double getCoursesgrade() {
        return coursesgrade;
    }

    public CoursesPO setCoursesgrade(Double coursesgrade) {
        this.coursesgrade = coursesgrade;
        return this;
    }

    public String getCoursesteacher() {
        return coursesteacher;
    }

    public CoursesPO setCoursesteacher(String coursesteacher) {
        this.coursesteacher = coursesteacher;
        return this;
    }

    public Integer getCoursesstunum() {
        return coursesstunum;
    }

    public CoursesPO setCoursesstunum(Integer coursesstunum) {
        this.coursesstunum = coursesstunum;
        return this;
    }

    public String getCoursesplace() {
        return coursesplace;
    }

    public CoursesPO setCoursesplace(String coursesplace) {
        this.coursesplace = coursesplace;
        return this;
    }

    public String getCoursestime() {
        return coursestime;
    }

    public CoursesPO setCoursestime(String coursestime) {
        this.coursestime = coursestime;
        return this;
    }

    public String getCoursesweek() {
        return coursesweek;
    }

    public CoursesPO setCoursesweek(String coursesweek) {
        this.coursesweek = coursesweek;
        return this;
    }
}