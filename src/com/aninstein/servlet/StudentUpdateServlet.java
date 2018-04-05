package com.aninstein.servlet;

import com.aninstein.bean.StudentsPO;
import com.aninstein.dao.StudentsPODao;
import com.aninstein.mapper.Impl.StudentsPOMapperImpl;
import com.aninstein.mapper.StudentsPOMapper;
import com.aninstein.po.PageMsg;
import com.aninstein.tool.MapTool;

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
@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        StudentsPOMapper studentsPOMapper=new StudentsPOMapperImpl();
        PageMsg pageMsg=new PageMsg();

        String id=request.getParameter("id");
        String stuname=request.getParameter("stuname");
        String stuid=request.getParameter("stuid");
        String stusex=request.getParameter("stusex");
        String stuage=request.getParameter("stuage");
        String stulevel=request.getParameter("stulevel");
        String stuspedt=request.getParameter("stuspedt");
        String stuclassid=request.getParameter("stuclassid");

        StudentsPO studentsPO=new StudentsPO();
        studentsPO.setStuname(stuname);
        studentsPO.setStuid(stuid);
        studentsPO.setStulevel(stulevel);
        studentsPO.setStuage(Integer.parseInt(stuage));
        studentsPO.setStusex(stusex);
        studentsPO.setStuspedt(stuspedt);
        studentsPO.setStuclassid(stuclassid);

        try {
            int statu=studentsPOMapper.updateStudent(studentsPO, MapTool.getOneConditionMap(StudentsPO._id,id));
            if(statu==200){
                out.print("200");
            }else {
                out.print("500");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
