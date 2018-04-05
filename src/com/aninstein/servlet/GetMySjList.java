package com.aninstein.servlet;

import com.aninstein.mapper.Impl.SjtablePOMapperImpl;
import com.aninstein.mapper.SjtablePOMapper;
import com.aninstein.po.PageMsg;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/12/10.
 */
@WebServlet("/GetMySjList")
public class GetMySjList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //用到的组件
        PageMsg pageMsg=new PageMsg();
        ObjectMapper objectMapper=new ObjectMapper();
        SjtablePOMapper sjtablePOMapper=new SjtablePOMapperImpl();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
