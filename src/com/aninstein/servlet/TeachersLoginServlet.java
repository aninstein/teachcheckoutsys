package com.aninstein.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aninstein.bean.TeachersPO;
import com.aninstein.en.TeachersStatuEnum;
import com.aninstein.mapper.Impl.TeachersPOMapperImpl;
import com.aninstein.po.PageMsg;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class TeachersLoginServlet
 */
@WebServlet("/TeachersLoginServlet")
public class TeachersLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeachersLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//需要用到的组件
		TeachersPOMapperImpl teachersPOMapperImpl = new TeachersPOMapperImpl();
		PageMsg pageMsg=new PageMsg();
		ObjectMapper objectMapper=new ObjectMapper();

		HttpSession session = request.getSession();

		if (username == null || username.equals("")) {
			out.print("");
			request.getRequestDispatcher("teacher_login.jsp").forward(request, response);
		} else {

			try {
				int statu = teachersPOMapperImpl.teachersLogin(username, password);//如果验证正确会直接返回该教师的身份信息
				if (statu == TeachersStatuEnum.Normal.ordinal()) {
					TeachersPO teachersPO = teachersPOMapperImpl.getTeacherInfo(username);
					session.setAttribute("username", username);
					session.setAttribute("statu", statu);
					session.setAttribute("teacherInfo", teachersPO);
					pageMsg.setPageMessage("200");
					pageMsg.setPagePath("teacher_index.jsp");
					out.print(objectMapper.writeValueAsString(pageMsg));
				} else if (statu == TeachersStatuEnum.Admin.ordinal()) {
					TeachersPO teachersPO = teachersPOMapperImpl.getTeacherInfo(username);
					session.setAttribute("username", username);
					session.setAttribute("statu", statu);
					session.setAttribute("teacherInfo", teachersPO);
					pageMsg.setPageMessage("200");
					pageMsg.setPagePath("teacher_index.jsp");
				} else if (statu == 403) {
					pageMsg.setPagePath("teacher_login.jsp");
					pageMsg.setPageMessage("密码错误！");
				} else if (statu == 404) {
					pageMsg.setPagePath("teacher_login.jsp");
					pageMsg.setPageMessage("用户名错误！");
				} else if (statu == 409) {
					pageMsg.setPagePath("teacher_login.jsp");
					pageMsg.setPageMessage("您的账号正在审核中，请耐心等待！");
				} else {
					pageMsg.setPagePath("teacher_login.jsp");
					pageMsg.setPageMessage("服务器错误！");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				out.print(objectMapper.writeValueAsString(pageMsg));
			}
		}

	}

}
