package com.pbi.vst;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.pbi.vst.effect.ImageReflect;
import com.pbi.vst.effect.anim.ScaleAnimEffect;
import com.pbi.vst.ui.Itv52LayoutInterface;

public class PlayCollectLayout extends LinearLayout implements
		Itv52LayoutInterface, View.OnClickListener, View.OnFocusChangeListener {

	private Context context;

	ScaleAnimEffect animEffect = new ScaleAnimEffect();
	TextView colectionCount;
	private AbsoluteLayout colectionLayout;
	ImageView colectionPoster;
	private FrameLayout historyFL;
	ListView historyList;
	private Context mContext;
	// private ArrayList<VideoPlayInfo> recodes; // 其实这个类用不到 。不如不创建

	private ImageView refImageView;
	private FrameLayout shoucangFL;
	TextView zhuiCount;
	TextView zhuiName;
	ImageView zhuiPoster;
	private FrameLayout zhuijuFL;

	public PlayCollectLayout(Context context) {
		super(context);
		this.context = context;
	}

	public void initData() {
		updateData();
	}

	@Override
	public void initListener() {
		this.zhuijuFL.setOnClickListener(this);
		this.shoucangFL.setOnClickListener(this);
		this.historyList.setOnFocusChangeListener(this);
		// this.historyList.setOnItemClickListener(new
		// PlayCollectLayout.1(this)); // 用不到
	}

	@Override
	public void initView() {
		setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		setGravity(1); // 1 代表什么 ..
		setOrientation(VERTICAL);

		addView(LayoutInflater.from(this.context).inflate(
				R.layout.play_colection, null));

		this.zhuijuFL = ((FrameLayout) findViewById(R.id.play_collect_tv_fl));
		this.zhuijuFL.getBackground().setAlpha(0);
		this.zhuijuFL.setOnFocusChangeListener(this);
		this.historyFL = ((FrameLayout) findViewById(R.id.play_collect_played_fl));
		this.historyFL.getBackground().setAlpha(0);
		this.historyFL.setOnFocusChangeListener(this);
		this.shoucangFL = ((FrameLayout) findViewById(R.id.play_collect_collected_fl));
		this.shoucangFL.getBackground().setAlpha(0);
		this.shoucangFL.setOnFocusChangeListener(this);
		this.colectionLayout = ((AbsoluteLayout) findViewById(R.id.play_colection_layout));
		this.refImageView = ((ImageView) findViewById(R.id.play_collect_reflected_img));
		this.zhuiPoster = ((ImageView) this.zhuijuFL
				.findViewById(R.id.play_collect_tv_poster));
		this.colectionPoster = ((ImageView) this.shoucangFL
				.findViewById(R.id.play_collect_collected_poster));
		this.zhuiCount = ((TextView) this.zhuijuFL
				.findViewById(R.id.play_collect_tv_text_count));
		this.zhuiName = ((TextView) this.zhuijuFL
				.findViewById(R.id.play_collect_tv_text_tvname));
		this.colectionCount = ((TextView) this.shoucangFL
				.findViewById(R.id.play_collect_collected_count));
		this.historyList = ((ListView) this.historyFL
				.findViewById(R.id.play_collect_played_list));
		this.historyList.setSelector(new ColorDrawable(0));
		this.historyList.setNextFocusUpId(R.id.play_collect);
		// 下面的用不到
		// this.adapter = new PlayHistoryRecodeAdapter(this.mContext,
		// this.recodes);
		// this.historyList.setAdapter(this.adapter);

	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateData() {
		Bitmap localBitmap = ImageReflect.createCutReflectedImage(
				ImageReflect.convertViewToBitmap(this.colectionLayout), 80);
		this.refImageView.setImageBitmap(localBitmap);
	}

	@Override
	public void onClick(View v) {
		// 跳转到Activity ///
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		switch (v.getId()) {
		case R.id.play_collect_tv_fl:
			if (hasFocus) {
				this.zhuijuFL.getBackground().setAlpha(255);
				this.animEffect.setAttributs(1.0F, 1.15F, 1.0F, 1.16F, 150L);
				Animation localAnimation3 = this.animEffect.createAnimation();
				this.zhuijuFL.bringToFront();
				this.zhuijuFL.startAnimation(localAnimation3);
				this.zhuijuFL.setNextFocusUpId(R.id.play_collect);
				this.zhuijuFL.setNextFocusRightId(R.id.play_collect_played_fl);
				break;
			} else {
				this.animEffect.setAttributs(1.15F, 1.0F, 1.16F, 1.0F, 80L);
				this.zhuijuFL.startAnimation(this.animEffect.createAnimation());
				this.zhuijuFL.getBackground().setAlpha(0);
				break;
			}
		case R.id.play_collect_played_fl:
			if (hasFocus) {
				this.historyFL.getBackground().setAlpha(255);
				this.animEffect.setAttributs(1.0F, 1.15F, 1.0F, 1.16F, 150L);
				Animation localAnimation1 = this.animEffect.createAnimation();
				this.historyFL.bringToFront();
				this.historyFL.startAnimation(localAnimation1);
				this.historyFL.setNextFocusUpId(R.id.play_collect);
				this.shoucangFL.setNextFocusLeftId(R.id.play_collect_tv_fl);
				this.shoucangFL.setNextFocusRightId(R.id.play_collect_collected_fl);
				break;
			} else {
				this.animEffect.setAttributs(1.15F, 1.0F, 1.16F, 1.0F, 80L);
				this.historyFL
						.startAnimation(this.animEffect.createAnimation());
				this.historyFL.getBackground().setAlpha(0);
				break;
			}
			
		case R.id.play_collect_collected_fl:
			if (hasFocus) {
				this.shoucangFL.getBackground().setAlpha(255);
				this.animEffect.setAttributs(1.0F, 1.15F, 1.0F, 1.16F, 150L);
				Animation localAnimation2 = this.animEffect.createAnimation();
				this.shoucangFL.bringToFront();
				this.shoucangFL.startAnimation(localAnimation2);
				this.shoucangFL.setNextFocusUpId(R.id.play_collect);
				this.shoucangFL.setNextFocusLeftId(R.id.play_collect_played_fl);
				
				break;
			} else {
				this.animEffect.setAttributs(1.15F, 1.0F, 1.16F, 1.0F, 80L);
				this.shoucangFL.startAnimation(this.animEffect
						.createAnimation());
				this.shoucangFL.getBackground().setAlpha(0);
				break;

			}

		default:
			break;
		}
	}

}
