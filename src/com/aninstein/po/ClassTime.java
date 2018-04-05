package com.aninstein.po;

/**
 * Created by Administrator on 2017/11/29.
 */
public class ClassTime {

    public static String getWeek(String weekStr){
        String[] weekdays=weekStr.split(",");
        String week="星期";
        for(String day:weekdays){
            int theday=Integer.parseInt(day);
            switch (theday){
                case 1:week+="一,";break;
                case 2:week+="二,";break;
                case 3:week+="三,";break;
                case 4:week+="四,";break;
                case 5:week+="五,";break;
                case 6:week+="六,";break;
                case 7:week+="日,";break;
                default:break;
            }
        }
        if(!week.equals("星期")) {
            return week.substring(0,week.length()-1);
        }else {
            return null;
        }
    }

    public static String getClassTime(String weekStr,String classTimeStr){
        String[] weekdays=weekStr.split(",");
        String[] classtimeno=classTimeStr.split(",");
        String classtime="";
        for (int i = 0; i < weekdays.length; i++) {
            classtime+="星期";
            int theday=Integer.parseInt(weekdays[i]);
            switch (theday){
                case 1:classtime+="一";break;
                case 2:classtime+="二";break;
                case 3:classtime+="三";break;
                case 4:classtime+="四";break;
                case 5:classtime+="五";break;
                case 6:classtime+="六";break;
                case 7:classtime+="日";break;
                default:break;
            }
            classtime+=classtimeno[i]+",";
        }
        return classtime.substring(0,classtime.length()-1);
    }

}
