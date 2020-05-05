package com.jq.vo;


import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jq.constant.Constant;

public class EasyUIResult {

    private int  returnCode = 0;// 分页查询默认成功的
    
    private String returnMsg = "";
    
    private Integer total;

    private List<?> rows;

    public EasyUIResult() {
    }

    public EasyUIResult(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }
    
    public EasyUIResult(int returnCode, String returnMsg, Integer total, List<?> rows) {
    	this.returnCode = returnCode;
    	this.returnMsg = returnMsg;
        this.total = total;
        this.rows = rows;
    }

    public static EasyUIResult fail(int returnCode, String returnMsg){
      
    	return new EasyUIResult(returnCode, returnMsg, Constant.ZERO, null);
    }
    
    public static EasyUIResult success(Integer total, List<?> rows){
        
    	return new EasyUIResult(total, rows);
    }
    
    public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
 
}
