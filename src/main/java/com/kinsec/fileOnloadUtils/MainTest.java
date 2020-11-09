package com.kinsec.fileOnloadUtils;

import java.io.IOException;

import com.kinsec.test.SignSealThread;

public class MainTest {

	public static void main(String[] args) throws IOException {

		
		// write your code here
		long startTime = System.currentTimeMillis();
		String url = "http://192.168.201.210:8080/fileOnloadServerMVC/download?filename=teste7a2b279dd9b447d8b9f3ac0402c42fc_sign.ofd";

		String token = "v32Eo2Tw+qWI/eiKW3D8ye7l19mf1NngRLushO6CumLMHIO1aryun0/Y3N3YQCv/TqzaO/TFHw4=";
		// String
		HttpRequest.downLoadFromUrl(url, "teste7a2b279dd9b447d8b9f3ac0402c42fc_sign.ofd", "D:\\0fileOnload");
		System.out.println("下载完成");
		long endTime = System.currentTimeMillis();
		System.out.println("Spring方法的运行时间：" + String.valueOf(endTime - startTime) + "ms");
	}
}