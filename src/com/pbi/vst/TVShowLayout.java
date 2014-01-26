package com.pbi.vst;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.pbi.vst.effect.ImageReflect;
import com.pbi.vst.effect.anim.ScaleAnimEffect;
import com.pbi.vst.model.LiveChannelInfo;
import com.pbi.vst.model.LiveTypeInfo;
import com.pbi.vst.ui.Itv52LayoutInterface;

public class TVShowLayout extends LinearLayout implements Itv52LayoutInterface,
		OnClickListener, View.OnFocusChangeListener {

	private static final String TAG = "TVShowLayout";
	private Context context;

	private RegularAdapter adapter;

	private FrameLayout myChanles;
	private FrameLayout cctv;
	private FrameLayout locality;

	private FrameLayout provinceIn;
	private ImageView refImageView;
	private ListView regularChanles;
	private FrameLayout regularChanlesFL;
	ArrayList<LiveChannelInfo> regulars = new ArrayList();
	private FrameLayout satellites;
	private FrameLayout sports;
	private AbsoluteLayout tvChanles;
	private FrameLayout tvScreen;
	private ArrayList<LiveTypeInfo> types;

	ScaleAnimEffect animEffect = new ScaleAnimEffect();

	// private MygicaVideoView videoView; 先取消这个 这个是播放视频画面的view

	public TVShowLayout(Context context) {
		super(context);
		this.context = context;
		// 这里还 获取 数据 ..
	}

	public void initData() {
		// 更新数据
		//
		Bitmap localBitmap = ImageReflect.createCutReflectedImage(
				ImageReflect.convertViewToBitmap(this.tvChanles), 74);
		this.refImageView.setImageBitmap(localBitmap);
		this.tvChanles.bringToFront();
	}

	@Override
	public void initListener() {
		this.tvScreen.setOnFocusChangeListener(this);
		this.tvScreen.setOnClickListener(this);
		this.provinceIn.setOnFocusChangeListener(this);
		this.provinceIn.setOnClickListener(this);
		this.myChanles.setOnFocusChangeListener(this);
		this.myChanles.setOnClickListener(this);
		this.sports.setOnFocusChangeListener(this);
		this.sports.setOnClickListener(this);
		this.cctv.setOnFocusChangeListener(this);
		this.cctv.setOnClickListener(this);
		this.satellites.setOnFocusChangeListener(this);
		this.satellites.setOnClickListener(this);
		this.locality.setOnFocusChangeListener(this);
		this.locality.setOnClickListener(this);
		this.regularChanlesFL.setOnFocusChangeListener(this);
		this.regularChanles.setOnFocusChangeListener(this);
		this.regularChanles
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					public void onItemClick(AdapterView<?> paramAdapterView,
							View paramView, int paramInt, long paramLong) {
						LiveChannelInfo localLiveChannelInfo = (LiveChannelInfo) TVShowLayout.this.adapter
								.getItem(paramInt);
						// 这里跳转到 另一个Activity 播放影片的Activity
						// Intent localIntent = new Intent(
						// TVShowLayout.this.context, LivePlayer.class);
						// localIntent.putExtra("tid",
						// localLiveChannelInfo.tid);
						// localIntent.putExtra("vid",
						// localLiveChannelInfo.vid);
						// TVShowLayout.this.context.startActivity(localIntent);
					}
				});
	}

	@Override
	public void initView() {
		setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		setGravity(1); // 1 代表什么 ..
		setOrientation(VERTICAL);
		addView(LayoutInflater.from(this.context).inflate(R.layout.tv_show,
				null));

		this.tvScreen = ((FrameLayout) findViewById(R.id.tv_show_tv));
		// this.videoView = ((MygicaVideoView)findViewById(2131230958));
		// this.videoView.setZOrderOnTop(true);
		this.provinceIn = ((FrameLayout) findViewById(R.id.tv_show_province_in));
		this.provinceIn.getBackground().setAlpha(0);
		this.myChanles = ((FrameLayout) findViewById(R.id.tv_show_my_chanles));
		this.myChanles.getBackground().setAlpha(0);
		this.sports = ((FrameLayout) findViewById(R.id.tv_show_sports));
		this.sports.getBackground().setAlpha(0);
		this.cctv = ((FrameLayout) findViewById(R.id.tv_show_cctv));
		this.cctv.getBackground().setAlpha(0);
		this.satellites = ((FrameLayout) findViewById(R.id.tv_show_satellites));
		this.satellites.getBackground().setAlpha(0);
		this.locality = ((FrameLayout) findViewById(R.id.tv_show_locality));
		this.locality.getBackground().setAlpha(0);
		this.regularChanlesFL = ((FrameLayout) findViewById(R.id.tv_show_chanles_fl));
		this.regularChanlesFL.getBackground().setAlpha(0);
		this.regularChanles = ((ListView) findViewById(R.id.tv_show_regularChancles));
		this.regularChanles.setNextFocusUpId(R.id.tv_show);
		this.regularChanles.setEmptyView(findViewById(R.id.tv_show_empty_text));
		this.adapter = new RegularAdapter();
		this.regularChanles.setAdapter(this.adapter);
		this.regularChanles.setSelector(new ColorDrawable(0));
		this.refImageView = ((ImageView) findViewById(R.id.tv_show_refimg));
		this.tvChanles = ((AbsoluteLayout) findViewById(R.id.tv_show_chanles));

	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		switch (v.getId()) {
		case R.id.tv_show_video:

			break;
		case R.id.tv_show_chanles:

			break;
		case R.id.tv_show_chanles_fl:

			break;
		case R.id.tv_show_regularChancles:

			break;
		case R.id.tv_show_empty_text:

			break;
		case R.id.tv_show_tv:
			if (hasFocus) {
				this.tvScreen.setBackgroundResource(R.drawable.tv_bg_selected);
				this.tvScreen.bringToFront();
				// this.mHandler.postDelayed(this.play, 500L);
				this.tvScreen.setNextFocusUpId(R.id.tv_show);
				break;
			} else {
				this.tvScreen.setBackgroundResource(R.drawable.tv_bg_default);
				break;
			}
		case R.id.tv_show_province_in:
			if (hasFocus) {
				this.provinceIn.getBackground().setAlpha(255);
				this.animEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
				Animation localAnimation6 = this.animEffect.createAnimation();
				this.provinceIn.bringToFront();
				this.provinceIn.startAnimation(localAnimation6);
				this.provinceIn.setNextFocusUpId(R.id.tv_show);
				break;
			} else {
				this.animEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
				this.provinceIn.startAnimation(this.animEffect
						.createAnimation());
				this.provinceIn.getBackground().setAlpha(0);
				break;

			}
		case R.id.tv_show_my_chanles:
			if (hasFocus) {
				this.myChanles.getBackground().setAlpha(255);
				this.animEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
				Animation localAnimation5 = this.animEffect.createAnimation();
				this.myChanles.bringToFront();
				this.myChanles.startAnimation(localAnimation5);
				break;
			} else {
				this.animEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
				this.myChanles
						.startAnimation(this.animEffect.createAnimation());
				this.myChanles.getBackground().setAlpha(0);
				break;
			}
		case R.id.tv_show_sports:
			if (hasFocus) {
				this.sports.getBackground().setAlpha(255);
				this.animEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
				Animation localAnimation4 = this.animEffect.createAnimation();
				this.sports.bringToFront();
				this.sports.startAnimation(localAnimation4);
				this.sports.setNextFocusUpId(R.id.tv_show);
				break;
			} else {
				this.animEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
				this.sports.startAnimation(this.animEffect.createAnimation());
				this.sports.getBackground().setAlpha(0);
				break;
			}
		case R.id.tv_show_cctv:
			if (hasFocus) {
				this.cctv.getBackground().setAlpha(255);
				this.animEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
				Animation localAnimation3 = this.animEffect.createAnimation();
				this.cctv.bringToFront();
				this.cctv.startAnimation(localAnimation3);
				break;
			} else {
				this.animEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
				this.cctv.startAnimation(this.animEffect.createAnimation());
				this.cctv.getBackground().setAlpha(0);
				break;
			}
		case R.id.tv_show_satellites:
			if (hasFocus) {
				this.satellites.getBackground().setAlpha(255);
				this.animEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
				Animation localAnimation2 = this.animEffect.createAnimation();
				this.satellites.bringToFront();
				this.satellites.startAnimation(localAnimation2);
				this.satellites.setNextFocusUpId(R.id.tv_show);
				break;
			} else {
				this.animEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
				this.satellites.startAnimation(this.animEffect
						.createAnimation());
				this.satellites.getBackground().setAlpha(0);
				break;
			}
		case R.id.tv_show_locality:
			if (hasFocus) {
				this.locality.getBackground().setAlpha(255);
				this.animEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
				Animation localAnimation1 = this.animEffect.createAnimation();
				this.locality.bringToFront();
				this.locality.startAnimation(localAnimation1);
				break;
			} else {
				this.animEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
				this.locality.startAnimation(this.animEffect.createAnimation());
				this.locality.getBackground().setAlpha(0);
				break;
			}

		default:
			break;
		}
	}

	class RegularAdapter extends BaseAdapter {
		RegularAdapter() {
		}

		public int getCount() {
			return TVShowLayout.this.regulars.size();
		}

		public Object getItem(int paramInt) {
			return TVShowLayout.this.regulars.get(paramInt);
		}

		public long getItemId(int paramInt) {
			return paramInt;
		}

		public View getView(int paramInt, View paramView,
				ViewGroup paramViewGroup) {
			LiveChannelInfo localLiveChannelInfo = (LiveChannelInfo) TVShowLayout.this.regulars
					.get(paramInt);
			TextView localTextView = new TextView(TVShowLayout.this.context);
			localTextView.setTextSize(20.0F);
			localTextView.setLeft(10);
			localTextView.setBottom(10);
			localTextView.setTop(10);
			localTextView
					.setBackgroundResource(R.drawable.listview_item_selector);
			localTextView.setTextColor(-16777216);
			localTextView.setText(localLiveChannelInfo.vname);
			return localTextView;
		}
	}
}
