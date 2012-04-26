package com.spdp.nettech;

import java.util.ArrayList;

import com.spdp.nettech.AdapterCampusDetails.ViewHolder;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterCourseMaterial extends BaseAdapter{

	private static ArrayList<Files> filearraylist ;
	private LayoutInflater mInflator ;

	public AdapterCourseMaterial(Context context , ArrayList<Files> results)
	{
		filearraylist = results ;
		mInflator = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return filearraylist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return filearraylist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	static class ViewHolder {
		protected TextView filename;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = null ;
		ViewHolder holder;
		
		if(convertView == null){
			view = mInflator.inflate(R.layout.coursematerial_row, null);
			holder = new ViewHolder();
			holder.filename = (TextView)view.findViewById(R.id.coursem_filename);
			view.setTag(holder);
		}else
			{
				view = convertView ;
			}
		ViewHolder holderNew = (ViewHolder)view.getTag();
		Log.d("Size in Adapter", filearraylist.size() + " ");
		Log.d("NAAM", filearraylist.get(position).getname());
		Log.d("pos", position + "");

		//holder.filename = (TextView)view.findViewById(R.id.coursem_filename);		
		holderNew.filename.setText(filearraylist.get(position).getname());
		
		return view;
	}

}
