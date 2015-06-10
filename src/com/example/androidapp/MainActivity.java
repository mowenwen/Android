package com.example.androidapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public TextView tv_splash_version;
	
	
	
	//定义常亮
	private static final int GET_INFO_SUCCESS=10;
	private static final int SERVER_ERROR=11;
	private static final int Server_URL_ERROR=12;
	private static final int PROTOCOL_ERROR=13;
	private static final int IO_ERROR=14;
	private static final int XML_PARSE_ERROR=15;
	protected static final String TAG = "MainActivity";
	
	
	private PackageInfo info;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//设置无标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//全屏模式
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
		
		this.init();
		
		
		
	}

	private void init() {
		// TODO Auto-generated method stub
		tv_splash_version = (TextView) findViewById(R.id.tv_splash_version);
		tv_splash_version.setText("版本号:"+getVersion());
	}

	private String getVersion() {
		// TODO Auto-generated method stub
		PackageManager pm = this.getPackageManager();
		try {
			info = pm.getPackageInfo(getPackageName(), 0);
			return info.versionName;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "版本未找到";
		}
		
		
	}
	
	private Handler handler = new Handler(){
		//完成后的回调
		 public void handleMessage(Message msg){
			 switch(msg.what){
			    case GET_INFO_SUCCESS :
			    	//成功获取版本号之后的操作  
			    	//在拿到服务器的版本之后与现有的版本进行对比。
			    	String currentPackageVersion = getVersion();
			    	String serverPackageVersion = "";
			    	if(currentPackageVersion.equals(serverPackageVersion)){
			    		//是最新版本
			    		
			    	}else{
			    		//非最新版本
			    		 Toast.makeText(getApplicationContext(), "有最新版本号了哦。", Toast.LENGTH_SHORT).show();
			    	}
			    	break;
			    case SERVER_ERROR :
			    	Toast.makeText(getApplicationContext(), "服务器异常", Toast.LENGTH_SHORT).show();
			    	break;
			    case Server_URL_ERROR :
			    	Toast.makeText(getApplicationContext(), "服务器URL异常", Toast.LENGTH_SHORT).show();
			    	break;
			    case PROTOCOL_ERROR :
			    	Toast.makeText(getApplicationContext(), "协议不支持", Toast.LENGTH_SHORT).show();
			    	break;
			    case IO_ERROR :
			    	Toast.makeText(getApplicationContext(), "I/O异常", Toast.LENGTH_SHORT).show();
			    	break;
			    case XML_PARSE_ERROR :
			    	Toast.makeText(getApplicationContext(), "XML解析异常", Toast.LENGTH_SHORT).show();
			    	break;
			    default:
			    	break;
			 }
		 }
	};

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
