/**
 * 
 */
package com.example.androidapp.adapter;

import com.example.androidapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author mowen
 *
 */
public class MainAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private Context context;
	
	private ImageView imageView;
	private TextView textView;
	
	//存放图标
	private static final int[] Icons = {};
	
	//存放文字
	private static final String[] names = {};
	
	
	public MainAdapter(Context context) {
		super();
		this.context = context;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.main_item, null);
		imageView = (ImageView) view.findViewById(R.id.imageView1);
		textView = (TextView) view.findViewById(R.id.textView1);
		imageView.setImageResource(Icons[position]);
		textView.setText(names[position]);
		return view;
	}

}
