package com.jq.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class WebTopicDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8430482713930609972L;
	
	
	private  Long topicId; // 话题ID
	private  String topicDesc;// 话题图文信息
	private Timestamp created;// 创建时间
	private  Timestamp updated; //更新时间
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
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "WebTopicDetail [topicId=" + topicId + ", topicDesc=" + topicDesc + ", created=" + created + ", updated="
				+ updated + "]";
	}
	
}
