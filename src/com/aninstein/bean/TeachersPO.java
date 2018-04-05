package com.aninstein.bean;

import java.util.List;

public class TeachersPO {
    private Integer id;
    private String teacherid;//教师编号
    private String teachername;//教师名称
    private String teacheremail;//教师邮箱
    private String teachertel;//教师电话
    private String teacherusername;//教师用户名
    private String teacherpwd;//教师密码
    private String teacherlevel;//教师等级
    private List<String> teachercourse;//教师任教课程 
    private List<String> teacherclass;//教师任教班级
    private Integer teachfilenumber;//上传文件数
    private Integer teachtinumber;//上传试题数目
    private Integer teacherstatu;//教师状态
    private Double longitude;//经度
    private Double latitude;//维度
    
    
    /**
     * 参数名-数据库字段名
     */
    /*teachers的字段名*/
    public static String _id="id";
    public static String _teacherid="teacherid";
    public static String _teachername="teachername";
    public static String _teacheremail="teacheremail";
    public static String _teachertel="teachertel";
    public static String _teacherusername="teacherusername";
    public static String _teacherpwd="teacherpwd";
    public static String _teacherlevel="teacherlevel";
    public static String _teacherstatu="teacherstatu";
    public static String _teachercourse="teachercourse";
    public static String _teacherclass="teacherclass";
    public static String _teachfilenumber="teachfilenumber";
    public static String _teachtinumber="teachtinumber";
    public static String _longitude="longitude";
    public static String _latitude="latitude";
    
    
    /**
     * get和set
     * @return
     */

	public Integer getId() {
		return id;
	}

	public TeachersPO setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getTeacherid() {
		return teacherid;
	}

	public TeachersPO setTeacherid(String teacherid) {
		this.teacherid = teacherid;
		return this;
	}

	public String getTeachername() {
		return teachername;
	}

	public TeachersPO setTeachername(String teachername) {
		this.teachername = teachername;
		return this;
	}

	public String getTeacheremail() {
		return teacheremail;
	}

	public TeachersPO setTeacheremail(String teacheremail) {
		this.teacheremail = teacheremail;
		return this;
	}

	public String getTeachertel() {
		return teachertel;
	}

	public TeachersPO setTeachertel(String teachertel) {
		this.teachertel = teachertel;
		return this;
	}

	public String getTeacherusername() {
		return teacherusername;
	}

	public TeachersPO setTeacherusername(String teacherusername) {
		this.teacherusername = teacherusername;
		return this;
	}

	public String getTeacherpwd() {
		return teacherpwd;
	}

	public TeachersPO setTeacherpwd(String teacherpwd) {
		this.teacherpwd = teacherpwd;
		return this;
	}

	public String getTeacherlevel() {
		return teacherlevel;
	}

	public TeachersPO setTeacherlevel(String teacherlevel) {
		this.teacherlevel = teacherlevel;
		return this;
	}

	public List<String> getTeachercourse() {
		return teachercourse;
	}

	public TeachersPO setTeachercourse(List<String> teachercourse) {
		this.teachercourse = teachercourse;
		return this;
	}

	public List<String> getTeacherclass() {
		return teacherclass;
	}

	public TeachersPO setTeacherclass(List<String> teacherclass) {
		this.teacherclass = teacherclass;
		return this;
	}

	public Integer getTeachfilenumber() {
		return teachfilenumber;
	}

	public TeachersPO setTeachfilenumber(Integer teachfilenumber) {
		this.teachfilenumber = teachfilenumber;
		return this;
	}

	public Integer getTeachtinumber() {
		return teachtinumber;
	}

	public TeachersPO setTeachtinumber(Integer teachtinumber) {
		this.teachtinumber = teachtinumber;
		return this;
	}

	public Integer getTeacherstatu() {
		return teacherstatu;
	}

	public TeachersPO setTeacherstatu(Integer teacherstatu) {
		this.teacherstatu = teacherstatu;
		return this;
	}

	public Double getLongitude() {
		return longitude;
	}

	public TeachersPO setLongitude(Double longitude) {
		this.longitude = longitude;
		return this;
	}

	public Double getLatitude() {
		return latitude;
	}

	public TeachersPO setLatitude(Double latitude) {
		this.latitude = latitude;
		return this;
	}
}