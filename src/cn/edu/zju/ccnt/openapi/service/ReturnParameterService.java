package cn.edu.zju.ccnt.openapi.service;

import java.util.List;

import cn.edu.zju.ccnt.openapi.base.DaoSupport;
import cn.edu.zju.ccnt.openapi.domain.ReturnParameter;



/**
 * 
 * @author zheng
 * 2015年3月19日 下午7:25:22
 */
public interface ReturnParameterService extends DaoSupport<ReturnParameter>{
	//根据queryId获取返回参数
	List<ReturnParameter> getByQueryId(Long queryId);
}
