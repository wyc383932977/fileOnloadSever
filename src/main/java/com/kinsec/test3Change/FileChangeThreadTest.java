package com.kinsec.test3Change;


import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.kinsec.httpPost.HttpURLConnectionDemo;
import com.kinsec.utils.MyUtils2;

public class FileChangeThreadTest implements Runnable{

	private int times;
	private String resourceFolder;
	private String fileFolder;
	private String url;
	
	public FileChangeThreadTest(int times, String resourceFolder, String fileFolder, String url) {
		super();
		this.times = times;
		this.resourceFolder = resourceFolder;
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
					String uuid = MyUtils2.uuid();
					fileFolder=fileFolder+uuid;
					JSONObject json =new JSONObject();
					json.put("resourceFolder", resourceFolder);
					json.put("fileFolder", fileFolder);
					String jsonStr = json.toString();
					String doPost = HttpURLConnectionDemo.doPost(url, jsonStr);
					System.out.println("postRet="+doPost);
					if(!"succ".equalsIgnoreCase(doPost)) {
						System.out.println("返回错误");
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
