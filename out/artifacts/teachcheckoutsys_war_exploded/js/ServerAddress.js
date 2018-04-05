function ServerAddress()
{
	
}

//ServerAddress.hostServer="http://desktop-vurs4pm:8080/thisisexam/";
//ServerAddress.hostServer="http://192.168.1.102:8080/thisisexam/";

//ServerAddress.hostServer="http://thisisexam.applinzi.com/";
//ServerAddress.hostServer="http://127.0.0.1:8080/thisisexam/";
ServerAddress.hostServer="";

ServerAddress.otherHostServer="http://localhost:8080";

ServerAddress.StudentQiandao=ServerAddress.hostServer+"/qiandao";

//教师登陆
ServerAddress.TeacherLogin=ServerAddress.hostServer+"/TeachersLoginServlet";

//教师注册
ServerAddress.TeacherSign=ServerAddress.hostServer+"/TeachersSignServlet";

//教师登出
ServerAddress.Teacherlogout=ServerAddress.hostServer+"/TeachersLogoutServlet";

//教师信息修改
ServerAddress.TeacherInfoModify=ServerAddress.hostServer+"/TeachersInfoModifyServlet";

//教师修改密码
ServerAddress.TeachersChangePwd=ServerAddress.hostServer+"/TeachersChangePwd";

//搜索课程列表
ServerAddress.TeacherGetCourseList=ServerAddress.hostServer+"/TeacherGetCourseServlet";

//搜索所有学生信息
ServerAddress.GetAllStudentList=ServerAddress.hostServer+"/GetAllStudentList";

//更新学生信息
ServerAddress.StudentUpdate=ServerAddress.hostServer+"/StudentUpdateServlet";

//添加学生
ServerAddress.StudentAdd=ServerAddress.hostServer+"/StudentAddServlet";

//删除学生
ServerAddress.StudentDelete=ServerAddress.hostServer+"/StudentDeleteServlet";

//文件上传服务
ServerAddress.UploadFile=ServerAddress.hostServer+"/UploadFileServlet";

//文件上传服务
ServerAddress.UploadHandle=ServerAddress.hostServer+"/UploadHandle";

//读取Excel文件导入教师
ServerAddress.TeacherAddByExcel=ServerAddress.hostServer+"/TeacherAddByExcelServlet";

//管理员添加教师
ServerAddress.TeacherAdd=ServerAddress.hostServer+"/TeacherAddServlet";

//获取教师列表
ServerAddress.GetTeachersList=ServerAddress.hostServer+"/GetTeachersList";

//管理员删除老师
ServerAddress.TeachersDelete=ServerAddress.hostServer+"/TeachersDeleteServlet";

//设置管理员
ServerAddress.SetAdmin=ServerAddress.hostServer+"/SetAdminServlet";

//管理员获取课程表信息
ServerAddress.GetCoursesList=ServerAddress.hostServer+"/GetCoursesList";

//管理员删除课程
ServerAddress.CourseDlete=ServerAddress.hostServer+"/CourseDleteServlet";

//管理员添加课程
ServerAddress.CourseAdd=ServerAddress.hostServer+"/CourseAddServlet";

//教师-我的班级-显示班级
ServerAddress.GetClasstableList=ServerAddress.hostServer+"/GetClasstableList";

//教师-我的班级-添加班级
ServerAddress.ClassAdd=ServerAddress.hostServer+"/ClassAddServlet";

//教师-我的班级-查看班级
ServerAddress.ClassCheck=ServerAddress.hostServer+"/ClassCheckServlet";

//教师-我的班级-查看班级-删除
ServerAddress.ClassCheckDelete=ServerAddress.hostServer+"/ClassCheckDeleteServlet";

//教师-我的班级-查看班级-添加
ServerAddress.ClassCheckAdd=ServerAddress.hostServer+"/ClassCheckAddServlet";

//教师-添加试卷-添加
ServerAddress.SjAdd=ServerAddress.hostServer+"/SjAddServlet";

//教师-试卷管理-我的试卷
ServerAddress.GetMySjList=ServerAddress.hostServer+"/GetMySjList";

//教师-试卷管理-我的试卷
ServerAddress.SjAddByFile=ServerAddress.hostServer+"/SjAddByFileServlet";





/**
 * otherHostServer
 * @type {string}
 */
//OSS上传文件服务
ServerAddress.uploadFilesOSS=ServerAddress.otherHostServer+"/uploadFilesOSS";








