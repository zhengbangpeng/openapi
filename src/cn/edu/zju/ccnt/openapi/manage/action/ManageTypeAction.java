package cn.edu.zju.ccnt.openapi.manage.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.domain.Type;
import cn.edu.zju.ccnt.openapi.util.QueryHelper;

/**
 * 
 * @author zheng 2015年4月1日 上午9:27:32
 */
@Controller
@Scope("prototype")
public class ManageTypeAction extends BaseAction<Type> {
	
	private String item;
	public String list() throws Exception {

		
		// 准备所有的分类数据
		List<Type> typeList = null;
		typeList = typeService.findAll();
		ActionContext.getContext().put("typeList", typeList);
				
				
		return "list";
	}
	
	public String search() throws Exception {
		
		// 准备包含item的type
		List<Type> typeList = null;
		typeList=typeService.getByItem(item);
		ActionContext.getContext().put("typeList", typeList);
				
				
		return "list";
	}
	public String addUI() throws Exception {
		
		//转到添加页面
		System.out.println("addUI");
		return "addUI";
	}
	public void add() throws Exception{
		
		//设置该类型api数量为0
		model.setNum(0);
		
		//插入数据库
		typeService.save(model);
		
		//回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse(); 
		response.setContentType("text/plain;charset=UTF-8"); 
		response.getWriter().write("插入成功!");
	}
	public void delete() throws Exception{
		
		
		//删除id的类型
		typeService.delete(model.getId());
		/*HttpServletRequest request=ServletActionContext.getRequest();
		
		System.out.println(request.getAttribute("id"));*/
		
		//回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse(); 
		response.setContentType("text/plain;charset=UTF-8"); 
		response.getWriter().write("删除成功!");
		
	}
	
	public String updateUI() throws Exception{
		
		System.out.println("updateUI");
		
		//准备回显的数据
		model=typeService.getById(model.getId());
		ActionContext.getContext().put("type", model);
		
		return "updateUI";
	}
	public void update() throws Exception{
		
		System.out.println("update");
		
		//修改数据
		Type type=typeService.getById(model.getId());
		type.setName(model.getName());
		type.setDes(model.getDes());
		
		//将修改后的type存进数据库
		typeService.update(type);
		
		//回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse(); 
		response.setContentType("text/plain;charset=UTF-8"); 
		response.getWriter().write("修改成功!");
		
		
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	
	
}
