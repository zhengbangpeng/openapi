package cn.edu.zju.ccnt.openapi.service;

import java.util.List;

import cn.edu.zju.ccnt.openapi.base.DaoSupport;
import cn.edu.zju.ccnt.openapi.domain.Api;


/**
 * 
 * @author zheng
 * 2015年3月18日 下午5:10:59
 */
public interface ApiService extends DaoSupport<Api>{
	
	//获取表中的api总数
	int getTotalNum();
	
	//根据typeId获取api
	List<Api> getByTypeId(Long typeId);
	
	//根据item查询相关的api
	List<Api> getByItem(String item);

}
