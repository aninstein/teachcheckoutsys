package Test;

import com.aninstein.bean.StudentsPO;
import com.aninstein.dao.StudentsPODao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */
public class TestGetStudent {

    public static void main(String[] args) throws SQLException {

        StudentsPODao studentsPODao=new StudentsPODao();
        List<StudentsPO> studentsPOList=studentsPODao.selectAll();
        System.out.println(studentsPOList.toString());

    }

}
