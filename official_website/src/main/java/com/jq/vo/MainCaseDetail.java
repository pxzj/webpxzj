package com.jq.vo;

import java.io.Serializable;
import java.util.List;

import com.jq.pojo.WebCase;
import com.jq.pojo.WebSubCase;

public class MainCaseDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6658230872182809580L;
	
	
	private WebCase webCase;
	private   WebSubCase  webSubCase;
	public WebCase getWebCase() {
		return webCase;
	}
	public void setWebCase(WebCase webCase) {
		this.webCase = webCase;
	}
	public WebSubCase getWebSubCase() {
		return webSubCase;
	}
	public void setWebSubCase(WebSubCase webSubCase) {
		this.webSubCase = webSubCase;
	}
	@Override
	public String toString() {
		return "MainCaseDetail [webCase=" + webCase + ", webSubCase=" + webSubCase + "]";
	}
	
}
