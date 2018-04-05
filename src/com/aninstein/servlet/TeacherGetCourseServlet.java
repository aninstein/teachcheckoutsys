package com.aninstein.servlet;

import com.aninstein.bean.CoursesPO;
import com.aninstein.mapper.Impl.CoursesPOMapperImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class TeacherGetCourseServlet
 */
@WebServlet("/TeacherGetCourseServlet")
public class TeacherGetCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherGetCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String addcourse=request.getParameter("addcourse");
		CoursesPOMapperImpl coursesPOMapperImpl=new CoursesPOMapperImpl();
		ObjectMapper objectMapper=new ObjectMapper();

		if(addcourse.equals("")){
			out.print("");
			return;
		}
		
		List<Map<String,String>> maps=new ArrayList<>();
		try {
			List<CoursesPO> coursesPOs=coursesPOMapperImpl.getSearchCoursesByStr(addcourse);
			if(coursesPOs.size()>0){
				for(CoursesPO coursesPO:coursesPOs){
					Map<String,String> map=new HashMap<String, String>();
					map.put("courseName", coursesPO.getCoursesname());
					map.put("courseId", coursesPO.getCoursesid());
					maps.add(map);
				}
				//String result=objectMapper.writeValueAsString(maps);
				String result= JSONArray.fromObject(maps).toString();
//				System.out.println(result);
				out.print(result);
			}else{
				out.print("");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
