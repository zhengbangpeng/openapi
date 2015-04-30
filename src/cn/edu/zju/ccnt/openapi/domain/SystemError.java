package cn.edu.zju.ccnt.openapi.domain;


/**
 * 
 * @author zheng
 * 2015年3月20日 下午1:47:52
 */
public class SystemError {
	private Long id;
	private String name;  //该错误码名称，即编号
	private String des;
	
	
	public SystemError() {
		super();
	}
	
	
	public SystemError(String name, String des) {
		super();
		this.name = name;
		this.des = des;
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
	
	
}
