package cn.edu.zju.ccnt.openapi.service;

import java.util.List;

import cn.edu.zju.ccnt.openapi.base.DaoSupport;
import cn.edu.zju.ccnt.openapi.domain.Parameter;

/**
 * 
 * @author zheng
 * 2015年3月18日 下午5:12:47
 */
public interface ParameterService extends DaoSupport<Parameter>{
	
	//根据queryId获取请求参数
	List<Parameter> getByQueryId(Long queryId);
}
