package org.framework.xcode.spring.interceptor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.framework.business.util.Configuration;

public class BaseController {
	
	/**
	 * 获得项目路径
	 */
	public String getServerPath(HttpServletRequest request) {
		String basePath = "";
		String serverName = request.getServerName();
		basePath = request.getScheme() + "://" + serverName + ":"
				+ request.getServerPort() + request.getContextPath();
		return basePath;
	}
	
	
	/**
	 * 获取网址
	 */
	public String getSiteUrl(HttpServletRequest request){
    	return Configuration.getValue("site_url");
	}

	/**
	 * 通过servlet输出controller返回结果
	 * 
	 * @param result
	 * @param response
	 * @throws IOException
	 */
	protected void writeResult(String result, HttpServletResponse response)
			throws IOException {
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

	/**
	 * 获取日期 yyyy-mm-dd hh:mm:ss
	 * 
	 * @return
	 */
	protected String getTime() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		return df.format(date);
	}

	/**
	 * 获取30天后时间
	 * @param args
	 */
	public Date getDayAfterTime(int num){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, num);
       // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  calendar.getTime();
	}

	/**
	 * *} 根据小数位取小数后几位
	 * 
	 * @param decimal
	 * @return
	 */
	public String decimalFormat(String value, String decimal) {
		if ((!"".equals(decimal) && !"0".equals(decimal))
				&& (null != value && !"".equals(value))) {
			int decimals = Integer.parseInt(decimal);
			String format = "#0";
			for (int i = 0; i < decimals; i++) {
				if (i == 0) {
					format += ".";
				}
				format += "0";
			}
			DecimalFormat formater = new DecimalFormat(format);
			value = formater.format(Double.parseDouble(value)).toString();
			return value;
		} else if (null != value && !"".equals(value)) {
			Double val = Double.parseDouble(value);
			return val.intValue() + "";
		} else {
			return value;
		}
	}

	/**
	 * 获取post参数
	 * 
	 * @param is
	 * @param charset
	 * @return
	 */
	public String getContent(InputStream is, String charset) {
		String pageString = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			isr = new InputStreamReader(is, charset);
			br = new BufferedReader(isr);
			sb = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			pageString = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			sb = null;
		}
		return pageString;
	}
	
	/**  
     * 验证邮箱地址是否正确  
     * @param email  
     * @return  
     */  
    public static boolean checkEmail(String email){  
     boolean flag = false;  
     try{  
      String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";  
      Pattern regex = Pattern.compile(check);  
      Matcher matcher = regex.matcher(email);  
      flag = matcher.matches();  
     }catch(Exception e){  
      flag = false;  
     }  
       
     return flag;  
    }  
	
	/**
	 * 获取1小时前的时间
	 * @return
	 */
	public String getOneHoursAgoTime () {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  df.format(calendar.getTime());
    }
	
	/**
	 * 获取1天前时间
	 * @param args
	 */
	public String getOneDayAgoTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  df.format(calendar.getTime());
	}
	
	/**
	 * 获取一周前日期
	 * @param args
	 */
	public String getOneWeekAgoTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -7);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  df.format(calendar.getTime());
	}
	
	
	/**
	 * 获取一月前日期
	 * @param args
	 */
	public String getOneMonthAgoTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  df.format(calendar.getTime());
	}
	
	/**
	 * 获取一年前日期
	 * @param args
	 */
	public String getOneYearAgoTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  df.format(calendar.getTime());
	}
	
	/**
	 * 获取当前时
	 */
	public String getNowDateTime(){
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  df.format(calendar.getTime());
	}
	
	
	/**
	 * 获取当前时
	 */
	public String getNowDate(){
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return  df.format(calendar.getTime());
	}
	

	
	public String getCode(int num){
		Random random = new Random();
		String result="";
		for(int i=0;i<num;i++){
			result+=random.nextInt(10);
		}
		return result;
	}
	
	
	
	/**
	 * 获取长时间
	 */
	public long getLongTime() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String nowDate = df.format(date);
		return Long.parseLong(nowDate);
	}

	/**
	 * 获取长时间
	 */
	public String getNowData() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	
	public int getNowHoure() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH");
		return Integer.parseInt(df.format(date));
	}

	/**
	 * 获取当前月
	 */
	public int getNowMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH) + 1;
	}

	/***************************************************************************
	 * 获取当前周几
	 * 
	 * @return
	 */
	public String getWeekOfDate() {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	 * 
	 * @param minute 加指定分钟
	 * @return
	 */
	public Long getFailDate(int minute){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE,minute);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return Long.parseLong(df.format(cal.getTime()));
	}

	
	/**
	 * 获取当前时间
	 */
	public String getFormatNowDate(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(cal.getTime());
	}
	
	/**
	 * 获取当天具体时间
	 */
	public String getDayTime(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(cal.getTime());
	}
	
	/**
	 * 获取当天日期
	 */
	public String getDayDate(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(cal.getTime());
	}
	
	
    public static boolean isEmail(String email){       
    	String str="^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";  
        Pattern p = Pattern.compile(str);       
        Matcher m = p.matcher(email);         
        return m.matches();       
    }   
    
	/**
	 * 生成6为随机数
	 */
	public static String getCode(){
		Random random = new Random();
		String result="";
		for(int i=0;i<6;i++){
			result+=random.nextInt(10);
		}
		return result;
	}
	
	
	public static String getNumCode(int num){
		Random random = new Random();
		String result="";
		for(int i=0;i<num;i++){
			result+=random.nextInt(10);
		}
		return result;
	}
	
	
	public String getIpAddr(HttpServletRequest request) { 
	       String ip = request.getHeader("x-forwarded-for"); 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("WL-Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getRemoteAddr(); 
	       } 
	       return ip; 
	} 
	
}
