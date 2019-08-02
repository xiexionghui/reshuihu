package org.framework.business.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.sun.jmx.snmp.Timestamp;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateJsonValueProcessor implements JsonValueProcessor {
	private Object processValue(Object value) {
		if (value != null) {
			// yyyyMMddHHmmss
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (value instanceof Timestamp) {
				return dateFormat.format((Date) value);
			} else if (value instanceof Date) {
				return dateFormat.format((Date) value);
			} else if (value instanceof java.sql.Date) {
				return dateFormat.format((Date) value);
			}

		}
		return value;
	}


	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		return processValue(arg0);
	}


	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		return processValue(arg1);
	}

}
