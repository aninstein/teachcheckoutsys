package com.aninstein.tool;

/**
 * Created by Administrator on 2017/11/24.
 */
public class ArrayTool {

    //把两个数组化为等式数组
    public static String[] getSetStringByStringArr(String[] letf,String[] right){
        //以等式左边长度为准
        String[] newStr=new String[letf.length];

        for (int i = 0; i < letf.length; i++) {
            if(i<right.length){
                newStr[i]=letf[i]+" = '"+right[i]+"'";
            }else {
                newStr[i]=letf[i]+" = ''";
            }
        }
        return newStr;
    }

    //返回一个内容相同的数组
    public static String[] getOneEqualContainStringArr(String contain,int length){
        String[] newStr=new String[length];
        for (int i = 0; i < length; i++) {
            newStr[i]=contain;
        }
        return newStr;
    }

}
