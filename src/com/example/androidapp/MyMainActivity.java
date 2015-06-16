/**
 * 
 */
package com.example.androidapp;

import com.example.androidapp.adapter.MainAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

/**
 * @author mowen
 *
 */
public class MyMainActivity extends Activity {
	
	private GridView gv_main;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.man_frame);
		 gv_main = (GridView) findViewById(R.id.gv_main);
		 gv_main.setAdapter(new MainAdapter(this));
		
	}

}
