package com.kinsec.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class MyUtils2 {

	/**
	 * 获取uuid
	 */
	public static String uuid() {
		String uuid = UUID.randomUUID().toString();//转化为String对象  
		uuid=uuid.replace("-", "");//因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可 
		return uuid;
	}
	
	public static String responseString(HttpResponse response) {
		String readContent = null;
		HttpEntity entity = response.getEntity();

		System.out.println("1.Get Response Status: " + response.getStatusLine());
		if (entity != null) {
			System.out.println("  Get ResponseContentEncoding():" + entity.getContentEncoding());
			System.out.println("  Content Length():" + entity.getContentLength());
			// getResponse
			InputStream in;
			try {
				in = entity.getContent();

				int count = 0;
				while (count == 0) {
					count = Integer.parseInt("" + entity.getContentLength());// in.available();
				}
				byte[] bytes = new byte[count];
				int readCount = 0; // 已经成功读取的字节的个数
				while (readCount <= count) {
					if (readCount == count)
						break;
					readCount += in.read(bytes, readCount, count - readCount);
				}
				// 转换成字符串
				readContent = new String(bytes, 0, readCount, "UTF-8"); // convert to string using bytes
				System.out.println("2.Get Response Content():\n" + readContent);
			} catch (UnsupportedOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return readContent;
	}
	
	   /**
  * 获取文件名称前缀
  * @param fileName
  * @return
  */
 public static String getPrefix(String fileName) {
     if (fileName.contains(".")) {
     	fileName = fileName.substring(0,fileName.lastIndexOf("."));
     }
     return fileName;
 }
}
