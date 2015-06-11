package com.example.androidapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.style.BulletSpan;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public TextView tv_splash_version;
	public RelativeLayout rl_splash;
	
	
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
		
		AlphaAnimation aa = new AlphaAnimation(0.3f,1.0f);
		aa.setDuration(2000);
		rl_splash.setAnimation(aa);
		
		//链接服务器，获取配置信息
		
		
		
	}

	private void init() {
		// TODO Auto-generated method stub
		tv_splash_version = (TextView) findViewById(R.id.tv_splash_version);
		rl_splash = (RelativeLayout) findViewById(R.id.rl_splash);
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
			    		Log.i(TAG, "版本号相同，进入主界面");
			    	}else{
			    		//非最新版本
			    		 Toast.makeText(getApplicationContext(), "有最新版本号了哦。", Toast.LENGTH_SHORT).show();
			    		 //让用户选择是否去升级。
			    		 Log.i(TAG, "版本号不同，升级对话框。");
			    		 this.showUpdateDialog();
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

		private void showUpdateDialog() {
			// TODO Auto-generated method stub
//			AlertDialog alertDialog = new AlertDialog()
			//创建builder
			Builder builder = new Builder(getApplicationContext());
			//设置参数
			builder.setIcon(R.drawable.bg);
			builder.setTitle("提示");
			builder.setMessage("已经发布新版本，您需要更新吗？");
			builder.setPositiveButton("", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			
			builder.setNegativeButton("", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			//创建并显示
			builder.create().show();
		}
	};

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
