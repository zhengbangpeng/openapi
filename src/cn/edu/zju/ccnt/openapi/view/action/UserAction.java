package cn.edu.zju.ccnt.openapi.view.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.User;

/**
 * 
 * @author zheng
 * 2015年4月13日 下午1:33:52
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	private String userCode;
	public String registerUI() throws Exception{
		System.out.println("registerUI");
		return "registerUI";
	}
	public String loginUI() throws Exception{
		System.out.println("loginUI");
		return "loginUI";
	}
	public void logout() throws Exception{
		System.out.println("logout");
		ActionContext.getContext().getSession().remove("user");
	}
	public void login() throws Exception{
		System.out.println("login");
		Map<String,String>data=new HashMap<String,String>();
		String msg=null;
		System.out.println(model.getUsername());
		System.out.println(model.getPassword());
		User user=userService.findByLoginNameAndPassword(model.getUsername(),model.getPassword());
		System.out.println("here");
		if(user==null){
			msg="用户名或密码错误";
		}else{
			if(user.getIsActive()==0){
				msg="该帐号未激活";
			}else{
				ActionContext.getContext().getSession().put("user", user);
			}
		}
		data.put("msg", msg);
		String jsonText=JSON.toJSONString(data);
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(jsonText);
	}
	public String activation() throws Exception{
		System.out.println("activation");
		String username=model.getUsername();
		System.out.println("username");
		User user=userService.getByUsername(username);
		String msg=null;
		if(user==null){
			msg="该用户不存在";
		}else{
			if(user.getIsActive()!=0){
				msg="该帐号已激活过";
			}else{
				user.setIsActive(1);
				userService.update(user);
				msg="激活成功";
			}
		}
		ActionContext.getContext().put("msg", msg);
		return "activation";
	}
	public void register() throws Exception{
		System.out.println("register");
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();
		response.setContentType("text/plain;charset=UTF-8");
		//response.getWriter().write("删除成功!");
		
		//取得用户输入的验证码
		String vCode=(String) request.getSession().getAttribute("vCode");
		//System.out.println(vCode);
		//System.out.println(vCode);
		//if(uCode==null) uCode=(String) request.getParameter("uCode");
		System.out.println(userCode);
		
		if(!vCode.equalsIgnoreCase(userCode)){
			response.getWriter().write("验证码错误");
			//System.out.println("验证码错误");
			return;
		}
		
		//System.out.println("I am here1");
		String username=model.getUsername();
		
		if(userService.getByUsername(username)!=null){
			//System.out.println("用户名已存在");
			response.getWriter().write("用户名已存在");
			return;
		}
		
		model.setIsActive(0);
		model.setPassword(DigestUtils.md5Hex(model.getPassword()));
		
		//System.out.println("I am here3");
		model.setUserType(2);  //用户类型  0：超级管理员  1:管理员  2：普通用户
		
		//System.out.println("验证完毕");
		userService.save(model);
		//System.out.println("I am here5");
		userService.sendMail(model);
		response.getWriter().write("注册成功,需激活后登录");
		return;
		
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	
	
	
}
