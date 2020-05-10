package com.jq.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.jq.pojo.WebTopic;
import com.jq.pojo.WebTopicDetail;
@Component
public class TopicInfomation implements  Serializable{

private WebTopic webTopic;
private WebTopicDetail webTopicDetail;
public WebTopic getWebTopic() {
	return webTopic;
}
public void setWebTopic(WebTopic webTopic) {
	this.webTopic = webTopic;
}
public WebTopicDetail getWebTopicDetail() {
	return webTopicDetail;
}
public void setWebTopicDetail(WebTopicDetail webTopicDetail) {
	this.webTopicDetail = webTopicDetail;
}
@Override
public String toString() {
	return "TopicInfomation [webTopic=" + webTopic + ", webTopicDetail=" + webTopicDetail + "]";
}


}
