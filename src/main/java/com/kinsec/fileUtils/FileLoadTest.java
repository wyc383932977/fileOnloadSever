package com.kinsec.fileUtils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FileLoadTest {

	// 82ms
		public static String testFileLoad2(String url,String fileName) throws Exception{
			// 设定要上传的普通Form Field及其对应的value
			ArrayList<FormFieldKeyValuePair> ffkvp = new ArrayList<FormFieldKeyValuePair>();
			ffkvp.add(new FormFieldKeyValuePair("phone", "123456789"));// 其他参数
			ffkvp.add(new FormFieldKeyValuePair("receiver", "123123"));
//			ffkvp.add(new FormFieldKeyValuePair("type", "png"));

			// 设定要上传的文件
			ArrayList<UploadFileItem> ufi = new ArrayList<UploadFileItem>();
			ufi.add(new UploadFileItem("fileName", fileName));
			HttpPostEmulator hpe = new HttpPostEmulator();
			String response = "失败";
			response = hpe.sendHttpPostRequest(url, ffkvp, ufi);
			System.out.println("Responsefrom server is: " + response);
			JSONObject jsonObject = JSONObject.parseObject(response);
			Integer retCode = (Integer)jsonObject.get("retCode");
			String signFileName = (String)jsonObject.get("signFileName");
			if(retCode==0) {
				return signFileName;
			}else {
				return "fail";
			}
		}

		//httpClient文件上传 797ms
		public static void testFileLoad4() {
			// 文件sTestsetFile：solr_etl_agent35.json是存有JSON字符串的文件
	        String sTestsetFile="D:\\ofd\\blank.ofd";
	        
	        String sURL="http://127.0.0.1:8080/fileOnloadServerMVC/fileUpload";
	        
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        HttpPost uploadFile = new HttpPost(sURL);
	        
	        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	        builder.addTextBody("field1", "yes", ContentType.TEXT_PLAIN);

	        // 把文件加到HTTP的post请求中
	        File f = new File(sTestsetFile);
	        try {
				builder.addBinaryBody(
				    "fileName",
				    new FileInputStream(f),
				    ContentType.APPLICATION_OCTET_STREAM,
				    f.getName()
				);
	        HttpEntity multipart = builder.build();
	        uploadFile.setEntity(multipart);
	        CloseableHttpResponse response = httpClient.execute(uploadFile);
	        HttpEntity responseEntity = response.getEntity();
	        String sResponse=EntityUtils.toString(responseEntity, "UTF-8");
	        System.out.println("Post 返回结果"+sResponse);
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	//787ms
	public static void testFileLoad3() {
		StringBuffer buffer = new StringBuffer();
		try {
			MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE,
					"----------ThIs_Is_tHe_bouNdaRY_$", Charset.defaultCharset());
			multipartEntity.addPart("phone", new StringBody("136********", Charset.forName("UTF-8")));
			multipartEntity.addPart("receiver", new StringBody("138***********", Charset.forName("UTF-8")));
			multipartEntity.addPart("fileName", new FileBody(
					new File("D:\\ofd\\mayun4.jpg"), "image/png"));

			HttpPost request = new HttpPost("http://127.0.0.1:8080/fileOnloadServerMVC/fileUpload");
			request.setEntity(multipartEntity);
			request.addHeader("Content-Type", "multipart/form-data; boundary=----------ThIs_Is_tHe_bouNdaRY_$");

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpResponse response = httpClient.execute(request);
			InputStream is = response.getEntity().getContent();  
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			
			String line = "";
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}

			is = response.getEntity().getContent();
		} catch (UnsupportedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("发送消息收到的返回：" + buffer.toString());
	}

	

	// 1
	public static String sendPostwithFile(String url) {
		DataOutputStream out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			String BOUNDARY = "---------7d4a6d158c9";// 定义数据分隔线
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;NSIE 6.0;Windows NT 5.1;SV1)");
			conn.setRequestProperty("Charsert", "UTF-8");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			conn.connect();

			out = new DataOutputStream(conn.getOutputStream());
			byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();// 定义最后数据分隔线门添加参数luid

			// 添加参数luid
			StringBuilder sb1 = new StringBuilder();
			sb1.append("--");
			sb1.append(BOUNDARY);
			sb1.append("\r\n");
			sb1.append("Content-Disposition: form-data; name=\"luid\"");
			sb1.append("\r\n");
			sb1.append("\rin");
			sb1.append("123");
			sb1.append("\r\n");
			out.write(sb1.toString().getBytes());// 添加参数file
			File file = new File("D:\\ofd\\blank.ofd");
			StringBuilder sb = new StringBuilder();
			sb.append("--");
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition: form-data;name=\"fileName\";filename=\"" + file.getName() + "\"");
			sb.append("\r\n");
			sb.append("Content-Type:application/octet-stream");
			sb.append("\r\n");
			sb.append("\r\n");
			out.write(sb.toString().getBytes());

			DataInputStream in1 = new DataInputStream(new FileInputStream(file));
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in1.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			out.write("\rin".getBytes());// 多个文件时，二个文件之间加入这个in1.close();
			out.write(end_data);
			// flush输出流的缓冲out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送POST 请求出现异常!" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return result;
	}

}
