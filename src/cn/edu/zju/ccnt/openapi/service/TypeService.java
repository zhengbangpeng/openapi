package cn.edu.zju.ccnt.openapi.service;

import java.util.List;

import cn.edu.zju.ccnt.openapi.base.DaoSupport;
import cn.edu.zju.ccnt.openapi.domain.Type;
/**
 * 
 * @author zheng
 * 2015年3月18日 上午9:34:07
 */
public interface TypeService extends DaoSupport<Type>{
	//根据item查询相关的type
	List<Type> getByItem(String item);
}
