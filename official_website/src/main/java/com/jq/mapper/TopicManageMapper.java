package com.jq.mapper;

import com.jq.pojo.WebTopic;
import com.jq.pojo.WebTopicDetail;

public interface TopicManageMapper {

	
	/*新增话题表记录*/
	void  insertWebTopic(WebTopic webTopic);
	
	/*新增话题明细*/
    void  insertWebTopicDetail(WebTopicDetail webTopicDetail);
}
