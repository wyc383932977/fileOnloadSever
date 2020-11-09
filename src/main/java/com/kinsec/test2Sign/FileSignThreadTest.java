package com.kinsec.test2Sign;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.alibaba.fastjson.JSONObject;
import com.kinsec.httpPost.HttpURLConnectionDemo;

public class FileSignThreadTest implements Runnable{

	private int times;
	private String resourcePoth;
	private String fileFolder;
	private String url;
	
	
	public FileSignThreadTest(int times, String resourcePoth, String fileFolder, String url) {
		super();
		this.times = times;
		this.resourcePoth = resourcePoth;
		this.fileFolder = fileFolder;
		this.url = url;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		 String threadName=Thread.currentThread().getName();
//		 String prefix = MyUtils.getPrefix(resourcePoth);
		 try {
			 for (int i = 0; i < times; i++) {
					long startTime = System.currentTimeMillis();
					String signFilePost=fileFolder+"/blank_"+threadName+"_"+"+_sign"+i+".ofd";
					JSONObject json =new JSONObject();
					json.put("resourcePoth", resourcePoth);
					json.put("fileFolder", fileFolder);
					json.put("signFilePost", signFilePost);
					String jsonStr = json.toString();
					String doPost = HttpURLConnectionDemo.doPost(url, jsonStr);
					System.out.println("postRet="+doPost);
					if(!"true".equalsIgnoreCase(doPost)) {
						throw new InterruptedException();
					}
//					MainTest2.signFile(resourcePoth,fileFolder, signFilePost);
					long endTime = System.currentTimeMillis();
					System.out.println("useTime："+ threadName+"_"+"+_sign"+i+":"+ String.valueOf(endTime - startTime) + "ms");
				}
		} catch (Exception e) {
			// TODO: handle exception
			 System.out.println(threadName+"进入catch代码块，线程结束执行正常");
	         e.printStackTrace();
		}
		
	}
	
	
	


}
