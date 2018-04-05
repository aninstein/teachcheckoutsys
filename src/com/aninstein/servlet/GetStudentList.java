package com.aninstein.servlet;

import com.aninstein.bean.StudentsPO;
import com.aninstein.en.TeachersStatuEnum;
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
import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */
@WebServlet("/GetAllStudentList")
public class GetStudentList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        PageMsg pageMsg=new PageMsg();
        StudentsPOMapper studentsPOMapper=new StudentsPOMapperImpl();
        ObjectMapper objectMapper=new ObjectMapper();

        String admin=request.getParameter("admin");
        String condition=request.getParameter("condition");
        String choosestuid=request.getParameter("choosestuid");

        if(Integer.parseInt(admin) < TeachersStatuEnum.Normal.ordinal()){
            pageMsg.setPageMessage("您的账号正在审核");
            pageMsg.setStatu("409");
            pageMsg.setPagePath("teacher_index.jsp");
            out.print(objectMapper.writeValueAsString(pageMsg));
            request.getRequestDispatcher("teacher_index.jsp").forward(request,response);
        }else if(condition!=null && !condition.equals("")&&!condition.equals("choosestuid")){
            try {
                List<StudentsPO> studentsPOList=studentsPOMapper.getStudent(condition);
                System.out.println(objectMapper.writeValueAsString(studentsPOList));
                out.print(objectMapper.writeValueAsString(studentsPOList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(condition!=null && condition.equals("choosestuid")&&choosestuid!=null){
            try {
                String[] stuids=choosestuid.split(",");
                List<StudentsPO> studentsPOList = studentsPOMapper.getStudentByStuids(stuids);
                System.out.println(objectMapper.writeValueAsString(studentsPOList));
                out.print(objectMapper.writeValueAsString(studentsPOList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {
                List<StudentsPO> studentsPOList=studentsPOMapper.getAllStudent();
                System.out.println(objectMapper.writeValueAsString(studentsPOList));
                out.print(objectMapper.writeValueAsString(studentsPOList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
