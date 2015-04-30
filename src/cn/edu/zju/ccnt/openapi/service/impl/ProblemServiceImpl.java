package cn.edu.zju.ccnt.openapi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.ccnt.openapi.base.DaoSupportImpl;
import cn.edu.zju.ccnt.openapi.domain.Problem;
import cn.edu.zju.ccnt.openapi.service.ProblemService;

/**
 * 
 * @author zheng
 * 2015年4月17日 下午4:24:08
 */
@Service
@Transactional
public class ProblemServiceImpl extends DaoSupportImpl<Problem> implements ProblemService{
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<Problem> findByUserId(Long userId) {
		return sessionFactory.getCurrentSession().createQuery(
				"FROM Problem p WHERE p.author.id=?")
				.setParameter(0, userId)
				.list();
	}

}
