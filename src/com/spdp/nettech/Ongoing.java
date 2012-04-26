package com.spdp.nettech;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Ongoing extends Activity{

	private InputStream is = null;
	private StringBuilder sb = null;
	private String result;
	private JSONArray jArray;
	private ArrayList<CampusDetails> campusname_list; 
	private ListView list ;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.participantlist);
		
		campusname_list = new ArrayList<CampusDetails>();
		
		// Connect and fetch data from corresponding table in database
		connect_and_fetch_data();		
		if(campusname_list.isEmpty() == true)
		{
			Toast.makeText(getApplicationContext(), " No campus found ! ", Toast.LENGTH_SHORT).show();
		}else
		{
			Log.d("Size", campusname_list.size() + " ");
			list = (ListView)findViewById(android.R.id.list);
			list.setAdapter(new AdapterCampusDetails(Ongoing.this, campusname_list));
		}
		
		// click events on list items
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
				// TODO Auto-generated method stub
				
				String cname = campusname_list.get(position).toString();
				//Toast.makeText(getApplicationContext(),cname , Toast.LENGTH_SHORT);
				Intent in = new Intent(getApplicationContext(), MenuOngoing.class);
				in.putExtra("CAMPUS_NAME", cname);
				startActivity(in);
			}
		});
}

	private void connect_and_fetch_data() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

        //http post
        try{
        	HttpClient httpclient = new DefaultHttpClient();
        	HttpPost httppost = new HttpPost("http://10.0.2.2/ongoing.php");
        	
        	HttpResponse response = httpclient.execute(httppost);
        	HttpEntity entity = response.getEntity();
        	is = entity.getContent();
        }catch(Exception e){
        	Log.e("log_tag", "Error in http connection" + e.toString());
        	}
//convert response to string
        try{
        	BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"),8);
        	sb = new StringBuilder();
        	sb.append(reader.readLine() + "\n");
        	String line="0";
        	while ((line = reader.readLine()) != null) {
        		sb.append(line + "\n");
        	}
        	is.close();
        	result=sb.toString();
        	}catch(Exception e){
        		Log.e("log_tag", "Error converting result "+ e.toString());
        	}
//paring data

        	int id;
        	String campus_name;
        	        	
        	try{
        		jArray = new JSONArray(result);
        		JSONObject json_data = null;
        		for(int i=0;i < jArray.length();i++){
        			json_data = jArray.getJSONObject(i);
        			
        			id  = json_data.getInt("id");
        			campus_name = json_data.getString("campus_name").toString();
        			Log.d("name", campus_name);
        			CampusDetails cn = new CampusDetails();
        			cn.setname(campus_name);
        			campusname_list.add(cn);
           }
        	}catch(JSONException e1){
        		Toast.makeText(getApplicationContext(), " Json Exception ", Toast.LENGTH_SHORT).show();
        	} catch (ParseException e1) {
			e1.printStackTrace();
        }
	}
}
