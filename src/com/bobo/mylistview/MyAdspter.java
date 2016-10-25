package com.bobo.mylistview;

import java.util.List;
import java.util.Map;
import com.example.mylistview.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdspter extends BaseAdapter {

	private List<Map<String, Object>> data;
	private LayoutInflater layoutInflater;
	private Context context;
	public MyAdspter(Context context,List<Map<String, Object>> data){
		this.data = data;
		this.layoutInflater = LayoutInflater.from(context);
		this.context = context;
	}
	
	public final class Zujian{
		public ImageView image;
		public TextView title;
		public Button view;
		public TextView info;
	}
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertview, ViewGroup parent) {
		
		Zujian zujian = null;
		final int ID = position;
		if(convertview==null){
			zujian = new Zujian();
			convertview = layoutInflater.inflate(R.layout.list, null);
			zujian.image = (ImageView)convertview.findViewById(R.id.image);
			zujian.title = (TextView) convertview.findViewById(R.id.title);
			zujian.view = (Button) convertview.findViewById(R.id.view);
			zujian.info = (TextView) convertview.findViewById(R.id.info);
			convertview.setTag(zujian);
		}
		else {
			zujian = (Zujian) convertview.getTag();
		}
		zujian.image.setBackgroundResource((Integer)data.get(position).get("image"));
		zujian.title.setText((String)data.get(position).get("title"));
		zujian.info.setText((String)data.get(position).get("info"));
		zujian.view.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, (CharSequence) data.get(ID).get("title"), Toast.LENGTH_SHORT).show();
			}
		});
		return convertview;
	}

}
