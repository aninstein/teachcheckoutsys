package com.aninstein.po;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/24.
 */
public class POIReact {

    public String returnMag;
    public int isOkNum;
    public int existNum;
    public int statu;

    public String getReturnMag() {
        return returnMag;
    }

    public POIReact setReturnMag(String returnMag) {
        this.returnMag = returnMag;
        return this;
    }

    public int getIsOkNum() {
        return isOkNum;
    }

    public POIReact setIsOkNum(int isOkNum) {
        this.isOkNum = isOkNum;
        return this;
    }

    public int getExistNum() {
        return existNum;
    }

    public POIReact setExistNum(int existNum) {
        this.existNum = existNum;
        return this;
    }

    public int getStatu() {
        return statu;
    }

    public POIReact setStatu(int statu) {
        this.statu = statu;
        return this;
    }

    //一个全局的map,用来做二次修改
    public static Map<String,Object> map =new HashMap<>();

    public static Map<String, Object> getMap() {
        return POIReact.map;
    }

    public static void setMap(Map<String, Object> map) {
        POIReact.map = map;
    }
}
