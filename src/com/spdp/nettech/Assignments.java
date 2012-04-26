package com.spdp.nettech;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.ParseException;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Assignments extends Activity {
	private String fileLink;
	private final String PATH = "/data/data/com.spdp.nettech/assignments/";
	private InputStream is = null;
	private StringBuilder sb = null;
	private String result;
	private JSONArray jArray;
	private ArrayList<Files> assignfiles ;
	private ListView list ;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.participantlist);
		
		assignfiles = new ArrayList<Files>();
		connect_and_fetch_data(); 
		if(assignfiles.size() == 0)
		{
			Log.d("Size", assignfiles.size() + " ");
			Toast.makeText(getApplicationContext(), "No material ", Toast.LENGTH_SHORT).show();
		}else
		{
			Log.d("Size", assignfiles.size() + " ");
		}
		
		list = (ListView)findViewById(android.R.id.list);
		list.setAdapter(new AdapterCourseMaterial(Assignments.this, assignfiles));
		
		list.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
				switch(pos){
				case 0: {fileLink = "ipv4.pdf";break;}
				case 1: {fileLink = "filesystem_OS.pdf";break;}
				}
				//File ff = new File(PATH+fileLink);
				//if(!ff.exists()){
				DownloadFile(fileLink);
				//}
				//Uri path = Uri.fromFile(ff);
            	//Intent n = new Intent(Intent.ACTION_VIEW);
            	//n.setDataAndType(path, "application/pdf");
            	//n.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			}
		}); 
	}
	
	private void connect_and_fetch_data() {
		// TODO Auto-generated method stub

        //http post
        try{
        	HttpClient httpclient = new DefaultHttpClient();
        	HttpPost httppost = new HttpPost("http://10.0.2.2/assign_file.php");
        	
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
        	String file_name;
        	        	
        	try{
        		jArray = new JSONArray(result);
        		JSONObject json_data = null;
        		for(int i=0;i < jArray.length();i++){
        			json_data = jArray.getJSONObject(i);
        			
        			id  = json_data.getInt("id");
        			file_name = json_data.getString("filename").toString();
        			Log.d("name", file_name);
        			Files f = new Files();
        			f.setname(file_name);
        			assignfiles.add(f);
           }
        	}catch(JSONException e1){
        		Toast.makeText(getApplicationContext(), " Json Exception ", Toast.LENGTH_SHORT).show();
        	} catch (ParseException e1) {
			e1.printStackTrace();
        }
	}
	
	public void DownloadFile(String fileName) {  
        try {
                URL url = new URL("http://10.0.2.2/assignments/" + fileName); 
                File file = new File(fileName);
                long startTime = System.currentTimeMillis();
                Log.d("file download", "download begining");
                Log.d("file download", "download url:" + url);
                Log.d("file download", "downloaded file name:" + fileName);
                URLConnection ucon = url.openConnection();

                InputStream is = ucon.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is,8192);

                ByteArrayBuffer baf = new ByteArrayBuffer(50);
                int current = 0;
                while ((current = bis.read()) != -1) {
                        baf.append((byte) current);
                }

                FileOutputStream fos = new FileOutputStream(file);
                fos.write(baf.toByteArray());
                fos.close();
                baf.clear();
                bis.close();
                is.close();
                Log.d("file download", "download ready in"
                                + ((System.currentTimeMillis() - startTime) / 1000)
                                + " sec");
        } catch (IOException e) {
                Log.d("file download", "Error: " + e);
        }
    }
}