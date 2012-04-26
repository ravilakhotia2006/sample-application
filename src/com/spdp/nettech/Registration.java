package com.spdp.nettech;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
@SuppressWarnings("unused")
public class Registration extends Activity {

	private EditText fname;
	private EditText mname;
	private EditText lname;
	private EditText emailaddress;
	private EditText studentid;
	private EditText address;
	private EditText mobilenumber;
	private Button submit;
	
	private boolean first = true;
	private boolean middle =  true;
	private boolean last = true;
	private boolean email;
	private boolean stu_id;
	private boolean add;

	private JSONArray jArray;
    private String result = "a";
    private InputStream is = null;
    private StringBuilder sb = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		
		init();
		
		submit.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				Pattern pattern = Pattern.compile("[a-zA-Z]+");

				Matcher matcherfname = pattern.matcher(fname.getText().toString());
				Matcher matcherlname = pattern.matcher(lname.getText().toString());
				Matcher matchermname = pattern.matcher(mname.getText().toString());
				
				if(matcherfname.matches())	{	first = false;	}
				if(matcherlname.matches())	{	last =  true;	}
				if(matchermname.matches())	{	middle = true;	}
				
				//Pattern emailpattern = Pattern.compile(".+@.+\\.[a-z]+");
				Matcher emailmatcher = Patterns.EMAIL_ADDRESS.matcher(emailaddress.getText().toString());
				
				if(!emailmatcher.matches())	{	email = true;	}
				
				boolean name = first && last && middle ;
				
				if(!name)
				{
					Toast.makeText(getApplicationContext(), "Please fill Name properly", Toast.LENGTH_SHORT).show();
				}else if(!email)
				{
					Toast.makeText(getApplicationContext(), "Please fill E-mail properly", Toast.LENGTH_SHORT).show();					
				}else if(name && email)
				{
					connecttodatabse();
				}
			}
		});
	}
			private void connecttodatabse() {
				// TODO Auto-generated method stub
		        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);

		        try{
		        	HttpClient httpclient = new DefaultHttpClient();
		        	HttpPost httppost = new HttpPost("http://10.0.2.2/registration.php");
		        	
		        	nameValuePairs.add(new BasicNameValuePair("FNAME", fname.getText().toString()));
		        	nameValuePairs.add(new BasicNameValuePair("MNAME", mname.getText().toString()));
		        	nameValuePairs.add(new BasicNameValuePair("LNAME", lname.getText().toString()));
		        	nameValuePairs.add(new BasicNameValuePair("EMAIL", emailaddress.getText().toString()));
		        	nameValuePairs.add(new BasicNameValuePair("ADDRESS", address.getText().toString()));
		        	nameValuePairs.add(new BasicNameValuePair("PHONE", mobilenumber.getText().toString()));
		        	nameValuePairs.add(new BasicNameValuePair("STUDENT_ID", studentid.getText().toString()));

		        	httppost.setEntity(new UrlEncodedFormEntity( nameValuePairs ));
		        	
		        	HttpResponse response = httpclient.execute(httppost);
		        	HttpEntity entity = response.getEntity();
		        	is = entity.getContent();
		        }
		        	catch(Exception e)
		        	{
		        		Log.e("log_tag", "Error in http connection" + e.toString());
		        	}
		
		        	Intent in  = new Intent(getApplicationContext(), MenuGonnabe.class);
		        	startActivity(in);
		}
	private void init() {
		// TODO Auto-generated method stub
		
		fname = (EditText)findViewById(R.id.fname);
		lname = (EditText)findViewById(R.id.lname);
		mname = (EditText)findViewById(R.id.mname);
		emailaddress = (EditText)findViewById(R.id.email);
		studentid = (EditText)findViewById(R.id.student_id);
		address = (EditText)findViewById(R.id.address);
		mobilenumber = (EditText)findViewById(R.id.mobile);
		submit = (Button)findViewById(R.id.submit);
	}

}
