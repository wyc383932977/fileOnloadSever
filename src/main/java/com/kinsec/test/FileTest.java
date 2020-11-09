package com.kinsec.test;


public class FileTest {

	static int judge=0;
	public static void main(String[] args) {
		oneFIleCase();
	}
	public static void oneFIleCase() {
		System.out.println("");
		int threadTimes=100;
		int signFileTimes=10;
		//http://192.168.201.115:21105/fileOnloadServerMVC/
		String uploadUrl="http://192.168.201.115:21105/fileOnloadServerMVC/fileUpload";
		String downloadUrl="http://192.168.201.115:21105/fileOnloadServerMVC/download";
		for(int i = 0; i < threadTimes; i++){
			Runnable signSealThread=new SignSealThread(signFileTimes,"D:\\ofd\\nihao.doc","D:\\0fileOnload",uploadUrl,downloadUrl);
			Thread signSeal=new Thread(signSealThread,"FileTest-"+i);
			signSeal.start();
		}
	}
}
