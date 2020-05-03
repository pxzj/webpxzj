package com.jq.mapper;

import com.jq.pojo.WebCase;
import com.jq.pojo.WebSubCase;

public interface CaseManageMapper {

     /*插入信息到案例表*/	
	  void insertMainCase(WebCase webCase);
	
	  /*插入信息到子案例表*/
	   void  insertSubCase(WebSubCase webSubCase);
}
