package com.pbi.vst.model;

import java.io.Serializable;

public class VideoInfo implements Serializable {
	private static final long serialVersionUID = 991029316222408987L;
	public String banben;
	public int id;
	public String img;
	public String nexturl;
	public String title;

	public String toString() {
		return "VideoInfo [id=" + this.id + ", title=" + this.title + ", img="
				+ this.img + ", banben=" + this.banben + ", nexturl="
				+ this.nexturl + "]";
	}
}
