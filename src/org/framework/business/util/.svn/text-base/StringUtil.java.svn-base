package org.framework.business.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringUtil {
	/**
	 * 清除所有的特殊字符
	 * @param str
	 * @return
	 * @throws PatternSyntaxException
	 */
	public  static String StringFilter(String   str)throws PatternSyntaxException   {        
	    String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？] ";
	    Pattern p = Pattern.compile(regEx);        	
	    Matcher m = p.matcher(str);        
	    return m.replaceAll("").trim();        
	}        
}
