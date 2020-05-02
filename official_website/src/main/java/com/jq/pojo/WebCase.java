package com.jq.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class WebCase {
	
	 private Long Id;// 自增主键ID
	 private String mainCasePhoto;// 主案例图片URL
	 private String subCasePhoto;// 子案例图片URL
	 private String projectName;// 项目名称
	 private int projectArea;// 项目面积
	 private Date endDate;// 项目结束时间
	 private String projectAddress;// 项目地址
	 private String designStyle;// 设计风格
	 private String mainMaterial;// 主要材料
	 private String designCompany;// 设计单位
	 private String designer;// 设计师
	 private String assistDisigner;// 辅助设计师
	 private String photographer;// 摄影师
	 private String sales;// 营销顾问
	 private Timestamp created;// 创建时间
	 private Timestamp updated;// 更新时间
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getMainCasePhoto() {
		return mainCasePhoto;
	}
	public void setMainCasePhoto(String mainCasePhoto) {
		this.mainCasePhoto = mainCasePhoto;
	}
	public String getSubCasePhoto() {
		return subCasePhoto;
	}
	public void setSubCasePhoto(String subCasePhoto) {
		this.subCasePhoto = subCasePhoto;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getProjectArea() {
		return projectArea;
	}
	public void setProjectArea(int projectArea) {
		this.projectArea = projectArea;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getProjectAddress() {
		return projectAddress;
	}
	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}
	public String getDesignStyle() {
		return designStyle;
	}
	public void setDesignStyle(String designStyle) {
		this.designStyle = designStyle;
	}
	public String getMainMaterial() {
		return mainMaterial;
	}
	public void setMainMaterial(String mainMaterial) {
		this.mainMaterial = mainMaterial;
	}
	public String getDesignCompany() {
		return designCompany;
	}
	public void setDesignCompany(String designCompany) {
		this.designCompany = designCompany;
	}
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	public String getAssistDisigner() {
		return assistDisigner;
	}
	public void setAssistDisigner(String assistDisigner) {
		this.assistDisigner = assistDisigner;
	}
	public String getPhotographer() {
		return photographer;
	}
	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
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
		return "WebCase [Id=" + Id + ", mainCasePhoto=" + mainCasePhoto + ", subCasePhoto=" + subCasePhoto
				+ ", projectName=" + projectName + ", projectArea=" + projectArea + ", endDate=" + endDate
				+ ", projectAddress=" + projectAddress + ", designStyle=" + designStyle + ", mainMaterial="
				+ mainMaterial + ", designCompany=" + designCompany + ", designer=" + designer + ", assistDisigner="
				+ assistDisigner + ", photographer=" + photographer + ", sales=" + sales + ", created=" + created
				+ ", updated=" + updated + "]";
	}
	 
	 
	 
	
}
