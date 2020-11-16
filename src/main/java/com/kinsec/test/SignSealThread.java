package com.kinsec.test;

import java.io.File;
import java.io.IOException;

import com.kinsec.fileDownloadUtils.FileDownloadUtils1;
import com.kinsec.fileUploadUtils.FileLoadUtils;

public class SignSealThread implements Runnable{
	private int times=0;
	//原文件地址
	private String sourcesFilePoth;
	//放置的文件夹
	private String signFileFolder;
	
	private String uploadUrl;
	
	private String downloadUrl;
	
	public SignSealThread(int times, String sourcesFilePoth, String signFileFolder, String uploadUrl,
			String downloadUrl) {
		super();
		this.times = times;
		this.sourcesFilePoth = sourcesFilePoth;
		this.signFileFolder = signFileFolder;
		this.uploadUrl = uploadUrl;
		this.downloadUrl = downloadUrl;
	}

	@Override
	public void run() {
		 String threadName=Thread.currentThread().getName();
		 signFileFolder=signFileFolder+File.separator+threadName;
		 new File(threadName).mkdirs();
		for (int i = 0; i < times; i++) {
			try {
				if(FileTest.judge!=0) {
					throw new InterruptedException();
				}
			} catch (Exception e) {
				System.out.println("进入catch代码块，线程结束执行正常");
	            e.printStackTrace();
	            break;
			}
			try {
				long startTime = System.currentTimeMillis();
				String signFileName = FileLoadUtils.testFileLoad2(uploadUrl,sourcesFilePoth);
				System.out.println("signFileName="+signFileName);
				if(!"fail".equals(signFileName)) {
					String url = downloadUrl+"?filename="+signFileName;
					try {
						String fileName = FileUtils.getFileName(sourcesFilePoth);
						FileDownloadUtils1.downLoadFromUrl(url, FileUtils.getPrefix(fileName)+i+"_sign.ofd", signFileFolder);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("下载完成");
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Spring方法的运行时间：" + String.valueOf(endTime - startTime) + "ms");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				FileTest.judge=-1;
				System.out.println(threadName+"进入catch代码块，线程结束执行正常");
				break;
			}
			
			
		}
	}

}
