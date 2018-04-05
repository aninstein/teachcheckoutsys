package Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/22.
 */
public class TestWriteString {

    public static void main(String[] args) {
        String str="\"teacherid\":$\n" + "\"teachername\"";
        char[] array=str.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if(!Character.isLetterOrDigit(array[i])){
                array[i]=',';
            }
        }
        String newStr=String.valueOf(array);

        String[] pramaS=newStr.split(",");

        //去重
        Set<String> stringSet=new HashSet<>();
        for (String pramaStr:pramaS){
            stringSet.add(pramaStr);
        }

        if(stringSet.size()>0){
            for (String pramaStr:stringSet){
                System.out.println("String "+pramaStr+" = request.getParameter(\""+pramaStr+"\");");
            }
            System.out.println();
            for (String pramaStr:stringSet){
                System.out.println("\""+pramaStr+"\" : $(\"#"+pramaStr+"\").val(),");
            }
            System.out.println();
            for (String pramaStr:stringSet){
                System.out.println("\""+pramaStr+"\":"+pramaStr+",");
            }
        }

    }

}
