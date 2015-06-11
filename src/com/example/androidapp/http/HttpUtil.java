/**
 * 
 */
package com.example.androidapp.http;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpClientConnection;

import com.example.androidapp.Configs.Config;

/**
 * @author mowen
 *
 */
public class HttpUtil {
	
	private static final String TAG="Httptil";
	
	public String startTime;
	public String serverUrl;
	
	public String httpRequest(String requesturl,String requestMethod,int connectTimeout){
		//首先获取服务器端的地址对象。
		serverUrl = Config.ServerUrl;
		//拼接URL
		serverUrl+=requesturl; 
		
		URL url;
		try {
			url = new URL(serverUrl);
			HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod(requestMethod);
			httpURLConnection.setConnectTimeout(connectTimeout);
//			httpURLConnection.setReadTimeout(timeoutMillis)
			
			int responseCode = httpURLConnection.getResponseCode();
			if(responseCode==200){
				InputStream is = httpURLConnection.getInputStream();
				return is.toString();
			}else{
				return null;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	    
		
	}
}
