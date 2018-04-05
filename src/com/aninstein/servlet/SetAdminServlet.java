package com.aninstein.servlet;

import com.aninstein.bean.TeachersPO;
import com.aninstein.en.TeachersStatuEnum;
import com.aninstein.mapper.Impl.TeachersPOMapperImpl;
import com.aninstein.mapper.TeachersPOMapper;
import com.aninstein.po.PageMsg;
import com.aninstein.tool.MapTool;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/25.
 */
@WebServlet("/SetAdminServlet")
public class SetAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();
        TeachersPOMapper teachersPOMapper=new TeachersPOMapperImpl();

        String pass=request.getParameter("pass");
        String teacherid=request.getParameter("teacherid");
        String admin=request.getParameter("admin");

        TeachersPO teachersPO=new TeachersPO();
        Map<String, Object> condiMap = MapTool.getOneConditionMap(TeachersPO._teacherid, teacherid);

        if(Integer.parseInt(admin)!= TeachersStatuEnum.Admin.ordinal()){
            pageMsg.setPageMessage("您不是管理员，无权操作！");
            pageMsg.setStatu("409");
            pageMsg.setPagePath("teacher_index.jsp");
            out.print(objectMapper.writeValueAsString(pageMsg));
            request.getRequestDispatcher("teacher_index.jsp").forward(request,response);
        }else {
            //通过审核
            if (pass != null && pass.equals("pass")) {
                teachersPO.setTeacherid(teacherid);
                teachersPO.setTeacherstatu(TeachersStatuEnum.Normal.ordinal());
                try {
                    int statu = teachersPOMapper.updateTeacher(teachersPO, condiMap);
                    if (statu == 200) {
                        pageMsg.setPageMessage("设置成功！");
                        pageMsg.setPagePath("admin_audit.jsp");
                        pageMsg.setStatu(statu + "");
                    } else {
                        pageMsg.setPageMessage("设置失败！");
                        pageMsg.setPagePath("admin_audit.jsp");
                        pageMsg.setStatu(statu + "");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {//设置管理员
                try {
                    if (teacherid != null && !teacherid.equals("")) {
                        teachersPO.setTeacherid(teacherid);

                        //如果已经是管理员的话就设置成不是管理员
                        TeachersPO thisteacher = teachersPOMapper.getTeacherInfo(teacherid);
                        if (thisteacher.getTeacherstatu() == TeachersStatuEnum.Admin.ordinal()) {
                            teachersPO.setTeacherstatu(TeachersStatuEnum.Normal.ordinal());
                        } else {
                            teachersPO.setTeacherstatu(TeachersStatuEnum.Admin.ordinal());
                        }

                        int statu = teachersPOMapper.updateTeacher(teachersPO, condiMap);
                        if (statu == 200) {
                            pageMsg.setPageMessage("设置成功！");
                            pageMsg.setPagePath("admin_teacher.jsp");
                            pageMsg.setStatu(statu + "");
                        } else {
                            pageMsg.setPageMessage("设置失败！");
                            pageMsg.setPagePath("admin_teacher.jsp");
                            pageMsg.setStatu(statu + "");
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    out.print(objectMapper.writeValueAsString(pageMsg));
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
