package cn.edu.zju.ccnt.openapi.domain;
/**
 * 
 * @author zheng
 * 2015年3月17日 下午2:06:23
 * 
 * 一条请求参数
 */
public class Parameter {
	private Long id;
	private String name;
	private String type;  //参数类型
	private Integer required; //参数是否必须  1：必须   0：可选
	private String des;  //参数说明
	
	//该参数所属的查询参数
	private Query query;

	public Parameter() {
		super();
	}
	
	

	



	public Parameter(String name, String type, Integer required, String des,
			Query query) {
		super();
		this.name = name;
		this.type = type;
		this.required = required;
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

	public Integer getRequired() {
		return required;
	}

	public void setRequired(Integer required) {
		this.required = required;
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
