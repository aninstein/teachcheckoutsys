package com.aninstein.servlet;

import com.aninstein.bean.TeachersPO;
import com.aninstein.dao.TeachersPODao;
import com.aninstein.en.TeachersStatuEnum;
import com.aninstein.mapper.Impl.TeachersPOMapperImpl;
import com.aninstein.po.PageMsg;
import com.aninstein.tool.ListTool;
import com.aninstein.tool.MapTool;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class TeachersInfoModifyServlet
 */
@WebServlet("/TeachersInfoModifyServlet")
public class TeachersInfoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachersInfoModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//用到的组件
		ListTool listTool=new ListTool();
		MapTool mapTool=new MapTool();
		TeachersPODao teachersPODao=new TeachersPODao();
		PageMsg pageMsg=new PageMsg();
		ObjectMapper objectMapper=new ObjectMapper();
		TeachersPOMapperImpl teachersPOMapper=new TeachersPOMapperImpl();

		HttpSession session=request.getSession();

		String id=request.getParameter("Id");
		String teacherId=request.getParameter("teacherId");
		String name=request.getParameter("name");
		String teachlevel=request.getParameter("teachlevel");
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String admin= request.getParameter("admin");

		//给PO赋值
		TeachersPO teachersPO=new TeachersPO();

		//课程列表获取到的是一个字符串数组
		String courseArray=request.getParameter("courseArray");
		List<String> courseList=null;
		if(courseArray!=null&&!courseArray.equals("")&&!courseArray.equals("无")) {
			courseList = listTool.arraysToList(courseArray.split(","));
			teachersPO.setTeachercourse(courseList);
		}

		teachersPO.setTeacherid(teacherId);
		teachersPO.setTeachername(name);
		teachersPO.setTeacheremail(email);
		teachersPO.setTeacherlevel(teachlevel);
		teachersPO.setTeacherusername(username);
		teachersPO.setTeachertel(tel);


		try {
			mapTool.setEqualTo(TeachersPO._id,id);
			boolean isupdate=teachersPODao.update(teachersPO,mapTool.getMap());
			if(isupdate){
				pageMsg.setPageMessage("修改成功!");
				pageMsg.setStatu("200");
				if(admin!=null&&Integer.parseInt(admin)== TeachersStatuEnum.Admin.ordinal()){
					pageMsg.setPagePath("admin_teacher.jsp");
				}else {
					pageMsg.setPagePath("teacher_info.jsp");
				}
				TeachersPO newTeachersPO = teachersPOMapper.getTeacherInfo(email);
				session.setAttribute("teacherInfo", newTeachersPO);
			}else {
				pageMsg.setPageMessage("修改失败!");
				pageMsg.setStatu("500");
				pageMsg.setPagePath("teacher_info.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			out.print(objectMapper.writeValueAsString(pageMsg));
		}

	}

}
