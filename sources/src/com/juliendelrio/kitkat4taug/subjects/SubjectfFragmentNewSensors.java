package com.juliendelrio.kitkat4taug.subjects;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juliendelrio.kitkat4taug.R;

public class SubjectfFragmentNewSensors extends AbstractSubjectfFragment implements
		SensorEventListener {
	private static final StringBuilder sBuilder = new StringBuilder();
	public static final int TYPE_GEOMAGNETIC_ROTATION_VECTOR = Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR;
	public static final int TYPE_STEP_COUNTER = Sensor.TYPE_STEP_COUNTER;
	public static final int TYPE_STEP_DETECTOR = Sensor.TYPE_STEP_DETECTOR;
	private SensorManager mSensorManager;
	private Sensor mGeomagneticRotationVector;
	private Sensor mStepCounter;
	private Sensor mStepDetector;
	private TextView textView_geo_accu;
	private TextView textView_geo_values;
	private TextView textView_step_counter_accu;
	private TextView textView_step_counter_values;
	private TextView textView_step_detect_accu;
	private TextView textView_step_detect_values;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_new_sensors, container, false);
		textView_geo_accu = (TextView) view.findViewById(R.id.textView_geo_accu);
		textView_geo_values = (TextView) view.findViewById(R.id.textView_geo_values);
		textView_step_counter_accu = (TextView) view.findViewById(R.id.textView_step_counter_accu);
		textView_step_counter_values = (TextView) view
				.findViewById(R.id.textView_step_counter_values);
		textView_step_detect_accu = (TextView) view.findViewById(R.id.textView_step_detect_accu);
		textView_step_detect_values = (TextView) view
				.findViewById(R.id.textView_step_detect_values);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
		mGeomagneticRotationVector = mSensorManager
				.getDefaultSensor(TYPE_GEOMAGNETIC_ROTATION_VECTOR);
		mStepCounter = mSensorManager.getDefaultSensor(TYPE_STEP_COUNTER);
		mStepDetector = mSensorManager.getDefaultSensor(TYPE_STEP_DETECTOR);
	}

	public void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, mGeomagneticRotationVector,
				SensorManager.SENSOR_DELAY_NORMAL);
		mSensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_NORMAL);
		mSensorManager.registerListener(this, mStepDetector, SensorManager.SENSOR_DELAY_NORMAL);
	}

	public void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(this);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		if (sensor == mGeomagneticRotationVector) {
			textView_geo_accu.setText("" + accuracy);
		} else if (sensor == mStepCounter) {
			textView_step_counter_accu.setText("" + accuracy);
		} else if (sensor == mStepDetector) {
			textView_step_detect_accu.setText("" + accuracy);
		}

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		Sensor sensor = event.sensor;
		float[] values = event.values;
		sBuilder.setLength(0);
		for (int i = 0; i < values.length; i++) {
			sBuilder.append(Math.round(values[i] * 1000) / 1000f);
			if (i + 1 < values.length)
				sBuilder.append(", ");
		}
		if (sensor == mGeomagneticRotationVector) {
			textView_geo_values.setText(sBuilder.toString());
		} else if (sensor == mStepCounter) {
			textView_step_counter_values.setText(sBuilder.toString());
		} else if (sensor == mStepDetector) {
			textView_step_detect_values.setText(sBuilder.toString());
		}

	}
}
