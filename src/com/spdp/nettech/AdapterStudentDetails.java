package com.spdp.nettech;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterStudentDetails extends BaseAdapter{

	private static ArrayList<StudentDetails> studentdetailsArraylist ;
	private LayoutInflater mInflator ;
	
	public AdapterStudentDetails(Context context , ArrayList<StudentDetails> results)
	{
		studentdetailsArraylist = results ;
		mInflator = LayoutInflater.from(context);
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return studentdetailsArraylist.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return studentdetailsArraylist.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	static class ViewHolder {
		protected TextView name;
		protected TextView studentID;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		
		if(convertView == null){
			convertView = mInflator.inflate(R.layout.custom_participant_list_row, null);
			holder = new ViewHolder();
			holder.name = (TextView)convertView.findViewById(R.id.name);
			holder.studentID = (TextView)convertView.findViewById(R.id.student_id);
			convertView.setTag(holder);
		}else
			{
				holder = (ViewHolder)convertView.getTag();
			}
		holder.name.setText(studentdetailsArraylist.get(position).getname());
		holder.studentID.setText(studentdetailsArraylist.get(position).getid());
		
		return convertView;
	}

}
