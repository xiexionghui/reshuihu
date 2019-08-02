package org.framework.xcode.spring.interceptor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import org.framework.business.model.entity.OperLog;
import org.framework.business.model.entity.RoleQx;
import org.framework.business.model.entity.User;
import org.framework.business.model.service.IRoleQxService;
import org.framework.business.model.service.IUserServices;
import org.framework.business.model.service.impl.UserServicesImpl;
import org.framework.business.util.Configuration;
import org.framework.business.util.ExcelUtil;
import org.framework.business.util.HttpClientUtil;
import org.framework.business.util.Md5Encrypt;
import org.framework.business.util.PageList;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import sun.misc.BASE64Encoder;


public class MyFrameworkInterceptor extends HandlerInterceptorAdapter {

	private final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(getClass());
	/***
	 * 保存登录session
	 * @param request
	 * @param user
	 */
	protected void saveUserSession(HttpServletRequest request,User user){
		request.getSession().setAttribute("user", user);
	}
	/***
	 * 获取登录session
	 * @param request
	 * @return
	 */
	protected User getUserSession(HttpServletRequest request){
		  return (User)request.getSession().getAttribute("user");
	}


	/***
	 * 保存登录qx
	 * @param request
	 * @param qx  权限  逗号隔开
	 */
	protected void saveAdminSessionQx(HttpServletRequest request,IRoleQxService roleQxService,User user){
//		根据登陆用户查询出该用户拥有的权限
		StringBuffer qxStr = new StringBuffer();
		List<RoleQx> qxList = new ArrayList<RoleQx>();
		String objRid[] = user.getRid().split(",");
		StringBuffer objStr = new StringBuffer();
		if(objRid!=null && objRid.length>0){
			objStr.append("(");
			for(int i=0;i<objRid.length;i++){
				if(i<objRid.length-1){
					objStr.append(objRid[i]+",");
				}else{
					objStr.append(objRid[i]);
				}
			}
			objStr.append(")");
			qxList = roleQxService.query("select obj from RoleQx obj where obj.rid in "+objStr.toString()+"", null, -1, -1);
//			if(qxList!=null && qxList.size()>0){
//				for(int i=0;i<qxList.size();i++){
//					RoleQx objRoleQx = qxList.get(i);
//					qxStr.append(objRoleQx.getUrl()+",");
//				}
//			}
		}
		request.getSession().setAttribute("qxList", qxList);
	}
	
