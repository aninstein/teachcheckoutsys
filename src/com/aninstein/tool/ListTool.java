package com.aninstein.tool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/20.
 */
public class ListTool {

    public static final String NULL="[\"无\"]";

    //可以将数组转化为带有“”的list
    public static List<String> arraysToList(String[] stringArray){
        List<String> list=new ArrayList<>();
        for(String str:stringArray){
            list.add("\""+str+"\"");
        }
        return list;
    }

    //可以将数组转化为带有“”的list
    public static List<String> listToList(List<String> stringArray){
        List<String> list=new ArrayList<>();
        for(String str:stringArray){
            list.add("\""+str+"\"");
        }
        return list;
    }

    //删除数组某一个元素
    public static List<String> deleteListEnity(List<String> stringArray,String index){
        for(String str:stringArray){
            if(str.equals(index)){
                stringArray.remove(str);
                break;
            }
        }
        return stringArray;
    }

}
