package com.pbi.vst;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.pbi.vst.adapter.AllPagesAdapter;
import com.pbi.vst.ui.Itv52LayoutInterface;

/**
 *  问题 就出现在 Application  这个  类里面
 * @author Administrator
 *
 */
public class HomePage extends FrameLayout implements Itv52LayoutInterface {

	private RadioGroup titleGroup;
	private ViewPager centerPager;

	public ArrayList<View> pages = new ArrayList();
	private LatestHotLayout hot;
	private TVShowLayout live;
	private VideoTypeLayout cate;
	private PlayCollectLayout fav;
	private ApplicationLayout appMnanger;
	private SettingsLayout setting;

	private RadioButton hotrbtn, liverbtn, caterbtn, favrbtn, apprbtn,
			settingrbtn;

	private Context context;
	public HomePage(Context context) {
		 super(context);
		this.context = context;
		setFocusable(true);
		setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
		
		
		hot = new LatestHotLayout(context);
		live = new TVShowLayout(context);
		cate = new VideoTypeLayout(context);
		fav = new PlayCollectLayout(context);
		appMnanger = new ApplicationLayout(context);
		setting = new SettingsLayout(context);
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.latest_recommend, null);
		pages.add(hot);
		pages.add(live);
		pages.add(cate);
		pages.add(fav);
		pages.add(appMnanger);
		pages.add(setting);
		
		
		initView();
		loadData();
		initData();
		initListener();
		updateData();
	}
	


	public void initData() {
		hot.initData();
		live.initData();
		cate.initData();
		fav.initData();
		appMnanger.initData();
		setting.initData();
	}

	@Override
	public void initView() {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View localView = inflater.inflate(R.layout.main_layout_52itv, this);
		titleGroup = (RadioGroup) localView.findViewById(R.id.title_group);

		titleGroup.check(R.id.latest_recommend);

		centerPager = (ViewPager) localView.findViewById(R.id.main_layout_pager);

		centerPager.setAdapter(new AllPagesAdapter(pages));

		centerPager.setCurrentItem(0);

		hotrbtn = (RadioButton) localView.findViewById(R.id.latest_recommend);
		liverbtn = (RadioButton) localView.findViewById(R.id.tv_show);
		caterbtn = (RadioButton) localView.findViewById(R.id.video_type);
		favrbtn = (RadioButton) localView.findViewById(R.id.play_collect);
		apprbtn = (RadioButton) localView.findViewById(R.id.application);
		settingrbtn = (RadioButton) localView.findViewById(R.id.settings);

		this.hot.initView();
		this.live.initView();
		this.cate.initView();
		this.fav.initView();
		this.appMnanger.initView();
		this.setting.initView();
	}

	@Override
	public void loadData() {
		// 这是获取数据 先取消
		// new Thread(new HomePage.3(this)).start();
		hot.loadData();
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub

	}

	public void updateData(int paramInt) {
		// 更新 数据 这句话 还不懂 .. 取消 。
		/*
		 * while (true) { if (paramInt == 1) this.fav.updateData(); if (paramInt
		 * == 2) { this.live.updateData(); continue; } return; }
		 */
	}

	@Override
	public void initListener() {
		this.hotrbtn.setNextFocusDownId(R.id.latest_recommend_1_fl);
		this.liverbtn.setNextFocusDownId(R.id.tv_show_tv);
		this.caterbtn.setNextFocusDownId(R.id.video_type_xunleiOffLine_fl);
		this.favrbtn.setNextFocusDownId(R.id.play_collect_tv_fl);
		this.apprbtn.setNextFocusDownId(R.id.latest_recommend_1_fl);
		this.settingrbtn.setNextFocusDownId(R.id.net_setup_iv);
		this.hotrbtn.setNextFocusRightId(R.id.tv_show);
		this.liverbtn.setNextFocusRightId(R.id.video_type);
		this.liverbtn.setNextFocusLeftId(R.id.net_setup_iv);
		this.caterbtn.setNextFocusRightId(R.id.play_collect);
		this.caterbtn.setNextFocusLeftId(R.id.tv_show);
		this.favrbtn.setNextFocusRightId(R.id.application);
		this.favrbtn.setNextFocusLeftId(R.id.video_type);
		this.apprbtn.setNextFocusRightId(R.id.settings);
		this.apprbtn.setNextFocusLeftId(R.id.play_collect);
		this.settingrbtn.setNextFocusLeftId(R.id.application);
		
		
		HomePage_1 local1 = new HomePage_1(context);
		
		this.hotrbtn.setOnFocusChangeListener(local1);
		this.liverbtn.setOnFocusChangeListener(local1);
		this.caterbtn.setOnFocusChangeListener(local1);
		this.favrbtn.setOnFocusChangeListener(local1);
		this.apprbtn.setOnFocusChangeListener(local1);
		this.settingrbtn.setOnFocusChangeListener(local1);
		
		this.centerPager.setOnPageChangeListener(new HomePage_2(context));
		this.hot.initListener();
		this.live.initListener();
		this.cate.initListener();
		this.fav.initListener();
		this.appMnanger.initListener();
		this.setting.initListener();
		// this.mHandler.sendEmptyMessage(10);
	}

	/**
	 *  解决了 以前是 R.layout。 换成R.id 就行了
	 * @author Administrator
	 *
	 */
	class HomePage_2 implements ViewPager.OnPageChangeListener {

		private Context context;

		public HomePage_2(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int paramInt) {
			switch (paramInt) {
			case 0:
				titleGroup.check(R.id.latest_recommend);
				break;
			case 1:
				titleGroup.check(R.id.tv_show);
				break;
			case 2:
				titleGroup.check(R.id.video_type);
				break;
			case 3:
				titleGroup.check(R.id.play_collect);
				break;
			case 4:
				titleGroup.check(R.id.application);
				break;
			case 5:
				titleGroup.check(R.id.settings);
				break;

			default:

				break;
			}

		}

	}

	
	class HomePage_1 implements View.OnFocusChangeListener {

		private Context context;

		public HomePage_1(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
		}

		@Override
		public void onFocusChange(View paramView, boolean paramBoolean) {
			switch (paramView.getId()) {
			case R.id.latest_recommend:
				if(paramBoolean){
					centerPager.setCurrentItem(0);
				}
				break;
			case R.id.tv_show:
				if (paramBoolean)
					centerPager.setCurrentItem(1);
				break;
			case R.id.video_type:
				if (paramBoolean)
					centerPager.setCurrentItem(2);
				break;
			case R.id.play_collect:
				if (paramBoolean)
					centerPager.setCurrentItem(3);
				break;
			case R.id.application:
				if (paramBoolean)
					centerPager.setCurrentItem(4);
				break;
			case R.id.settings:
				if (paramBoolean)
					centerPager.setCurrentItem(5);
				break;

			default:
				break;
			}

		}

	}

}
