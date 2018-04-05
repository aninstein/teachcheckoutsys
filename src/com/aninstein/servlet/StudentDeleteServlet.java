package com.aninstein.servlet;

import com.aninstein.bean.StudentsPO;
import com.aninstein.mapper.Impl.StudentsPOMapperImpl;
import com.aninstein.mapper.StudentsPOMapper;
import com.aninstein.po.PageMsg;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        StudentsPOMapper studentsPOMapper=new StudentsPOMapperImpl();
        ObjectMapper objectMapper=new ObjectMapper();
        PageMsg pageMsg=new PageMsg();

        String stuid=request.getParameter("stuid");
        String batch=request.getParameter("batch");

        if(stuid==null&&stuid.equals("")){
            request.getRequestDispatcher("admin_student.jsp").forward(request,response);
        }

        try {
            if (batch!=null && batch.equals("batch")) {
                List<StudentsPO> studentsPOList=new ArrayList<>();
                String[] stuidArr= stuid.split(",");
                for(String thestuid:stuidArr){
                    StudentsPO studentsPO=new StudentsPO();
                    studentsPO.setStuid(thestuid);
                    studentsPOList.add(studentsPO);
                }
                int statu=studentsPOMapper.batchDeletStudent(studentsPOList);
                pageMsg.setStatu(statu+"");
                pageMsg.setPagePath("admin_student.jsp");
                pageMsg.setPageMessage("删除成功");

            } else {
                StudentsPO studentsPO=new StudentsPO();
                studentsPO.setStuid(stuid);
                int statu = studentsPOMapper.deletStudent(studentsPO);
                pageMsg.setStatu(statu+"");
                pageMsg.setPagePath("admin_student.jsp");
                pageMsg.setPageMessage("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(objectMapper.writeValueAsString(pageMsg));
            out.print(objectMapper.writeValueAsString(pageMsg));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
