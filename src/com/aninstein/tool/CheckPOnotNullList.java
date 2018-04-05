package com.aninstein.tool;

import com.aninstein.bean.*;

import java.util.ArrayList;
import java.util.List;

public class CheckPOnotNullList {

	/*admintablePO字段列表*/
	public List<Object> getAdmintablePOColnameList(AdmintablePO admintablePO) {
		List<Object> colnameList=new ArrayList<Object>();

		if(admintablePO.getId()!=null){
			colnameList.add(AdmintablePO._id);
		}
		if(admintablePO.getAdminid()!=null){
			colnameList.add(AdmintablePO._adminid);
		}
		if(admintablePO.getAdminname()!=null){
			colnameList.add(AdmintablePO._adminname);
		}
		if(admintablePO.getAdmintel()!=null){
			colnameList.add(AdmintablePO._admintel);
		}
		if(admintablePO.getAdminemail()!=null){
			colnameList.add(AdmintablePO._adminemail);
		}
		if(admintablePO.getAdminusername()!=null){
			colnameList.add(AdmintablePO._adminusername);
		}
		if(admintablePO.getAdminpwd()!=null){
			colnameList.add(AdmintablePO._adminpwd);
		}
		if(admintablePO.getAdminposition()!=null){
			colnameList.add(AdmintablePO._adminposition);
		}
		return colnameList;
	}



	/*admintablePO值的表格*/
	public List<Object> getAdmintablePOValuesList(AdmintablePO admintablePO) {
		List<Object> valuesList = new ArrayList<>();

		if(admintablePO.getId()!=null){
			valuesList.add(admintablePO.getId());
		}
		if(admintablePO.getAdminid()!=null){
			valuesList.add(admintablePO.getAdminid());
		}
		if(admintablePO.getAdminname()!=null){
			valuesList.add(admintablePO.getAdminname());
		}
		if(admintablePO.getAdmintel()!=null){
			valuesList.add(admintablePO.getAdmintel());
		}
		if(admintablePO.getAdminemail()!=null){
			valuesList.add(admintablePO.getAdminemail());
		}
		if(admintablePO.getAdminusername()!=null){
			valuesList.add(admintablePO.getAdminusername());
		}
		if(admintablePO.getAdminpwd()!=null){
			valuesList.add(admintablePO.getAdminpwd());
		}
		if(admintablePO.getAdminposition()!=null){
			valuesList.add(admintablePO.getAdminposition());
		}
		return valuesList;
	}



	/*classtablePO字段列表*/
	public List<Object> getClasstablePOColnameList(ClasstablePO classtablePO) {
		List<Object> colnameList=new ArrayList<Object>();

		if(classtablePO.getId()!=null){
			colnameList.add(ClasstablePO._id);
		}
		if(classtablePO.getClassid()!=null){
			colnameList.add(ClasstablePO._classid);
		}
		if(classtablePO.getClassname()!=null){
			colnameList.add(ClasstablePO._classname);
		}
		if(classtablePO.getClassteacher()!=null){
			colnameList.add(ClasstablePO._classteacher);
		}
		if(classtablePO.getClassteacherid()!=null){
			colnameList.add(ClasstablePO._classteacherid);
		}
		if(classtablePO.getClasssubject()!=null){
			colnameList.add(ClasstablePO._classsubject);
		}
		if(classtablePO.getClassspedt()!=null){
			colnameList.add(ClasstablePO._classspedt);
		}
		if(classtablePO.getClassnum()!=null){
			colnameList.add(ClasstablePO._classnum);
		}
		if(classtablePO.getClassstu()!=null){
			colnameList.add(ClasstablePO._classstu);
		}
		if(classtablePO.getClasstablename()!=null){
			colnameList.add(ClasstablePO._classtablename);
		}
		return colnameList;
	}



