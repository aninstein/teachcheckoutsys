package com.aninstein.tool;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/20.
 */
public class MapTool {

    Map<String,Object> map=new HashMap<>();

    public Map<String, Object> getMap() {
        return map;
    }

    public static Map<String, Object> getOneConditionMap(String key, Object value) {
        Map<String, Object> newMap=new HashMap<>();
        newMap.put(key,value);
        return newMap;
    }

    // 把Map的key和value转化为"key"="value"的字符串数组
    public static String[] returnSetStringByMap(Map<String, Object> map) {
        String[] kvS = new String[map.size()];
        int i = 0;
        // 遍历map
        for (Map.Entry<String, Object> myMap : map.entrySet()) {
            kvS[i] = myMap.getKey() + "='" + myMap.getValue() + "'";
            i++;
        }
        return kvS;
    }

    // 把Map的key和value转化为"key"="value"的字符串数组
    public static String[] returnLikeStringByMap(Map<String, Object> map) {
        String[] kvS = new String[map.size()];
        int i = 0;
        // 遍历map
        for (Map.Entry<String, Object> myMap : map.entrySet()) {
            kvS[i] = myMap.getKey() + " LIKE '%" + myMap.getValue() + "%'";
            i++;
        }
        return kvS;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void  setEqualTo(String key, String value){
        this.map.put(key,value);
    }

    public static String getJsonByListToMap(List<Map<String ,Object>> mapList){
        JSONArray jsonArray=new JSONArray();
        for(Map<String,Object> themap:mapList){
            JSONObject jsonObject=new JSONObject();
            for (Map.Entry<String,Object> entry:themap.entrySet()){
                jsonObject.put(entry.getKey(),entry.getValue());
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }


}
