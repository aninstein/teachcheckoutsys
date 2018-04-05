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

/**
 * Created by Administrator on 2017/11/25.
 */
@WebServlet("/TeacherAddServlet")
public class TeacherAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();
        TeachersPOMapper teachersPOMapper=new TeachersPOMapperImpl();

        String teachlevel = request.getParameter("teachlevel").trim();
        String name = request.getParameter("name").trim();
        String tel = request.getParameter("tel").trim();
        String teacherNo = request.getParameter("teacherNo").trim();
        String email = request.getParameter("email").trim();
        String username = request.getParameter("username").trim();

        TeachersPO teachersPO=new TeachersPO();
        if(name.equals("")||teacherNo.equals("")||email.equals("")){
            pageMsg.setPageMessage("输入内容不能为空！");
            pageMsg.setStatu("400");
            out.print(objectMapper.writeValueAsString(pageMsg));
        }else {

            try {
                if (teachersPOMapper.isExist(email)) {
                    pageMsg.setPageMessage("插入的邮箱已经存在！");
                    pageMsg.setStatu("415");
                } else if (teachersPOMapper.isExist(teacherNo)) {
                    pageMsg.setPageMessage("插入的教师编号已经存在！");
                    pageMsg.setStatu("415");
                } else {
                    teachersPO.setTeachername(name).setTeacheremail(email).setTeacherlevel(teachlevel).setTeachertel(tel).setTeacherid(teacherNo).setTeacherusername(username).setTeacherpwd("123456")//初始密码是123456
                            .setTeacherstatu(TeachersStatuEnum.Normal.ordinal());

                    int statu = teachersPOMapper.insertTeacher(teachersPO);
                    if (statu == 200) {
                        pageMsg.setPageMessage("插入成功");
                        pageMsg.setStatu("200");
                    } else {
                        pageMsg.setPageMessage("插入失败");
                        pageMsg.setStatu("500");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(objectMapper.writeValueAsString(pageMsg));
                out.print(objectMapper.writeValueAsString(pageMsg));
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
