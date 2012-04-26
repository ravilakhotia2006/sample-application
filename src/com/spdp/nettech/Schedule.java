package com.spdp.nettech;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;
import android.app.Activity;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("unused")
public class Schedule extends Activity {
    /** Called when the activity is first created. */
	
	private ImageView image1;
	private ImageView image2;
	private ImageView image3;
	private ImageView image4;
	private ImageView image5;
	private ImageView image6;
	private ImageView image7;
	private ImageView image8;
	private ImageView image9;
	private ImageView image10;
	private ImageView image11;
	private ImageView image12;
	private ImageView image13;
	private ImageView image14;
	private ImageView image15;
	private ImageView image16;
	private ImageView image17;
	private ImageView image18;
	private ImageView image19;
	private ImageView image20;
	private TextView datetext;
	private TextView topictext;
	private TextView venuetext;
	private TextView pcrtext;

	private JSONArray jArray;
    private String result = "a";
    private InputStream is = null;
    private StringBuilder sb = null;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
      //  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        init();
        onclicklisteners();

    }

	private void connecttodatabase(String imageid) {
		// TODO Auto-generated method stub

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
        //http post
        try{
        	HttpClient httpclient = new DefaultHttpClient();
        	HttpPost httppost = new HttpPost("http://10.0.2.2/schedule.php");
        	
        	nameValuePairs.add(new BasicNameValuePair("ID", imageid));
        	httppost.setEntity(new UrlEncodedFormEntity( nameValuePairs ));
        	
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

        	String date;
        	String venue ;
        	String pcr;
        	String topic;
        	
        	try{
        		jArray = new JSONArray(result);
        		JSONObject json_data=null;
        		for(int i=0;i<jArray.length();i++){
        			json_data = jArray.getJSONObject(i);

        			date  = json_data.getString("date").toString();
        			venue = json_data.getString("venue").toString();
        			topic = json_data.getString("topic").toString();
        			pcr   = json_data.getString("pcr").toString();
        			
        			datetext.setText(date);
        			venuetext.setText(venue);
        			topictext.setText(topic);
        			pcrtext.setText(pcr);
        			
          }
      }
     
        	catch(JSONException e1){
        		Toast.makeText(getBaseContext(), "No Schedule Found" ,Toast.LENGTH_LONG).show();
        	} catch (ParseException e1) {
			e1.printStackTrace();
        }
}		
	

	private void onclicklisteners() {
		// TODO Auto-generated method stub
		
		image1.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("1");
			}
		});		
		image2.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("2");
			}
		});
		image3.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("3");
			}
		});
		image4.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("4");
			}
		});
		image5.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("5");
			}
		});
		image6.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("6");
			}
		});
		image7.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("7");
			}
		});
		image8.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("8");
			}
		});
		image9.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("9");
			}
		});
		image10.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("10");
			}
		});
		image11.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("11");
			}
		});
		image12.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("12");
			}
		});
		image13.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("13");
			}
		});
		image14.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("14");
			}
		});
		image15.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("15");
			}
		});
		image16.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("16");
			}
		});
		image17.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("17");
			}
		});
		image18.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("18");
			}
		});
		image19.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("19");
			}
		});
		image20.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				connecttodatabase("20");
			}
		});
	}


	
	private void init() {
		// TODO Auto-generated method stub
		 datetext 	= (TextView)findViewById(R.id.calenderdate);
		 topictext 	= (TextView)findViewById(R.id.topic_name);
		 venuetext	= (TextView)findViewById(R.id.venue_name);
		 pcrtext 	= (TextView)findViewById(R.id.preclass_name);
		 
		 image1 = (ImageView)findViewById(R.id.img1);
		 image2 = (ImageView)findViewById(R.id.img2);
		 image3 = (ImageView)findViewById(R.id.img3);
		 image4 = (ImageView)findViewById(R.id.img4);
		 image5 = (ImageView)findViewById(R.id.img5);
		 image6 = (ImageView)findViewById(R.id.img6);
		 image7 = (ImageView)findViewById(R.id.img7);
		 image8 = (ImageView)findViewById(R.id.img8);
		 image9 = (ImageView)findViewById(R.id.img9);
		 image10 = (ImageView)findViewById(R.id.img10);
		 image11 = (ImageView)findViewById(R.id.img11);
		 image12 = (ImageView)findViewById(R.id.img12);
		 image13 = (ImageView)findViewById(R.id.img13);
		 image14 = (ImageView)findViewById(R.id.img14);
		 image15 = (ImageView)findViewById(R.id.img15);
		 image16 = (ImageView)findViewById(R.id.img16);
		 image17 = (ImageView)findViewById(R.id.img17);
		 image18 = (ImageView)findViewById(R.id.img18);
		 image19 = (ImageView)findViewById(R.id.img19);
		 image20 = (ImageView)findViewById(R.id.img20);
	}
}