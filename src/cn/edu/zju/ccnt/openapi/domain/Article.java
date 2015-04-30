package cn.edu.zju.ccnt.openapi.domain;

import java.util.Date;



/**
 * 
 * @author zheng
 * 2015年4月17日 下午3:28:36
 */
public class Article {
	private Long id;
	private String title; // 标题
	private String content;// 内容
	private User author;// 作者
	private Date postTime;// 发表时间
	public Article() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	
}
