package cn.edu.zju.ccnt.openapi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.ccnt.openapi.base.DaoSupportImpl;
import cn.edu.zju.ccnt.openapi.domain.Parameter;
import cn.edu.zju.ccnt.openapi.service.ParameterService;
/**
 * 
 * @author zheng
 * 2015年3月18日 下午7:13:19
 */
@Service
@Transactional
public class ParameterServiceImpl extends DaoSupportImpl<Parameter> implements ParameterService{
	
	
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public List<Parameter> getByQueryId(Long queryId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(
				"from Parameter p where p.query.id=?")
				.setParameter(0, queryId)
				.list();
	}

}
