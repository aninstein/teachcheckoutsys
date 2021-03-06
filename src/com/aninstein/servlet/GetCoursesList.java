package com.aninstein.servlet;

import com.aninstein.bean.CoursesPO;
import com.aninstein.en.TeachersStatuEnum;
import com.aninstein.mapper.CoursesPOMapper;
import com.aninstein.mapper.Impl.CoursesPOMapperImpl;
import com.aninstein.po.PageMsg;
import com.aninstein.tool.GetTablePO;
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
 * Created by Administrator on 2017/11/29.
 */
@WebServlet("/GetCoursesList")
public class GetCoursesList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //用到的组件
        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();
        CoursesPOMapper coursesPOMapper=new CoursesPOMapperImpl();

        String admin=request.getParameter("admin");
        String condition=request.getParameter("condition");

        if(Integer.parseInt(admin)!= TeachersStatuEnum.Admin.ordinal()){
            pageMsg.setPageMessage("您不是管理员，无权操作！");
            pageMsg.setStatu("409");
            pageMsg.setPagePath("teacher_index.jsp");
            out.print(objectMapper.writeValueAsString(pageMsg));
            request.getRequestDispatcher("teacher_index.jsp").forward(request,response);
        }else if(condition!=null && !condition.equals("")){
            try {
                List<Object> objectList=coursesPOMapper.selectAllTable(condition);
                List<CoursesPO> coursesPOList= GetTablePO.objectToCoursesPO(objectList);
                System.out.println(objectMapper.writeValueAsString(coursesPOList));
                out.print(objectMapper.writeValueAsString(coursesPOList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {

                List<Object> objectList=coursesPOMapper.selectAll();
                List<CoursesPO> coursesPOList= GetTablePO.objectToCoursesPO(objectList);
                System.out.println(objectMapper.writeValueAsString(coursesPOList));
                out.print(objectMapper.writeValueAsString(coursesPOList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
