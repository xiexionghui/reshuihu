package org.framework.business.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;



public class HttpClientUtil 
{
	private static final int timeout = 30000;
	
	private static final int maxConnectionsPerHost = 20;

	private static final int maxTotalConnection = 100;
	
	private static final String encoding = "UTF-8";
	
	public static final String RETURN_CODE_FAIL = "request_fail";
	
	private static HttpConnectionManager httpConnectionManager = null;
	
	
	public HttpClientUtil()
	{
		if(httpConnectionManager == null)
		{
			initConnectionManager();
		}
	}
	private void initConnectionManager()
	{
		httpConnectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = httpConnectionManager.getParams();
        params.setConnectionTimeout(timeout); 
        params.setSoTimeout(timeout); 
        params.setDefaultMaxConnectionsPerHost(maxConnectionsPerHost);
        params.setMaxTotalConnections(maxTotalConnection);
        
	}

	public String postRequest(String url,Map <String,String> params)
	{
		String result = "";
		PostMethod postMethod = null;
		HttpClient httpClient = null;
		try
		{
			if(httpConnectionManager == null)
			{
				initConnectionManager();
			}
			httpClient = new HttpClient(httpConnectionManager);
	        httpClient.getParams().setContentCharset(encoding);
	        httpClient.getParams().setHttpElementCharset(encoding);
	        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,encoding);
	       
			
			postMethod = new PostMethod(url);
		        
			List <NameValuePair> list = new ArrayList<NameValuePair>();
			NameValuePair nameValuePair = null;
			Iterator iter = params.entrySet().iterator();
			while (iter.hasNext()) 
			{
				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String)entry.getKey();
				String val = (String)entry.getValue();
				nameValuePair = new NameValuePair(key, val);
				list.add(nameValuePair);
			}
			NameValuePair[] data = list.toArray(new NameValuePair[list.size()]);  
			postMethod.setRequestBody(data);
			
