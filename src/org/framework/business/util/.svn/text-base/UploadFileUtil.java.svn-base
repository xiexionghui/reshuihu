package org.framework.business.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.DefaultFileItemFactory;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

public class UploadFileUtil {
	/**
	 * 上传文件，并获取上传文件路径
	 * @param request
	 * @return
	 */
	public static String getUploadFilePath(HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("/uploadimg");
		File fileInfo = new File(path);
		//判断文件夹是否存在,如果不存在则创建文件夹
		if (!fileInfo.exists()) {
			fileInfo.mkdir();
		}
		try {
			DefaultFileItemFactory factory = new DefaultFileItemFactory();
			DiskFileUpload up = new DiskFileUpload(factory);
			List<FileItem> ls = up.parseRequest(request);
			for (FileItem fileItem : ls) {
				if (fileItem.isFormField()) {//没有选择文件
					continue;
				} else {
					String fileName = "12345.png";
					File mkr = new File(path, fileName);
					if (mkr.createNewFile()) {
						path = path + File.separator + fileName;
						fileItem.write(mkr);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return path;
	}
	
	
	/**
	 * 上传文件并获取form表单里的属性
	 * @param request
	 * @param propertyName[]  form表单中非file控件的属性name
	 * @return Map  
	 */
	public static Map<String,Object> getUploadProperty(HttpServletRequest request,String propertyName[]){
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			String path = request.getSession().getServletContext().getRealPath("/uploadimg");
			File fileInfo = new File(path);
			//判断文件夹是否存在,如果不存在则创建文件夹
			if (!fileInfo.exists()) {
				fileInfo.mkdir();
			}
			DefaultFileItemFactory factory = new DefaultFileItemFactory();
			DiskFileUpload up = new DiskFileUpload(factory);
			List<FileItem> ls = up.parseRequest(request);
			for (FileItem fileItem : ls) {
				if (fileItem.isFormField()) {//非file
					if(propertyName!=null && propertyName.length>0){
						for(int i = 0;i<propertyName.length;i++){
							if(fileItem.getFieldName().trim().equals(propertyName[i].trim())){
								map.put(propertyName[i].trim(), new String(fileItem.getString().getBytes("ISO-8859-1"),"UTF-8"));
								break;
							}
						}
					}
				} else {//是file
					if(fileItem.getSize()>0){
						String fileName = "12345.png";
						delUploadFilePath(path+"\\"+fileName);
						File mkr = new File(path, fileName);
						if (mkr.createNewFile()) {
							path = path + File.separator + fileName;
							fileItem.write(mkr);
						}
						map.put("path", path);//上传文件的路径
				    }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}
	
	/**
	 * 删除上传文件
	 * @param path 文件的路径
	 */
	public static void delUploadFilePath(String path){
		try {
			File delFile = new File(path);
			if(delFile.exists()){
			   delFile.delete();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
