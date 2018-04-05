package com.aninstein.servlet;

import com.aninstein.bean.TeachersPO;
import com.aninstein.en.TeachersStatuEnum;
import com.aninstein.mapper.Impl.TeachersPOMapperImpl;
import com.aninstein.mapper.TeachersPOMapper;
import com.aninstein.po.PageMsg;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2017/11/25.
 */
@WebServlet("/GetTeachersList")
public class GetTeachersList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();
        TeachersPOMapper teachersPOMapper=new TeachersPOMapperImpl();

        String admin=request.getParameter("admin");
        String condition=request.getParameter("condition");

        if(Integer.parseInt(admin)!= TeachersStatuEnum.Admin.ordinal()){
            pageMsg.setPageMessage("您不是管理员，无权操作！");
            pageMsg.setStatu("409");
            pageMsg.setPagePath("teacher_index.jsp");
            out.print(objectMapper.writeValueAsString(pageMsg));
            request.getRequestDispatcher("teacher_index.jsp").forward(request,response);
        }else if(condition!=null && !condition.equals("") && !condition.equals("auditing")){
            try {
                List<TeachersPO> teachersPOList=teachersPOMapper.getTeachersByCondition(condition);
                System.out.println(objectMapper.writeValueAsString(teachersPOList));
                out.print(objectMapper.writeValueAsString(teachersPOList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(condition!=null && condition.equals("auditing")){
            List<TeachersPO> teachersPOList= null;
            try {
                teachersPOList = teachersPOMapper.getAuditingTeachers();
                System.out.println(objectMapper.writeValueAsString(teachersPOList));
                out.print(objectMapper.writeValueAsString(teachersPOList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {
                List<TeachersPO> teachersPOList=teachersPOMapper.getAllTeachers();
                System.out.println(objectMapper.writeValueAsString(teachersPOList));
                out.print(objectMapper.writeValueAsString(teachersPOList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
