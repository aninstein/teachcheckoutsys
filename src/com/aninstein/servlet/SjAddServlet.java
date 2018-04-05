package com.aninstein.servlet;

import com.aninstein.bean.QuestionPO;
import com.aninstein.bean.SjtablePO;
import com.aninstein.bean.TeachersPO;
import com.aninstein.mapper.Impl.SjtablePOMapperImpl;
import com.aninstein.mapper.Impl.TeachersPOMapperImpl;
import com.aninstein.mapper.SjtablePOMapper;
import com.aninstein.mapper.TeachersPOMapper;
import com.aninstein.po.PageMsg;
import com.aninstein.tool.ListTool;
import com.aninstein.tool.MapTool;
import com.aninstein.tool.UtilService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/12/6.
 */
@WebServlet("/SjAddServlet")
public class SjAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //用到的组件
        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-DD");
        SjtablePOMapper sjtablePOMapper=new SjtablePOMapperImpl();
        TeachersPOMapper teachersPOMapper=new TeachersPOMapperImpl();

        SjtablePO sjtablePO=new SjtablePO();

        String sjsubject = request.getParameter("sjsubject");
        String sjname = request.getParameter("sjname");
        String sjtag = request.getParameter("sjtag");
        String sjsubjectchp = request.getParameter("sjsubjectchp");
        String questions = request.getParameter("questions");
        String sjdecri = request.getParameter("sjdecri");
        String sjtinum=request.getParameter("sjtinum");
        String teacherid = request.getParameter("teacherid");
        String teachername = request.getParameter("teachername");

        List<String> defChecksum=new ArrayList<>();
        defChecksum.add("0000");//默认校验和

        List<QuestionPO> questionPOList=objectMapper.readValue(questions, new TypeReference<List<QuestionPO>>() {
        });

        //获取当前老师
        TeachersPO teachersPO=null;
        try {
            teachersPO=teachersPOMapper.getTeacherInfo(teacherid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(UtilService.isNullOrEmpty(sjsubject)||
                UtilService.isNullOrEmpty(sjname)||
                UtilService.isNullOrEmpty(sjtag)||
                UtilService.isNullOrEmpty(sjsubjectchp)||
                UtilService.isNullOrEmpty(sjdecri)||
                UtilService.isNullOrEmpty(questions)){
            pageMsg.setPageMessage("信息不完全！");
            pageMsg.setPagePath("teacher_sj.jsp");
            pageMsg.setStatu("405");
        }else {
            try {
                sjtablePO.setSjauthor(teacherid)//作者
                        .setSjdescribe(sjdecri)//描述
                        .setSjcoursechp(sjsubjectchp)//课程章节
                        .setSjid("sj"+new Date().getTime())//试卷id
                        .setSjcourseid(sjsubject)//试卷课程id
                        .setSjname(sjname)//试卷命
                        .setSjcontain(questionPOList)//试卷json内容
                        .setSjchecksum(ListTool.listToList(defChecksum))//校验和
                        .setSjtag(sjtag)//试卷标签
                        .setSjtinum(Integer.parseInt(sjtinum))//题目数量
                        .setSjcreatetime(simpleDateFormat.format(new Date()));
                int statu=sjtablePOMapper.insert(sjtablePO);
                if(statu==200){
                    //更新一下老师的发布题目数量
                    teachersPO.setTeachtinumber(teachersPO.getTeachtinumber()+1);
                    teachersPOMapper.updateTeacher(teachersPO, MapTool.getOneConditionMap(TeachersPO._teacherid,teacherid));


                    pageMsg.setPageMessage("添加成功，可以在发布页面发布试卷！");
                    pageMsg.setPagePath("teacher_sj_mylist.jsp");
                    pageMsg.setStatu("200");
                }else {
                    pageMsg.setPageMessage("添加失败!");
                    pageMsg.setStatu("500");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        out.print(objectMapper.writeValueAsString(pageMsg));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
