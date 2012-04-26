package com.spdp.nettech;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Launcher extends Activity {
	/** Called when the activity is first created. */
	private Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		button = (Button)findViewById(R.id.buttonLauncher);
		final AlertDialog.Builder builder = new AlertDialog.Builder(Launcher.this);
		
		builder.setTitle(R.string.locate);
		builder.setSingleChoiceItems(R.array.Campus_Name, -1, new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				switch(which){
				case(0):{
					Intent in = new Intent(getApplicationContext(),
							Ongoing.class);
					startActivity(in);
					break;
				}
				case(1):{
					Intent in = new Intent(getApplicationContext(),
							Gonnabe.class);
					startActivity(in);
					break;
				}
				}
			}
		});
		button.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog alert = builder.create();
				alert.show();
			}
			
		});
		
	}
}