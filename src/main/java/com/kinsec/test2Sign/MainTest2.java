package com.kinsec.test2Sign;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.alibaba.fastjson.JSONObject;
import com.kinsec.utils.MyUtils2;

public class MainTest2 {

	public static void main(String[] args) {
		//centos
//		String resource="/opt/wyccs/2.12TestCs/apache-tomcat-8.5.47/webapps/fileOnloadServerMVC/WEB-INF/classes/fileInput/dcs/blank.ofd";
//		String fileFolder="/opt/wyccs/2.12TestCs/apache-tomcat-8.5.47/webapps/fileOnloadServerMVC/WEB-INF/classes/fileSignput/dcs/";
//		String url="http://192.168.201.210:8080/fileOnloadServerMVC/fileSignTest";
		//ft1500b
		String resource="/opt/wyccs/apache-tomcat-8.5.47/webapps/fileOnloadServerMVC/WEB-INF/classes/fileInput/dcs/blank.ofd";
		String fileFolder="/opt/wyccs/apache-tomcat-8.5.47/webapps/fileOnloadServerMVC/WEB-INF/classes/fileSignput/dcs/";
		String url="http://192.168.201.115:21105/fileOnloadServerMVC/fileSignTest";
		int threadTimes=1;
		int signTimes=1;
		for (int i = 0; i < threadTimes; i++) {
			Runnable FileThreadTest=new FileSignThreadTest(signTimes,resource,fileFolder,url);
			Thread thread=new Thread(FileThreadTest,"thread_"+i);
			thread.start();
		}
		
//		signFile(resource,fileFolder, fileFolder+"1.ofd");
	}
	
	public static void signFile(String resourcePoth,String fileFolder,String signFilePost) {
		// http://127.0.0.1:20521/qureyCertAuthCount
		// http://192.168.5.91:8080/kinsecZeroMay/qureyCertAuthCount
		// http://220.162.244.154:8080/kinsecZeroMay/qureyCertAuthCount
		//192.168.201.210:8080
		String url = "http://192.168.201.115:8080/fileOnloadServerMVC/fileSignTest";
		
//		abs="CC392FF7038984089AAED7DC4525BDAF";
		JSONObject jsonReq=new JSONObject();
		jsonReq.put("resourcePoth", resourcePoth);
		jsonReq.put("fileFolder", fileFolder);
		jsonReq.put("signFilePost", signFilePost);
		
		String baseReq = jsonReq.toString();
		System.out.println("baseReq="+baseReq);

		// 创建默认的httpClient实例.
		HttpClient client = new DefaultHttpClient();

		StringEntity entity = new StringEntity(baseReq, "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		HttpPost httppost = new HttpPost(url);
		httppost.setEntity(entity);
		try {
			HttpResponse response = client.execute(httppost);
			String responseString = MyUtils2.responseString(response);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
