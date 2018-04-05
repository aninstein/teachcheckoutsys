package com.aninstein.bean;

public class AdmintablePO {
    private Integer id;

    private String adminid;

    private String adminname;

    private String admintel;

    private String adminemail;

    private String adminusername;

    private String adminpwd;

    private String adminposition;
    
    /*admintable的字段名*/
    public static String _id="id";
    public static String _adminid="adminid";
    public static String _adminname="adminname";
    public static String _admintel="admintel";
    public static String _adminemail="adminemail";
    public static String _adminusername="adminusername";
    public static String _adminpwd="adminpwd";
    public static String _adminposition="adminposition";
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid == null ? null : adminid.trim();
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getAdmintel() {
        return admintel;
    }

    public void setAdmintel(String admintel) {
        this.admintel = admintel == null ? null : admintel.trim();
    }

    public String getAdminemail() {
        return adminemail;
    }

    public void setAdminemail(String adminemail) {
        this.adminemail = adminemail == null ? null : adminemail.trim();
    }

    public String getAdminusername() {
        return adminusername;
    }

    public void setAdminusername(String adminusername) {
        this.adminusername = adminusername == null ? null : adminusername.trim();
    }

    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd == null ? null : adminpwd.trim();
    }

    public String getAdminposition() {
        return adminposition;
    }

    public void setAdminposition(String adminposition) {
        this.adminposition = adminposition == null ? null : adminposition.trim();
    }
}