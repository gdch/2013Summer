package me.xiangchen.app.duetapp.call;

import me.xiangchen.app.duetapp.AppExtension;
import me.xiangchen.technique.posturesense.xacPostureSenseFeatureMaker;

import com.sonyericsson.extras.liveware.aef.control.Control;

public class CallExtension extends AppExtension {

	int posture;
	
	public CallExtension() {
		CallManager.setWatch(this);
	}
	
	@Override
	public void doResume() {
		showText("Call");
	}
	
	@Override
	public void doAccelerometer(float[] values) {
		xacPostureSenseFeatureMaker.updateWatchAccel(values);
		xacPostureSenseFeatureMaker.addWatchFeatureEntry();
	}
	
	@Override
	public void doSwipe(int direction) {
		posture = xacPostureSenseFeatureMaker.calculatePosture();
		if(posture != xacPostureSenseFeatureMaker.WATCH) {
			return;
		}
		
		switch (direction) {
		case Control.Intents.SWIPE_DIRECTION_UP:
			buzz(100);
			CallManager.playLastVoiceMail();
			break;
		case Control.Intents.SWIPE_DIRECTION_DOWN:
			buzz(100);
			CallManager.playNextVoiceMail();
			break;
		}
	}
}