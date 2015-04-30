package cn.edu.zju.ccnt.openapi.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.domain.Parameter;
import cn.edu.zju.ccnt.openapi.domain.Query;
import cn.edu.zju.ccnt.openapi.domain.ReturnParameter;
import cn.edu.zju.ccnt.openapi.domain.ServiceError;
import cn.edu.zju.ccnt.openapi.domain.SystemError;
import cn.edu.zju.ccnt.openapi.domain.Type;

/**
 * 
 * @author zheng
 * 2015年3月19日 下午3:08:44
 */
@Controller
@Scope("prototype")
public class QueryAction extends BaseAction<Query>{
	
	private Long apiId;
	private Long queryId;
	public String list() throws Exception{
		//准备当前的api
		Api api=apiService.getById(apiId);
		ActionContext.getContext().put("api", api);
		
		//准备该api的所有查询方式
		List<Query> queryList=null;
		queryList=queryService.getByApiId(apiId);
		ActionContext.getContext().put("queryList", queryList);
		
		//取出一种查询方式
		Query query=null;
		if(!queryList.isEmpty()) query=queryList.get(0);
		ActionContext.getContext().put("query", query);
		
		//取出该查询方式的参数
		List<Parameter>parameterList=null;
		if(query!=null){
			parameterList=parameterService.getByQueryId(query.getId());
		}
		ActionContext.getContext().put("parameterList", parameterList);
		
		//取出该查询方式的返回参数
		List<ReturnParameter> returnParamterList=null;
		if(query!=null){
			returnParamterList=returnParameterService.getByQueryId(query.getId());
		}
		ActionContext.getContext().put("returnParamterList", returnParamterList);
		
		List<SystemError> systemErrorList=null;
		systemErrorList=systemErrorService.findAll();
		ActionContext.getContext().put("systemErrorList", systemErrorList);
		
		List<ServiceError> serviceErrorList=null;
		serviceErrorList=serviceErrorService.getByApiId(api.getId());
		ActionContext.getContext().put("serviceErrorList", serviceErrorList);
		
		return "list";
	}
	
	public String listById() throws Exception{
		//取出当前id的Query
		Query query=null;
		query=queryService.getById(queryId);
		ActionContext.getContext().put("query", query);
		
		//取出该Query所属的Api
		Api api=query.getApi();
		ActionContext.getContext().put("api", api);
		
		//取出Api所有的Query
		List<Query> queryList=null;
		queryList=queryService.getByApiId(api.getId());
		ActionContext.getContext().put("queryList", queryList);
		
		//取出该查询方式的参数
		List<Parameter>parameterList=null;
		if(query!=null){
			parameterList=parameterService.getByQueryId(query.getId());
		}
		ActionContext.getContext().put("parameterList", parameterList);
				
		//取出该查询方式的返回参数
		List<ReturnParameter> returnParamterList=null;
		if(query!=null){
			returnParamterList=returnParameterService.getByQueryId(query.getId());
		}
		ActionContext.getContext().put("returnParamterList", returnParamterList);
		
		List<SystemError> systemErrorList=null;
		systemErrorList=systemErrorService.findAll();
		ActionContext.getContext().put("systemErrorList", systemErrorList);
		
		List<ServiceError> serviceErrorList=null;
		serviceErrorList=serviceErrorService.getByApiId(api.getId());
		ActionContext.getContext().put("serviceErrorList", serviceErrorList);
		
		
		return "list";
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
	
	

}
