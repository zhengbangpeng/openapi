package cn.edu.zju.ccnt.openapi.view.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.domain.Problem;
import cn.edu.zju.ccnt.openapi.domain.Reply;
import cn.edu.zju.ccnt.openapi.domain.User;
import cn.edu.zju.ccnt.openapi.util.QueryHelper;
/**
 * 
 * @author zheng
 * 2015年4月17日 下午4:29:13
 */
@Controller
@Scope("prototype")
public class ProblemAction extends BaseAction<Problem>{
	private Long userId;
	private String item;
	public String list() throws Exception{
		System.out.println("list");
		
		//准备分页数据
		new QueryHelper(Problem.class, "p")
		.addOrderProperty("postTime", false)
		.preparePageBean(problemService, pageNum, pageSize);
		return "list";
	}
	public String search() throws Exception{
		System.out.println("search");
		
		//准备分页数据
		new QueryHelper(Problem.class, "p")
		.addCondition("p.title like '%"+item+"%' or p.content like '%"+item+"%'")
		.addOrderProperty("postTime", false)
		.preparePageBean(problemService, pageNum, pageSize);
		return "list";
	}
	public String listByReplyCount() throws Exception{
		System.out.println("listByReplyCount");
		
		//准备分页数据
		new QueryHelper(Problem.class, "p")
		.addOrderProperty("replyCount", false)
		.preparePageBean(problemService, pageNum, pageSize);
		return "listByReplyCount";
	}
	public String listByViews() throws Exception{
		System.out.println("listByViews");
		
		//准备分页数据
		new QueryHelper(Problem.class, "p")
		.addOrderProperty("views", false)
		.preparePageBean(problemService, pageNum, pageSize);
		return "listByViews";
	}
	public String listById() throws Exception{
		System.out.println("listById");
		
		//取得当前问题
		Problem problem=problemService.getById(model.getId());
		ActionContext.getContext().put("problem", problem);
		
		problem.setViews(problem.getViews()+1);
		problemService.update(problem);
		
		
		List<Reply> replyList=null;
		replyList=replyService.findByProblemId(problem.getId());
		ActionContext.getContext().put("replyList", replyList);
		return "listById";
	}
	public String askUI() throws Exception{
		System.out.println("askUI");
		return "askUI";
	}
	public String listMy() throws Exception{
		System.out.println("listMy");
		System.out.println(userId);
		//查找并准备该用户的问题 
		List<Problem> problemList=null;
		problemList=problemService.findByUserId(userId);
		
		System.out.println(problemList.size());
		ActionContext.getContext().put("problemList", problemList);
		
		return "listMy";
	}
	
	public void ask() throws Exception{
		System.out.println("ask");
		//取得当前用户
		User user=userService.getById(userId);
		
		model.setAuthor(user);
		model.setPostTime(new Date());
		model.setReplyCount(0);
		model.setViews(0);
		
		problemService.save(model);
		
		//回写返回数据
		Map<String,String>data=new HashMap<String,String>();
		String msg="提问成功";
		
		data.put("msg", msg);
		String jsonText=JSON.toJSONString(data);
		// 回写返回数据
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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	
	
	
}
