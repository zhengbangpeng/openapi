package cn.edu.zju.ccnt.openapi.domain;

/**
 * 
 * @author zheng
 * 2015年3月20日 下午1:42:41
 */
public class ServiceError {
	private Long id;
	private String name;  //错误码名称，即编号
	private String des;
	//该错误码所属的Api
	private Api api;
	public ServiceError() {
		super();
	}
	public ServiceError(String name, String des, Api api) {
		super();
		this.name = name;
		this.des = des;
		this.api = api;
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
	public Api getApi() {
		return api;
	}
	public void setApi(Api api) {
		this.api = api;
	}
	
	
	
	
}
