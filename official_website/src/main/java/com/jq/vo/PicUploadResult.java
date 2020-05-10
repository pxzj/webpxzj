package com.jq.vo;

import java.util.List;

import com.jq.constant.Constant;

public class PicUploadResult {
	
    private Integer error = Constant.ZERO;		//0表示无异常，1代表异常
    
    
    private List<Photo> data; // 支持返回多个照片的路径
 
    public PicUploadResult(){
    	
    }
    public PicUploadResult( List<Photo> data){
    	this.data = data;
    } 
    
   public PicUploadResult(int error, List<Photo> data){
    	this.error = error;
    	this.data = data;
    }

   public static PicUploadResult  fail(int error, List<Photo> data){
	   return new PicUploadResult(error, data);
   }
   
   public static PicUploadResult success(List<Photo> data){
	   return new PicUploadResult(data);
   }
   
	public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }
	public List<Photo> getData() {
		return data;
	}
	public void setData(List<Photo> data) {
		this.data = data;
	}

}
