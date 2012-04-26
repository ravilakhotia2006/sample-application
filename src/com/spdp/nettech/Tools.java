package com.spdp.nettech;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Tools extends ListActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tools);

		String[] Tools_List = new String[] { "Ping a Server",
				"Traceroute to a Server", "Whois of a Domain Name",
				"Wifi Connectivity Tester" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(Tools.this,
				R.layout.tools_row, Tools_List);
		setListAdapter(adapter);
		
	}
}