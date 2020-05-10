package com.jq.vo;

import java.io.Serializable;

public class Photo implements Serializable{

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1556189309019571247L;
	
	
	
private String url;// 照片的路径
private String height;// 照片的高度
private String width;// 照片的宽度	
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getHeight() {
	return height;
}
public void setHeight(String height) {
	this.height = height;
}
public String getWidth() {
	return width;
}
public void setWidth(String width) {
	this.width = width;
}
	



	
}
