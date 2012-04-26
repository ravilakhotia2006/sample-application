package com.spdp.nettech;

import java.util.ArrayList;

import com.spdp.nettech.AdapterStudentDetails.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterCampusDetails extends BaseAdapter{

	private static ArrayList<CampusDetails> campusnamearraylist ;
	private LayoutInflater mInflator ;

	public AdapterCampusDetails(Context context , ArrayList<CampusDetails> results)
	{
		campusnamearraylist = results ;
		mInflator = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return campusnamearraylist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return campusnamearraylist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	static class ViewHolder {
		protected TextView campusname;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		
		if(convertView == null){
			convertView = mInflator.inflate(R.layout.campuslist_row, null);
			holder = new ViewHolder();
			holder.campusname = (TextView)convertView.findViewById(R.id.campusname);
			convertView.setTag(holder);
		}else
			{
				holder = (ViewHolder)convertView.getTag();
			}
		holder.campusname.setText(campusnamearraylist.get(position).getname());
		
		return convertView;
	}
}
