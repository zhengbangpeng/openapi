package cn.edu.zju.ccnt.openapi.manage.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.SystemError;

import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @author zheng
 * 2015年4月9日 上午10:14:02
 */
@Controller
@Scope("prototype")
public class ManageSystemErrorAction extends BaseAction<SystemError>{
	public String updateUI() throws Exception{
		
		SystemError systemError=systemErrorService.getById(model.getId());
		ActionContext.getContext().put("systemError", systemError);
		return "updateUI";
	}
	public void update() throws Exception{
		System.out.println("update");
		// 修改数据
		SystemError systemError=systemErrorService.getById(model.getId());
		systemError.setName(model.getName());
		systemError.setDes(model.getDes());
		
		// 将修改后的数据存进数据库
		systemErrorService.update(systemError);
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("修改成功!");
		
	}
	public void delete() throws Exception{
		System.out.println("delete");
		// 删除数据
		systemErrorService.delete(model.getId());
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("删除成功!");
		
	}
	public String addUI() throws Exception{
		System.out.println("addUI");
		return "addUI";
		
	}
	public void add() throws Exception{
		System.out.println("add");
		
		systemErrorService.save(model);
		
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("添加成功!");
		
		
	}
}