	/*classtablePO值的表格*/
	public List<Object> getClasstablePOValuesList(ClasstablePO classtablePO) {
		List<Object> valuesList = new ArrayList<>();

		if(classtablePO.getId()!=null){
			valuesList.add(classtablePO.getId());
		}
		if(classtablePO.getClassid()!=null){
			valuesList.add(classtablePO.getClassid());
		}
		if(classtablePO.getClassname()!=null){
			valuesList.add(classtablePO.getClassname());
		}
		if(classtablePO.getClassteacher()!=null){
			valuesList.add(classtablePO.getClassteacher());
		}
		if(classtablePO.getClassteacherid()!=null){
			valuesList.add(classtablePO.getClassteacherid());
		}
		if(classtablePO.getClasssubject()!=null){
			valuesList.add(classtablePO.getClasssubject());
		}
		if(classtablePO.getClassspedt()!=null){
			valuesList.add(classtablePO.getClassspedt());
		}
		if(classtablePO.getClassnum()!=null){
			valuesList.add(classtablePO.getClassnum());
		}
		if(classtablePO.getClassstu()!=null){
			valuesList.add(classtablePO.getClassstu());
		}
		if(classtablePO.getClasstablename()!=null){
			valuesList.add(classtablePO.getClasstablename());
		}
		return valuesList;
	}



	/*coursesPO字段列表*/
	public List<Object> getCoursesPOColnameList(CoursesPO coursesPO) {
		List<Object> colnameList=new ArrayList<Object>();

		if(coursesPO.getId()!=null){
			colnameList.add(CoursesPO._id);
		}
		if(coursesPO.getCoursesid()!=null){
			colnameList.add(CoursesPO._coursesid);
		}
		if(coursesPO.getCoursesname()!=null){
			colnameList.add(CoursesPO._coursesname);
		}
		if(coursesPO.getCoursesmajor()!=null){
			colnameList.add(CoursesPO._coursesmajor);
		}
		if(coursesPO.getCoursesgrade()!=null){
			colnameList.add(CoursesPO._coursesgrade);
		}
		if(coursesPO.getCoursesteacher()!=null){
			colnameList.add(CoursesPO._coursesteacher);
		}
		if(coursesPO.getCoursesstunum()!=null){
			colnameList.add(CoursesPO._coursesstunum);
		}
		if(coursesPO.getCoursesplace()!=null){
			colnameList.add(CoursesPO._coursesplace);
		}
		if(coursesPO.getCoursesweek()!=null){
			colnameList.add(CoursesPO._coursesweek);
		}
		if(coursesPO.getCoursestime()!=null){
			colnameList.add(CoursesPO._coursestime);
		}
		return colnameList;
	}



	/*coursesPO值的表格*/
	public List<Object> getCoursesPOValuesList(CoursesPO coursesPO) {
		List<Object> valuesList = new ArrayList<>();

		if(coursesPO.getId()!=null){
			valuesList.add(coursesPO.getId());
		}
		if(coursesPO.getCoursesid()!=null){
			valuesList.add(coursesPO.getCoursesid());
		}
		if(coursesPO.getCoursesname()!=null){
			valuesList.add(coursesPO.getCoursesname());
		}
		if(coursesPO.getCoursesmajor()!=null){
			valuesList.add(coursesPO.getCoursesmajor());
		}
		if(coursesPO.getCoursesgrade()!=null){
			valuesList.add(coursesPO.getCoursesgrade());
		}
		if(coursesPO.getCoursesteacher()!=null){
			valuesList.add(coursesPO.getCoursesteacher());
		}
		if(coursesPO.getCoursesstunum()!=null){
			valuesList.add(coursesPO.getCoursesstunum());
		}
		if(coursesPO.getCoursesplace()!=null){
			valuesList.add(coursesPO.getCoursesplace());
		}
		if(coursesPO.getCoursesweek()!=null){
			valuesList.add(coursesPO.getCoursesweek());
		}
		if(coursesPO.getCoursestime()!=null){
			valuesList.add(coursesPO.getCoursestime());
		}
		return valuesList;
	}



	/*filetablePO字段列表*/
	public List<Object> getFiletablePOColnameList(FiletablePO filetablePO) {
		List<Object> colnameList=new ArrayList<Object>();

		if(filetablePO.getId()!=null){
			colnameList.add(FiletablePO._id);
		}
		if(filetablePO.getFileid()!=null){
			colnameList.add(FiletablePO._fileid);
		}
		if(filetablePO.getFilename()!=null){
			colnameList.add(FiletablePO._filename);
		}
		if(filetablePO.getFileauthor()!=null){
			colnameList.add(FiletablePO._fileauthor);
		}
		if(filetablePO.getFileautorname()!=null){
			colnameList.add(FiletablePO._fileautorname);
		}
		if(filetablePO.getFilesubject()!=null){
			colnameList.add(FiletablePO._filesubject);
		}
		if(filetablePO.getFiletype()!=null){
			colnameList.add(FiletablePO._filetype);
		}
		if(filetablePO.getFileurl()!=null){
			colnameList.add(FiletablePO._fileurl);
		}
		if(filetablePO.getFilepath()!=null){
			colnameList.add(FiletablePO._filepath);
		}
		if(filetablePO.getFileperson()!=null){
			colnameList.add(FiletablePO._fileperson);
		}
		if(filetablePO.getFileupdate()!=null){
			colnameList.add(FiletablePO._fileupdate);
		}
		return colnameList;
	}



