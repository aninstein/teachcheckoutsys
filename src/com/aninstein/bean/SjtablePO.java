package com.aninstein.bean;

import java.util.List;

public class SjtablePO {
    private Integer id;

    private String sjid;

    private String sjname;

    private String sjauthor;

    private String sjtag;

    private String sjdescribe;

    private Integer sjtinum;

    private List<String> sjchecksum;

    private String sjcourseid;

    private String sjcoursechp;

    private Integer sjreplynum;

    private Double sjright;

    private String sjcreatetime;

    private List<QuestionPO> sjcontain;


    
    /*sjtable的字段名*/
    public static String _id="id";
    public static String _sjid="sjid";
    public static String _sjname="sjname";
    public static String _sjauthor="sjauthor";
    public static String _sjtag="sjtag";
    public static String _sjdescribe="sjdescribe";
    public static String _sjtinum="sjtinum";
    public static String _sjchecksum="sjchecksum";
    public static String _sjcourseid="sjcourseid";
    public static String _sjcoursechp="sjcoursechp";
    public static String _sjreplynum="sjreplynum";
    public static String _sjright="sjright";
    public static String _sjcreatetime="sjcreatetime";
    public static String _sjcontain="sjcontain";

    public Integer getId() {
        return id;
    }

    public SjtablePO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getSjid() {
        return sjid;
    }

    public SjtablePO setSjid(String sjid) {
        this.sjid = sjid;
        return this;
    }

    public String getSjname() {
        return sjname;
    }

    public SjtablePO setSjname(String sjname) {
        this.sjname = sjname;
        return this;
    }

    public String getSjauthor() {
        return sjauthor;
    }

    public SjtablePO setSjauthor(String sjauthor) {
        this.sjauthor = sjauthor;
        return this;
    }

    public String getSjtag() {
        return sjtag;
    }

    public SjtablePO setSjtag(String sjtag) {
        this.sjtag = sjtag;
        return this;
    }

    public String getSjdescribe() {
        return sjdescribe;
    }

    public SjtablePO setSjdescribe(String sjdescribe) {
        this.sjdescribe = sjdescribe;
        return this;
    }

    public Integer getSjtinum() {
        return sjtinum;
    }

    public SjtablePO setSjtinum(Integer sjtinum) {
        this.sjtinum = sjtinum;
        return this;
    }

    public List<String> getSjchecksum() {
        return sjchecksum;
    }

    public SjtablePO setSjchecksum(List<String> sjchecksum) {
        this.sjchecksum = sjchecksum;
        return this;
    }

    public String getSjcourseid() {
        return sjcourseid;
    }

    public SjtablePO setSjcourseid(String sjcourseid) {
        this.sjcourseid = sjcourseid;
        return this;
    }

    public String getSjcoursechp() {
        return sjcoursechp;
    }

    public SjtablePO setSjcoursechp(String sjcoursechp) {
        this.sjcoursechp = sjcoursechp;
        return this;
    }

    public Integer getSjreplynum() {
        return sjreplynum;
    }

    public SjtablePO setSjreplynum(Integer sjreplynum) {
        this.sjreplynum = sjreplynum;
        return this;
    }

    public Double getSjright() {
        return sjright;
    }

    public SjtablePO setSjright(Double sjright) {
        this.sjright = sjright;
        return this;
    }

    public String getSjcreatetime() {
        return sjcreatetime;
    }

    public SjtablePO setSjcreatetime(String sjcreatetime) {
        this.sjcreatetime = sjcreatetime;
        return this;
    }

    public List<QuestionPO> getSjcontain() {
        return sjcontain;
    }

    public SjtablePO setSjcontain(List<QuestionPO> sjcontain) {
        this.sjcontain = sjcontain;
        return this;
    }

    @Override
    public String toString() {
        return "SjtablePO{" + "id=" + id + ", sjid='" + sjid + '\'' + ", sjname='" + sjname + '\'' + ", sjauthor='" + sjauthor + '\'' + ", sjtag='" + sjtag + '\'' + ", sjdescribe='" + sjdescribe + '\'' + ", sjtinum=" + sjtinum + ", sjchecksum=" + sjchecksum + ", sjcourseid='" + sjcourseid + '\'' + ", sjcoursechp='" + sjcoursechp + '\'' + ", sjreplynum=" + sjreplynum + ", sjright=" + sjright + ", sjcreatetime='" + sjcreatetime + '\'' + ", sjcontain='" + sjcontain + '\'' + '}';
    }
}