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
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

public class ParticipantList extends Activity{
	private InputStream is = null;
	private StringBuilder sb = null;
	private String result;
	private JSONArray jArray;
	private ListView lv;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participantlist);
        lv = (ListView) findViewById(android.R.id.list);
        
        ArrayList<StudentDetails> studentdetails = connecttodatabase();        
        lv.setAdapter(new AdapterStudentDetails(this,studentdetails));
        
    }
    
	private ArrayList<StudentDetails> connecttodatabase() {
		// TODO Auto-generated method stub

        //http post
        try{
        	HttpClient httpclient = new DefaultHttpClient();
        	HttpPost httppost = new HttpPost("http://10.0.2.2/participant_list.php");
        	
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
        		Log.e("log_tag", "Error converting result "+e.toString());
        	}
//paring data
    		ArrayList<StudentDetails> results = new ArrayList<StudentDetails>();
        	String name;
        	String stuID;
        	
        	
        	try{
        		jArray = new JSONArray(result);
        		JSONObject json_data=null;
        		for(int i=0;i<jArray.length();i++){
        			json_data = jArray.getJSONObject(i);

        			name  = json_data.getString("date").toString();
        			stuID = json_data.getString("student_id").toString();
        			
        			StudentDetails sdetails = new StudentDetails();
        			sdetails = new StudentDetails();
        			sdetails.setid(stuID);
        			sdetails.setname(name);
        			results.add(sdetails);
          }
      }
     
        	catch(JSONException e1){
        		StudentDetails sdetails = new StudentDetails();
        		sdetails.setid("2008A7PS021G");
        		sdetails.setname("RPL");
        		results.add(sdetails);
        		
        		sdetails = new StudentDetails();
        		sdetails.setid("2008A7PS065G");
        		sdetails.setname("Agni");
        		results.add(sdetails);
        		lv.setAdapter(new AdapterStudentDetails(this,results));
        	} catch (ParseException e1) {
			e1.printStackTrace();
        }
        	return results;
}		
}
