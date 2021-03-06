package me.xiangchen.app.authenticsense;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import me.xiangchen.ml.WatchAuthenticClassifier;
import me.xiangchen.ml.xacFeatureMaker;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AuthenticSense extends Activity implements SensorEventListener {

	public final static String LOGTAG = "AuthenticSense";
	public final static int PHONEACCELFPS = 50;

	RelativeLayout layout;
	Button btnAuthen;
	Button btnTraining;
	TextView textView;

	SensorManager sensorManager;
	Sensor sensorAccel;

	double runningSumAccel;
	double counter;

	long timeAuthen;

	boolean isLocked = true;
	boolean isTouching = false;

//	int numRowsToSend = 500 / (1000 / PHONEACCELFPS);

	Timer timer;
	int red = 255;
	int green = 255 - red;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_authentic_sense);

		AuthenticManager.initFeatureMaker();

		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensorAccel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensorManager.registerListener(this, sensorAccel,
				SensorManager.SENSOR_DELAY_FASTEST);

		btnAuthen = (Button) findViewById(R.id.btnAuthen);
		btnAuthen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AuthenticManager.toggleAuthenticMode();
				btnAuthen
						.setText(AuthenticManager.getMode() == AuthenticManager.AuthenMode.USINGWATCH ? "Watch"
								: "Phone");

			}
		});

		btnTraining = (Button) findViewById(R.id.btnTraining);
		btnTraining.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				AuthenticManager.toggleLabel();
				int label = AuthenticManager.getLabel();

				switch (label) {
				case AuthenticManager.INTHEWILD:
					btnTraining.setText("In the wild");
					break;
				case AuthenticManager.LEFTBACKWRIST:
					btnTraining.setText("Left back wrist");
					break;
				case AuthenticManager.LEFTINNERWRIST:
					btnTraining.setText("Left inner wrist");
					break;
				case AuthenticManager.RIGHTBACKWRIST:
					btnTraining.setText("Right back wrist");
					break;
				case AuthenticManager.RIGHTINNERWRIST:
					btnTraining.setText("Right inner wrist");
					break;
				case AuthenticManager.LEFTBACKWRISTNOPHONE:
					btnTraining.setText("Left back wrist no phone");
					break;
				}

			}
		});

		textView = (TextView) findViewById(R.id.textView);

		layout = (RelativeLayout) findViewById(R.id.layout);
		layout.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (AuthenticManager.getMode() != AuthenticManager.AuthenMode.USINGWATCH) {
					return false;
				}
				int action = event.getAction();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					isTouching = true;
					break;
				case MotionEvent.ACTION_UP:
					if (AuthenticManager.isRecognition()) {
						red = isLocked ? 255 : 0;
						green = 255 - red;
					} else {
						xacFeatureMaker .sendOffData(AuthenticManager.NUMROWPHONEAUTHEN,
								AuthenticManager.classLabels);
						xacFeatureMaker.clearData();
					}
					isTouching = false;
					break;
				}

				return true;
			}
		});

		if (AuthenticManager.isRecognition()) {
			btnTraining.setAlpha(0);
			textView.setText(isLocked ? "Locked!"
					: "5 missed calls from Tiffany");
		} else {
			btnTraining.setAlpha(1);
			textView.setText("AuthenticSense");
		}

		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				// Your database code here
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						red *= 0.9;
						green *= 0.9;
						textView.setBackgroundColor(Color.argb(255, red, green,
								0));

						if (AuthenticManager.isRecognition()) {
							btnTraining.setAlpha(0);

							if (AuthenticManager.getMode() == AuthenticManager.AuthenMode.USINGWATCH) {
								textView.setText(isLocked ? "Locked!"
										: "5 missed calls from Tiffany");
							} else {
								textView.setText("Authentic\nSense");
							}
						} else {
							btnTraining.setAlpha(1);
							textView.setText("AuthenticSense");
						}
					}
				});
			}
		}, new Date(), 50);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.authentic_sense, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_VOLUME_DOWN:
			toggleMode();
			break;
		}

		return true;
	}

	private void toggleMode() {
		AuthenticManager.toggleTrainingRecognition();
		Toast.makeText(
				this,
				AuthenticManager.isRecognition() ? "Recognition mode"
						: "Training mode", Toast.LENGTH_SHORT).show();

		// if (AuthenticManager.isRecognition()) {
		// btnTraining.setAlpha(0);
		// textView.setText(isLocked ? "Locked!"
		// : "5 missed calls from Tiffany");
		// } else {
		// btnTraining.setAlpha(1);
		// textView.setText("AuthenticSense");
		// }
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		xacFeatureMaker.updatePhoneAccel(event.values);
		xacFeatureMaker.addPhoneFeatureEntry();

		// float sumAccel = (float) (Math.sqrt(event.values[0] * event.values[0]
		// + event.values[1] * event.values[1] + event.values[2] *
		// event.values[2]) - 9.8f);
		// runningSumAccel *= 0.99;
		// counter *= 0.99;
		// runningSumAccel += sumAccel;
		// counter++;
		//
		// float runningAvrg = (float) ((runningSumAccel + 1)
		// / (counter + 1));
		// float spikePerc = (sumAccel - runningAvrg) / runningAvrg;
		//
		// if(spikePerc > 100) {
		// Log.d(LOGTAG, spikePerc + " " + runningAvrg + " " + counter);

		Calendar lCDateTime = Calendar.getInstance();
		long curTime = lCDateTime.getTimeInMillis();

		if (isTouching
				&& curTime - timeAuthen > AuthenticManager.AUTHENTICACTIONTIMEOUT) {
			if (AuthenticManager.isRecognition()) {
				int label = doClassification(AuthenticManager.NUMROWPHONEAUTHEN);
				if (label != AuthenticManager.INTHEWILD) {
					isLocked = !isLocked;
					textView.setText(isLocked ? "Locked!"
							: "5 missed calls from Tiffany");
					red = !isLocked ? 0 : 255;
					green = 255 - red;
					timeAuthen = curTime;
				}
			}
		}

	}

	private int doClassification(int n) {
		int idxClass = -1;
		Object[] features = xacFeatureMaker.getFlattenedData(n);
		if (features != null) {
			try {
				idxClass = (int) WatchAuthenticClassifier.classify(features);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//		switch (idxClass) {
//		case 0:
//			return AuthenticManager.HANDAUTHENTICATED;
//		case 1:
//			return AuthenticManager.INTHEWILD;
//		case 2:
//			return AuthenticManager.WATCHAUTHENTICATED;
//		}

		return idxClass;
	}

}
