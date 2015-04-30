package cn.edu.zju.ccnt.openapi.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.ccnt.openapi.base.DaoSupportImpl;
import cn.edu.zju.ccnt.openapi.domain.Query;
import cn.edu.zju.ccnt.openapi.service.QueryService;

/**
 * 
 * @author zheng
 * 2015年3月18日 下午7:10:57
 */
@Service
@Transactional
public class QueryServiceImpl extends DaoSupportImpl<Query> implements QueryService{
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<Query> getByApiId(Long apiId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(
				"FROM Query q WHERE q.api.id=?")
				.setParameter(0, apiId)
				.list();
	}

}
