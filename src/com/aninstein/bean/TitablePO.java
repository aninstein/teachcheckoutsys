package com.aninstein.bean;

public class TitablePO {
    private Integer id;

    private String tiid;

    private Integer tino;

    private Integer titype;

    private String tititle;

    private String ticontent;

    private String tianswer;

    private String timostanswer;

    private Double tiright;

    private String sjid;
    
    /*titable的字段名*/
    public static String _id="id";
    public static String _tiid="tiid";
    public static String _tino="tino";
    public static String _titype="titype";
    public static String _tititle="tititle";
    public static String _ticontent="ticontent";
    public static String _tianswer="tianswer";
    public static String _timostanswer="timostanswer";
    public static String _tiright="tiright";
    public static String _sjid="sjid";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTiid() {
        return tiid;
    }

    public void setTiid(String tiid) {
        this.tiid = tiid == null ? null : tiid.trim();
    }

    public Integer getTino() {
        return tino;
    }

    public void setTino(Integer tino) {
        this.tino = tino;
    }

    public Integer getTitype() {
        return titype;
    }

    public void setTitype(Integer titype) {
        this.titype = titype;
    }

    public String getTititle() {
        return tititle;
    }

    public void setTititle(String tititle) {
        this.tititle = tititle == null ? null : tititle.trim();
    }

    public String getTicontent() {
        return ticontent;
    }

    public void setTicontent(String ticontent) {
        this.ticontent = ticontent == null ? null : ticontent.trim();
    }

    public String getTianswer() {
        return tianswer;
    }

    public void setTianswer(String tianswer) {
        this.tianswer = tianswer == null ? null : tianswer.trim();
    }

    public String getTimostanswer() {
        return timostanswer;
    }

    public void setTimostanswer(String timostanswer) {
        this.timostanswer = timostanswer == null ? null : timostanswer.trim();
    }

    public Double getTiright() {
        return tiright;
    }

    public void setTiright(Double tiright) {
        this.tiright = tiright;
    }

    public String getSjid() {
        return sjid;
    }

    public void setSjid(String sjid) {
        this.sjid = sjid == null ? null : sjid.trim();
    }
}