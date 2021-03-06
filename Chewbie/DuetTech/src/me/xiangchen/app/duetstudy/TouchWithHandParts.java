package me.xiangchen.app.duetstudy;

import me.xiangchen.app.duettech.R;
import me.xiangchen.technique.touchsense.xacTouchSenseFeatureMaker;
import android.content.Context;
import android.view.MotionEvent;

public class TouchWithHandParts extends TechniqueShell {

	public TouchWithHandParts(Context context) {
		super(context);
		technique = TOUCHWITHHANDPARTS;

		numClasses = 3;
		classLabels = new int[] {xacTouchSenseFeatureMaker.PAD, xacTouchSenseFeatureMaker.SIDE, xacTouchSenseFeatureMaker.KNUCKLE};
		numTrialsPerBlock = numClasses * numDataPointsPerClass / numBlocks;
		
		labelCounter = new int[numClasses];
		radii = new float[numClasses];
		for(int i=0; i<numClasses; i++) {
			labelCounter[i] = 0;
			radii[i] = 1;
		}
		
		tvStatus.setText("Touch with hand parts");
	}

	@Override
	public boolean doTouch(MotionEvent event) {
		if(!isBreak && isReadyForNextTrial) {
			if(isStarted) {
				if (xacTouchSenseFeatureMaker.isDataReady()) {
					int touchResult = xacTouchSenseFeatureMaker
							.calculateHandPart(new double[] { event.getSize(0) });
					xacTouchSenseFeatureMaker.setLabels(label, touchResult);
					xacTouchSenseFeatureMaker.sendOffData(new float[] { event
							.getSize(0) });
					trial++;

					if (trial == numTrialsPerBlock) {
						block++;
						isBreak = true;
						if (block == numBlocks) {
							tvCue.setTextColor(0xFFFFFFFF);
							tvCue.setText("End of technique");
						} else {
							tvCue.setTextColor(0xFFFFFFFF);
							tvCue.setText("End of block");
						}
					} else {
						tvCue.setTextColor(0xFFFFFFFF);
						tvCue.setText("Please wait ...");
					}
				}
				
			} else {
				isStarted = true;
				block = 0;
				trial = 0;
			}
			xacTouchSenseFeatureMaker.clearData();
			isReadyForNextTrial = false;
			
		}
		return false;
	}
	
	@Override
	public void runOnTimer() {
		if (!isBreak) {
			if (!xacTouchSenseFeatureMaker.isDataReady()) {
				tvCue.setTextColor(0xFFFFFFFF);
				tvCue.setText("Please wait ...");
				isReadyForNextTrial = false;
				// Log.d(LOGTAG, "wait...");
			} else {
				if (!isReadyForNextTrial) {
					if (isStarted) {
						if(block == 0) {
							label = nextClassLabel(true);
						} else {
							label = nextClassLabel(false);
						}
						setCues();
						setStatus();
					} else {
						tvCue.setTextColor(0xFFFFFFFF);
						tvCue.setText("Tap to start...");
					}

					isReadyForNextTrial = true;
					// Log.d(LOGTAG, "ready");
				}
			}
		}
	}
	
	@Override
	protected void setCues() {
		super.setCues();
		switch(label) {
		case xacTouchSenseFeatureMaker.PAD:
			tvCue.setText("Pad of index finger");
			ivCue.setImageResource(R.drawable.pad);
			break;
		case xacTouchSenseFeatureMaker.SIDE:
			tvCue.setText("Side of index finger");
			ivCue.setImageResource(R.drawable.side);
			break;
		case xacTouchSenseFeatureMaker.KNUCKLE:
			tvCue.setText("Knuckle of index finger");
			ivCue.setImageResource(R.drawable.knuckle);
			break;
		}
	}
}
