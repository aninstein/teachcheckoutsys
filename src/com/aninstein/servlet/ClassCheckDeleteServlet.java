package com.aninstein.servlet;

import com.aninstein.bean.ClasstablePO;
import com.aninstein.en.TeachersStatuEnum;
import com.aninstein.mapper.ClasstablePOMapper;
import com.aninstein.mapper.Impl.ClasstablePOMapperImpl;
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
import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
@WebServlet("/ClassCheckDeleteServlet")
public class ClassCheckDeleteServlet extends HttpServlet {
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
        String stuid=request.getParameter("stuid");
        String classid=request.getParameter("classid");

        if(Integer.parseInt(admin)< TeachersStatuEnum.Normal.ordinal()){
            pageMsg.setPageMessage("您的账号正在审核中！");
            pageMsg.setStatu("409");
            pageMsg.setPagePath("teacher_login.jsp");
            out.print(objectMapper.writeValueAsString(pageMsg));
            request.getRequestDispatcher("teacher_login.jsp").forward(request,response);
        }else if(classid!=null && !classid.equals("")){
            try {
                ClasstablePO classtablePO=(ClasstablePO)classtablePOMapper.selectOne(MapTool.getOneConditionMap(ClasstablePO._classid,classid));
                if(stuid!=null&&!stuid.equals("")){
                    List<String> stuidList= ListTool.deleteListEnity(classtablePO.getClassstu(),stuid);
                    classtablePO.setClassstu(stuidList);
                    classtablePO.setClassstu(ListTool.listToList(classtablePO.getClassstu()));
                    int statu=classtablePOMapper.update(classtablePO,MapTool.getOneConditionMap(ClasstablePO._classid,classid));
                    if(statu==200){
                        pageMsg.setPageMessage("删除成功！");
                        pageMsg.setStatu("200");
                        pageMsg.setPagePath("teacher_myclass_class.jsp");
                    }else {
                        pageMsg.setPageMessage("删除失败！");
                        pageMsg.setStatu("500");
                        pageMsg.setPagePath("teacher_myclass_class.jsp");
                    }
                }else {
                    pageMsg.setPageMessage("获取信息有误！");
                    pageMsg.setStatu("500");
                    pageMsg.setPagePath("teacher_myclass_class.jsp");
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
