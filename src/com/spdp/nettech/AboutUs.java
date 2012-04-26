package com.spdp.nettech;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUs extends Activity {

	private TextView phone1;
	private TextView phone2;
	private TextView site;
	private TextView email;
	private ImageView fb;
	private ImageView twitter;
	private ImageView blogger;
	private ImageView locationmage;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutus);
		
		initialize();
		
		phone1.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//phone1.setFocusableInTouchMode(true);
				String callstring = "tel:" + "09331590003";
				Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse(callstring));
				startActivity(intent);
			}
		});
	
		phone2.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				// TODO Auto-generated method stub			
				phone2.setFocusableInTouchMode(true);
				String callstring = "tel:" + "09339590003";
				Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse(callstring));
				startActivity(intent);
			}
		});
		
		site.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				site.setFocusableInTouchMode(true);
				String site = "http://www.nettech.in";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(site));
				startActivity(i);
			}
		});
		
		email.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				email.setFocusableInTouchMode(true);
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("plain/text");
				intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "swapan@nettech.in" });
				startActivity(Intent.createChooser(intent, ""));			}
		});
		
		fb.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				fb.setFocusableInTouchMode(true);
				String site = "http://www.facebook.com/nettech.in";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(site));
				startActivity(i); 
			}
		});
			
		twitter.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					// TODO Auto-generated method stub
					twitter.setFocusableInTouchMode(true);
					String site = "http://twitter.com/#!/nettech_in";
					Intent i = new Intent(Intent.ACTION_VIEW);
					i.setData(Uri.parse(site));
					startActivity(i); 
				}
			});

		blogger.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				blogger.setFocusableInTouchMode(true);
				String site = "http://blog.nettech.in/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(site));
				startActivity(i); 
			}
		});
		
		locationmage.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(getBaseContext(),ViewLocation.class);
				startActivity(in);
			}
		});
	}

	private void initialize() {
		// TODO Auto-generated method stub
		phone1 = (TextView)findViewById(R.id.phone1);
		phone2 = (TextView)findViewById(R.id.phone2);
		site = (TextView)findViewById(R.id.site);
		email = (TextView)findViewById(R.id.email);
		fb = (ImageView)findViewById(R.id.facebook);
		twitter = (ImageView)findViewById(R.id.twitter);
		blogger = (ImageView)findViewById(R.id.blogger);
		locationmage = (ImageView)findViewById(R.id.nettechlocationlauncher);
	}
}