	/***
	 * 获取登录qx
	 * @param request
	 * @return
	 */
	protected String getAdminSessionQx(HttpServletRequest request){
		  return (String)request.getSession().getAttribute("qxList");
	}
	
	
	
	
	/**
	 * 最后执行，可用于释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		LOG.debug("afterCompletion");
	}

	/**
	 * render
	 */
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		LOG.debug("afterConcurrentHandlingStarted");
	}

	/**
	 * 生成视图之前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		LOG.debug("postHandle");
	}

	/**
	 * Action之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	

	/**
	 * 获取uuid
	 */
	public String getUuid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
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
	 * 获取年度
	 */
	public int getYear() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String nowDate = df.format(date);
		return Integer.parseInt(nowDate);
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
	
	
	/**
	 * 一周前
	 */
	public static Long getWeek(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,-7);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return Long.parseLong(df.format(cal.getTime()));
	}
	
	//获取明天日期
	public static Date getTomTime() throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(cal.getTime()));
		return df.parse(df.format(cal.getTime()));
	}
	
	
	public static Date getNowCurryTime() throws ParseException{
		 Calendar calendar = Calendar.getInstance();
         calendar.setTime(new Date());
         calendar.set(Calendar.HOUR_OF_DAY, 0);
         calendar.set(Calendar.MINUTE, 0);
         calendar.set(Calendar.SECOND, 0);
         Date zero = calendar.getTime();
         return zero;
	}
	
	
	public Long getFailTomDate() throws NumberFormatException, ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return Long.parseLong(df.format(getTomTime()));
	}
	
	
	public  Long getFailLongTime() throws NumberFormatException, ParseException{
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return Long.parseLong(df.format(date));
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
	public Long getNowDate(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return Long.parseLong(df.format(cal.getTime()));
	}
	
	
	public Long getCurrDate(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
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
	 * 获得项目路径
	 */
	public static String getServerPath(HttpServletRequest request) {
		String basePath = "";
		String serverName = request.getServerName();
		basePath = request.getScheme() + "://" + serverName + ":"
				+ request.getServerPort() + request.getContextPath();
		return basePath;
	}
	


	/**
	 * 生成随机数字和字母组合
	 * @param length[生成随机数的长度]
	 * @return
	 */
	public String getCharAndNumr(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val.toUpperCase();
	}
	
	public String getCode(int num){
		Random random = new Random();
		String result="";
		for(int i=0;i<num;i++){
			result+=random.nextInt(10);
		}
		return result;
	}
	
	
	 public String decimalFormat(String value,String decimal){
		 if((decimal!=null && !"".equals(decimal) && !"0".equals(decimal)) && (null!=value && !"".equals(value))){
			 int decimals = Integer.parseInt(decimal);
			 String format="#0.";
			 for(int i = 0;i < decimals;i++){
				 format+="0";
			 }
			 DecimalFormat formater = new DecimalFormat(format);
			 value = formater.format(Double.parseDouble(value)).toString();
			 return value;
		 }else if(null!=value && !"".equals(value)){
			 Double val = Double.parseDouble(value);
			 return  val.intValue()+"";
		 }else{
			 return value;
		 }
	 }
	 
	 
	 	/**
		 * 获取1小时后的时间
		 * @return
		 */
		public String getOneHoursAfterTime () {
	        Calendar calendar = Calendar.getInstance();
	        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + 1);
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return  df.format(calendar.getTime());
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
		
		
		public Date getTomDay(String time,int day) throws ParseException{
			SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dayStime = df1.parse(time);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dayStime);
			calendar.add(Calendar.DAY_OF_MONTH, day);// 今天+1天
	        Date tomorrow = calendar.getTime();
	        System.out.println("明天是:" + df1.format(tomorrow));
	        return tomorrow;
	        
		}
		
		
		public Long get3DayAfter(){
			Calendar cal = Calendar.getInstance();
			cal.add(cal.DAY_OF_MONTH, 3);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			return Long.parseLong(df.format(cal.getTime()));
		}
		
		
		public Long getYearAfter(int num){
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR,-num);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
			return Long.parseLong(df.format(cal.getTime()));
		}
		
		
		/**
		 * 获取返回Url
		 */
		public String getBackUrl(){
			return Configuration.getValue("site_url");
		}
		
		/***************************************************************************
		 * 获取多少分钟之前
		 * 
		 * @param timeMillis
		 * @return
		 */
		public String getPastTime(long timeMillis) {
			long curren = System.currentTimeMillis();
			curren = curren - timeMillis * 60 * 1000;
			Date da = new Date(curren);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return dateFormat.format(da);
		}
		
		/***************************************************************************
		 * 比较的时间是否超过 timeMillis
		 * 
		 * @param date1
		 *            最后一次发生时间
		 * @return
		 */
		public boolean compare_date(String lastUpdateDate, String date2) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date dt1 = dateFormat.parse(lastUpdateDate);
				Date dt2 = dateFormat.parse(date2);
				if (dt1.getTime() >= dt2.getTime()) {
					return true;
				} else if (dt1.getTime() < dt2.getTime()) {
					return false;
				} else {
					return false;
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			return false;
		}
		
		/**
		 * 判断两个时间是否相等
		 * @param endDate  传停车出厂时间
		 * @param gzDate传计费规则中的end时间
		 * @return
		 */
		public boolean compare_dateinfo(Date endDate, Date gzDate) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				
				if (endDate.getTime() >= gzDate.getTime()) {
					return true;
				} else if (endDate.getTime() < gzDate.getTime()) {
					return false;
				} else {
					return false;
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			return false;
		}
		
		
		public boolean compare_dateInteger(Date endDate, int gzDate) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
			try {
				int endHours = Integer.parseInt(dateFormat.format(endDate));
				if (endHours >= gzDate) {
					return true;
				}else {
					return false;
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			return false;
		}
		
		
		public boolean compare_dateInteger1(Date endDate, int gzDate) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
			try {
				int endHours = Integer.parseInt(dateFormat.format(endDate));
				if (endHours <= gzDate) {
					return true;
				}else {
					return false;
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			return false;
		}
		
		
		/**
		 * 判断2个时间的时长  多少天多少小时多少分钟
		 */
		public String getTwoHourTime(Date beginTime,Date endTime){
			long l = endTime.getTime() - beginTime.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			String info="";
			if(day>0){
				info+=day+"天";
			}
			if(hour>0){
				info+=hour+"小时";
			}
			if(min>0){
				info+=min+"分";
			}
			System.out.println("" + day + "天" + hour + "小时" + min + "分");
			return info;
		}
		
		
		public Date getAfterDate(Date startTime,int day) throws ParseException{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.setTime(startTime);
			cal.add(Calendar.HOUR_OF_DAY,day*24);
			System.out.println(df.format(cal.getTime()));
			return cal.getTime();
		}
		
		public Long getDayTime(Date beginTime,Date endTime){
			long l = endTime.getTime() - beginTime.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			return day;
		}
		
		
		public Long getDayTime1(Date beginTime,Date endTime){
			long l = endTime.getTime() - beginTime.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long num = l % (24 * 60 * 60 * 1000); 
			if(num!=0){
				day=day+1;
			}
			return day;
		}
		
		
		
		//四舍五入
		public static int txfloatMin(int a,int b,int ssTime) {
			int ys = a%b;
			if(ys<ssTime){//小于起算时间
				return a/b;
			}else{//大于起算时间
				//return Math.round((float)a/b);
				return (a/b)+1;
			} 
		}
		
		//分钟计算方式
		public static int txfloatHour(double a,int b,int ssTime) {
			double ys = a%b;
			BigDecimal b1 = new BigDecimal(a);
			BigDecimal b2 = new BigDecimal(b);
			
			if(ys*60 < ssTime){//小于起算时间
				return b1.divide(b2).intValue();
			}else{//大于起算时间
				//return Math.round((float)a/b);
				return b1.divide(b2).intValue()+1;
			} 
		}
		
		
		
		public Date getHoursTime (int hours) throws ParseException {
			String strHours = String.format("%02d", hours);      

			String time="";
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			time = df.format(date)+" "+strHours+":00:00";
			
	        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return  df1.parse(time);
	    }
		
		
		public Date getHoursTimeDay (String time,int hours) throws ParseException {
			String strHours = String.format("%02d", hours);      

			//String time="";
//			Date date = new Date();
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			time = time+" "+strHours+":00:00";
			
	        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return  df1.parse(time);
	    }
		
		
		public Date getHoursTime1 (int hours) throws ParseException {
			String strHours = String.format("%02d", hours);      

			String time="";
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			time = df.format(date)+" "+strHours+":00:00";
			
	        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return  df1.parse(time);
	    }
		
		
		
		/**
		 * 判断2个时间相差分钟数
		 */
		public Long getTwoHourLongTime(Date beginTime,Date endTime){
			long l = endTime.getTime() - beginTime.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			
			System.out.println("" + day + "天" + hour + "小时" + min + "分");
			
			Long time = (day*24*60)+(hour*60)+min;
			System.out.println("相差分钟数:"+time);
			return time;
		}
		
		
		
		/**
		 * 
		 * @param url  跳转的url - 传空
		 * @param staticURL 传空
		 * @param params 传空
		 * @param PageList 
		 * @param modelMap
		 */
		public  void savePageModelMap(PageList<?> page, ModelMap modelMap) {
			if (page != null) {
				modelMap.addAttribute("objs", page.getResult());
				modelMap.addAttribute("totalPage", page.getPages());
				modelMap.addAttribute("pageSize", page.getPageSize());
				modelMap.addAttribute("rows", page.getRowCount());
				modelMap.addAttribute("currentPage", page.getCurrentPage());
				modelMap.addAttribute("gotoPageJsp", showPageFormHtml(page.getCurrentPage(),page.getPages(),page.getRowCount(),page.getCurrentPage(),page.getPages()));
			}
		}
		
		/**
		 * @param currentPage  当前页
		 * @param pages   总页数
		 * @param rows    总行数
		 * @return
		 */
		public String showPageFormHtml(int page, int pages, int rows,int currPage,int totalPage) {
			String pageHtml = "<div class=\"text-center\">"; //到首页
			if(totalPage > 0){
				pageHtml+="<ul class=\"pagination\" id=\"_queryPage\"><li data-index=\"1\"><a href=\"#\" type=\"button\">首页</a></li>";
				if(page > 1){			
					pageHtml += "<li data-index=\""+ (page - 1) +"\"><a href=\"#\" type=\"button\">上一页</a></li>"; //到上一页
				}
				int beginPage = page - 3 < 1 ? 1 : page - 3;
				if (beginPage <= totalPage) {
					int i = beginPage;
					for (int j = 0; (i <= totalPage) && (j < 6); j=j+1) {
						if (i == page) {
							pageHtml = pageHtml + "<li data-index="+i+"><a href='#' type=\"button\"><font color=\"red\">"+i+"</font></a></li> ";
						} else {
							pageHtml = pageHtml + "<li data-index="+i+"><a href='#' type=\"button\">"+i+"</a></li> ";
						}
						i=i+1;
					}
				}
				if(page < totalPage){
					pageHtml += "<li data-index=\""+ (page + 1) +"\"><a href=\"#\" type=\"button\">下一页</a></li>"; //到末页			
				}
				pageHtml += "<li data-index=\""+ totalPage +"\"><a href=\"#\" type=\"button\">末页</a></li><li><a href=\"#\">共计"+rows+"条数据</a></li></ul>"; //到末页
			}
			pageHtml+="</div>";
			return pageHtml;
			
		} 	
		
		
		/**
		 * 判断超过48小时
		 * @param date1
		 * @param date2
		 * @return
		 * @throws Exception
		 */
		public static boolean judgmentDate(String date1, String date2) throws Exception { 
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	        Date start = sdf.parse(date1); 
	        Date end = sdf.parse(date2); 
	        long cha = end.getTime() - start.getTime(); 
	        if(cha<0){
	          return false; 
	        }
	 
	        double result = cha * 1.0 / (1000 * 60 * 60);
	 
	        if(result<=48){ 
	             return true; 
	        }else{ 
	             return false; 
	        } 
	 
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
		
		
		public static String formatDivNum(int num){
			StringBuffer objStr = new StringBuffer();
			String count = String.format("%06d", num);  
			System.out.println(count);
			if(count!=null && !count.equals("")){
				for(int i=0;i<count.length();i++){
					objStr.append("<div class=\"pc_body_trre_td\">");
					objStr.append(count.substring(i, i+1));
					objStr.append("</div>");
				}
			}
			return objStr.toString();
		}
		
		
		public static String formatDivLevel(int num){
			StringBuffer objStr = new StringBuffer();
			for(int i=0;i<num;i++){
				objStr.append("<img src=\""+Configuration.getValue("site_url")+"/images/pc/xingji.png\" class=\"pc_Ranking_Star\">");
			}
			return objStr.toString();
		}
		
		
		//星级
		public static int getLevel(int num){
			int level=1;
			if(num <= 10){
				level = 1;
			}else if(num > 10 && num<=20){
				level = 2;
			}else if(num > 20 && num<=30){
				level = 3;
			}else if(num > 30 && num<=50){
				level = 4;
			}else if(num>50){
				level = 5;
			}
			
			return level;
		}
		
		public static String getLevelSpan(int level){
			String spanStr="";
			for(int i=0;i<level;i++){
				spanStr+="<span><img src='"+Configuration.getValue("site_url")+"/images/pc/xingji.png' class='pc_Ranking_Star'/></span>";
			}
			return spanStr;
		}
		
		
		public static String getLevelSpanAdmin(int level){
			String spanStr="";
			for(int i=0;i<level;i++){
				spanStr+="<img src='"+Configuration.getValue("site_url")+"/images/pc/xingji.png' class='pc_Ranking_Star' width='10px;' height='10px;'/>";
			}
			return spanStr;
		}
		
		
		public static String getDatePoor(Date endDate, Date nowDate) {
			 
		    long nd = 1000 * 24 * 60 * 60;
		    long nh = 1000 * 60 * 60;
		    long nm = 1000 * 60;
		    // long ns = 1000;
		    // 获得两个时间的毫秒时间差异
		    long diff = endDate.getTime() - nowDate.getTime();
		    // 计算差多少天
		    long day = diff / nd;
		    // 计算差多少小时
		    long hour = diff % nd / nh;
		    
		    long min = diff % nd % nh / nm;
		    
		    day = day*24*60;//天换算成分钟
		    hour = hour*60;//小时换算成分钟
		    
		    Double time = Double.parseDouble(String.valueOf(day + hour + min))/60;
		    
		    // 计算差多少秒//输出结果
		    // long sec = diff % nd % nh % nm / ns;
		    return String.format("%.2f ",time);//计算相差多少小时
		}

		
		public String getIp(HttpServletRequest request){
			String ipAddress = request.getHeader("x-forwarded-for");  
	        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	            ipAddress = request.getHeader("Proxy-Client-IP");  
	        }  
	        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	            ipAddress = request.getHeader("WL-Proxy-Client-IP");  
	        }  
	        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	            ipAddress = request.getRemoteAddr();  
	            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
	                //根据网卡取本机配置的IP  
	                InetAddress inet=null;  
	                try {  
	                    inet = InetAddress.getLocalHost();  
	                } catch (UnknownHostException e) {  
	                    e.printStackTrace();  
	                }  
	                ipAddress= inet.getHostAddress();  
	            }  
	        }  
	        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
	        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
	            if(ipAddress.indexOf(",")>0){  
	                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
	            }  
	        }  
	        
	        return ipAddress;
		}
		
		
		
		
		/**
		 * 创建excel文档，
		 * 
		 * @param list
		 *            数据
		 * @param keys
		 *            list中map的key数组集合
		 * @param columnNames
		 *            excel的列名
		 */
		public void createExcel(HttpServletRequest request,HttpServletResponse response, List<Map<String, Object>> list,
				String[] keys, String[] columnNames,String fileName,String sensorName) {
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			try {
				ExcelUtil.createWorkBook(list, keys, columnNames,sensorName).write(os);
				byte[] content = os.toByteArray();
				InputStream is = new ByteArrayInputStream(content);
				// 设置response参数，可以打开下载页面
				response.reset();
				response.setContentType("application/vnd.ms-excel;charset=utf-8");
				response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
				ServletOutputStream out = response.getOutputStream();
				
				bis = new BufferedInputStream(is);
				bos = new BufferedOutputStream(out);
				byte[] buff = new byte[2048];
				int bytesRead;
				// Simple read/write loop.
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}

			} catch (IOException e) {
			} finally {
				if (bis != null)
					try {
						bis.close();
					} catch (IOException e) {
					}
				if (bos != null)
					try {
						bos.close();
					} catch (IOException e) {
					}
			}
		}
		
		
		public static String getCharAndNumrInfo(int length) {
			String val = "";
			Random random = new Random();
			for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
				if ("char".equalsIgnoreCase(charOrNum)) {
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
				} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
				}
			}
			return val.toUpperCase();
		}

		
		public void saveOperLog(User user,String one_menu,String two_menu,String content,IUserServices userServices){
			OperLog operLog = new OperLog();
			operLog.setUserId(user.getId());
			operLog.setUserName(user.getUserName());
			operLog.setNickName(user.getNickName());
			operLog.setOne_menu(one_menu);
			operLog.setTwo_menu(two_menu);
			operLog.setContent(content);
			operLog.setAddTime(new Date());
			userServices.saveOperLog(operLog);
		}
		
		
		
		
		public static void main(String[] args) throws ParseException {
//			Calendar cal = Calendar.getInstance();
//			cal.add(cal.DAY_OF_MONTH, 3);
			//System.out.println(getCharAndNumrInfo(7));
			
			//System.out.println("2017-11".replaceAll("-", "").replaceAll(" ", "").replaceAll(":", ""));
			
			
//			 Calendar calendar = Calendar.getInstance();
//	         calendar.setTime(new Date());
//	         calendar.set(Calendar.HOUR_OF_DAY, 0);
//	         calendar.set(Calendar.MINUTE, 0);
//	         calendar.set(Calendar.SECOND, 0);
//	         Date zero = calendar.getTime();
//	         System.out.println(zero);
//	         
//	         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//	         System.out.println(sdf.format(zero));
//			System.out.println(txfloatMin(40, 13, 2));
//			SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
//			Date dayStime = df1.parse("2018-12-20 15:00:00");
//			Date dayStime1 = df1.parse("2018-12-22 15:00:00");
//			
//			long l = dayStime1.getTime() - dayStime.getTime();
//			long day = l / (24 * 60 * 60 * 1000);
//			System.out.println(day);
//			
//			System.out.println(l % (24 * 60 * 60 * 1000));
			
//			
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(dayStime);
//			calendar.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
//	 
//	        Date tomorrow = calendar.getTime();
//	        System.out.println("明天是:" + df1.format(tomorrow));
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String time = "2019-04-17 09:30:00";
//			
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(df.parse(time));
//			cal.add(Calendar.HOUR_OF_DAY,24);
//			System.out.println(df.format(cal.getTime()));
			
			Double aa = 89.00;
			System.out.println(Math.round(aa/60));

		}
		
}
