package Test;

import com.aninstein.bean.StudentsPO;
import com.aninstein.tool.DeleteSql;

/**
 * Created by Administrator on 2017/11/20.
 */
public class TestDelete {

    public static void main(String[] args) {

        DeleteSql deleteSql=new DeleteSql();
        StudentsPO studentsPO=new StudentsPO();
        studentsPO.setStuname("李昌安");

        String sql=deleteSql.deleteStudentslePOSql(studentsPO);

        System.out.println(sql);


    }

}
