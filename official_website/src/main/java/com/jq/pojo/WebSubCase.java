package com.jq.pojo;

import java.io.Serializable;

public class WebSubCase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long mainCaseId;// 主案例ID
	private String subCaseInfo; // 子案例图文信息
	public Long getMainCaseId() {
		return mainCaseId;
	}
	public void setMainCaseId(Long mainCaseId) {
		this.mainCaseId = mainCaseId;
	}
	public String getSubCaseInfo() {
		return subCaseInfo;
	}
	public void setSubCaseInfo(String subCaseInfo) {
		this.subCaseInfo = subCaseInfo;
	}
	@Override
	public String toString() {
		return "WebSubCase [mainCaseId=" + mainCaseId + ", subCaseInfo=" + subCaseInfo + "]";
	}
	
}
