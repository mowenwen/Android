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
	
	
	//���峣��
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
		//�����ޱ���
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//ȫ��ģʽ
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
		
		this.init();
		
		AlphaAnimation aa = new AlphaAnimation(0.3f,1.0f);
		aa.setDuration(2000);
		rl_splash.setAnimation(aa);
		
		//���ӷ���������ȡ������Ϣ
		
		
		
	}

	private void init() {
		// TODO Auto-generated method stub
		tv_splash_version = (TextView) findViewById(R.id.tv_splash_version);
		rl_splash = (RelativeLayout) findViewById(R.id.rl_splash);
		tv_splash_version.setText("�汾��:"+getVersion());
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
			return "�汾δ�ҵ�";
		}
		
		
	}
	
	private Handler handler = new Handler(){
		//��ɺ�Ļص�
		 public void handleMessage(Message msg){
			 switch(msg.what){
			    case GET_INFO_SUCCESS :
			    	//�ɹ���ȡ�汾��֮��Ĳ���  
			    	//���õ��������İ汾֮�������еİ汾���жԱȡ�
			    	String currentPackageVersion = getVersion();
			    	String serverPackageVersion = "";
			    	if(currentPackageVersion.equals(serverPackageVersion)){
			    		//�����°汾
			    		Log.i(TAG, "�汾����ͬ������������");
			    	}else{
			    		//�����°汾
			    		 Toast.makeText(getApplicationContext(), "�����°汾����Ŷ��", Toast.LENGTH_SHORT).show();
			    		 //���û�ѡ���Ƿ�ȥ������
			    		 Log.i(TAG, "�汾�Ų�ͬ�������Ի���");
			    		 this.showUpdateDialog();
			    	}
			    	break;
			    case SERVER_ERROR :
			    	Toast.makeText(getApplicationContext(), "�������쳣", Toast.LENGTH_SHORT).show();
			    	break;
			    case Server_URL_ERROR :
			    	Toast.makeText(getApplicationContext(), "������URL�쳣", Toast.LENGTH_SHORT).show();
			    	break;
			    case PROTOCOL_ERROR :
			    	Toast.makeText(getApplicationContext(), "Э�鲻֧��", Toast.LENGTH_SHORT).show();
			    	break;
			    case IO_ERROR :
			    	Toast.makeText(getApplicationContext(), "I/O�쳣", Toast.LENGTH_SHORT).show();
			    	break;
			    case XML_PARSE_ERROR :
			    	Toast.makeText(getApplicationContext(), "XML�����쳣", Toast.LENGTH_SHORT).show();
			    	break;
			    default:
			    	break;
			 }
		 }

		private void showUpdateDialog() {
			// TODO Auto-generated method stub
//			AlertDialog alertDialog = new AlertDialog()
			//����builder
			Builder builder = new Builder(getApplicationContext());
			//���ò���
			builder.setIcon(R.drawable.bg);
			builder.setTitle("��ʾ");
			builder.setMessage("�Ѿ������°汾������Ҫ������");
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
			//��������ʾ
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
