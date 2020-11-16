package com.kinsec.fileDownloadUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloadUtils2 {

	public static InputStream doLoad(String address) {
        InputStream in = null;
        try {
            URL url = new URL(address);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;

            // true -- will setting parameters
            httpURLConnection.setDoOutput(true);
            // true--will allow read in from
            httpURLConnection.setDoInput(true);
            // will not use caches
            httpURLConnection.setUseCaches(false);
            // setting serialized
            httpURLConnection.setRequestProperty("Content-type", "application/x-java-serialized-object");
            // default is GET
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Charsert", "UTF-8");
            // 1 min
            httpURLConnection.setConnectTimeout(60000);
            // 1 min
            httpURLConnection.setReadTimeout(60000);

            // connect to server (tcp)
            httpURLConnection.connect();

            in = httpURLConnection.getInputStream();
        } catch(Exception e){
            e.printStackTrace();
            try {
                if(in != null){
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return in;
    }
	
    /**
     * 将InputStream写入本地文件
     * @param destination 写入本地目录
     * @param input 输入流
     * @throws IOException IOException
     */
    public static void writeToLocal(String destination, InputStream input)
            throws IOException {
        int index;
        byte[] bytes = new byte[1024];
        FileOutputStream downloadFile = new FileOutputStream(destination);
        while ((index = input.read(bytes)) != -1) {
            downloadFile.write(bytes, 0, index);
            downloadFile.flush();
        }
        input.close();
        downloadFile.close();

    }
}
