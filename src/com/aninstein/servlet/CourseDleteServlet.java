package com.aninstein.servlet;

import com.aninstein.bean.CoursesPO;
import com.aninstein.mapper.CoursesPOMapper;
import com.aninstein.mapper.Impl.CoursesPOMapperImpl;
import com.aninstein.po.PageMsg;
import com.aninstein.tool.ListTool;
import com.aninstein.tool.MapTool;
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
 * Created by Administrator on 2017/11/29.
 */
@WebServlet("/CourseDleteServlet")
public class CourseDleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //用到的组件
        ListTool listTool=new ListTool();
        MapTool mapTool=new MapTool();
        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();
        CoursesPOMapper coursesPOMapper=new CoursesPOMapperImpl();

        String delid=request.getParameter("delid");
        String batch=request.getParameter("batch");

        if(delid==null&&delid.equals("")){
            pageMsg.setPageMessage("未选中任何项！");
            pageMsg.setPagePath("admin_teacher.jsp");
            pageMsg.setStatu("302");
            out.print(objectMapper.writeValueAsString(pageMsg));
            return;
//            request.getRequestDispatcher("admin_teacher.jsp").forward(request,response);
        }

        try {

            if (batch!=null && batch.equals("batch")) {
                List<CoursesPO> coursesPOList=new ArrayList<>();
                String[] delIds= delid.split(",");
                for(String theid:delIds){
                    coursesPOList.add(new CoursesPO().setCoursesid(theid));
                }
                int statu=coursesPOMapper.batchDelete(coursesPOList);
                if(statu==200) {
                    pageMsg.setStatu(statu+"");
                    pageMsg.setPagePath("admin_course.jsp");
                    pageMsg.setPageMessage("删除成功");
                }else {
                    pageMsg.setStatu(statu+"");
                    pageMsg.setPagePath("admin_course.jsp");
                    pageMsg.setPageMessage("删除失败");
                }
            } else {
                int statu=coursesPOMapper.delete(new CoursesPO().setCoursesid(delid));
                pageMsg.setStatu(statu+"");
                pageMsg.setPagePath("admin_course.jsp");
                pageMsg.setPageMessage("删除成功");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.print(objectMapper.writeValueAsString(pageMsg));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