	/*filetablePO值的表格*/
	public List<Object> getFiletablePOValuesList(FiletablePO filetablePO) {
		List<Object> valuesList = new ArrayList<>();

		if(filetablePO.getId()!=null){
			valuesList.add(filetablePO.getId());
		}
		if(filetablePO.getFileid()!=null){
			valuesList.add(filetablePO.getFileid());
		}
		if(filetablePO.getFilename()!=null){
			valuesList.add(filetablePO.getFilename());
		}
		if(filetablePO.getFileauthor()!=null){
			valuesList.add(filetablePO.getFileauthor());
		}
		if(filetablePO.getFileautorname()!=null){
			valuesList.add(filetablePO.getFileautorname());
		}
		if(filetablePO.getFilesubject()!=null){
			valuesList.add(filetablePO.getFilesubject());
		}
		if(filetablePO.getFiletype()!=null){
			valuesList.add(filetablePO.getFiletype());
		}
		if(filetablePO.getFileurl()!=null){
			valuesList.add(filetablePO.getFileurl());
		}
		if(filetablePO.getFilepath()!=null){
			valuesList.add(filetablePO.getFilepath());
		}
		if(filetablePO.getFileperson()!=null){
			valuesList.add(filetablePO.getFileperson());
		}
		if(filetablePO.getFileupdate()!=null){
			valuesList.add(filetablePO.getFileupdate());
		}
		return valuesList;
	}




	/*sjtablePO字段列表*/
	public List<Object> getSjtablePOColnameList(SjtablePO sjtablePO) {
		List<Object> colnameList=new ArrayList<Object>();

		if(sjtablePO.getId()!=null){
			colnameList.add(SjtablePO._id);
		}
		if(sjtablePO.getSjid()!=null){
			colnameList.add(SjtablePO._sjid);
		}
		if(sjtablePO.getSjname()!=null){
			colnameList.add(SjtablePO._sjname);
		}
		if(sjtablePO.getSjauthor()!=null){
			colnameList.add(SjtablePO._sjauthor);
		}
		if(sjtablePO.getSjtag()!=null){
			colnameList.add(SjtablePO._sjtag);
		}
		if(sjtablePO.getSjdescribe()!=null){
			colnameList.add(SjtablePO._sjdescribe);
		}
		if(sjtablePO.getSjtinum()!=null){
			colnameList.add(SjtablePO._sjtinum);
		}
		if(sjtablePO.getSjcontain()!=null){
			colnameList.add(SjtablePO._sjcontain);
		}
		if(sjtablePO.getSjchecksum()!=null){
			colnameList.add(SjtablePO._sjchecksum);
		}
		if(sjtablePO.getSjcourseid()!=null){
			colnameList.add(SjtablePO._sjcourseid);
		}
		if(sjtablePO.getSjcoursechp()!=null){
			colnameList.add(SjtablePO._sjcoursechp);
		}
		if(sjtablePO.getSjreplynum()!=null){
			colnameList.add(SjtablePO._sjreplynum);
		}
		if(sjtablePO.getSjright()!=null){
			colnameList.add(SjtablePO._sjright);
		}
		if(sjtablePO.getSjcreatetime()!=null){
			colnameList.add(SjtablePO._sjcreatetime);
		}
		return colnameList;
	}



