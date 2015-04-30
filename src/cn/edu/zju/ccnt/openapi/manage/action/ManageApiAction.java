package cn.edu.zju.ccnt.openapi.manage.action;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zju.ccnt.openapi.base.BaseAction;
import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.domain.Parameter;
import cn.edu.zju.ccnt.openapi.domain.Query;
import cn.edu.zju.ccnt.openapi.domain.ReturnParameter;
import cn.edu.zju.ccnt.openapi.domain.ServiceError;
import cn.edu.zju.ccnt.openapi.domain.SystemError;
import cn.edu.zju.ccnt.openapi.domain.Type;
import cn.edu.zju.ccnt.openapi.util.DeCompressUtil;
import cn.edu.zju.ccnt.openapi.util.QueryHelper;

/**
 * 
 * @author zheng 2015年4月2日 下午2:04:23
 */
@Controller
@Scope("prototype")
public class ManageApiAction extends BaseAction<Api> {

	private File image;
	private String imageFileName;

	private String item;

	private Long typeId;

	private Long queryId;

	private Query query;

	public String list() throws Exception {

		System.out.println("list");

		// 准备所有的api数据
		/*
		 * List<Api> apiList = null; apiList = apiService.findAll();
		 * System.out.println(apiList.size());
		 * ActionContext.getContext().put("apiList", apiList);
		 */

		// 准备分页的api
		new QueryHelper(Api.class, "a").preparePageBean(apiService, pageNum,
				pageSize);

		return "list";
	}

	public void delete() throws Exception {
		/* System.out.println("this is in delete function"); */

		// 根据id获取该api对象
		model = apiService.getById(model.getId());

		// 删除id的类型
		apiService.delete(model.getId());

		// 更新type中api的数量
		Type type = model.getType();
		// System.out.println(type.getNum());
		type.setNum(type.getNum() - 1);
		// System.out.println(type.getNum());
		typeService.update(type);

		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("删除成功!");

	}

	public String addUI() throws Exception {

		// 准备所有的type数据
		List<Type> typeList = null;
		typeList = typeService.findAll();
		ActionContext.getContext().put("typeList", typeList);

		// 转到添加页面
		System.out.println("addUI");
		return "addUI";
	}

	public void add() throws Exception {

		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/img");
		System.out.println(realPath);

		String newFileName = UUID.randomUUID().toString() + "."
				+ FilenameUtils.getExtension(imageFileName);
		FileUtils.copyFile(image, new File(realPath + File.separator
				+ newFileName));

		model.setPictureUrl("/img/" + newFileName);
		model.setNum(0);

		Type type = typeService.getById(typeId);
		model.setType(type);
		type.setNum(type.getNum() + 1);

		apiService.save(model);
		typeService.update(type);
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("插入成功!");
	}

	public String search() throws Exception {

		// 准备包含item的api
		new QueryHelper(Api.class, "a").addCondition(
				"a.name like '%" + item + "%' or a.des like '%" + item + "%'")
		/*
		 * .addCondition("a.name like '%?%' or a.des like '%?%'", new
		 * Object[]{item,item})
		 */.preparePageBean(apiService, pageNum, pageSize);

		return "search";
	}

	public String updateUI() throws Exception {

		System.out.println("updateUI");

		// 准备回显的数据
		model = apiService.getById(model.getId());
		ActionContext.getContext().put("api", model);

		// 准备所有的type
		List<Type> typeList = null;
		typeList = typeService.findAll();
		ActionContext.getContext().put("typeList", typeList);

		return "updateUI";
	}

	public void update() throws Exception {

		System.out.println("update");

		// 修改数据
		Api api = apiService.getById(model.getId());
		api.setName(model.getName());
		api.setDes(model.getDes());

		Type newType = typeService.getById(typeId);
		Type oldType = api.getType();

		api.setType(newType);
		newType.setNum(newType.getNum() + 1);
		oldType.setNum(oldType.getNum() - 1);

		if (imageFileName != null) {
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/img");
			System.out.println(realPath);

			String newFileName = UUID.randomUUID().toString() + "."
					+ FilenameUtils.getExtension(imageFileName);
			FileUtils.copyFile(image, new File(realPath + File.separator
					+ newFileName));

			api.setPictureUrl("/img/" + newFileName);
		}

		// 将修改后的数据存进数据库
		typeService.update(newType);
		typeService.update(oldType);

		apiService.update(api);

		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("修改成功!");

	}

