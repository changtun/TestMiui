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
		// ����ж��� ��ʾ �Ƿ����°�װ��APP ������ʾһ�� new ��Imageview 
		// if (isANewApp(localAppBean))
		// localImageView2.setVisibility(0);
		// ���� �� ��ʾ����ķ�ҳ ��
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
	 * �ж�APP ����޸ĵ�ʱ�� �����Լ ĳһʱ��� ��˵���� �ɵ� �����°�װ��App �������Ȳ����ж��Ȳ�������ʾ �Ƿ����µ�
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
