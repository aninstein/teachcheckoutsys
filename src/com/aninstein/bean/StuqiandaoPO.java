package com.aninstein.bean;

public class StuqiandaoPO {
    private Integer id;

    private String stuid;

    private String stuname;

    private String courseid;

    private Long ts;

    private String qichecksum;

    private String qidate;

    private String qitime;

    private Integer qistatu;

    private Integer classnum;
    
    /*stuqiandao的字段名*/
    public static String _id="id";
    public static String _stuid="stuid";
    public static String _stuname="stuname";
    public static String _courseid="courseid";
    public static String _ts="ts";
    public static String _qichecksum="qichecksum";
    public static String _qidate="qidate";
    public static String _qitime="qitime";
    public static String _qistatu="qistatu";
    public static String _classnum="classnum";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid == null ? null : stuid.trim();
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid == null ? null : courseid.trim();
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getQichecksum() {
        return qichecksum;
    }

    public void setQichecksum(String qichecksum) {
        this.qichecksum = qichecksum == null ? null : qichecksum.trim();
    }

    public String getQidate() {
        return qidate;
    }

    public void setQidate(String qidate) {
        this.qidate = qidate == null ? null : qidate.trim();
    }

    public String getQitime() {
        return qitime;
    }

    public void setQitime(String qitime) {
        this.qitime = qitime == null ? null : qitime.trim();
    }

    public Integer getQistatu() {
        return qistatu;
    }

    public void setQistatu(Integer qistatu) {
        this.qistatu = qistatu;
    }

    public Integer getClassnum() {
        return classnum;
    }

    public void setClassnum(Integer classnum) {
        this.classnum = classnum;
    }
}