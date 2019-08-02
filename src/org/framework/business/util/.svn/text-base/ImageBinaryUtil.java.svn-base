package org.framework.business.util;
import java.awt.image.BufferedImage;      
import java.io.ByteArrayInputStream;      
import java.io.ByteArrayOutputStream;      
import java.io.File;      
import java.io.IOException;     
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;   
import sun.misc.BASE64Decoder;      
import sun.misc.BASE64Encoder; 

public class ImageBinaryUtil {
	static BASE64Encoder encoder = new sun.misc.BASE64Encoder();      
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();      
    
    /**
     * 图片转二进制
     * @return
     */
    public static String getImageBinary(String pic_path){      
        File f = new File(pic_path);             
        BufferedImage bi;      
        try {      
            bi = ImageIO.read(f);      
            ByteArrayOutputStream baos = new ByteArrayOutputStream();      
            ImageIO.write(bi, "jpg", baos);      
            byte[] bytes = baos.toByteArray();      
                  
            return encoder.encodeBuffer(bytes).trim();      
        } catch (IOException e) {      
            e.printStackTrace();      
        }      
        return null;      
    }      
    
    /**
     * 二进制数据转图片
     * @param base64String_pic 图片的二进制数据
     */
   public static void base64StringToImage(String base64String_pic,String path,String sensorId){      
        try {      
        	Date date = new Date();
    		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    		String nowDate = df.format(date);
            byte[] bytes1 = decoder.decodeBuffer(base64String_pic); 
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);      
            BufferedImage bi1 =ImageIO.read(bais);      
            File w2 = new File(path+"//"+sensorId+"_"+nowDate+".jpg");
            ImageIO.write(bi1, "jpg", w2);
        } catch (IOException e) {      
            e.printStackTrace();      
        }      
    }  
}