			int statusCode = httpClient.executeMethod(postMethod);
		    if (statusCode == HttpStatus.SC_OK) 
		    {
		    	result = postMethod.getResponseBodyAsString();
		    }
		    else
		    {
		    	result = RETURN_CODE_FAIL;
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result = RETURN_CODE_FAIL;
		}
		finally
		{
			if(postMethod != null)
			{
				postMethod.releaseConnection();
			}
			if(httpClient != null)
			{
				((MultiThreadedHttpConnectionManager)httpClient.getHttpConnectionManager()).shutdown();
			}
		}
		return result;
		
		
	}

	public String postRequestOfNoParamName(String url,String body)
	{
		String result = "";
		PostMethod postMethod = null;
		HttpClient httpClient = null;
		try
		{
			if(httpConnectionManager == null)
			{
				initConnectionManager();
			}
			httpClient = new HttpClient(httpConnectionManager);
	        httpClient.getParams().setContentCharset("GBK");
	        httpClient.getParams().setHttpElementCharset("GBK");
	        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
	        
			
			postMethod = new PostMethod(url);
			postMethod.setRequestEntity(new StringRequestEntity(body,"","GBK"));
			
			int statusCode = httpClient.executeMethod(postMethod);
		    if (statusCode == HttpStatus.SC_OK) 
		    {
		    	result = postMethod.getResponseBodyAsString();
		    }
		    else
		    {
		    	result = RETURN_CODE_FAIL;
		    }
		}
		catch(Exception e)
		{
			result = RETURN_CODE_FAIL;
		}
		finally
		{
			if(postMethod != null)
			{
				postMethod.releaseConnection();
			}
			if(httpClient != null)
			{
				((MultiThreadedHttpConnectionManager)httpClient.getHttpConnectionManager()).shutdown();
			}
		}
		return result;
		
		
	}

	public static String doGetRequest(String urlstr) {
		String res = null;
		HttpClient client = new HttpClient(
				new MultiThreadedHttpConnectionManager());
		client.getParams().setIntParameter("http.socket.timeout", 10000);
		client.getParams().setIntParameter("http.connection.timeout", 5000);
		HttpMethod httpmethod = new GetMethod(urlstr);
		try {
			int statusCode = client.executeMethod(httpmethod);
			if (statusCode == HttpStatus.SC_OK) {
				byte obj[] = httpmethod.getResponseBody();
				res = new String(obj,"UTF-8");
				//res = httpmethod.getResponseBodyAsString();
			}
			if(res == null || res.equals("")){
				res = ""+statusCode;
			}
		} catch (HttpException e) { 
		} catch (IOException e) { 
		} finally {
			httpmethod.releaseConnection();
		}
		return res;
	} 

	
	public String postRequestJson(String url,String str)
	{
		String result = "";
		PostMethod postMethod = null;
		HttpClient httpClient = null;
		try
		{
			//if(httpConnectionManager == null)
			//{
				initConnectionManager();
			//}
			httpClient = new HttpClient(httpConnectionManager);
	        httpClient.getParams().setContentCharset(encoding);
	        httpClient.getParams().setHttpElementCharset(encoding);
	        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,encoding);
			
			postMethod = new PostMethod(url);
			List <NameValuePair> list = new ArrayList<NameValuePair>();
			NameValuePair nameValuePair = null;
			nameValuePair = new NameValuePair("resultinfo", URLEncoder.encode(str, "utf-8"));
			list.add(nameValuePair);
			
			NameValuePair[] data = list.toArray(new NameValuePair[list.size()]);  
			
			postMethod.setRequestBody(data);
			
			int statusCode = httpClient.executeMethod(postMethod);
		    if (statusCode == HttpStatus.SC_OK) 
		    {
		    	result = postMethod.getResponseBodyAsString();
		    }
		    else
		    {
		    	result = RETURN_CODE_FAIL;
		    }
		}
		catch(Exception e)
		{
			result = RETURN_CODE_FAIL;
		}
		finally
		{
			if(postMethod != null)
			{
				postMethod.releaseConnection();
			}
			if(httpClient != null)
			{
				((MultiThreadedHttpConnectionManager)httpClient.getHttpConnectionManager()).shutdown();
			}
		}
		return result;
	}
	
	public void postRegUser(String reg_url,Map<String,String> map) throws IOException{
		   URL postUrl = new URL(reg_url);  
	       HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();  
	       connection.setDoOutput(true);  
	       connection.setDoInput(true);  
	       connection.setRequestMethod("POST");  
	       connection.setUseCaches(false);  
	       connection.setInstanceFollowRedirects(true);  
	       connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
	       connection.setChunkedStreamingMode(5);  
	       connection.connect();  
	    
	       DataOutputStream out = new DataOutputStream(connection.getOutputStream());  
	       String content = "UserName=" + URLEncoder.encode(map.get("UserName"), "utf-8")+"&Password="+URLEncoder.encode(map.get("PassWord"), "utf-8")+"&Email="+URLEncoder.encode(map.get("Email"), "utf-8");  
	       out.writeBytes(content);   
	       out.flush();  
	       out.close(); // 到此时服务器已经收到了完整的http request了，而在readContentFromPost()函数里，要等到下一句服务器才能收到http请求。  
	       connection.disconnect();  
	}
	
	
	 /** 
     * @param url post传参 
     * @param xml 
     * @param method 
     * @param contentType 
     * @return 
     */  
    public static String jsonHttpProxy(String url,String json){  
        InputStream is = null;  
        OutputStream os = null;  
        try {
            URL _url = new URL(url);  
            HttpURLConnection conn = (HttpURLConnection) _url.openConnection();  
            conn.setDoInput(true);     
            conn.setDoOutput(true);     
            conn.setRequestProperty("Content-type", "UTF-8");  
            conn.setRequestMethod("POST");          
            //发送参数  
            os = conn.getOutputStream();  
            os.write(json.getBytes("UTF-8"));  
            os.flush();  
           
            //返回值  
            is = conn.getInputStream(); 
            return getContent(is, "utf-8");  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally{  
            try {  
                if(os!=null){os.close();}  
                if(is!=null){is.close();}  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }  
	
    
    
    public static String jsonHttpProxy1(String url,String json){  
        InputStream is = null;  
        OutputStream os = null;  
        try {
            URL _url = new URL(url);  
            HttpURLConnection conn = (HttpURLConnection) _url.openConnection();  
            conn.setDoInput(true);     
            conn.setDoOutput(true);     
            conn.setRequestProperty("Content-type", "application/json");  
            conn.setRequestMethod("POST");          
            //发送参数  
            os = conn.getOutputStream();  
            os.write(json.getBytes("UTF-8"));  
            os.flush();  
           
            //返回值  
            is = conn.getInputStream(); 
            return getContent(is, "utf-8");  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally{  
            try {  
                if(os!=null){os.close();}  
                if(is!=null){is.close();}  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }  
    
    
    
    public static String jsonHttpProxyToken(String url,String json,String token){  
        InputStream is = null;  
        OutputStream os = null;  
        try {
            URL _url = new URL(url);  
            HttpURLConnection conn = (HttpURLConnection) _url.openConnection();  
            conn.setDoInput(true);     
            conn.setDoOutput(true);     
            conn.setRequestProperty("Content-type", "application/json");  
            conn.setRequestProperty("Authorization", token);  
            conn.setRequestMethod("POST");          
            //发送参数  
            os = conn.getOutputStream();  
            os.write(json.getBytes("UTF-8"));  
            os.flush();  
           
            //返回值  
            is = conn.getInputStream(); 
            return getContent(is, "utf-8");  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally{  
            try {  
                if(os!=null){os.close();}  
                if(is!=null){is.close();}  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }  
	
    
    
    
    public static String postJson(String url,String jsonString)
        {
            String result = null;
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            CloseableHttpResponse response = null;
            try {
                post.setEntity(new ByteArrayEntity(jsonString.getBytes("UTF-8")));
                response = httpClient.execute(post);
                if(response != null && response.getStatusLine().getStatusCode() == 200)
                {
                    HttpEntity entity = response.getEntity();
                    result = entityToString(entity);
                }
                return result;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    httpClient.close();
                    if(response != null)
                    {
                        response.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    
    
    
    private static String entityToString(HttpEntity entity) throws IOException {
    	          String result = null;
    	          if(entity != null)
    	          {
    	              long lenth = entity.getContentLength();
    	              if(lenth != -1 && lenth < 2048)
    	              {
    	                  result = EntityUtils.toString(entity,"UTF-8");
    	              }else {
    	                 InputStreamReader reader1 = new InputStreamReader(entity.getContent(), "UTF-8");
    	                 CharArrayBuffer buffer = new CharArrayBuffer(2048);
    	                 char[] tmp = new char[1024];
    	                 int l;
    	                 while((l = reader1.read(tmp)) != -1) {
    	                     buffer.append(tmp, 0, l);
    	                 }
    	                 result = buffer.toString();
    	             }
    	         }
    	         return result;
    	     }
    
    /** 
     * 获取post参数 
     * @param is 
     * @param charset 
     * @return 
     */  
    public static String getContent(InputStream is, String charset) {  
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
                if (is != null){  
                    is.close();  
                }  
                if(isr!=null){  
                    isr.close();  
                }  
                if(br!=null){  
                    br.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
            sb = null;  
        }  
        return pageString;  
    }  
	
    public static void main(String[] args) {
    	//aIMsEYDCbJKPj6PE6UlHALg6GqvAsvQcFuoOmdXxIJw
//    	Map<String,Object> weixinMap = new HashMap<String, Object>();
//		weixinMap.put("template_id_short", "OPENTM206919910");   //模板编号
//		System.out.println(JsonUtil.parseJSON(weixinMap));
//		String template = HttpClientUtil.jsonHttpProxy("https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=8ugq1Sg-FQ1mxYxbL-sc-gMLKwH8Ao9v-F5L8vkBUvhQhcurQ5YTSh7bpMaN_KCxlY0gR2t5yNcsy16xDpVxZKT7Jw2OEnzNM9BkhPE9fC4",JsonUtil.parseJSON(weixinMap));
//    	System.out.println(template);
//    	
//    	
//    	 Map<String,Object> first = new HashMap<String, Object>();
//		    first.put("value", "aaa");
//		    first.put("color", "#173177");
//		    
//		    Map<String,Object> keyword1 = new HashMap<String, Object>();
//		    keyword1.put("value", "bbb");
//			keyword1.put("color", "#173177");
//			
//			Map<String,Object> keyword2 = new HashMap<String, Object>();
//		    keyword2.put("value", "ccc");
//			keyword2.put("color", "#173177");
//			
//
//			Map<String,Object> remark = new HashMap<String, Object>();
//			remark.put("value", "当前值： " + 11);
//			remark.put("color", "#173177");
//
//			Map<String,Object> data = new HashMap<String, Object>();
//			data.put("first",first);
//			data.put("keyword1",keyword1);
//			data.put("keyword2",keyword2);
//			data.put("remark",remark);
//			
//			//String tenplate_id = weixinMap.get("template_id").toString();
//			Map<String,Object> reqMap = new HashMap<String, Object>();
//			reqMap.put("touser", "o_y_3sw6b5x3toNjK_gRC7MSF0Xo");
//			reqMap.put("template_id", "vQW5W8pdzIDT-JAVlDcSAM2awAGUcm1LfkxzzME6-vQ");
//			reqMap.put("topcolor", "#FF0000");
//			reqMap.put("data", data);
//
//			String requestData = JsonUtil.parseJSON(reqMap);
//    	String token="oa4cPTkU7Ks64I215MNcCmwp1RqDm0fgGXr3tmpQl_f-tbioa_R_eWVOjE-8j0bZK8Dm1Qep7QjzhIc5OGZfCvi9v5sQLnYCK0qVNaHdQ5E";
//    	System.out.println(HttpClientUtil.jsonHttpProxy("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + token,requestData));
    	
    	//获取所有openId
    	String token="EM9AlpCnRSYW6e5dzOCKwsSCK0JsqgP-1XAfNqsYkBoiEKXVQNq6DShPdghz4zIxksO3M3T81_8al4eWcTWxMA0nEazns-M_wpqiseCgIQA";
    	String jsonStr = HttpClientUtil.doGetRequest("https://api.weixin.qq.com/cgi-bin/user/get?access_token="+token+"&next_openid=");
    	Map<String,Object> map=JsonUtil.parseJSON2Map(jsonStr);
    	System.out.println("总数:"+map.get("total").toString());
    	System.out.println("当前获取:"+map.get("count").toString());
    	System.out.println("newx_openID:"+map.get("next_openid").toString());
    	//System.out.println(map.get("data").toString());
    	String dataJson = map.get("data").toString();
    	String objStr = dataJson.split("\\[")[1];
    	objStr = objStr.split("\\]}")[0];
    	
    	String openId[] = objStr.split(",");
    	for(int i=0;i<openId.length;i++){
    		System.out.println(openId[i].replaceAll("\"", ""));
    	}
    	
    	//Map<String,Object> dataMap=JsonUtil.parseJSON2Map(dataJson);
    	//System.out.println(objStr);
    }

}