	/*sjtablePO值的表格*/
	public List<Object> getSjtablePOValuesList(SjtablePO sjtablePO) {
		List<Object> valuesList = new ArrayList<>();

		if(sjtablePO.getId()!=null){
			valuesList.add(sjtablePO.getId());
		}
		if(sjtablePO.getSjid()!=null){
			valuesList.add(sjtablePO.getSjid());
		}
		if(sjtablePO.getSjname()!=null){
			valuesList.add(sjtablePO.getSjname());
		}
		if(sjtablePO.getSjauthor()!=null){
			valuesList.add(sjtablePO.getSjauthor());
		}
		if(sjtablePO.getSjtag()!=null){
			valuesList.add(sjtablePO.getSjtag());
		}
		if(sjtablePO.getSjdescribe()!=null){
			valuesList.add(sjtablePO.getSjdescribe());
		}
		if(sjtablePO.getSjtinum()!=null){
			valuesList.add(sjtablePO.getSjtinum());
		}
		if(sjtablePO.getSjcontain()!=null){
			valuesList.add(sjtablePO.getSjcontain());
		}
		if(sjtablePO.getSjchecksum()!=null){
			valuesList.add(sjtablePO.getSjchecksum());
		}
		if(sjtablePO.getSjcourseid()!=null){
			valuesList.add(sjtablePO.getSjcourseid());
		}
		if(sjtablePO.getSjcoursechp()!=null){
			valuesList.add(sjtablePO.getSjcoursechp());
		}
		if(sjtablePO.getSjreplynum()!=null){
			valuesList.add(sjtablePO.getSjreplynum());
		}
		if(sjtablePO.getSjright()!=null){
			valuesList.add(sjtablePO.getSjright());
		}
		if(sjtablePO.getSjcreatetime()!=null){
			valuesList.add(sjtablePO.getSjcreatetime());
		}
		return valuesList;
	}




	/*studentsPO字段列表*/
	public List<Object> getStudentsPOColnameList(StudentsPO studentsPO) {
		List<Object> colnameList=new ArrayList<Object>();

		if(studentsPO.getId()!=null){
			colnameList.add(StudentsPO._id);
		}
		if(studentsPO.getStuid()!=null){
			colnameList.add(StudentsPO._stuid);
		}
		if(studentsPO.getStuname()!=null){
			colnameList.add(StudentsPO._stuname);
		}
		if(studentsPO.getStuspedt()!=null){
			colnameList.add(StudentsPO._stuspedt);
		}
		if(studentsPO.getStulevel()!=null){
			colnameList.add(StudentsPO._stulevel);
		}
		if(studentsPO.getStuage()!=null){
			colnameList.add(StudentsPO._stuage);
		}
		if(studentsPO.getStusex()!=null){
			colnameList.add(StudentsPO._stusex);
		}
		if(studentsPO.getStuclassid()!=null){
			colnameList.add(StudentsPO._stuclassid);
		}
		if(studentsPO.getStucourses()!=null){
			colnameList.add(StudentsPO._stucourses);
		}
		return colnameList;
	}



	/*studentsPO值的表格*/
	public List<Object> getStudentsPOValuesList(StudentsPO studentsPO) {
		List<Object> valuesList = new ArrayList<>();

		if(studentsPO.getId()!=null){
			valuesList.add(studentsPO.getId());
		}
		if(studentsPO.getStuid()!=null){
			valuesList.add(studentsPO.getStuid());
		}
		if(studentsPO.getStuname()!=null){
			valuesList.add(studentsPO.getStuname());
		}
		if(studentsPO.getStuspedt()!=null){
			valuesList.add(studentsPO.getStuspedt());
		}
		if(studentsPO.getStulevel()!=null){
			valuesList.add(studentsPO.getStulevel());
		}
		if(studentsPO.getStuage()!=null){
			valuesList.add(studentsPO.getStuage());
		}
		if(studentsPO.getStusex()!=null){
			valuesList.add(studentsPO.getStusex());
		}
		if(studentsPO.getStuclassid()!=null){
			valuesList.add(studentsPO.getStuclassid());
		}
		if(studentsPO.getStucourses()!=null){
			valuesList.add(studentsPO.getStucourses());
		}
		return valuesList;
	}



