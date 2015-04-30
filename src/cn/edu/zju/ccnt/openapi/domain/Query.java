package cn.edu.zju.ccnt.openapi.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author zheng
 * 2015年3月17日 下午2:02:51
 * 
 * 某个api的一种查询方式
 */
public class Query {
	private Long id;
	private String name;
	private String supportType; //支持格式
	private String queryExample; //请求示例
	private String requestType;   //请求方式
	private String url;
	private String jsonExample; //json示例
	
	private String keywords;   //关键字  以","隔开
	
	//该查询方式所属的Api
	private Api api;
	
	//该查询方式的请求参数
	private transient Set<Parameter>parameters=new HashSet<Parameter>();
	
	private transient Set<ReturnParameter>returnParameters=new HashSet<ReturnParameter>();

	public Query() {
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



	public String getSupportType() {
		return supportType;
	}



	public void setSupportType(String supportType) {
		this.supportType = supportType;
	}



	public String getQueryExample() {
		return queryExample;
	}



	public void setQueryExample(String queryExample) {
		this.queryExample = queryExample;
	}



	public String getRequestType() {
		return requestType;
	}



	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getJsonExample() {
		return jsonExample;
	}



	public void setJsonExample(String jsonExample) {
		this.jsonExample = jsonExample;
	}



	public Api getApi() {
		return api;
	}



	public void setApi(Api api) {
		this.api = api;
	}



	public Set<Parameter> getParameters() {
		return parameters;
	}



	public void setParameters(Set<Parameter> parameters) {
		this.parameters = parameters;
	}



	public Set<ReturnParameter> getReturnParameters() {
		return returnParameters;
	}



	public void setReturnParameters(Set<ReturnParameter> returnParameters) {
		this.returnParameters = returnParameters;
	}



	public String getKeywords() {
		return keywords;
	}



	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	
	
	
	
}
