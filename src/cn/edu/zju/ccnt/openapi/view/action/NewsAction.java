package cn.edu.zju.ccnt.openapi.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.domain.News;
import cn.edu.zju.ccnt.openapi.domain.Type;
import cn.edu.zju.ccnt.openapi.util.QueryHelper;
/**
 * 
 * @author zheng
 * 2015年4月16日 下午4:41:39
 */
@Controller
@Scope("prototype")
public class NewsAction extends BaseAction<News>{
	public String list() throws Exception{
		
		System.out.println("list");
		
		//准备分页的api
		new QueryHelper(News.class, "n")
		.addOrderProperty("postTime", false)
		.preparePageBean(newsService, pageNum, pageSize);
		
		return "list";
	}
	public String listById() throws Exception{
		
		//根据id取得news
		model=newsService.getById(model.getId());
		ActionContext.getContext().put("news", model);
		
		return "listNews";
	}
}
