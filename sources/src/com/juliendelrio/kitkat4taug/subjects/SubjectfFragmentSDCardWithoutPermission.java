package com.juliendelrio.kitkat4taug.subjects;

import java.io.File;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.juliendelrio.kitkat4taug.R;

public class SubjectfFragmentSDCardWithoutPermission extends AbstractSubjectfFragment {

	private TextView textView_path;
	private ListView listView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_sdcard_without_permission, container, false);
		textView_path = (TextView) view.findViewById(R.id.textView_path);
		listView = (ListView) view.findViewById(android.R.id.list);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		File file = getActivity().getExternalFilesDir(null);
		textView_path.setText(file.getAbsolutePath());
		File[] childsList = file.listFiles();
		listView.setAdapter(new CustomAdapter(getActivity().getLayoutInflater(), childsList));
	}

	private class CustomAdapter extends BaseAdapter {
		private File[] filesList;
		private LayoutInflater inflater;

		public CustomAdapter(LayoutInflater inflater, File[] filesList) {
			super();
			this.filesList = filesList;
			this.inflater = inflater;
		}

		@Override
		public int getCount() {
			return filesList.length;
		}

		@Override
		public Object getItem(int position) {
			return filesList[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Holder holder;
			if (convertView == null) {
				convertView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
				holder = new Holder();
				holder.text1 = (TextView) convertView.findViewById(android.R.id.text1);
				holder.text2 = (TextView) convertView.findViewById(android.R.id.text2);
				convertView.setTag(holder);
			} else {
				holder = (Holder) convertView.getTag();
			}
			holder.text1.setText(filesList[position].getName());
			if (filesList[position].isDirectory()) {
				holder.text2.setText("Is directory");
			} else {
				holder.text2.setText(filesList[position].getAbsolutePath());
			}
			return convertView;
		}

		private class Holder {
			TextView text1;
			TextView text2;
		}

	}
}
