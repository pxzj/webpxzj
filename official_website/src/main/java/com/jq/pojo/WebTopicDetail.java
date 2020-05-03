package com.jq.pojo;

import java.io.Serializable;

public class WebTopicDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8430482713930609972L;
	
	
	
	private  Long topicId; // 话题ID
	private  String topicDesc;// 话题图文信息
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public String getTopicDesc() {
		return topicDesc;
	}
	public void setTopicDesc(String topicDesc) {
		this.topicDesc = topicDesc;
	}
	@Override
	public String toString() {
		return "WebTopicDetail [topicId=" + topicId + ", topicDesc=" + topicDesc + "]";
	}
	
}
