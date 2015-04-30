package cn.edu.zju.ccnt.openapi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.ccnt.openapi.base.DaoSupportImpl;
import cn.edu.zju.ccnt.openapi.domain.Reply;
import cn.edu.zju.ccnt.openapi.service.ReplyService;
/**
 * 
 * @author zheng
 * 2015年4月17日 下午4:28:22
 */
@Service
@Transactional
public class ReplyServiceImpl extends DaoSupportImpl<Reply> implements ReplyService{
	
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public List<Reply> findByProblemId(Long problemId) {
		return sessionFactory.getCurrentSession().createQuery(
				"FROM Reply r WHERE r.problem.id=? order by r.postTime asc")
				.setParameter(0, problemId)
				.list();
	}

}
