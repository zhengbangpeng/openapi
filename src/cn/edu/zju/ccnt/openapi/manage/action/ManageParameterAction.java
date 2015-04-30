package cn.edu.zju.ccnt.openapi.manage.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;







import com.opensymphony.xwork2.ActionContext;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.domain.Parameter;
import cn.edu.zju.ccnt.openapi.domain.Query;
import cn.edu.zju.ccnt.openapi.domain.ServiceError;

/**
 * 
 * @author zheng
 * 2015年4月8日 下午3:58:24
 */
@Controller
@Scope("prototype")
public class ManageParameterAction extends BaseAction<Parameter>{
	private Long queryId;
	public String updateUI() throws Exception{
		System.out.println("updateUI");
		Parameter parameter = parameterService.getById(model.getId());
		ActionContext.getContext().put("parameter", parameter);
		return "updateUI";
	}
	
	public void update() throws Exception{
		System.out.println("update");
		// 修改数据
		Parameter parameter=parameterService.getById(model.getId());
		parameter.setName(model.getName());
		parameter.setDes(model.getDes());
		parameter.setType(model.getType());
		parameter.setRequired(model.getRequired());
		// 将修改后的数据存进数据库
		parameterService.update(parameter);
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("修改成功!");
		
	}
	public void delete() throws Exception{
		System.out.println("delete");
		// 删除数据
		parameterService.delete(model.getId());
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("删除成功!");
		
	}
	public String addUI() throws Exception{
		System.out.println("addUI");
		ActionContext.getContext().put("queryId", queryId);
		return "addUI";
		
	}
	public void add() throws Exception{
		System.out.println("add");
		System.out.println(queryId);
		
		Query query=queryService.getById(queryId);
		
		model.setQuery(query);
		
		parameterService.save(model);
		
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("添加成功!");
		
		
	}

	public Long getQueryId() {
		return queryId;
	}

	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}
	
}
