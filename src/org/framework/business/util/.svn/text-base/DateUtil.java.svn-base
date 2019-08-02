package org.framework.business.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/***
	 * 计算起始时间距离结束时间间隔
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long getDayNum(String startTime,String endTime){
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	    	long to = df.parse(endTime).getTime();
	 	    long from = df.parse(startTime).getTime();
	 	    long sumDay  =  (to - from) / (1000 * 60 * 60 * 24) + 1;
	 	    long dayNum = 0;
	 	    if(sumDay % 7 == 0 ){
	 	    	dayNum = (sumDay / 7);
	 		}else{
	 			dayNum = (sumDay / 7) + 1;
	 		}
	 	    return dayNum;
		} catch (Exception e) {
		   System.out.println("时间周期转换异常"+e.getMessage());
		   return  0;
		}
	}
	
	/***
	 * 获取day之后的时间
	 * @return
	 */
	public static String getDayLong(int day,String dataTime){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//String curDatetime = "2015-07-15";
		try {
			Date date = df.parse(dataTime);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE,day);
			return df.format(calendar.getTime());
		} catch (Exception e) {
			 System.out.println("时间周期转换异常"+e.getMessage());
			 return "";
		}
	}

	
	/**
	 * 获取当前时间
	 */
	public static Long getNowDate(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return Long.parseLong(df.format(cal.getTime()));
	}
	
    /** 
     * 根据日期获得星期 
     * @param date 
     * @return 
     */ 
	public static String getWeekOfDate(Date date) { 
		String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" }; 
		//String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" }; 
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(date); 
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1; 
		return weekDaysName[intWeek]; 
	}

	
}
