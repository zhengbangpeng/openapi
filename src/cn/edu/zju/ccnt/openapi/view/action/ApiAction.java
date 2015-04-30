package cn.edu.zju.ccnt.openapi.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.domain.Type;
import cn.edu.zju.ccnt.openapi.util.QueryHelper;
/**
 * 
 * @author zheng
 * 2015年3月18日 下午8:26:21
 */
@Controller
@Scope("prototype")
public class ApiAction extends BaseAction<Api>{
	
	private Long typeId;
	private String item;
	public String list() throws Exception{
		//准备所有的分类数据
		List<Type> typeList=null;
		typeList=typeService.findAll();
		ActionContext.getContext().put("typeList", typeList);
		
		//准备所得的api
		/*List<Api>apiList=null;
		apiList=apiService.findAll();
		ActionContext.getContext().put("apiList", apiList);*/
		
		//准备分页的api
		new QueryHelper(Api.class, "a").preparePageBean(apiService, pageNum, pageSize);
		
		
		//查询api的总数
		int totalNum=apiService.getTotalNum();
		ActionContext.getContext().put("totalNum", totalNum);
		
		
		return "list";
	}
	
	public String test() throws Exception{
		String str="Hello,world!!";
		ActionContext.getContext().put("str", str);
		return "test";
	}
	
	public String search() throws Exception{
		//准备所有的分类数据
		List<Type> typeList=null;
		typeList=typeService.findAll();
		ActionContext.getContext().put("typeList", typeList);
		
		//准备包含item的api
		/*List<Api>apiList=null;
		apiList=apiService.getByItem(item);
		ActionContext.getContext().put("apiList", apiList);*/
		
		//准备分页的api
		new QueryHelper(Api.class, "a")
		.addCondition("a.name like '%"+item+"%' or a.des like '%"+item+"%'")
/*		.addCondition("a.name like '%?%' or a.des like '%?%'", new Object[]{item,item})
*/		.preparePageBean(apiService, pageNum, pageSize);
		
		//查询api的总数
		int totalNum=apiService.getTotalNum();
		ActionContext.getContext().put("totalNum", totalNum);
		
		
		return "search";
	}
	
	public String listByType() throws Exception{
		//准备所有的分类数据
		List<Type> typeList=null;
		typeList=typeService.findAll();
		ActionContext.getContext().put("typeList", typeList);
		System.out.println(typeList);
		
		//根据typeId准备该分类的api
		/*List<Api>apiList=null;
		apiList=apiService.getByTypeId(typeId);
		ActionContext.getContext().put("apiList", apiList);*/
		
		//准备分页数据
		new QueryHelper(Api.class, "a")
		.addCondition("a.type.id=?", typeId)
		.preparePageBean(apiService, pageNum, pageSize);
		
		//查询api的总数
		int totalNum=apiService.getTotalNum();
		ActionContext.getContext().put("totalNum", totalNum);
		System.out.println(totalNum);
		
		//准备该type的数据
		Type type=typeService.getById(typeId);
		ActionContext.getContext().put("type", type);
		
		return "listType";
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	
	
}



