package com.spdp.nettech;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuOngoing extends Activity {

	private ImageView aboutus;
	private ImageView assignments;
	private ImageView challenge;
	private ImageView courseMaterial;
	private ImageView participantList;
	private ImageView schedule;
	private ImageView tools;
	private String campus_name;
	private CharSequence cname ;
	private CharSequence nettech ;
	private String name;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuongoing);
		
		Bundle b = getIntent().getExtras();
		nettech = "Nettech @ " ; 
		cname = b.getCharSequence("CAMPUS_NAME");
		setTitle(cname);
		
		aboutus = (ImageView) findViewById(R.id.ImageButton07);
		assignments = (ImageView) findViewById(R.id.ImageButton04);
		challenge = (ImageView) findViewById(R.id.ImageButton06);
		courseMaterial = (ImageView) findViewById(R.id.ImageButton01);
		participantList = (ImageView) findViewById(R.id.ImageButton03);
		schedule = (ImageView) findViewById(R.id.ImageButton02);


		
		aboutus.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuOngoing.this, AboutUs.class);
				intent.putExtra("CAMPUS_NAME", cname);
				startActivity(intent);
			}
		});
		participantList.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuOngoing.this,
						ParticipantList.class);
				intent.putExtra("CAMPUS_NAME", cname);
				startActivity(intent);
			}
		});
		schedule.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuOngoing.this, Schedule.class);
				intent.putExtra("CAMPUS_NAME", cname);
				startActivity(intent);
			}
		});
		challenge.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuOngoing.this, Challenge.class);
				intent.putExtra("CAMPUS_NAME", cname);
				startActivity(intent);
			}
		});
		assignments.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuOngoing.this, Assignments.class);
				intent.putExtra("CAMPUS_NAME", cname);
				startActivity(intent);
			}
		});
		courseMaterial.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuOngoing.this,CourseMaterial.class);
				intent.putExtra("CAMPUS_NAME", cname);
				startActivity(intent);
			}
		});
	}
}
