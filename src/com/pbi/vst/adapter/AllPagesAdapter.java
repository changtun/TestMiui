package com.pbi.vst.adapter;

import java.util.ArrayList;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class AllPagesAdapter extends PagerAdapter {

	private ArrayList<View> views;

	public AllPagesAdapter(ArrayList<View> paramArrayList) {
		this.views = paramArrayList;
	}

	public void dataChanged(ArrayList<View> paramArrayList) {
		this.views = paramArrayList;
		notifyDataSetChanged();
	}

	public void destroyItem(ViewGroup paramViewGroup, int paramInt,
			Object paramObject) {
		((ViewPager) paramViewGroup).removeView(views.get(paramInt));
	}

	public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
		View localView = (View)this.views.get(paramInt);
	    paramViewGroup.addView(localView);
		return  localView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return views.size();
	}

	@Override
	public boolean isViewFromObject(View paramView, Object paramObject) {
		return paramView == paramObject;
	}

	public Parcelable saveState() {
		return null;
	}

	public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt,
			Object paramObject) {
	}
}
