package com.pbi.vst.effect.anim;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

public class ScaleAnimEffect {

	private long duration;
	private float fromXScale;
	private float fromYScale;
	private float toXScale;
	private float toYScale;

	public Animation createAnimation() {
		ScaleAnimation localScaleAnimation = new ScaleAnimation(
				this.fromXScale, this.toXScale, this.fromYScale, this.toYScale,
				1, 0.5F, 1, 0.5F);
		localScaleAnimation.setFillAfter(true);
		localScaleAnimation.setDuration(this.duration);
		return localScaleAnimation;
	}

	public void setAttributs(float paramFloat1, float paramFloat2,
			float paramFloat3, float paramFloat4, long paramLong) {
		this.fromXScale = paramFloat1;
		this.fromYScale = paramFloat3;
		this.toXScale = paramFloat2;
		this.toYScale = paramFloat4;
		this.duration = paramLong;
	}
}
