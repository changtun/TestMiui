package com.pbi.vst;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pbi.vst.effect.ImageReflect;
import com.pbi.vst.ui.Itv52LayoutInterface;

public class SettingsLayout extends LinearLayout implements Itv52LayoutInterface, View.OnClickListener{

	private Context context;
	
	private ImageView channelSetup;
	  private ImageView clearCaches;
	  private ImageView netSetup;
	  private ImageView refImageView;
	  private ImageReflect reflect;
	  private ImageView regestLogin;
	  private ImageView remotSetup;
	  private ImageView scalerSetup;
	  private ImageView serverSetup;
	  private LinearLayout settingLayout;
	  private ImageView speedTest;
	  private ImageView systemSetup;
	  private ImageView vodSetup;
	public SettingsLayout(Context context) {
		super(context);
		this.context = context;
		
		setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
	    setGravity(1);
	    setOrientation(1);
	    addView(LayoutInflater.from(this.context).inflate(R.layout.settings, null));
//	    initView();
//	    initData();
//	    initListener();
	    
	}
	public void initData() {
		 Bitmap localBitmap = ImageReflect.createReflectedImage(ImageReflect.convertViewToBitmap(this.settingLayout));
		    this.refImageView.setImageBitmap(localBitmap);
	}
	@Override
	public void initListener() {
		this.netSetup.setOnClickListener(this);
	    this.serverSetup.setOnClickListener(this);
	    this.regestLogin.setOnClickListener(this);
	    this.channelSetup.setOnClickListener(this);
	    this.vodSetup.setOnClickListener(this);
	    this.systemSetup.setOnClickListener(this);
	    this.scalerSetup.setOnClickListener(this);
	    this.remotSetup.setOnClickListener(this);
	    this.speedTest.setOnClickListener(this);
	    this.clearCaches.setOnClickListener(this);
	}
	@Override
	public void initView() {
		 this.netSetup = ((ImageView)findViewById(R.id.net_setup_iv));
		    this.serverSetup = ((ImageView)findViewById(R.id.ser_setup_iv));
		    this.regestLogin = ((ImageView)findViewById(R.id.reg_setup_iv));
		    this.channelSetup = ((ImageView)findViewById(R.id.channel_setup_iv));
		    this.vodSetup = ((ImageView)findViewById(R.id.vod_setup_iv));
		    this.systemSetup = ((ImageView)findViewById(R.id.system_setup_iv));
		    this.scalerSetup = ((ImageView)findViewById(R.id.scaler_setup_iv));
		    this.remotSetup = ((ImageView)findViewById(R.id.remot_setup_iv));
		    this.speedTest = ((ImageView)findViewById(R.id.testspeed_setup_iv));
		    this.clearCaches = ((ImageView)findViewById(R.id.clear_setup_iv));
		    this.refImageView = ((ImageView)findViewById(R.id.settings_reflected_img));
		    this.settingLayout = ((LinearLayout)findViewById(R.id.settings_layout));
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
		// Í¨¹ý Intent Ìø×ª
		
	}

}
