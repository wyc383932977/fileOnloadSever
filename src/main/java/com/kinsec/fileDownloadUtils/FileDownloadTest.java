package com.kinsec.fileDownloadUtils;

import java.io.IOException;
import java.io.InputStream;

public class FileDownloadTest {

	public static void main(String[] args) {
		// write your code here
		long startTime = System.currentTimeMillis();
		String url = "http://127.0.0.1:8080/fileOnloadServerMVC/downloadTraditional?fileName=blank.ofd";
		
		try {
			//方法1
//			InputStream doLoad = FileDownloadUtils2.doLoad(url);
//			FileDownloadUtils2.writeToLocal("D:\\0fileOnload\\blank.ofd", doLoad);
			//方法2 其实跟1一样可能
			FileDownloadUtils1.downLoadFromUrl(url, "blank.ofd", "D:\\0fileOnload\\");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Spring方法的运行时间：" + String.valueOf(endTime - startTime) + "ms");
	}
}
