package cn.edu.zju.ccnt.openapi.manage.action;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.domain.News;
import cn.edu.zju.ccnt.openapi.domain.Type;
import cn.edu.zju.ccnt.openapi.domain.User;
import cn.edu.zju.ccnt.openapi.util.QueryHelper;

/**
 * 
 * @author zheng
 * 2015年4月16日 下午4:42:45
 */
@Controller
@Scope("prototype")
public class ManageNewsAction extends BaseAction<News>{
	private Long userId;
	private String item;
	public String list() throws Exception {
		System.out.println("list");

		// 准备分页的News
		new QueryHelper(News.class, "n").preparePageBean(newsService, pageNum,
				pageSize);

		return "list";
	}
	
	public String addUI() throws Exception {

		// 转到添加页面
		System.out.println("addUI");
		return "addUI";
	}
	public void add() throws Exception {
		System.out.println("add");
		
		User user=userService.getById(userId);
		
		model.setAuthor(user);
		model.setPostTime(new Date());
		
		newsService.save(model);
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("插入成功!");
		
	}
	public void delete() throws Exception {
		System.out.println("this is in delete function");
		// 删除id的类型
		newsService.delete(model.getId());
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("删除成功!");

	}
	
	public String updateUI() throws Exception {

		System.out.println("updateUI");

		// 准备回显的数据
		model = newsService.getById(model.getId());
		ActionContext.getContext().put("news", model);
		return "updateUI";
	}
	
	public void update() throws Exception {

		System.out.println("update");

		// 修改数据
		News news=newsService.getById(model.getId());
		news.setTitle(model.getTitle());
		news.setContent(model.getContent());

		// 将修改后的数据存进数据库
		newsService.update(news);

		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("修改成功!");

	}
	/**
	 * 只查找title中还有item的news
	 * @return
	 * @throws Exception
	 */
	public String search() throws Exception {

		// 准备包含item的api
		new QueryHelper(News.class, "n").addCondition(
				"n.title like '%" + item + "%'")
		/*
		 * .addCondition("a.name like '%?%' or a.des like '%?%'", new
		 * Object[]{item,item})
		 */.preparePageBean(newsService, pageNum, pageSize);

		return "list";
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
