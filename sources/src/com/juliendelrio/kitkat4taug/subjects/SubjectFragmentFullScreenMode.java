package com.juliendelrio.kitkat4taug.subjects;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.juliendelrio.kitkat4taug.R;

public class SubjectFragmentFullScreenMode extends AbstractSubjectFragment implements
		OnClickListener {

	private View mDecorView;
	private Button buttonSystemUI;
	private Button buttonNavigationUI;
	private Button buttonNavigationUIWithImmersive;
	private Button buttonDefault;
	private Button buttonSystemUIWithNavigation;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_immersive, container, false);
		buttonNavigationUI = (Button) view.findViewById(R.id.Button_navigationUI);
		buttonNavigationUI.setOnClickListener(this);
		buttonNavigationUIWithImmersive = (Button) view
				.findViewById(R.id.Button_navigationUIWithImmersive);
		buttonNavigationUIWithImmersive.setOnClickListener(this);
		buttonSystemUI = (Button) view.findViewById(R.id.Button_systemUI);
		buttonSystemUI.setOnClickListener(this);
		buttonSystemUIWithNavigation = (Button) view
				.findViewById(R.id.Button_systemUIWithNavigation);
		buttonSystemUIWithNavigation.setOnClickListener(this);
		buttonDefault = (Button) view.findViewById(R.id.Button_default);
		buttonDefault.setOnClickListener(this);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		mDecorView = getActivity().getWindow().getDecorView();
		super.onActivityCreated(savedInstanceState);
	}

	private void hideSystemUI() {
		mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
				| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LOW_PROFILE
				| View.SYSTEM_UI_FLAG_IMMERSIVE);
	}

	private void showSystemUI() {
		mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
				| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
	}

	@Override
	public void onClick(View v) {
		if (buttonNavigationUI == v) {
			mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
		}
		if (buttonNavigationUIWithImmersive == v) {
			mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE
					| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
		}
		if (buttonSystemUI == v) {
			mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
		}
		if (buttonSystemUIWithNavigation == v) {
			mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
					| View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
		}
		if (buttonDefault == v) {
			mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
		}

	}
}
