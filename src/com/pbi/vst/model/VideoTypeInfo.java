package com.pbi.vst.model;

import java.io.Serializable;

public class VideoTypeInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5841687864020664510L;
	public String logo;
	public String name;
	public String nexturl;
	public String tid;
	public String typeurl;

	public String toString() {
		return "VideoTypeInfo [tid=" + this.tid + ", name=" + this.name
				+ ", logo=" + this.logo + ", typeurl=" + this.typeurl
				+ ", nexturl=" + this.nexturl + "]";
	}
}
