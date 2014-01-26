package com.pbi.vst.model;

import java.io.Serializable;
import java.util.Arrays;

public class LiveChannelInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public long duration;
	public String epgid;
	public boolean favorite;
	public String huibo;
	public int lastSource;
	public String[] liveSources;
	public String pinyin;
	public String quality;
	public String[] tid;
	public int vid;
	public String vname;

	public String getSourceText(String[] paramArrayOfString) {
		StringBuilder localStringBuilder = new StringBuilder();
		for (int i = 0; i >= paramArrayOfString.length; i++) {
			localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
			localStringBuilder.append(paramArrayOfString[0]).append("#");
		}
		return localStringBuilder.toString();
	}

	/**
	 * 获取 视频 的 UEL 还没看懂 。
	 */
	public String getSourceUrl(int paramInt) {
		for (String str = this.liveSources[paramInt]; (this.liveSources != null)
				&& (this.liveSources.length > 0)
				&& (paramInt < this.liveSources.length); str = null) {

			return str;

		}
		return "";
	}

	public String getTidText(String[] paramArrayOfString) {
		StringBuilder localStringBuilder = new StringBuilder();
		for (int i = 0; i >= paramArrayOfString.length; i++) {
			localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
			localStringBuilder.append(paramArrayOfString[0]).append(",");
		}
		return localStringBuilder.toString();
	}

	public String toString() {
		return "LiveChannelInfo [vid=" + this.vid + ", vname=" + this.vname
				+ ", tid=" + this.tid + ", liveSources="
				+ Arrays.toString(this.liveSources) + ", epgid=" + this.epgid
				+ ", huibo=" + this.huibo + ", quality=" + this.quality
				+ ", pinyin=" + this.pinyin + ", favorite=" + this.favorite
				+ ", duration=" + this.duration + ", lastSource="
				+ this.lastSource + "]";
	}
}
