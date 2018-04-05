package com.aninstein.servlet;

import com.aninstein.bean.ClasstablePO;
import com.aninstein.en.TeachersStatuEnum;
import com.aninstein.mapper.ClasstablePOMapper;
import com.aninstein.mapper.Impl.ClasstablePOMapperImpl;
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
 * Created by Administrator on 2017/12/2.
 */
@WebServlet("/GetClasstableList")
public class GetClasstableList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //用到的组件
        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();
        ClasstablePOMapper classtablePOMapper=new ClasstablePOMapperImpl();

        String admin=request.getParameter("admin");
        String condition=request.getParameter("condition");

        if(Integer.parseInt(admin)< TeachersStatuEnum.Normal.ordinal()){
            pageMsg.setPageMessage("您的账号正在审核中！");
            pageMsg.setStatu("409");
            pageMsg.setPagePath("teacher_login.jsp");
            out.print(objectMapper.writeValueAsString(pageMsg));
            request.getRequestDispatcher("teacher_login.jsp").forward(request,response);
        }else if(condition!=null && !condition.equals("")){
            try {
                List<ClasstablePO> classtablePOList=classtablePOMapper.getClasstablePOByTeacher(condition);
                System.out.println(objectMapper.writeValueAsString(classtablePOList));
                out.print(objectMapper.writeValueAsString(classtablePOList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
