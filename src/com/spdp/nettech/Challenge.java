package com.spdp.nettech;

import android.app.Activity;
import android.os.Bundle;

public class Challenge extends Activity {
	private String cname ;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.challenge);
		
		Bundle b = getIntent().getExtras();
		cname = b.getString("CAMPUS_NAME");
		setTitle(cname);
	}
}
