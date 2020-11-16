package com.kinsec.fileUploadUtils;

public class FileUploadTest {

	public static void main(String[] args) {
//		String uploadUrl="http://127.0.0.1:8080/fileOnloadServerMVC/springUpload";
//		doUplaod(uploadUrl, "D:\\ofd\\blank.ofd");
	}
	
	public static void doUplaod(String uploadUrl,String sourcesFilePoth) {
		try {
			long startTime = System.currentTimeMillis();
			FileLoadUtils.testFileLoad4(uploadUrl,sourcesFilePoth);
			long endTime = System.currentTimeMillis();
			System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
