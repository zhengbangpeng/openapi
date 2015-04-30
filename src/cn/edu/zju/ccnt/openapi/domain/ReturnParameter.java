package cn.edu.zju.ccnt.openapi.domain;

/**
 * 
 * @author zheng
 * 2015年3月19日 下午7:12:06
 */
public class ReturnParameter {
	private Long id;
	private String name;
	private String type;  //参数类型
	private String des;  //参数说明
	
	//该参数所属的查询参数
	private Query query;

	public ReturnParameter() {
		super();
	}
	
	

	public ReturnParameter(String name, String type, String des, Query query) {
		super();
		this.name = name;
		this.type = type;
		this.des = des;
		this.query = query;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}
	
	
}
