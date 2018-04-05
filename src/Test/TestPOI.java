package Test;

import com.aninstein.en.ExcelTypeEnum;
import com.aninstein.service.Impl.POIReadExcelServiceImpl;
import com.aninstein.service.POIReadExcelService;
import com.aninstein.tool.HttpDownUtil;

/**
 * Created by Administrator on 2017/11/21.
 */
public class TestPOI {

    public static void main(String[] args) throws Exception {
        POIReadExcelService poiReadExcelService=new POIReadExcelServiceImpl();

//        String path="G:\\Desktop\\大创\\上传文件模板\\学生表模板.xls";
//        List<Object> objectList=poiReadExcelService.readExcelByFilePath(path, ExcelTypeEnum.student.ordinal(),1);
//        for(Object object:objectList){
//            StudentsPO studentsPO=(StudentsPO)object;
//            System.out.println(studentsPO.toString());
//        }

        //通过Http的链接得到文件
        HttpDownUtil httpDownUtil=new HttpDownUtil();
        httpDownUtil.setUrl("https://teach-checkout.oss-cn-beijing.aliyuncs.com/a-casual-name/andon/upload/学生表模板.xls")
                .setCasualPath()
                .setFileName(httpDownUtil.getFileNameByUrl())
                .download();

        String thepath=httpDownUtil.getPathAndFileName();

        poiReadExcelService.readExcelByFilePath(thepath, ExcelTypeEnum.student.ordinal(),1);

    }

}
