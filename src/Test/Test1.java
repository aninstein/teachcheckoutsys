package Test;

import com.aninstein.dao.TeachersPODao;

public class Test1 {
	
	public static void main(String[] args) throws Exception {
		
		TeachersPODao teachersPODao=new TeachersPODao();
		boolean b=teachersPODao.verifyUser("1111");
		
	}

}
