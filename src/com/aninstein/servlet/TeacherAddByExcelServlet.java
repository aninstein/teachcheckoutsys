package com.aninstein.servlet;

import com.aninstein.bean.FiletablePO;
import com.aninstein.en.ExcelTypeEnum;
import com.aninstein.en.PrivateEnum;
import com.aninstein.mapper.FiletablePOMapper;
import com.aninstein.mapper.Impl.FiletablePOMapperImpl;
import com.aninstein.po.POIReact;
import com.aninstein.po.PageMsg;
import com.aninstein.service.Impl.POIReadExcelServiceImpl;
import com.aninstein.service.POIReadExcelService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/27.
 */
@WebServlet("/TeacherAddByExcelServlet")
public class TeacherAddByExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();
        FiletablePOMapper filetablePOMapper=new FiletablePOMapperImpl();
        POIReadExcelService poiReadExcelService=new POIReadExcelServiceImpl();

        FiletablePO filetablePO=new FiletablePO();


        String downUrl=request.getParameter("downurl");
        String author=request.getParameter("author");
        String authorname=request.getParameter("authorname");
        String filename=request.getParameter("filename");

        try {
            Map<String,Object> POIresultMap=poiReadExcelService.readExcelByHttpUrl(downUrl, ExcelTypeEnum.teacher.ordinal(),1);

            //获取读取的List
            List<Object> objectList= (List<Object>) POIresultMap.get("objectList");
            POIReact poiReact=poiReadExcelService.saveDataBaseByType(objectList,ExcelTypeEnum.teacher.ordinal());

            //确定时间
            DateFormat fmtDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr=fmtDateTime.format(new Date());

            filetablePO.setFileauthor(author)
                    .setFileautorname(authorname)
                    .setFileurl(downUrl)
                    .setFilename(filename)
                    .setFilepath(((String)POIresultMap.get("filePath")).replace("\\","/"))
                    .setFiletype(ExcelTypeEnum.teacher.ordinal())
                    .setFileperson(PrivateEnum.PERSON.ordinal())
                    .setFileid("teacher"+new Date().getTime())
                    .setFileupdate(dateStr);

            int statu=filetablePOMapper.insert(filetablePO);
            if(statu==200&&poiReact.getStatu()==200){
                pageMsg.setStatu(statu+"");
                pageMsg.setPageMessage("导入成功！");
                pageMsg.setContain(poiReact.getReturnMag());
                pageMsg.setPagePath("admin_teacher.jsp");
            }else {
                pageMsg.setStatu(statu+"");
                pageMsg.setPageMessage("导入失败！");
                pageMsg.setContain(poiReact.getReturnMag());
                pageMsg.setPagePath("admin_teacher.jsp");
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
