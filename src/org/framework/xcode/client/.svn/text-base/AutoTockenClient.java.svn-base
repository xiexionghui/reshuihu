package org.framework.xcode.client;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import org.framework.business.model.service.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;

public class AutoTockenClient extends TimerTask{

	
	private Timer timer = null;
	
	@Override
	public void run() {
		timer = new Timer();
	}

	

	// 销毁监听器，停止执行任务
	public void contextDestroyed(ServletContextEvent event) {
		// 注意，在此计时器调用的计时器任务的 run 方法内调用此方法，就可以绝对确保正在执行的任务是此计时器所执行的最后一个任务。
		timer.cancel();
	}

	
	
	// 增加或减少天数
	public Date addDay(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		return startDT.getTime();
	}

	
	
	public  Date toGetDate(int time) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, time);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		Date date = calendar.getTime(); // 第一次执行定时任务的时间
		
		if (date.before(new Date())) {
			date = this.addDay(date, 1);
		}

		return date;
	}
	
}

