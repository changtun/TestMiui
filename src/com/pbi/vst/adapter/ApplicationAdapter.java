package com.pbi.vst.adapter;

import java.io.File;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pbi.vst.R;
import com.pbi.vst.model.AppBean;

public class ApplicationAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<AppBean> lancherInfos;
	int index = -1;

	public ApplicationAdapter(Context context, ArrayList<AppBean> paramArrayList) {
		this.context = context;
		setLauncher(paramArrayList);
	}

	private void setLauncher(ArrayList<AppBean> paramArrayList) {
		if (paramArrayList != null) {
			lancherInfos = paramArrayList;
		} else {
			lancherInfos = new ArrayList<AppBean>();
		}
	}

	@Override
	public int getCount() {
		return lancherInfos.size();
	}

	@Override
	public Object getItem(int arg0) {
		return lancherInfos.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
		if (paramView == null) {
			paramView = LayoutInflater.from(context).inflate(
					R.layout.application_grid_item, null);
		}
		ImageView localImageView1 = (ImageView) paramView
				.findViewById(R.id.app_icon);
		TextView localTextView = (TextView) paramView
				.findViewById(R.id.app_name);
		ImageView localImageView2 = (ImageView) paramView
				.findViewById(R.id.new_app);
		ImageView localImageView3 = (ImageView) paramView
				.findViewById(R.id.directioniv);

		AppBean localAppBean = (AppBean) this.lancherInfos.get(paramInt);
		localImageView1.setImageDrawable(localAppBean.getIcon());
		localTextView.setText(localAppBean.getName());
		// 这个判断是 显示 是否是新安装的APP 上面显示一个 new 的Imageview 
		// if (isANewApp(localAppBean))
		// localImageView2.setVisibility(0);
		// 这是 个 显示下面的翻页 。
		if (this.index == paramInt)
			localImageView3.setVisibility(0);
		paramView.setLayoutParams(new AbsListView.LayoutParams(180, 180));
		return paramView;
	}

	public void changeData(int paramInt) {
		this.index = paramInt;
		notifyDataSetChanged();
	}

	public void changeData(ArrayList<AppBean> paramArrayList, int paramInt) {
		this.lancherInfos = paramArrayList;
		this.index = paramInt;
		notifyDataSetChanged();
	}

	/**
	 * 判断APP 最后修改的时间 如果大约 某一时间段 就说明是 旧的 否则新安装的App 我这里先不做判断先不让他显示 是否是新的
	 * 
	 * @param paramAppBean
	 * @return
	 */
	private boolean isANewApp(AppBean paramAppBean) {
		if (259200000L + new File(paramAppBean.getDataDir()).lastModified() >= System
				.currentTimeMillis()) {
			return false;
		}
		return true;
	}
}
