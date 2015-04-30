package cn.edu.zju.ccnt.openapi.service;

import java.util.List;

import cn.edu.zju.ccnt.openapi.base.DaoSupport;
import cn.edu.zju.ccnt.openapi.domain.Problem;
/**
 * 
 * @author zheng
 * 2015年4月17日 下午4:22:46
 */
public interface ProblemService extends DaoSupport<Problem>{
	
	//根据userId查找问题
	List<Problem> findByUserId(Long userId);

}
