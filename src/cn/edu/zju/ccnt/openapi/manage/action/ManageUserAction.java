package cn.edu.zju.ccnt.openapi.manage.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.User;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @author zheng
 * 2015年4月16日 上午11:14:35
 */
@Controller
@Scope("prototype")
public class ManageUserAction extends BaseAction<User>{
	public void login() throws Exception{
		System.out.println("manageLogin");
		Map<String,String>data=new HashMap<String,String>();
		String msg=null;
		
		//根据用户名和密码查找用户
		User user=userService.findByLoginNameAndPassword(model.getUsername(),model.getPassword());
		if(user==null){
			msg="用户名或密码错误";
		}else{
			if(user.getIsActive()==0){
				msg="该帐号未激活";
			}else{
				if(user.getUserType()==2){
					msg="该帐号权限不足";
				}else{
					ActionContext.getContext().getSession().put("user", user);
				}
			}
		}
		data.put("msg", msg);
		String jsonText=JSON.toJSONString(data);
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(jsonText);
	}
	
	public String index() throws Exception{
		System.out.println("index");
		return "index";
	}
	public String logout() throws Exception{
		System.out.println("logout");
		ActionContext.getContext().getSession().remove("user");
		return "login";
	}
}
