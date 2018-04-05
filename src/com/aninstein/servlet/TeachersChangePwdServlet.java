package com.aninstein.servlet;

import com.aninstein.bean.TeachersPO;
import com.aninstein.mapper.Impl.TeachersPOMapperImpl;
import com.aninstein.mapper.TeachersPOMapper;
import com.aninstein.po.PageMsg;
import com.aninstein.tool.MapTool;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/21.
 */
@WebServlet("/TeachersChangePwd")
public class TeachersChangePwdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();
        TeachersPOMapper teachersPOMapper=new TeachersPOMapperImpl();

        String orgpwd=request.getParameter("orgpassword");
        String newpwd=request.getParameter("newpassword");

        TeachersPO teachersPO=(TeachersPO)request.getSession().getAttribute("teacherInfo");
        if(teachersPO!=null && !orgpwd.equals(teachersPO.getTeacherpwd())){
            pageMsg.setPageMessage("密码错误！");
            pageMsg.setStatu("401");
        }else if(teachersPO!=null){
            Map<String,Object> condiMap= MapTool.getOneConditionMap(TeachersPO._id,teachersPO.getId());
            try {
                int statu=teachersPOMapper.teachersChangePwd(condiMap,newpwd);
                if(statu==200){
                    pageMsg.setPagePath("teacher_login.jsp");
                    pageMsg.setPageMessage("修改成功！请重新登陆！");
                    pageMsg.setStatu(""+statu);
                }else {
                    pageMsg.setPageMessage("修改失败！");
                    pageMsg.setStatu(""+statu);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                out.print(objectMapper.writeValueAsString(pageMsg));
            }
        }else {
            request.getRequestDispatcher("teacher_login.jsp").forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
