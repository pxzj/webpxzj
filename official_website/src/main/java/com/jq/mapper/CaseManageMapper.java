package com.jq.mapper;

import java.util.List;

import com.jq.pojo.WebCase;
import com.jq.pojo.WebSubCase;
import com.jq.pojo.WebTopic;

public interface CaseManageMapper {

     /*插入信息到案例表*/	
	  void insertMainCase(WebCase webCase);
	
	  /*插入信息到子案例表*/
	   void  insertSubCase(WebSubCase webSubCase);
	   
	   /*查询所有的案例*/
	    List<WebCase> selectAllCase();
	    
	    /*查询所有的案例总数目*/
	    Integer selectCaseCount();
	    
	    /*分页查询案例记录*/
	    List<WebCase> findCaseByPage(Integer begin, Integer pageSize);
	    
	    /*根据主案例ID删除主案例表信息*/
	    void  deleteWebCase(Long mainCaseId);
	    
	    /*根据主案例ID删除子案例表信息*/
	   void deleteWebSubCase(Long mainCaseId);
}
