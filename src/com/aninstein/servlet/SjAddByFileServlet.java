package com.aninstein.servlet;

import com.aninstein.bean.FiletablePO;
import com.aninstein.bean.SjtablePO;
import com.aninstein.en.ExcelTypeEnum;
import com.aninstein.en.PrivateEnum;
import com.aninstein.mapper.FiletablePOMapper;
import com.aninstein.mapper.Impl.FiletablePOMapperImpl;
import com.aninstein.mapper.Impl.SjtablePOMapperImpl;
import com.aninstein.mapper.SjtablePOMapper;
import com.aninstein.po.PageMsg;
import com.aninstein.service.Impl.ReadSjServiceImpl;
import com.aninstein.service.ReadSjService;
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
import java.util.Map;

/**
 * Created by Administrator on 2017/12/16.
 */
@WebServlet("/SjAddByFileServlet")
public class SjAddByFileServlet extends HttpServlet {
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
        FiletablePOMapper filetablePOMapper=new FiletablePOMapperImpl();
        ReadSjService readSjService=new ReadSjServiceImpl();

        FiletablePO filetablePO=new FiletablePO();
        SjtablePO sjtablePO=new SjtablePO();


        String downUrl=request.getParameter("downurl");
        String author=request.getParameter("author");
        String authorname=request.getParameter("authorname");
        String filename=request.getParameter("filename");
        String type=request.getParameter("type");


        try {
            Map<String,Object> POIresultMap=readSjService.readOneSjExcelByHttpUrl(downUrl,0);

            //确定时间
            DateFormat fmtDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr=fmtDateTime.format(new Date());

            sjtablePO=(SjtablePO)POIresultMap.get("sjtable");

            filetablePO.setFileauthor(author)
                    .setFileautorname(authorname)
                    .setFileurl(downUrl)
                    .setFilename(filename)
                    .setFilepath(((String)POIresultMap.get("filePath")).replace("\\","/"))
                    .setFiletype(ExcelTypeEnum.sj.ordinal())
                    .setFileperson(PrivateEnum.PERSON.ordinal())
                    .setFileid("sj"+new Date().getTime())
                    .setFileupdate(dateStr)
                    .setFilesubject(sjtablePO.getSjcourseid());

            int statu=filetablePOMapper.insert(filetablePO);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println(objectMapper.writeValueAsString(sjtablePO));
            out.print(objectMapper.writeValueAsString(sjtablePO));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
