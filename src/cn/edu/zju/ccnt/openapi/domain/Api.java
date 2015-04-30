package cn.edu.zju.ccnt.openapi.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author zheng
 * 2015年3月17日 下午1:57:25
 * 
 * 一个API，包含多个查询方式（Query）
 */
public class Api {
	private Long id;
	private String name;
	private String des; //描述
	private Integer num; //该api查询方式的数量
	
	private String pictureUrl; //图片的url
	
	private Type type;   //该api所属的类型
	
	
	//该api所包含的查询方式
	private transient Set<Query> querys=new HashSet<Query>();
	
	private transient Set<ServiceError> serviceErrors=new HashSet<ServiceError>();


	public Api() {
		super();
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


	public String getDes() {
		return des;
	}


	public void setDes(String des) {
		this.des = des;
	}


	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
		this.num = num;
	}


	public String getPictureUrl() {
		return pictureUrl;
	}


	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public Set<Query> getQuerys() {
		return querys;
	}


	public void setQuerys(Set<Query> querys) {
		this.querys = querys;
	}


	public Set<ServiceError> getServiceErrors() {
		return serviceErrors;
	}


	public void setServiceErrors(Set<ServiceError> serviceErrors) {
		this.serviceErrors = serviceErrors;
	}

	
	
}
