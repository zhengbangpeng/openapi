package cn.edu.zju.ccnt.openapi.view.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.domain.Parameter;
import cn.edu.zju.ccnt.openapi.domain.Query;
import cn.edu.zju.ccnt.openapi.domain.Type;









import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @author zheng
 * 2015年4月10日 下午2:33:05
 */
@Controller
@Scope("prototype")
public class ApiTestAction extends BaseAction<Api> {
	
	//jackson
    //private JsonGenerator jsonGenerator = null;
   // private ObjectMapper objectMapper = null;
	
	private Long typeId;
	private Long apiId;
	private Long queryId;
	private String url;
	public String list() throws Exception{
		
		//准备所有的分类数据
		List<Type> typeList=null;
		typeList=typeService.findAll();
		ActionContext.getContext().put("typeList", typeList);
		
		//准备所有的api数据
		List<Api>apiList=null;
		apiList=apiService.findAll();
		ActionContext.getContext().put("apiList", apiList);
		
		return "list";
		
	}
	
	public void changeType() throws Exception{
		System.out.println("changeType");
		List<Api>apiList=null;
		apiList=apiService.getByTypeId(typeId);
		
		String jsonText=JSON.toJSONString(apiList, true);
		
		System.out.println(jsonText);
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(jsonText);
	}
	public void getJson() throws Exception{
		System.out.println("getJson");
		System.out.println(url);
		StringBuilder json = new StringBuilder();  
        try {  
            URL urlObject = new URL(url);  
            URLConnection uc = urlObject.openConnection();  
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));  
            String inputLine = null;  
            while ( (inputLine = in.readLine()) != null) {  
                json.append(inputLine);  
            }  
            in.close();  
        } catch (Exception e) {  
            throw e;  
        } 
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(json.toString());
	}
	public void changeApi() throws Exception{
		System.out.println("changeApi");
		List<Query>queryList=null;
		queryList=queryService.getByApiId(apiId);
		
		String jsonText=JSON.toJSONString(queryList, true);
		
		System.out.println(jsonText);
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(jsonText);
	}
	
	public void changeQuery() throws Exception{
		System.out.println("changeQuery");
		List<Parameter>parameterList=null;
		parameterList=parameterService.getByQueryId(queryId);
		
		String jsonText=JSON.toJSONString(parameterList, true);
		
		System.out.println(jsonText);
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(jsonText);
	}
	
	
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	
	
	public Long getApiId() {
		return apiId;
	}

	public void setApiId(Long apiId) {
		this.apiId = apiId;
	}
	public Long getQueryId() {
		return queryId;
	}

	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static void main(String[] args) {
		Type type=new Type();
		type.setName("类型");
		type.setDes("这是一个类型");
		
		Api api=new Api();
		api.setName("ap");
		api.setDes("这是一个api");
		
		api.setType(type);
		
		Set<Api> apis=new HashSet<Api>();
		apis.add(api);
		
		type.setApis(apis);
		
		String str=JSON.toJSONString(type);
		
		System.out.println(str);
		
		
	}
	
	
}
