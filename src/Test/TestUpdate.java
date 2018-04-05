package Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.aninstein.bean.TeachersPO;
import com.aninstein.tool.DBTool;
import com.aninstein.dao.TeachersPODao;
import com.aninstein.tool.UpdateSql;

public class TestUpdate {
	
	public static void main(String[] args) throws SQLException {
		
		DBTool dbTool=new DBTool();
		Connection connection=dbTool.getConnection();
		TeachersPODao teachersPODao=new TeachersPODao();
		UpdateSql updateSql=new UpdateSql();
		
		Map<String,Object> conditionMap=new HashMap<String, Object>();
		conditionMap.put(TeachersPO._teacherid, "20145570");
		
		TeachersPO ateahcer=teachersPODao.selectTeachersPOByEmail("123@qq.com");
		ateahcer.setTeacherid("201711");
		ateahcer.setTeacheremail("li@li.com");
		ateahcer.setTeachername("孔明");
		
		String sql=updateSql.getUpdateTeachersPOSql(ateahcer, conditionMap);
		
		System.out.println(sql);
	}

}
