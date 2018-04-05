package com.aninstein.bean;

public class FiletablePO {

    private Integer id;

    private String fileid;

    private String filename;

    private String fileauthor;

    private String fileautorname;

    private String filesubject;

    private Integer filetype;

    private String fileurl;

    private String filepath;

    private Integer fileperson;

    private String fileupdate;


    /*filetable的字段名*/
    public static String _id="id";
    public static String _fileid="fileid";
    public static String _filename="filename";
    public static String _fileauthor="fileauthor";
    public static String _fileautorname="fileautorname";
    public static String _filesubject="filesubject";
    public static String _filetype="filetype";
    public static String _fileurl="fileurl";
    public static String _filepath="filepath";
    public static String _fileperson="fileperson";
    public static String _fileupdate="fileupdate";

    public Integer getId() {
        return id;
    }

    public FiletablePO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFileid() {
        return fileid;
    }

    public FiletablePO setFileid(String fileid) {
        this.fileid = fileid == null ? null : fileid.trim();
        return this;
    }

    public String getFilename() {
        return filename;
    }

    public FiletablePO setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
        return this;
    }

    public String getFileauthor() {
        return fileauthor;
    }

    public FiletablePO setFileauthor(String fileauthor) {
        this.fileauthor = fileauthor == null ? null : fileauthor.trim();
        return this;
    }

    public String getFileautorname() {
        return fileautorname;
    }

    public FiletablePO setFileautorname(String fileautorname) {
        this.fileautorname = fileautorname == null ? null : fileautorname.trim();
        return this;
    }

    public String getFilesubject() {
        return filesubject;
    }

    public FiletablePO setFilesubject(String filesubject) {
        this.filesubject = filesubject == null ? null : filesubject.trim();
        return this;
    }

    public String getFileurl() {
        return fileurl;
    }

    public FiletablePO setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
        return this;
    }

    public String getFilepath() {
        return filepath;
    }

    public FiletablePO setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
        return this;
    }

    public Integer getFileperson() {
        return fileperson;
    }

    public FiletablePO setFileperson(Integer fileperson) {
        this.fileperson = fileperson;
        return this;
    }

    public Integer getFiletype() {
        return filetype;
    }

    public FiletablePO setFiletype(Integer filetype) {
        this.filetype = filetype;
        return this;
    }

    public String getFileupdate() {
        return fileupdate;
    }

    public FiletablePO setFileupdate(String fileupdate) {
        this.fileupdate = fileupdate;
        return this;
    }

}