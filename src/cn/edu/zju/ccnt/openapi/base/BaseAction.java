package cn.edu.zju.ccnt.openapi.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;






import cn.edu.zju.ccnt.openapi.service.ApiService;
import cn.edu.zju.ccnt.openapi.service.NewsService;
import cn.edu.zju.ccnt.openapi.service.ParameterService;
import cn.edu.zju.ccnt.openapi.service.ProblemService;
import cn.edu.zju.ccnt.openapi.service.QueryService;
import cn.edu.zju.ccnt.openapi.service.ReplyService;
import cn.edu.zju.ccnt.openapi.service.ReturnParameterService;
import cn.edu.zju.ccnt.openapi.service.ServiceErrorService;
import cn.edu.zju.ccnt.openapi.service.SystemErrorService;
import cn.edu.zju.ccnt.openapi.service.TypeService;
import cn.edu.zju.ccnt.openapi.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	// =============== ModelDriven的支持 ==================

	protected T model;

	public BaseAction() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}

	// =============== Service实例的声明 ==================
/*	@Resource
	protected RoleService roleService;*/
	@Resource
	protected TypeService typeService;
	@Resource
	protected ApiService apiService;
	@Resource
	protected QueryService queryService;
	@Resource
	protected ParameterService parameterService;
	@Resource
	protected ReturnParameterService returnParameterService;
	@Resource
	protected ServiceErrorService serviceErrorService;
	@Resource
	protected SystemErrorService systemErrorService;
	@Resource
	protected UserService userService;
	@Resource
	protected NewsService newsService;
	@Resource
	protected ProblemService problemService;
	@Resource
	protected ReplyService replyService;
	
	

	/**
	 * 获取当前登录的用户
	 * 
	 * @return
	 */
	/*protected User getCurrentUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}*/

	// ============== 分页用的参数 =============

	protected int pageNum = 1; // 当前页
	protected int pageSize = 3; // 每页显示多少条记录

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
