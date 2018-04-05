package Test;

import com.aninstein.bean.SjtablePO;
import com.aninstein.service.Impl.ReadSjServiceImpl;
import com.aninstein.service.ReadSjService;

/**
 * Created by Administrator on 2017/12/11.
 */
public class TestReadSj {

    public static void main(String[] args) throws Exception {

        String path="G:\\Desktop\\大创\\上传文件模板\\试题模板.xls";

        ReadSjService readSjService=new ReadSjServiceImpl();


        SjtablePO sjtablePO=readSjService.readOneSjExcel(path,0);
        System.out.println(sjtablePO.toString());
    }

}
