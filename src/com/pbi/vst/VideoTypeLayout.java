package com.pbi.vst;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pbi.vst.effect.ImageReflect;
import com.pbi.vst.effect.anim.ScaleAnimEffect;
import com.pbi.vst.model.VideoTypeInfo;
import com.pbi.vst.ui.Itv52LayoutInterface;

public class VideoTypeLayout extends LinearLayout implements
		Itv52LayoutInterface, OnClickListener, View.OnFocusChangeListener {

	private Context context;

	private static final String TAG = "VideoTypeLayout";
	private FrameLayout arts;
	TextView artsText;
	private Drawable artsbg;
	Bitmap[] b = new Bitmap[3];
	private FrameLayout cartoon;
	TextView cartoonText;
	private Drawable cartoonbg;
	private FrameLayout education;
	TextView educationText;
	private Drawable educationbg;
	private FrameLayout film;
	TextView filmText;
	private Drawable filmbg;
	ImageView[] ivs;
	private FrameLayout jilu;
	private Drawable jilubg;
	private Context mContext;
	private Handler mHandler;
	TextView musicText;
	TextView news7Text;
	private ImageView refImageView;
	private ImageReflect reflect;
	private FrameLayout tv;
	TextView tvText;
	private Drawable tvbg;
	TextView[] tvs;
	private AbsoluteLayout typeLayout;
	private ArrayList<VideoTypeInfo> typePageData;
	private FrameLayout xunlei;
	private Drawable xunleibg;

	public VideoTypeLayout(Context context) {
		super(context);
		this.context = context;

	}

	public void initData() {
		 // 获取  数据 。没看..
		Bitmap localBitmap = ImageReflect.createCutReflectedImage(ImageReflect.convertViewToBitmap(this.typeLayout), 110);
	      this.refImageView.setImageBitmap(localBitmap);
	      this.typeLayout.bringToFront();
	}

	@Override
	public void initListener() {
		this.xunlei.setOnClickListener(this);
	    this.xunlei.setOnFocusChangeListener(this);
	    this.tv.setOnClickListener(this);
	    this.tv.setOnFocusChangeListener(this);
	    this.film.setOnClickListener(this);
	    this.film.setOnFocusChangeListener(this);
	    this.arts.setOnClickListener(this);
	    this.arts.setOnFocusChangeListener(this);
	    this.cartoon.setOnClickListener(this);
	    this.cartoon.setOnFocusChangeListener(this);
	    this.education.setOnClickListener(this);
	    this.education.setOnFocusChangeListener(this);
	    this.jilu.setOnClickListener(this);
	    this.jilu.setOnFocusChangeListener(this);
	}

	@Override
	public void initView() {
		setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		setGravity(1); // 1 代表什么 ..
		setOrientation(VERTICAL);
		addView(LayoutInflater.from(this.context).inflate(R.layout.video_type,
				null));

		this.xunlei = ((FrameLayout) findViewById(R.id.video_type_xunleiOffLine_fl));
		this.xunleibg = this.xunlei.getBackground();
		this.xunleibg.setAlpha(0);
		this.tv = ((FrameLayout) findViewById(R.id.video_type_tv_fl));
		this.tvbg = this.tv.getBackground();
		this.tvbg.setAlpha(0);
		this.film = ((FrameLayout) findViewById(R.id.video_type_film_fl));
		this.filmbg = this.film.getBackground();
		this.filmbg.setAlpha(0);
		this.arts = ((FrameLayout) findViewById(R.id.video_type_arts_fl));
		this.artsbg = this.arts.getBackground();
		this.artsbg.setAlpha(0);
		this.cartoon = ((FrameLayout) findViewById(R.id.video_type_cartoon_fl));
		this.cartoonbg = this.cartoon.getBackground();
		this.cartoonbg.setAlpha(0);
		this.education = ((FrameLayout) findViewById(R.id.video_type_education_fl));
		this.educationbg = this.education.getBackground();
		this.educationbg.setAlpha(0);
		this.jilu = ((FrameLayout) findViewById(R.id.video_type_jilu_fl));
		this.jilubg = this.jilu.getBackground();
		this.jilubg.setAlpha(0);
		this.refImageView = ((ImageView) findViewById(R.id.video_type_reflected_img));
		this.typeLayout = ((AbsoluteLayout) findViewById(R.id.video_type_layout));
		this.ivs = new ImageView[3];
		this.ivs[0] = ((ImageView) this.xunlei.findViewById(R.id.video_type_xunleiOffLine_poster));
		this.ivs[1] = ((ImageView) this.tv.findViewById(R.id.video_type_tvPoster));
		this.ivs[2] = ((ImageView) this.cartoon.findViewById(R.id.video_type_cartoon_poster));
		this.tvs = new TextView[7];
		this.tvs[0] = ((TextView) this.xunlei.findViewById(R.id.video_type_xunleiOffLine_text));
		this.tvs[1] = ((TextView) this.tv.findViewById(R.id.video_type_tv_text));
		this.tvs[2] = ((TextView) this.film.findViewById(R.id.video_type_film_text));
		this.tvs[3] = ((TextView) this.arts.findViewById(R.id.video_type_arts_text));
		this.tvs[4] = ((TextView) this.cartoon.findViewById(R.id.video_type_cartoon_text));
		this.tvs[5] = ((TextView) this.education.findViewById(R.id.video_type_education_text));
		this.tvs[6] = ((TextView) this.jilu.findViewById(R.id.video_type_jilu_text));
	}

	@Override
	public void loadData() {
		// 加载 数据 ... 
		// 先 拿过来一部分 研究一下 
		// 这里 好像是 请求一个 http 连接  并解析 网络 反悔的XML 数据 到一个ArrayList 中 
//		this.typePageData = Dom4jXmlUtils.parseTopCate(ConfigUtil.getValue("CATE_URL"));
		// 发送handler
//	      this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 10, 0));
		// 如果 请求的数据  不为空 
//	      if (!this.typePageData.isEmpty())
//	      {
		// 把 里面的图片 资源 赋值给 image
//	        this.b[0] = BitmapUtil.getBitmap(this.mContext, ((VideoTypeInfo)this.typePageData.get(0)).logo);
//	        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 5, 0));
//	        this.b[1] = BitmapUtil.getBitmap(this.mContext, ((VideoTypeInfo)this.typePageData.get(1)).logo);
//	        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 5, 0));
//	        this.b[2] = BitmapUtil.getBitmap(this.mContext, ((VideoTypeInfo)this.typePageData.get(4)).logo);
//	        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 5, 0));
//	      }
	}

	@Override
	public void updateData() {
		
	}


	@Override
	public void onClick(View v) {
		// 点击的时候 会 通过Intent 跳转  intent 里携带着数据 
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		ScaleAnimEffect localScaleAnimEffect = new ScaleAnimEffect();
		switch (v.getId()) {
		case R.id.video_type_xunleiOffLine_fl:
			 if (hasFocus)
		      {
		        this.xunleibg.setAlpha(255);
		        localScaleAnimEffect.setAttributs(1.0F, 1.15F, 1.0F, 1.16F, 150L);
		        Animation localAnimation7 = localScaleAnimEffect.createAnimation();
		        this.xunlei.bringToFront();
		        this.xunlei.startAnimation(localAnimation7);
		        this.xunlei.setNextFocusRightId(R.id.video_type_tv_fl);
		        this.xunlei.setNextFocusUpId(R.id.video_type);
		        break ;
		      }else{
		    	  localScaleAnimEffect.setAttributs(1.15F, 1.0F, 1.16F, 1.0F, 80L);
		    	  this.xunlei.startAnimation(localScaleAnimEffect.createAnimation());
		    	  this.xunleibg.setAlpha(0);
		    	  break;
		      }  
		case R.id.video_type_tv_fl:
			  if (hasFocus)
		      {
		        this.tvbg.setAlpha(255);
		        localScaleAnimEffect.setAttributs(1.0F, 1.15F, 1.0F, 1.15F, 150L);
		        Animation localAnimation6 = localScaleAnimEffect.createAnimation();
		        this.tv.bringToFront();
		        this.tv.startAnimation(localAnimation6);
		        this.tv.setNextFocusUpId(R.id.video_type);
		        this.tv.setNextFocusLeftId(R.id.video_type_xunleiOffLine_fl);
		        this.tv.setNextFocusRightId(R.id.video_type_cartoon_fl);
		        this.tv.setNextFocusDownId(R.id.video_type_film_fl);
		        break;
		      }else{
		    	  localScaleAnimEffect.setAttributs(1.15F, 1.0F, 1.15F, 1.0F, 80L);
		    	  this.tv.startAnimation(localScaleAnimEffect.createAnimation());
		    	  this.tvbg.setAlpha(0);
		    	  break;
		      }
		case R.id.video_type_film_fl:
			 if (hasFocus)
		      {
		        this.filmbg.setAlpha(255);
		        localScaleAnimEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
		        Animation localAnimation5 = localScaleAnimEffect.createAnimation();
		        this.film.bringToFront();
		        this.film.startAnimation(localAnimation5);
		        this.film.setNextFocusLeftId(R.id.video_type_xunleiOffLine_fl);
		        this.film.setNextFocusRightId(R.id.video_type_arts_fl);
		        this.film.setNextFocusUpId(R.id.video_type_tv_fl);
		        break;
		      }else{
		    	  localScaleAnimEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
		    	  this.film.startAnimation(localScaleAnimEffect.createAnimation());
		    	  this.filmbg.setAlpha(0);
		    	  break;
		      }
		case R.id.video_type_arts_fl:
			if (hasFocus)
		      {
		        this.artsbg.setAlpha(255);
		        localScaleAnimEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
		        Animation localAnimation4 = localScaleAnimEffect.createAnimation();
		        this.arts.bringToFront();
		        this.arts.startAnimation(localAnimation4);
		        this.arts.setNextFocusLeftId(R.id.video_type_film_fl);
		        this.arts.setNextFocusRightId(R.id.video_type_cartoon_fl);
		        this.arts.setNextFocusUpId(R.id.video_type_tv_fl);
		        break;
		      }else{
		    	  localScaleAnimEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
		    	  this.arts.startAnimation(localScaleAnimEffect.createAnimation());
		    	  this.artsbg.setAlpha(0);
		    	  break;
		      }
		case R.id.video_type_cartoon_fl:
			  if (hasFocus)
		      {
		        this.cartoonbg.setAlpha(255);
		        localScaleAnimEffect.setAttributs(1.0F, 1.15F, 1.0F, 1.16F, 150L);
		        Animation localAnimation3 = localScaleAnimEffect.createAnimation();
		        this.cartoon.bringToFront();
		        this.cartoon.startAnimation(localAnimation3);
		        this.cartoon.setNextFocusRightId(R.id.video_type_education_fl);
		        this.cartoon.setNextFocusLeftId(R.id.video_type_tv_fl);
		        this.cartoon.setNextFocusUpId(R.id.video_type);
		        break;
		      }else{
		    	  localScaleAnimEffect.setAttributs(1.15F, 1.0F, 1.16F, 1.0F, 80L);
		    	  this.cartoon.startAnimation(localScaleAnimEffect.createAnimation());
		    	  this.cartoonbg.setAlpha(0);
		    	  break;
		      }
		case R.id.video_type_education_fl:
			if (hasFocus)
		      {
		        this.educationbg.setAlpha(255);
		        localScaleAnimEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
		        Animation localAnimation2 = localScaleAnimEffect.createAnimation();
		        this.education.bringToFront();
		        this.education.startAnimation(localAnimation2);
		        this.education.setNextFocusLeftId(R.id.video_type_cartoon_fl);
		        this.education.setNextFocusDownId(R.id.video_type_jilu_fl);
		        this.education.setNextFocusUpId(R.id.video_type);
		        break;
		      }else{
		    	  localScaleAnimEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
		    	  this.education.startAnimation(localScaleAnimEffect.createAnimation());
		    	  this.educationbg.setAlpha(0);
		    	  break;
		      }
		case R.id.video_type_jilu_fl:
			 
		      if (hasFocus)
		      {
		        this.jilubg.setAlpha(255);
		        localScaleAnimEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
		        Animation localAnimation1 = localScaleAnimEffect.createAnimation();
		        this.jilu.bringToFront();
		        this.jilu.startAnimation(localAnimation1);
		        this.jilu.setNextFocusLeftId(R.id.video_type_cartoon_fl);
		        this.jilu.setNextFocusUpId(R.id.video_type_education_fl);
		        break;
		      }else{
		    	  localScaleAnimEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
		    	  this.jilu.startAnimation(localScaleAnimEffect.createAnimation());
		    	  this.jilubg.setAlpha(0);
		    	  break;
		    	  
		      }

		default:
			break;
		}
	}
	
}