	public String showDetail() throws Exception {

		Long apiId = model.getId();
		// 准备当前的api
		Api api = apiService.getById(apiId);
		ActionContext.getContext().put("api", api);

		// 准备该api的所有查询方式
		List<Query> queryList = null;
		queryList = queryService.getByApiId(apiId);
		ActionContext.getContext().put("queryList", queryList);

		// 取出一种查询方式
		query = null;
		if (!queryList.isEmpty())
			query = queryList.get(0);
		// 将string转换为json格式
		/*
		 * String json=query.getJsonExample().replace("\n", "<br>");
		 * query.setJsonExample(json);
		 */

		ActionContext.getContext().put("query", query);

		// 取出该查询方式的参数
		List<Parameter> parameterList = null;
		if (query != null) {
			parameterList = parameterService.getByQueryId(query.getId());
		}
		ActionContext.getContext().put("parameterList", parameterList);

		// 取出该查询方式的返回参数
		List<ReturnParameter> returnParamterList = null;
		if (query != null) {
			returnParamterList = returnParameterService.getByQueryId(query
					.getId());
		}
		ActionContext.getContext()
				.put("returnParamterList", returnParamterList);

		List<SystemError> systemErrorList = null;
		systemErrorList = systemErrorService.findAll();
		ActionContext.getContext().put("systemErrorList", systemErrorList);

		List<ServiceError> serviceErrorList = null;
		serviceErrorList = serviceErrorService.getByApiId(api.getId());
		ActionContext.getContext().put("serviceErrorList", serviceErrorList);
		return "showDetail";
	}

	public String showByQueryId() throws Exception {
		// 取出当前id的Query
		query = null;
		query = queryService.getById(queryId);

		// 将string转换为json格式
		/*
		 * String json=query.getJsonExample().replace("\n", "<br>");
		 * query.setJsonExample(json);
		 */

		ActionContext.getContext().put("query", query);

		// 取出该Query所属的Api
		Api api = query.getApi();
		ActionContext.getContext().put("api", api);

		// 取出Api所有的Query
		List<Query> queryList = null;
		queryList = queryService.getByApiId(api.getId());
		ActionContext.getContext().put("queryList", queryList);

		// 取出该查询方式的参数
		List<Parameter> parameterList = null;
		if (query != null) {
			parameterList = parameterService.getByQueryId(query.getId());
		}
		ActionContext.getContext().put("parameterList", parameterList);

		// 取出该查询方式的返回参数
		List<ReturnParameter> returnParamterList = null;
		if (query != null) {
			returnParamterList = returnParameterService.getByQueryId(query
					.getId());
		}
		ActionContext.getContext()
				.put("returnParamterList", returnParamterList);

		List<SystemError> systemErrorList = null;
		systemErrorList = systemErrorService.findAll();
		ActionContext.getContext().put("systemErrorList", systemErrorList);

		List<ServiceError> serviceErrorList = null;
		serviceErrorList = serviceErrorService.getByApiId(api.getId());
		ActionContext.getContext().put("serviceErrorList", serviceErrorList);

		return "showDetail";
	}

	public String uploadUI() throws Exception {
		return "uploadUI";
	}

	public void upload() throws Exception {
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/apiFile");
		System.out.println(realPath);
		// 更改文件名称
		String newFileName = UUID.randomUUID().toString() + "."
				+ FilenameUtils.getExtension(imageFileName);
		// 路径+名称
		String fullPath = realPath + File.separator + newFileName;
		File file = new File(fullPath);
		FileUtils.copyFile(image, file);

		// 解压文件
		String destDir = realPath + File.separator
				+ newFileName.substring(0, newFileName.lastIndexOf("."));
		DeCompressUtil.deCompress(fullPath, destDir);

		File fileDir = new File(destDir);
		File[] files = fileDir.listFiles();
		for (File f : files) {
			if (f.getName().endsWith(".xml")) {
				analyze(f);
			}
		}

		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write("上传成功!");
	}

