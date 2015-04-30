package cn.edu.zju.ccnt.openapi.manage.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.domain.Parameter;
import cn.edu.zju.ccnt.openapi.domain.Query;

import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @author zheng
 * 2015年4月8日 下午7:45:03
 */
@Controller
@Scope("prototype")
public class ManageQueryAction extends BaseAction<Query>{
	private Long apiId;
	public String updateUI() throws Exception{
		System.out.println("updateUI");
		Query query=queryService.getById(model.getId());
		ActionContext.getContext().put("query", query);
		return "updateUI";
	}
	
	public void update() throws Exception{
		System.out.println("update");
		// 修改数据
		Query query=queryService.getById(model.getId());
		query.setName(model.getName());
		query.setJsonExample(model.getJsonExample());
		query.setQueryExample(model.getQueryExample());
		query.setRequestType(model.getRequestType());
		query.setSupportType(model.getSupportType());
		query.setUrl(model.getUrl());
		query.setKeywords(model.getKeywords());
		
		// 将修改后的数据存进数据库
		queryService.update(query);
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("修改成功!");
		
	}
	public void delete() throws Exception{
		System.out.println("delete");
		// 删除数据
		Api api = queryService.getById(model.getId()).getApi();
		api.setNum(api.getNum()-1);
		
		queryService.delete(model.getId());
		apiService.update(api);
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("删除成功!");
		
	}
	public String addUI() throws Exception{
		System.out.println("addUI");
		ActionContext.getContext().put("apiId", apiId);
		return "addUI";
		
	}
	public void add() throws Exception{
		System.out.println("add");
		System.out.println(apiId);
		
		
		Api api=apiService.getById(apiId);
		
		
		model.setApi(api);
		api.setNum(api.getNum()+1);
		
		queryService.save(model);
		apiService.update(api);
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("添加成功!");
		
		
	}
	
	public String updateKeywordsUI() throws Exception{
		System.out.println("updateKeywordsUI");
		
		//准备query数据
		Query query=queryService.getById(model.getId());
		ActionContext.getContext().put("query", query);
		
		return "updateKeywordsUI";
	}
	public void updateKeywords() throws Exception{
		System.out.println("updateKeywords");
		//修改关键字
		Query query=queryService.getById(model.getId());
		query.setKeywords(model.getKeywords());
		//更新数据库
		queryService.update(query);
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("修改成功!");
	}

	public Long getApiId() {
		return apiId;
	}

	public void setApiId(Long apiId) {
		this.apiId = apiId;
	}
	
	
}
