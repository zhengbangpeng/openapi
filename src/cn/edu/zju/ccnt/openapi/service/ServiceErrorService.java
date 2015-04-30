package cn.edu.zju.ccnt.openapi.service;

import java.util.List;

import cn.edu.zju.ccnt.openapi.base.DaoSupport;
import cn.edu.zju.ccnt.openapi.domain.ServiceError;
/**
 * 
 * @author zheng
 * 2015年3月20日 下午2:12:34
 */
public interface ServiceErrorService extends DaoSupport<ServiceError>{
	//根据apiId获取服务级错误码
	List<ServiceError> getByApiId(Long apiId);
}
