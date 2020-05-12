package com.jq.pojo;

import java.beans.Transient;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;


public class WebTopic implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8096923622580982466L;		
	private  int titleId;
    private Long snId;// 自增主键
    private String title;// 话题标题
    private String author;// 话题作者
    private Date workDate;// 摄影师
    private Timestamp created;// 创建时间
    private Timestamp updated;// 更新时间
    
	@Transient
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	public Long getSnId() {
		return snId;
	}
	public void setSnId(Long snId) {
		this.snId = snId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
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
		return "WebTopic [titleId=" + titleId + ", snId=" + snId + ", title=" + title + ", author=" + author
				+ ", workDate=" + workDate + ", created=" + created + ", updated=" + updated + "]";
	}


}
