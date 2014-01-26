package com.pbi.vst;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pbi.vst.effect.ImageReflect;
import com.pbi.vst.effect.anim.ScaleAnimEffect;
import com.pbi.vst.model.VideoInfo;
import com.pbi.vst.ui.Itv52LayoutInterface;

public class LatestHotLayout extends LinearLayout implements
		Itv52LayoutInterface, View.OnClickListener, View.OnFocusChangeListener {

	private Context context;

	private ArrayList<ImageView> posters;

	private Drawable bg1;
	private Drawable bg2;
	private Drawable bg3;
	private Drawable bg4;
	private Drawable bg5;
	private Drawable bg6;
	private Drawable bg7;

	Bitmap[] bitmaps = null;

	private FrameLayout news1;
	private TextView news1Text;
	private FrameLayout news2;
	private TextView news2Text;
	private FrameLayout news3;
	private TextView news3Text;
	private FrameLayout news4;
	private TextView news4Text;
	private FrameLayout news5;
	private TextView news5Text;
	private FrameLayout news6;
	private TextView news6Text;
	private FrameLayout news7;
	private TextView news7Text;
	private ImageView refImageView;
	private ImageView text1bg;
	private ImageView text2bg;
	private ImageView text3bg;
	private ImageView text4bg;
	private ImageView text5bg;
	private ImageView text6bg;
	private ImageView text7bg;

	private AbsoluteLayout latestLayout;
	private ArrayList<VideoInfo> topRecommends;

	public LatestHotLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;

		setFocusable(true);
		setDescendantFocusability(262144);
		
	}

	public void initData() {
		Bitmap localBitmap2 = ImageReflect.createCutReflectedImage(
				ImageReflect.convertViewToBitmap(this.latestLayout), 110);
		this.refImageView.setImageBitmap(localBitmap2);
		
		setTextToView(0, this.news1Text);
		setTextToView(1, this.news2Text);
		setTextToView(2, this.news3Text);
		setTextToView(3, this.news4Text);
		setTextToView(4, this.news5Text);
		setTextToView(5, this.news6Text);
		setTextToView(6, this.news7Text);
		for (int i = 0; i >= this.posters.size(); i++) {
			Bitmap localBitmap1 = this.bitmaps[i];
			if (localBitmap1 != null) {
				((ImageView) this.posters.get(i)).setImageBitmap(localBitmap1);

			}
			// if (localBitmap1 == null)
			// continue;
		}

	}

	/**
	 * 这里面的 循环语句 有问题 ...
	 * 
	 * @param paramInt
	 * @param paramTextView
	 */
	private void setTextToView(int paramInt, TextView paramTextView) {
		String str = null;
		if (this.topRecommends != null) {
			str = ((VideoInfo) this.topRecommends.get(paramInt)).title;

		} else if (str != null) {
			paramTextView.setText(str);

		} else {
			paramTextView.setText("");

		}

	}

	// 首先调用的是 initView
	@Override
	public void initView() {
		setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		setGravity(1); // 1 代表什么 ..
		setOrientation(VERTICAL);

		addView(LayoutInflater.from(this.context).inflate(R.layout.latest_recommend,
				null));
		news1 = (FrameLayout) findViewById(R.id.latest_recommend_1_fl);
		news2 = (FrameLayout) findViewById(R.id.latest_recommend_2_fl);
		news3 = (FrameLayout) findViewById(R.id.latest_recommend_3_fl);
		news4 = (FrameLayout) findViewById(R.id.latest_recommend_4_fl);
		news5 = (FrameLayout) findViewById(R.id.latest_recommend_5_fl);
		news6 = (FrameLayout) findViewById(R.id.latest_recommend_6_fl);
		news7 = (FrameLayout) findViewById(R.id.latest_recommend_7_fl);
		this.bg1 = this.news1.getBackground();
		this.bg1.setAlpha(0);
		this.bg2 = this.news2.getBackground();
		this.bg2.setAlpha(0);
		this.bg3 = this.news3.getBackground();
		this.bg3.setAlpha(0);
		this.bg4 = this.news4.getBackground();
		this.bg4.setAlpha(0);
		this.bg5 = this.news5.getBackground();
		this.bg5.setAlpha(0);
		this.bg6 = this.news6.getBackground();
		this.bg6.setAlpha(0);
		this.bg7 = this.news7.getBackground();
		this.bg7.setAlpha(0);

		latestLayout = (AbsoluteLayout) this.findViewById(R.id.latest_layout);
		text1bg = (ImageView) this.news1
				.findViewById(R.id.latest_recommend_1_text_bg);
//		text1bg.setVisibility(GONE);
		text2bg = (ImageView) this.news2
				.findViewById(R.id.latest_recommend_2_text_bg);
		text2bg.setVisibility(GONE);
		text3bg = (ImageView) this.news3
				.findViewById(R.id.latest_recommend_3_text_bg);
		text3bg.setVisibility(GONE);
		text4bg = (ImageView) this.news4
				.findViewById(R.id.latest_recommend_4_text_bg);
		text4bg.setVisibility(GONE);
		text5bg = (ImageView) this.news5
				.findViewById(R.id.latest_recommend_5_text_bg);
		text5bg.setVisibility(GONE);
		text6bg = (ImageView) this.news6
				.findViewById(R.id.latest_recommend_6_text_bg);
		text6bg.setVisibility(GONE);
		text7bg = (ImageView) this.news7
				.findViewById(R.id.latest_recommend_7_text_bg);
		text7bg.setVisibility(GONE);

		news1Text = (TextView) this.news1.findViewById(R.id.latest_recommend_1_text);
		news1Text.setVisibility(GONE);
		news2Text = (TextView) this.news2.findViewById(R.id.latest_recommend_2_text);
		news2Text.setVisibility(GONE);
		news3Text = (TextView) this.news3.findViewById(R.id.latest_recommend_3_text);
		news3Text.setVisibility(GONE);
		news4Text = (TextView) this.news4.findViewById(R.id.latest_recommend_4_text);
		news4Text.setVisibility(GONE);
		news5Text = (TextView) this.news5.findViewById(R.id.latest_recommend_5_text);
		news5Text.setVisibility(GONE);
		news6Text = (TextView) this.news6.findViewById(R.id.latest_recommend_6_text);
		news6Text.setVisibility(GONE);
		news7Text = (TextView) this.news7.findViewById(R.id.latest_recommend_7_text);
		news7Text.setVisibility(GONE);

		this.posters = new ArrayList();
		posters.add((ImageView) this.news1
				.findViewById(R.id.latest_recommend_1_poster));
		posters.add((ImageView) this.news2
				.findViewById(R.id.latest_recommend_2_poster));
		posters.add((ImageView) this.news3
				.findViewById(R.id.latest_recommend_3_poster));
		posters.add((ImageView) this.news4
				.findViewById(R.id.latest_recommend_4_poster));
		posters.add((ImageView) this.news5
				.findViewById(R.id.latest_recommend_5_poster));
		posters.add((ImageView) this.news6
				.findViewById(R.id.latest_recommend_6_poster));
		posters.add((ImageView) this.news7
				.findViewById(R.id.latest_recommend_7_poster));

		refImageView = (ImageView) this.findViewById(R.id.reflected_img);
	}

	/**
	 * 先不加载数据....
	 */
	@Override
	public void loadData() {

		topRecommends = new ArrayList<VideoInfo>();
		VideoInfo videoInfo1 = new VideoInfo();
		videoInfo1.title = "陆贞传奇";
		videoInfo1.id = 1;
		topRecommends.add(videoInfo1);
		topRecommends.add(videoInfo1);
		topRecommends.add(videoInfo1);
		topRecommends.add(videoInfo1);
		topRecommends.add(videoInfo1);
		topRecommends.add(videoInfo1);
		topRecommends.add(videoInfo1);

		bitmaps = new Bitmap[7];
		bitmaps[0] = BitmapFactory.decodeResource(getResources(),
				R.drawable.six1);
		bitmaps[1] = BitmapFactory.decodeResource(getResources(),
				R.drawable.five);
		bitmaps[2] = BitmapFactory.decodeResource(getResources(),
				R.drawable.one);
		bitmaps[3] = BitmapFactory.decodeResource(getResources(),
				R.drawable.three);
		bitmaps[4] = BitmapFactory.decodeResource(getResources(),
				R.drawable.two);
		bitmaps[5] = BitmapFactory.decodeResource(getResources(),
				R.drawable.six);
		bitmaps[6] = BitmapFactory.decodeResource(getResources(),
				R.drawable.four);

		/**
		 * 这面的 这些 是从网络中 查找的
		 */
		// try {
		// this.topRecommends = Dom4jXmlUtils.parseTopRecommend(ConfigUtil
		// .getValue("TOP_URL"));
		// this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 10, 0));
		// if (!this.topRecommends.isEmpty()) {
		// this.bitmaps = new Bitmap[this.topRecommends.size()];
		// for (int i = 0; i < this.bitmaps.length; i++) {
		// this.bitmaps[i] = BitmapUtil.getBitmap(this.context,
		// ((VideoInfo) this.topRecommends.get(i)).img);
		// this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 5,
		// 0));
		// }
		// }
		// } catch (ConnectTimeoutException localConnectTimeoutException) {
		// this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
		// localConnectTimeoutException.printStackTrace();
		// } catch (SocketTimeoutException localSocketTimeoutException) {
		// this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
		// localSocketTimeoutException.printStackTrace();
		// } catch (IOException localIOException) {
		// this.mHandler.sendMessage(this.mHandler.obtainMessage(9));
		// localIOException.printStackTrace();
		// } catch (DocumentException localDocumentException) {
		// this.mHandler.sendMessage(this.mHandler.obtainMessage(9));
		// localDocumentException.printStackTrace();
		// }

	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {
		this.news1.setOnClickListener(this);
		this.news2.setOnClickListener(this);
		this.news3.setOnClickListener(this);
		this.news4.setOnClickListener(this);
		this.news5.setOnClickListener(this);
		this.news6.setOnClickListener(this);
		this.news7.setOnClickListener(this);
		this.news1.setOnFocusChangeListener(this);
		this.news2.setOnFocusChangeListener(this);
		this.news3.setOnFocusChangeListener(this);
		this.news4.setOnFocusChangeListener(this);
		this.news5.setOnFocusChangeListener(this);
		this.news6.setOnFocusChangeListener(this);
		this.news7.setOnFocusChangeListener(this);
	}

	/**
	 * 触 焦 方法
	 */
	@Override
	public void onFocusChange(View v, boolean paramBoolean) {
		this.latestLayout.bringToFront();
		ScaleAnimEffect localScaleAnimEffect = new ScaleAnimEffect();
		switch (v.getId()) {

		case R.id.latest_recommend_1_fl:
			if (paramBoolean) {
				this.bg1.setAlpha(255);
				this.text1bg.setVisibility(0);
				this.news1Text.setVisibility(0);
				localScaleAnimEffect.setAttributs(1.0F, 1.15F, 1.0F, 1.16F,
						150L);
				Animation localAnimation7 = localScaleAnimEffect
						.createAnimation();
				this.news1.bringToFront();
				this.news1.startAnimation(localAnimation7);
				this.news1.setNextFocusRightId(R.id.latest_recommend_2_fl);
				this.news1.setNextFocusUpId(R.id.latest_recommend);
				break;
			} else {
				localScaleAnimEffect
						.setAttributs(1.15F, 1.0F, 1.16F, 1.0F, 80L);
				this.news1.startAnimation(localScaleAnimEffect
						.createAnimation());
				this.bg1.setAlpha(0);
				this.text1bg.setVisibility(8);
				this.news1Text.setVisibility(8);
				break;
			}
		case R.id.latest_recommend_2_fl:
			if (paramBoolean) {
				//为什么背景色 不占用控件大小 。
				// 是因为 使用的是 frameLayout 写死了 X轴Y轴 如果图片大 后面的直接覆盖 在他上面所以 可以排列着很完整
				// 当获取到焦点时
				// 设置 背景色 为 不透明 
				this.bg2.setAlpha(255);
				// image 显示
				this.text2bg.setVisibility(0);
				// textview 显示
				this.news2Text.setVisibility(0);
				// 这是一个 动画 方法的 方法 
				localScaleAnimEffect.setAttributs(1.0F, 1.15F, 1.0F, 1.15F,
						150L);
				Animation localAnimation6 = localScaleAnimEffect
						.createAnimation();
				// 这个 方法 尤其重要 就是 当控件获取到焦点的时候 可以让 他 凸出 ，
				// 就是 可以让他 在 其他的控件的 前面 。其他的控件 在后面 。这里让layout 在其他layout 的前面了。
				this.news2.bringToFront();
				// 启动动画 
				this.news2.startAnimation(localAnimation6);
				
				this.news2.setNextFocusDownId(R.id.latest_recommend_3_fl);
				this.news2.setNextFocusRightId(R.id.latest_recommend_5_fl);
				this.news2.setNextFocusLeftId(R.id.latest_recommend_1_fl);
				this.news2.setNextFocusUpId(R.id.latest_recommend);
				break;
			} else {
				localScaleAnimEffect
						.setAttributs(1.15F, 1.0F, 1.15F, 1.0F, 80L);
				this.news2.startAnimation(localScaleAnimEffect
						.createAnimation());
				// 不是焦点的时候 
				// 设置 layout 的背景 为透明的 。所以 看不见 
				this.bg2.setAlpha(0);
				this.text2bg.setVisibility(8); // 不可见 不占用 原来的布局空间 
				this.news2Text.setVisibility(8);
				break;

			}
		case R.id.latest_recommend_3_fl:
			if (paramBoolean) {
				this.bg3.setAlpha(255);
				this.text3bg.setVisibility(0);
				this.news3Text.setAlpha(255.0F);
				localScaleAnimEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
				Animation localAnimation5 = localScaleAnimEffect
						.createAnimation();
				this.news3.bringToFront();
				this.news3.startAnimation(localAnimation5);
				this.news3.setNextFocusLeftId(R.id.latest_recommend_1_fl);
				this.news3.setNextFocusRightId(R.id.latest_recommend_4_fl);
				this.news3.setNextFocusUpId(R.id.latest_recommend_2_fl);
				break;
			} else {
				localScaleAnimEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
				this.news3.startAnimation(localScaleAnimEffect
						.createAnimation());
				this.bg3.setAlpha(0);
				this.text3bg.setVisibility(8);
				this.news3Text.setAlpha(0.0F);
				break;

			}
		case R.id.latest_recommend_4_fl:
			if (paramBoolean) {
				this.bg4.setAlpha(255);
				this.text4bg.setVisibility(0);
				this.news4Text.setVisibility(0);
				localScaleAnimEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
				Animation localAnimation4 = localScaleAnimEffect
						.createAnimation();
				this.news4.bringToFront();
				this.news4.startAnimation(localAnimation4);
				this.news4.setNextFocusLeftId(R.id.latest_recommend_3_fl);
				this.news4.setNextFocusRightId(R.id.latest_recommend_5_fl);
				this.news4.setNextFocusUpId(R.id.latest_recommend_2_fl);
				break;
			} else {
				localScaleAnimEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
				this.news4.startAnimation(localScaleAnimEffect
						.createAnimation());
				this.bg4.setAlpha(0);
				this.text4bg.setVisibility(8);
				this.news4Text.setVisibility(8);
				break;

			}
		case R.id.latest_recommend_5_fl:
			if (paramBoolean) {
				this.bg5.setAlpha(255);
				this.text5bg.setVisibility(0);
				this.news5Text.setVisibility(0);
				localScaleAnimEffect.setAttributs(1.0F, 1.16F, 1.0F, 1.16F,
						150L);
				Animation localAnimation3 = localScaleAnimEffect
						.createAnimation();
				this.news5.bringToFront();
				this.news5.startAnimation(localAnimation3);
				this.news5.setNextFocusLeftId(R.id.latest_recommend_2_fl);
				this.news5.setNextFocusRightId(R.id.latest_recommend_6_fl);
				this.news5.setNextFocusUpId(R.id.latest_recommend);
				break;
			}
			localScaleAnimEffect.setAttributs(1.16F, 1.0F, 1.16F, 1.0F, 80L);
			this.news5.startAnimation(localScaleAnimEffect.createAnimation());
			this.bg5.setAlpha(0);
			this.text5bg.setVisibility(8);
			this.news5Text.setVisibility(8);
			break;
		case R.id.latest_recommend_6_fl:
			if (paramBoolean) {
				this.bg6.setAlpha(255);
				this.text6bg.setVisibility(0);
				this.news6Text.setVisibility(0);
				localScaleAnimEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
				Animation localAnimation2 = localScaleAnimEffect
						.createAnimation();
				this.news6.bringToFront();
				this.news6.startAnimation(localAnimation2);
				this.news6.setNextFocusDownId(R.id.latest_recommend_7_fl);
				this.news6.setNextFocusLeftId(R.id.latest_recommend_5_fl);
				this.news6.setNextFocusUpId(R.id.latest_recommend);
				break;
			} else {
				localScaleAnimEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
				this.news6.startAnimation(localScaleAnimEffect
						.createAnimation());
				this.bg6.setAlpha(0);
				this.text6bg.setVisibility(8);
				this.news6Text.setVisibility(8);
				break;

			}
		case R.id.latest_recommend_7_fl:
			if (paramBoolean) {
				this.bg7.setAlpha(255);
				this.text7bg.setVisibility(0);
				this.news7Text.setVisibility(0);
				localScaleAnimEffect.setAttributs(1.0F, 1.3F, 1.0F, 1.3F, 150L);
				Animation localAnimation1 = localScaleAnimEffect
						.createAnimation();
				this.news7.bringToFront();
				this.news7.startAnimation(localAnimation1);
				this.news7.setNextFocusLeftId(R.id.latest_recommend_5_fl);
				this.news7.setNextFocusUpId(R.id.latest_recommend_6_fl);
				break;
			} else {
				localScaleAnimEffect.setAttributs(1.3F, 1.0F, 1.3F, 1.0F, 80L);
				this.news7.startAnimation(localScaleAnimEffect
						.createAnimation());
				this.bg7.setAlpha(0);
				this.text7bg.setVisibility(8);
				this.news7Text.setVisibility(8);
				break;
			}

		default:
			break;
		}

	}

	/**
	 * 点击 方法
	 * 
	 * 先取消 ... 点击跳转
	 */
	@Override
	public void onClick(View v) {

		/*
		 * Intent localIntent = new Intent(context, VideoDetailsActivity.class);
		 * VideoInfo localVideoInfo = null;
		 * 
		 * switch (v.getId()) { case R.id.latest_recommend_1_fl: localVideoInfo
		 * = (VideoInfo) this.topRecommends.get(0); break; case
		 * R.id.latest_recommend_2_fl: localVideoInfo = (VideoInfo)
		 * this.topRecommends.get(1); break; case R.id.latest_recommend_3_fl:
		 * localVideoInfo = (VideoInfo) this.topRecommends.get(2); break; case
		 * R.id.latest_recommend_4_fl: localVideoInfo = (VideoInfo)
		 * this.topRecommends.get(3); break; case R.id.latest_recommend_5_fl:
		 * localVideoInfo = (VideoInfo) this.topRecommends.get(4); break; case
		 * R.id.latest_recommend_6_fl: localVideoInfo = (VideoInfo)
		 * this.topRecommends.get(5); break; case R.id.latest_recommend_7_fl:
		 * localVideoInfo = (VideoInfo) this.topRecommends.get(6); break;
		 * default: if (localVideoInfo != null) break;
		 * this.mHandler.sendEmptyMessage(11);
		 * localIntent.putExtra("VIDEODEAIL", localVideoInfo.id);
		 * this.mContext.startActivity(localIntent); ((Activity)
		 * this.context).overridePendingTransition(2130968589, 2130968586); }
		 */

	}

}