	/*stuqiandaoPO字段列表*/
	public List<Object> getStuqiandaoPOColnameList(StuqiandaoPO stuqiandaoPO) {
		List<Object> colnameList=new ArrayList<Object>();

		if(stuqiandaoPO.getId()!=null){
			colnameList.add(StuqiandaoPO._id);
		}
		if(stuqiandaoPO.getStuid()!=null){
			colnameList.add(StuqiandaoPO._stuid);
		}
		if(stuqiandaoPO.getStuname()!=null){
			colnameList.add(StuqiandaoPO._stuname);
		}
		if(stuqiandaoPO.getCourseid()!=null){
			colnameList.add(StuqiandaoPO._courseid);
		}
		if(stuqiandaoPO.getTs()!=null){
			colnameList.add(StuqiandaoPO._ts);
		}
		if(stuqiandaoPO.getQichecksum()!=null){
			colnameList.add(StuqiandaoPO._qichecksum);
		}
		if(stuqiandaoPO.getQidate()!=null){
			colnameList.add(StuqiandaoPO._qidate);
		}
		if(stuqiandaoPO.getQitime()!=null){
			colnameList.add(StuqiandaoPO._qitime);
		}
		if(stuqiandaoPO.getQistatu()!=null){
			colnameList.add(StuqiandaoPO._qistatu);
		}
		if(stuqiandaoPO.getClassnum()!=null){
			colnameList.add(StuqiandaoPO._classnum);
		}
		return colnameList;
	}



	/*stuqiandaoPO值的表格*/
	public List<Object> getStuqiandaoPOValuesList(StuqiandaoPO stuqiandaoPO) {
		List<Object> valuesList = new ArrayList<>();

		if(stuqiandaoPO.getId()!=null){
			valuesList.add(stuqiandaoPO.getId());
		}
		if(stuqiandaoPO.getStuid()!=null){
			valuesList.add(stuqiandaoPO.getStuid());
		}
		if(stuqiandaoPO.getStuname()!=null){
			valuesList.add(stuqiandaoPO.getStuname());
		}
		if(stuqiandaoPO.getCourseid()!=null){
			valuesList.add(stuqiandaoPO.getCourseid());
		}
		if(stuqiandaoPO.getTs()!=null){
			valuesList.add(stuqiandaoPO.getTs());
		}
		if(stuqiandaoPO.getQichecksum()!=null){
			valuesList.add(stuqiandaoPO.getQichecksum());
		}
		if(stuqiandaoPO.getQidate()!=null){
			valuesList.add(stuqiandaoPO.getQidate());
		}
		if(stuqiandaoPO.getQitime()!=null){
			valuesList.add(stuqiandaoPO.getQitime());
		}
		if(stuqiandaoPO.getQistatu()!=null){
			valuesList.add(stuqiandaoPO.getQistatu());
		}
		if(stuqiandaoPO.getClassnum()!=null){
			valuesList.add(stuqiandaoPO.getClassnum());
		}
		return valuesList;
	}



	/*teachersPO字段列表*/
	public List<Object> getTeachersPOColnameList(TeachersPO teachersPO) {
		List<Object> colnameList=new ArrayList<Object>();

		if(teachersPO.getId()!=null){
			colnameList.add(TeachersPO._id);
		}
		if(teachersPO.getTeacherid()!=null){
			colnameList.add(TeachersPO._teacherid);
		}
		if(teachersPO.getTeachername()!=null){
			colnameList.add(TeachersPO._teachername);
		}
		if(teachersPO.getTeacheremail()!=null){
			colnameList.add(TeachersPO._teacheremail);
		}
		if(teachersPO.getTeachertel()!=null){
			colnameList.add(TeachersPO._teachertel);
		}
		if(teachersPO.getTeacherusername()!=null){
			colnameList.add(TeachersPO._teacherusername);
		}
		if(teachersPO.getTeacherpwd()!=null){
			colnameList.add(TeachersPO._teacherpwd);
		}
		if(teachersPO.getTeacherlevel()!=null){
			colnameList.add(TeachersPO._teacherlevel);
		}
		if(teachersPO.getTeacherstatu()!=null){
			colnameList.add(TeachersPO._teacherstatu);
		}
		if(teachersPO.getTeachercourse()!=null){
			colnameList.add(TeachersPO._teachercourse);
		}
		if(teachersPO.getTeacherclass()!=null){
			colnameList.add(TeachersPO._teacherclass);
		}
		if(teachersPO.getTeachfilenumber()!=null){
			colnameList.add(TeachersPO._teachfilenumber);
		}
		if(teachersPO.getTeachtinumber()!=null){
			colnameList.add(TeachersPO._teachtinumber);
		}
		if(teachersPO.getLongitude()!=null){
			colnameList.add(TeachersPO._longitude);
		}
		if(teachersPO.getLatitude()!=null){
			colnameList.add(TeachersPO._latitude);
		}
		return colnameList;
	}



