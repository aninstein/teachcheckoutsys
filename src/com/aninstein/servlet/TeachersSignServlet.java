package com.aninstein.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aninstein.mapper.Impl.TeachersPOMapperImpl;
import com.aninstein.po.PageMsg;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class TeachersSignServlet
 */
@WebServlet("/TeachersSignServlet")
public class TeachersSignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachersSignServlet() {
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
		
		String teacherId=request.getParameter("teacherId");
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		TeachersPOMapperImpl teachersPOMapperImpl=new TeachersPOMapperImpl();
		ObjectMapper objectMapper=new ObjectMapper();
		PageMsg pageMsg=new PageMsg();
		
		try {
			int statu=teachersPOMapperImpl.teachersSign(teacherId, username, email, password);
			if(statu==200){
				pageMsg.setPageMessage("注册成功，请登录！");
				pageMsg.setPagePath("teacher_login.jsp");
			}else if(statu==400){
				pageMsg.setPageMessage("注册失败！");
				pageMsg.setPagePath("teacher_sign.jsp");
			}else if(statu==415){
				pageMsg.setPageMessage("用户名或者邮箱已存在！");
				pageMsg.setPagePath("teacher_sign.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.print(objectMapper.writeValueAsString(pageMsg));
		}
		
	}

}
