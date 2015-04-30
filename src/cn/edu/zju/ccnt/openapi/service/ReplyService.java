package cn.edu.zju.ccnt.openapi.service;

import java.util.List;

import cn.edu.zju.ccnt.openapi.base.DaoSupport;
import cn.edu.zju.ccnt.openapi.domain.Reply;
/**
 * 
 * @author zheng
 * 2015年4月17日 下午4:23:30
 */
public interface ReplyService extends DaoSupport<Reply> {
	//根据问题查找回复
	List<Reply> findByProblemId(Long problemId);

}
