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
    private String topicPhoto;// 话题照片URL
    private String height;// 高度
    private String width;// 宽度
    private Timestamp created;// 创建时间
    private Timestamp updated;// 更新时间
    // 非数据库字段，仅页面使用
	 public String imgurl;
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
	
	public String getTopicPhoto() {
		return topicPhoto;
	}
	public void setTopicPhoto(String topicPhoto) {
		this.topicPhoto = topicPhoto;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
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
				+ ", workDate=" + workDate + ", topicPhoto=" + topicPhoto + ", height=" + height + ", width=" + width
				+ ", created=" + created + ", updated=" + updated + "]";
	}

}
