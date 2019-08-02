package org.framework.business.util;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketClient {
	private final static Logger logger = LoggerFactory.getLogger(SocketClient.class);

	// 客户端输入输出流
	Socket clientSocket;
	InputStream is;
	OutputStream os;
	DataInputStream dis;
	PrintStream ps;

	public void init(String ip, String port) {
		try {
			// 根据服务器名和端口号，连接服务器
			clientSocket = new Socket(ip, Integer.parseInt(port));
			// //要与服务器保持一致。
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			dis = new DataInputStream(is);
			ps = new PrintStream(os);
		} catch (Exception e) {
			logger.error("无法连接服务器!");
		}
	}

    /***
     * 没有返回值的socket
     * @param msg
     * @param socket_ip
     * @param socket_port
     * @return
     * @throws Exception
     */
	public String sendRequestAndGetResponse(String msg,String socket_ip,String socket_port) throws Exception {
		try {
			if (clientSocket == null || clientSocket.isClosed()) {
				init(socket_ip,socket_port);
			}
			// 向服务器端发送数据
			ps.println(msg+"\r\n"); // 将输入的字符串传给服务器端
			System.out.println("发送成功！");
		} catch (Exception e) {
			logger.error("无法连接服务器!");
		} finally {
			dis.close();
			ps.close();
			os.close();
			is.close();
			clientSocket.close();
		}
		return "";
	}
	
	/**
	 * 有返回值的socket
	 * @param msg
	 * @param socket_ip
	 * @param socket_port
	 * @return 00 成功 01 失败
	 * @throws Exception
	 */
	public String sendRequestAndGetResponseResult(String msg,String socket_ip,String socket_port) throws Exception {
		String result = "";
		try {
			if (clientSocket == null || clientSocket.isClosed()) {
				init(socket_ip, socket_port);
			}
			// 向服务器端发送数据
			//ps.println(msg); // 将输入的字符串传给服务器端
			os.write(msg.getBytes());
			byte[] by = new byte[8];
			int iread = is.read(by);
			is.read(by, 0, 4);
			result = new String(by,0,iread);
			
		} catch (Exception e) {
			//write("d:\\log\\log.txt",port + e.getMessage());
		} finally {
			dis.close();
			ps.close();
			os.close();
			is.close();
			clientSocket.close();
		}
		return result;	//00 成功 01 失败
	}
	
    /***
     * 
     * @param msg
     * @param socket_ip
     * @param socket_port
     * @param jobId
     * @return
     * @throws Exception
     */
	public String sendRequestAndGetResponse(String msg,String socket_ip,String socket_port,String jobId) throws Exception {
		try {
			if (clientSocket == null || clientSocket.isClosed()) {
				init(socket_ip,socket_port);
			}
			// 向服务器端发送数据
			ps.println(msg); // 将输入的字符串传给服务器端
			System.out.println("下发ip:"+socket_ip+"端口："+ socket_port+"任务Id"+jobId+":"+msg);
		} catch (Exception e) {
			logger.error("无法连接服务器!");
			System.out.println("下发ip:"+socket_ip+"端口："+e.getMessage());
		} finally {
			dis.close();
			ps.close();
			os.close();
			is.close();
			clientSocket.close();
		}
		return "";
	}
	

   public static void main(String[] args) {
		Map<String, Object> sendMap = new HashMap<String, Object>();
		sendMap.put("deviceNo", "6B8P43MZXTA98LUJ");
		sendMap.put("content", "1");
		sendMap.put("sensorId", "104223");
		sendMap.put("flag", "tcp");
		SocketClient s = new SocketClient();
		try {
			String str = JsonUtil.parseJSON(sendMap);
			System.out.println(str);
			s.sendRequestAndGetResponse("SZYF" , "127.0.0.1", "8647");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