	/*teachersPO值的表格*/
	public List<Object> getTeachersPOValuesList(TeachersPO teachersPO) {
		List<Object> valuesList = new ArrayList<>();

		if(teachersPO.getId()!=null){
			valuesList.add(teachersPO.getId());
		}
		if(teachersPO.getTeacherid()!=null){
			valuesList.add(teachersPO.getTeacherid());
		}
		if(teachersPO.getTeachername()!=null){
			valuesList.add(teachersPO.getTeachername());
		}
		if(teachersPO.getTeacheremail()!=null){
			valuesList.add(teachersPO.getTeacheremail());
		}
		if(teachersPO.getTeachertel()!=null){
			valuesList.add(teachersPO.getTeachertel());
		}
		if(teachersPO.getTeacherusername()!=null){
			valuesList.add(teachersPO.getTeacherusername());
		}
		if(teachersPO.getTeacherpwd()!=null){
			valuesList.add(teachersPO.getTeacherpwd());
		}
		if(teachersPO.getTeacherlevel()!=null){
			valuesList.add(teachersPO.getTeacherlevel());
		}
		if(teachersPO.getTeacherstatu()!=null){
			valuesList.add(teachersPO.getTeacherstatu());
		}
		if(teachersPO.getTeachercourse()!=null){
			valuesList.add(teachersPO.getTeachercourse());
		}
		if(teachersPO.getTeacherclass()!=null){
			valuesList.add(teachersPO.getTeacherclass());
		}
		if(teachersPO.getTeachfilenumber()!=null){
			valuesList.add(teachersPO.getTeachfilenumber());
		}
		if(teachersPO.getTeachtinumber()!=null){
			valuesList.add(teachersPO.getTeachtinumber());
		}
		if(teachersPO.getLongitude()!=null){
			valuesList.add(teachersPO.getLongitude());
		}
		if(teachersPO.getLatitude()!=null){
			valuesList.add(teachersPO.getLatitude());
		}
		return valuesList;
	}



	/*titablePO字段列表*/
	public List<Object> getTitablePOColnameList(TitablePO titablePO) {
		List<Object> colnameList=new ArrayList<Object>();

		if(titablePO.getId()!=null){
			colnameList.add(TitablePO._id);
		}
		if(titablePO.getTiid()!=null){
			colnameList.add(TitablePO._tiid);
		}
		if(titablePO.getTino()!=null){
			colnameList.add(TitablePO._tino);
		}
		if(titablePO.getTitype()!=null){
			colnameList.add(TitablePO._titype);
		}
		if(titablePO.getTititle()!=null){
			colnameList.add(TitablePO._tititle);
		}
		if(titablePO.getTicontent()!=null){
			colnameList.add(TitablePO._ticontent);
		}
		if(titablePO.getTianswer()!=null){
			colnameList.add(TitablePO._tianswer);
		}
		if(titablePO.getTimostanswer()!=null){
			colnameList.add(TitablePO._timostanswer);
		}
		if(titablePO.getTiright()!=null){
			colnameList.add(TitablePO._tiright);
		}
		if(titablePO.getSjid()!=null){
			colnameList.add(TitablePO._sjid);
		}
		return colnameList;
	}



	/*titablePO值的表格*/
	public List<Object> getTitablePOValuesList(TitablePO titablePO) {
		List<Object> valuesList = new ArrayList<>();

		if(titablePO.getId()!=null){
			valuesList.add(titablePO.getId());
		}
		if(titablePO.getTiid()!=null){
			valuesList.add(titablePO.getTiid());
		}
		if(titablePO.getTino()!=null){
			valuesList.add(titablePO.getTino());
		}
		if(titablePO.getTitype()!=null){
			valuesList.add(titablePO.getTitype());
		}
		if(titablePO.getTititle()!=null){
			valuesList.add(titablePO.getTititle());
		}
		if(titablePO.getTicontent()!=null){
			valuesList.add(titablePO.getTicontent());
		}
		if(titablePO.getTianswer()!=null){
			valuesList.add(titablePO.getTianswer());
		}
		if(titablePO.getTimostanswer()!=null){
			valuesList.add(titablePO.getTimostanswer());
		}
		if(titablePO.getTiright()!=null){
			valuesList.add(titablePO.getTiright());
		}
		if(titablePO.getSjid()!=null){
			valuesList.add(titablePO.getSjid());
		}
		return valuesList;
	}





}
