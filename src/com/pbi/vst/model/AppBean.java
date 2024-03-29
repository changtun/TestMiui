package com.pbi.vst.model;

import android.graphics.drawable.Drawable;

public class AppBean {

	private String dataDir;
	private Drawable icon;
	private String id;
	private String name;
	private String packageName;
	private int pageIndex;
	private int position;

	public String getDataDir() {
		return this.dataDir;
	}

	public Drawable getIcon() {
		return this.icon;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public int getPageIndex() {
		return this.pageIndex;
	}

	public int getPosition() {
		return this.position;
	}

	public void setDataDir(String paramString) {
		this.dataDir = paramString;
	}

	public void setIcon(Drawable paramDrawable) {
		this.icon = paramDrawable;
	}

	public void setId(String paramString) {
		this.id = paramString;
	}

	public void setName(String paramString) {
		this.name = paramString;
	}

	public void setPackageName(String paramString) {
		this.packageName = paramString;
	}

	public void setPageIndex(int paramInt) {
		this.pageIndex = paramInt;
	}

	public void setPosition(int paramInt) {
		this.position = paramInt;
	}

	public String toString() {
		return "AppBean [packageName=" + this.packageName + ", name="
				+ this.name + ", dataDir=" + this.dataDir + "]";
	}
}
