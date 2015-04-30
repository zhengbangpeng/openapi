package cn.edu.zju.ccnt.openapi.manage.action;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.domain.ServiceError;
/**
 * 
 * @author zheng
 * 2015年4月8日 上午10:07:02
 */
@Controller
@Scope("prototype")
public class ManageServiceErrorAction extends BaseAction<ServiceError>{
	
	private Long apiId;
	public String updateUI() throws Exception{
		ServiceError serviceError=serviceErrorService.getById(model.getId());
		ActionContext.getContext().put("serviceError", serviceError);
		return "updateUI";
	}
	public void update() throws Exception{
		System.out.println("update");
		// 修改数据
		ServiceError serviceError=serviceErrorService.getById(model.getId());
		serviceError.setName(model.getName());
		serviceError.setDes(model.getDes());
		// 将修改后的数据存进数据库
		serviceErrorService.update(serviceError);
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("修改成功!");
		
	}
	public void delete() throws Exception{
		System.out.println("delete");
		// 删除数据
		serviceErrorService.delete(model.getId());
		
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
		
		serviceErrorService.save(model);
		
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("添加成功!");
		
		
	}
	
	
	public Long getApiId() {
		return apiId;
	}
	public void setApiId(Long apiId) {
		this.apiId = apiId;
	}
	
	
}
