package cn.edu.zju.ccnt.openapi.domain;
/**
 * 
 * @author zheng
 * 2015年4月13日 下午1:23:48
 */
public class User {
	private Long id;
	private String username;
	private String password;
	private String nickname;   //昵称
	private Integer isActive;  //是否激活  1：已激活  0：未激活
	private Integer userType;  //用户类型  0：超级管理员  1:管理员  2：普通用户
	private String email;  //邮件
	public User() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
