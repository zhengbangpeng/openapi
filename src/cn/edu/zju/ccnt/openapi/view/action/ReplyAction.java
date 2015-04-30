package cn.edu.zju.ccnt.openapi.view.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.Problem;
import cn.edu.zju.ccnt.openapi.domain.Reply;
import cn.edu.zju.ccnt.openapi.domain.User;

/**
 * 
 * @author zheng
 * 2015年4月17日 下午4:29:40
 */
@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply>{
	private Long userId;
	private Long problemId;
	public void add() throws Exception{
		System.out.println("add");
		//取得当前用户
		User user=userService.getById(userId);
		model.setAuthor(user);
		
		//设置所属问题
		Problem problem=problemService.getById(problemId);
		model.setProblem(problem);
		
		model.setPostTime(new Date());
		
		//存入数据库
		replyService.save(model);
		
		//问题的回复数+1
		problem.setReplyCount(problem.getReplyCount()+1);
		problemService.update(problem);
		
		//回写返回数据
		Map<String,String>data=new HashMap<String,String>();
		String msg="回复成功";
		
		data.put("msg", msg);
		String jsonText=JSON.toJSONString(data);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(jsonText);
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProblemId() {
		return problemId;
	}
	public void setProblemId(Long problemId) {
		this.problemId = problemId;
	}
	
	
	
}