	// 解析xml文件
	private void analyze(File f)  {
		SAXReader reader = new SAXReader();
		Document document=null;
		try {
			document = reader.read(f);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 读取api内容
		Api api = new Api();
		apiService.save(api);

		Node typeIdNode = document.selectSingleNode("/api/typeId");
		Long typeId = Long.parseLong(typeIdNode.getText());
		Type type = typeService.getById(typeId);
		api.setType(type);
		type.setNum(type.getNum() + 1);

		Node nameNode = document.selectSingleNode("/api/name");
		api.setName(nameNode.getText());
		
		Node desNode = document.selectSingleNode("/api/des");
		api.setDes(desNode.getText());

		Node numNode = document.selectSingleNode("/api/num");
		api.setNum(Integer.parseInt(numNode.getText()));
		
		//System.out.println("I am here1");
		
		//处理图片：将图片复制到img下   然后将路径赋值到api.pictureUrl中
		Node pictureUrlNode = document.selectSingleNode("/api/pictureUrl");
		// 图片所在位置
		imageFileName = f.getParent() + File.separator
				+ pictureUrlNode.getText();
		image=new File(imageFileName);
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/img");
		String newFileName = UUID.randomUUID().toString() + "."
				+ FilenameUtils.getExtension(imageFileName);
		
		
		try {
			FileUtils.copyFile(image, new File(realPath + File.separator
					+ newFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("I am here2");
		
		api.setPictureUrl("/img/" + newFileName);
		
		

		List<Node> querysNode=document.selectNodes("/api/querys/query");
		for(Node queryNode:querysNode){
			Query query=new Query();
			queryService.save(query);
			query.setApi(api);
			
			nameNode=queryNode.selectSingleNode("name");
			query.setName(nameNode.getText());
			
			Node supportTypeNode=queryNode.selectSingleNode("supportType");
			query.setSupportType(supportTypeNode.getText());
			
			Node queryExampleNode=queryNode.selectSingleNode("queryExample");
			query.setQueryExample(queryExampleNode.getText());
			
			Node requestTypeNode=queryNode.selectSingleNode("requestType");
			query.setRequestType(requestTypeNode.getText());
			
			Node keywordsNode=queryNode.selectSingleNode("keywords");
			query.setKeywords(keywordsNode.getText());
			
			Node urlNode=queryNode.selectSingleNode("url");
			query.setUrl(urlNode.getText());
			
			//System.out.println("I am here3");
			
			Node jsonExampleNode=queryNode.selectSingleNode("jsonExample");
			query.setJsonExample(jsonExampleNode.getText());
			
			List<Node> parametersNode=queryNode.selectNodes("parameters/parameter");
			for(Node parameterNode:parametersNode){
				
				
				
				
				Parameter parameter=new Parameter();
				parameterService.save(parameter);
				parameter.setQuery(query);
				
				//System.out.println("I am here4");
				
				nameNode=parameterNode.selectSingleNode("name");
				parameter.setName(nameNode.getText());
				
				//System.out.println("I am here5");
				
				Node typeNode=parameterNode.selectSingleNode("type");
				parameter.setType(typeNode.getText());
				
				//System.out.println("I am here6");
				
				Node requiredNode=parameterNode.selectSingleNode("required");
				parameter.setRequired(Integer.valueOf(requiredNode.getText()));
				
				//System.out.println("I am here7");
				
				desNode=parameterNode.selectSingleNode("des");
				parameter.setDes(desNode.getText());
				
				//System.out.println("I am here8");
				
				parameterService.update(parameter);
				
				//System.out.println("I am here9");
				
			}
			
			List<Node> returnParametersNode=queryNode.selectNodes("returnParameters/returnParameter");
			for(Node returnParameterNode:returnParametersNode){
				ReturnParameter returnParameter=new ReturnParameter();
				returnParameterService.save(returnParameter);
				returnParameter.setQuery(query);
				
				nameNode=returnParameterNode.selectSingleNode("name");
				returnParameter.setName(nameNode.getText());
				
				Node typeNode=returnParameterNode.selectSingleNode("type");
				returnParameter.setType(typeNode.getText());
				
				
				desNode=returnParameterNode.selectSingleNode("des");
				returnParameter.setDes(desNode.getText());
				
				returnParameterService.update(returnParameter);
				
				
				
			}
			queryService.update(query);
		}
		List<Node> serviceErrorsNode=document.selectNodes("/api/serviceErrors/serviceError");
		for(Node serviceErrorNode:serviceErrorsNode){
			ServiceError serviceError=new ServiceError();
			serviceError.setApi(api);
			
			nameNode=serviceErrorNode.selectSingleNode("name");
			serviceError.setName(nameNode.getText());
			
			desNode=serviceErrorNode.selectSingleNode("des");
			serviceError.setDes(desNode.getText());
			
			serviceErrorService.save(serviceError);
		}
		
		apiService.update(api);
		typeService.update(type);
		
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
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

	public Long getQueryId() {
		return queryId;
	}

	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public static void main(String[] args) throws Exception {
		// System.out.println("/apiFile/阿阿.xml");
		File file = new File("config/阿阿.xml");
		new ManageApiAction().analyze(file);

	}

}
