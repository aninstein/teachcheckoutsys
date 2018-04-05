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

/**
 * Created by Administrator on 2017/11/22.
 */
@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        StudentsPOMapper studentsPOMapper=new StudentsPOMapperImpl();
        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();

        String stulevel = request.getParameter("stulevel");
        String stuclass = request.getParameter("stuclass");
        String sex = request.getParameter("sex");
        String name = request.getParameter("name");
        String stumajor = request.getParameter("stumajor");
        String stuno = request.getParameter("stuno");
        String age = request.getParameter("age");

        try {
            if(studentsPOMapper.isExistStudent(stuno)){
                pageMsg.setPageMessage("插入学号已存在！");
                pageMsg.setStatu("415");
            }else {
                StudentsPO studentsPO=new StudentsPO();
                studentsPO.setStuname(name)
                        .setStuid(stuno)
                        .setStusex(sex)
                        .setStuage(Integer.parseInt(age))
                        .setStulevel(stulevel)
                        .setStuclassid(stuclass)
                        .setStuspedt(stumajor);

                int statu=studentsPOMapper.insertStudent(studentsPO);
                if(statu==200){
                    pageMsg.setPageMessage("插入成功");
                    pageMsg.setStatu("200");
                }else {
                    pageMsg.setPageMessage("插入失败");
                    pageMsg.setStatu("500");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            out.print(objectMapper.writeValueAsString(pageMsg));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
