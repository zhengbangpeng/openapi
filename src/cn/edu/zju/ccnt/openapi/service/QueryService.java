package cn.edu.zju.ccnt.openapi.service;

import java.util.List;

import cn.edu.zju.ccnt.openapi.base.DaoSupport;
import cn.edu.zju.ccnt.openapi.domain.Query;
/**
 * 
 * @author zheng
 * 2015年3月18日 下午5:11:42
 */
public interface QueryService extends DaoSupport<Query>{
	
	//根据apiId获取查询方式集合
	List<Query> getByApiId(Long apiId);
}
