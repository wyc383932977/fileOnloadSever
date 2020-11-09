package com.kinsec.httpPost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

public class HttpURLConnectionDemo {
	
	
	 public static String doPost(String URL,String paramStr){
	        OutputStreamWriter out = null;
	        BufferedReader in = null;
	        StringBuilder result = new StringBuilder();
	        HttpURLConnection conn = null;
	        String line="error";
	        try{
	            URL url = new URL(URL);
	            conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("POST");
	            //发送POST请求必须设置为true
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            //设置连接超时时间和读取超时时间
	            conn.setConnectTimeout(30000);
	            conn.setReadTimeout(10000);
	            conn.setRequestProperty("Content-Type", "application/json");
	            conn.setRequestProperty("Accept", "application/json");
	            //获取输出流
	            out = new OutputStreamWriter(conn.getOutputStream());
	            out.write(paramStr);
	            out.flush();
	            out.close();
	            //取得输入流，并使用Reader读取
	            if (200 == conn.getResponseCode()){
	                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	                while ((line = in.readLine()) != null){
	                    result.append(line);
//	                    System.out.println(line);
	                }
	            }else{
	                System.out.println("ResponseCode is an error code:" + conn.getResponseCode());
	            }
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally {
	            try{
	                if(out != null){
	                    out.close();
	                }
	                if(in != null){
	                    in.close();
	                }
	            }catch (IOException ioe){
	                ioe.printStackTrace();
	            }
	        }
	        return result.toString();
	    }
}
