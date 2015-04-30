package cn.edu.zju.ccnt.openapi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.ccnt.openapi.base.DaoSupportImpl;
import cn.edu.zju.ccnt.openapi.domain.ReturnParameter;
import cn.edu.zju.ccnt.openapi.service.ReturnParameterService;
/**
 * 
 * @author zheng
 * 2015年3月19日 下午7:32:30
 */
@Service
@Transactional
public class ReturnParameterServiceImpl extends DaoSupportImpl<ReturnParameter> implements ReturnParameterService{
	
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public List<ReturnParameter> getByQueryId(Long queryId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(
				"from ReturnParameter p where p.query.id=?")
				.setParameter(0, queryId)
				.list();
	}

}
