package cn.edu.zju.ccnt.openapi.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author zheng
 * 2015年3月17日 下午1:57:41
 */
public class Type {
	private Long id;
	private String name;
	private Integer num;  //这个类型api的数量
	private String des;  //描述
	
	//该类型包含的api
	private transient Set<Api> apis=new HashSet<Api>();

	public Type() {
		super();
	}
	

	public Type(String name) {
		super();
		this.name = name;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Set<Api> getApis() {
		return apis;
	}

	public void setApis(Set<Api> apis) {
		this.apis = apis;
	}


	public String getDes() {
		return des;
	}


	public void setDes(String des) {
		this.des = des;
	}


	
	
	
	

}
