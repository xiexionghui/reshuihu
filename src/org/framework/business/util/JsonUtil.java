package org.framework.business.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class JsonUtil {
   
	 /**
	    * json转List
	    * @param jsonStr
	    * @return
	    */
    public static List<Map<String, Object>> parseJSON2List(String jsonStr){
        JSONArray jsonArr = JSONArray.fromObject(jsonStr);
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        Iterator<JSONObject> it = jsonArr.iterator();
        while(it.hasNext()){
            JSONObject json2 = it.next();
            list.add(parseJSON2Map(json2.toString()));
        }
        return list;
    }
    
   /**
    * json转map
    * @param jsonStr
    * @return
    */
    public static Map<String, Object> parseJSON2Map(String jsonStr){
        Map<String, Object> map = new HashMap<String, Object>();
        //最外层解析
        JSONObject json = JSONObject.fromObject(jsonStr);
        for(Object k : json.keySet()){
            Object v = json.get(k); 
            //如果内层还是数组的话，继续解析
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                Iterator<JSONObject> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
    
    
    /**
     * map转json
     * @param map
     * @return
     */
    public static String parseJSON(Map<String,Object> map){ 
    	JsonConfig jsonConfig = new JsonConfig();  
    	jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());  
    	 return JSONObject.fromObject(map,jsonConfig).toString();  
    }
    
    
    public static String parseStringJSON(Map<String,String> map){
   	 return JSONObject.fromObject(map).toString();  
   }
    
	/**
	 * xml to map xml <node><key label="key1">value1</key><key
	 * label="key2">value2</key>......</node>
	 * 
	 * @param xml
	 * @return
	 */
	public static Map xmltoMap(String xml) {
		try {
			Map map = new HashMap();
			Document document = DocumentHelper.parseText(xml);
			Element nodeElement = document.getRootElement();
			List node = nodeElement.elements();
			for (Iterator it = node.iterator(); it.hasNext();) {
				Element elm = (Element) it.next();
				map.put(elm.getName(), elm.getText());
				elm = null;
			}
			node = null;
			nodeElement = null;
			document = null;
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		HttpClientUtil objClient = new HttpClientUtil();
		String str = objClient.doGetRequest("http://api.map.baidu.com/geocoder/v2/?ak=EB77c29b7b9800e5804ef458fbf3ac67&location=31.298247284063569,120.66298796130684&output=json&pois=0");
		System.out.println(str);
		Map<String,Object> map = JsonUtil.parseJSON2Map(str);
		String result = map.get("result").toString();
		Map<String,Object> re_map = JsonUtil.parseJSON2Map(result);
		String address = re_map.get("addressComponent").toString();
		Map<String,Object> infoMap=JsonUtil.parseJSON2Map(address);
		System.out.println(infoMap.get("province"));
		System.out.println(infoMap.get("city"));
		System.out.println(infoMap.get("district"));
		System.out.println(infoMap.get("street"));
		System.out.println(infoMap.get("street_number"));
	}
	
}
