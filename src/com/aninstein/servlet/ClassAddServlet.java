package com.aninstein.servlet;

import com.aninstein.bean.ClasstablePO;
import com.aninstein.mapper.ClasstablePOMapper;
import com.aninstein.mapper.Impl.ClasstablePOMapperImpl;
import com.aninstein.mapper.Impl.StudentsPOMapperImpl;
import com.aninstein.mapper.StudentsPOMapper;
import com.aninstein.po.PageMsg;
import com.aninstein.tool.ListTool;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/2.
 */
@WebServlet("/ClassAddServlet")
public class ClassAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //用到的组件
        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();
        StudentsPOMapper studentsPOMapper=new StudentsPOMapperImpl();
        ClasstablePOMapper classtablePOMapper=new ClasstablePOMapperImpl();

        ClasstablePO classtablePO=new ClasstablePO();

        String chooseids = request.getParameter("chooseids");
        String classname = request.getParameter("classname");
        String major = request.getParameter("major");
        String subject = request.getParameter("subject");
        String teacherid = request.getParameter("teacherid");
        String teachername = request.getParameter("teachername");

        String[] chooseStuids=chooseids.split(",");

        if(classname.equals("")||major.equals("")||subject.equals("")){
            pageMsg.setPagePath("teacher_myclass.jsp");
            pageMsg.setPageMessage("输入内容不能为空！");
            pageMsg.setStatu("400");
            out.print(objectMapper.writeValueAsString(pageMsg));
        }else {
            try {
            classtablePO.setClassid("class"+new Date().getTime())
                    .setClassname(classname)
                    .setClasssubject(subject)
                    .setClassspedt(major)
                    .setClassnum(chooseStuids.length)
                    .setClassstu(ListTool.listToList(Arrays.asList(chooseStuids)))
                    .setClassteacher(teachername)
                    .setClassteacherid(teacherid);
                int statu=classtablePOMapper.insert(classtablePO);
                if(statu==200){
                    pageMsg.setPagePath("teacher_myclass.jsp");
                    pageMsg.setPageMessage("插入成功");
                    pageMsg.setStatu("200");
                }else{
                    pageMsg.setPagePath("teacher_myclass.jsp");
                    pageMsg.setPageMessage("插入失败");
                    pageMsg.setStatu("500");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                out.print(objectMapper.writeValueAsString(pageMsg));
            }
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
