package com.bobo.mylistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.mylistview.R;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView myListView;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        myListView = (ListView) findViewById(R.id.list);
        List<Map<String, Object>> list = getData();
        myListView.setAdapter(new MyAdspter(this, list));

    }

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		for(int i = 1;i<=20;i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", R.drawable.ic_launcher);
			map.put("title", "bobo"+i);
			map.put("info", "œÍœ∏–≈œ¢");
			list.add(map);
		}
		return list;
	}
}
