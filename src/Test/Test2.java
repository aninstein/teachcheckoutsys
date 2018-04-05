package Test;

import java.sql.SQLException;

import com.aninstein.bean.TeachersPO;
import com.aninstein.dao.TeachersPODao;

public class Test2 {
	
	public static void main(String[] args) throws SQLException {
		
		TeachersPODao teachersPODao=new TeachersPODao();
		
		TeachersPO pwd=teachersPODao.selectTeachersPOByEmail("6666@haha.com");
		
		System.out.println(pwd.getTeacherpwd());
		
	}

}
