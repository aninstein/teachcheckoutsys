package com.aninstein.servlet;

import com.aninstein.bean.CoursesPO;
import com.aninstein.mapper.CoursesPOMapper;
import com.aninstein.mapper.Impl.CoursesPOMapperImpl;
import com.aninstein.po.PageMsg;
import com.aninstein.po.ClassTime;
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

/**
 * Created by 慈祥的昌老师 on 2017/11/29.
 */
@WebServlet("/CourseAddServlet")
public class CourseAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //用到的组件
        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();
        CoursesPOMapper coursesPOMapper=new CoursesPOMapperImpl();

        String teacher = request.getParameter("teacher");
        String week = request.getParameter("week");
        String stunum = request.getParameter("stunum");
        String grade = request.getParameter("grade");
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String majorlist = request.getParameter("majorlist");
        String courseid = request.getParameter("courseid");
        String classtime = request.getParameter("classtime");

        CoursesPO coursesPO=new CoursesPO();

        if(teacher.equals("")||courseid.equals("")||classtime.equals("")){
            pageMsg.setPagePath("admin_course.jsp");
            pageMsg.setPageMessage("输入内容不能为空！");
            pageMsg.setStatu("400");
            out.print(objectMapper.writeValueAsString(pageMsg));
        }else {
            try {
                if(coursesPOMapper.isExist(courseid)){
                    pageMsg.setPagePath("admin_course.jsp");
                    pageMsg.setPageMessage("插入的邮箱已经存在！");
                    pageMsg.setStatu("415");
                }else {
                    coursesPO.setCoursesid(courseid)
                            .setCoursesname(name)
                            .setCoursesgrade(Double.parseDouble(grade))
                            .setCoursesteacher(teacher)
                            .setCoursesplace(location)
                            .setCoursesweek(ClassTime.getWeek(week))
                            .setCoursesstunum(Integer.parseInt(stunum))
                            .setCoursestime(ClassTime.getClassTime(week,classtime))
                            .setCoursesmajor(ListTool.listToList(Arrays.asList(majorlist.split(","))));
                    int statu = coursesPOMapper.insert(coursesPO);
                    if (statu == 200) {
                        pageMsg.setPagePath("admin_course.jsp");
                        pageMsg.setPageMessage("插入成功");
                        pageMsg.setStatu("200");
                    } else {
                        pageMsg.setPagePath("admin_course.jsp");
                        pageMsg.setPageMessage("插入失败");
                        pageMsg.setStatu("500");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                out.print(objectMapper.writeValueAsString(pageMsg));
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
