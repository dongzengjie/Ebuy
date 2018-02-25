package com.example.demo.dzj.ebuy.entity;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long newsId;
	private String content;
	private Date createTime;
	private String title;
	public Long getNewsId() {
		return newsId;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
