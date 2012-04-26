package com.spdp.nettech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MenuGonnabe extends Activity {

	private ImageView aboutus;
	private ImageView courseMaterial;
	private ImageView schedule;
	private ImageView registration;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menugonnabe);

		registration = (ImageView) findViewById(R.id.IB01);
		courseMaterial = (ImageView) findViewById(R.id.IB02);
		schedule = (ImageView) findViewById(R.id.IB03);
		aboutus = (ImageView) findViewById(R.id.IB04);

		aboutus.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuGonnabe.this, AboutUs.class);
				startActivity(intent);
			}
		});
		schedule.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuGonnabe.this, Schedule.class);
				startActivity(intent);
			}
		});
		registration.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuGonnabe.this, Registration.class);
				startActivity(intent);
			}
		});
		courseMaterial.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuGonnabe.this,
						CourseMaterial.class);
				startActivity(intent);
			}
		});
	}
}
