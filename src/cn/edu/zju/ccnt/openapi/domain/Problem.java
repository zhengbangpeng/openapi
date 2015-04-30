package cn.edu.zju.ccnt.openapi.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author zheng
 * 2015年4月17日 下午4:00:04
 */
public class Problem extends Article {
	private Set<Reply> replies = new HashSet<Reply>();
	private int replyCount;// 回复数量
	private int views;     //浏览量
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
	
}
