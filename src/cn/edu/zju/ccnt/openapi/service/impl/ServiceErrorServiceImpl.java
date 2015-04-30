package cn.edu.zju.ccnt.openapi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.ccnt.openapi.base.DaoSupportImpl;
import cn.edu.zju.ccnt.openapi.domain.ServiceError;
import cn.edu.zju.ccnt.openapi.service.ServiceErrorService;

/**
 * 
 * @author zheng
 * 2015年3月20日 下午2:14:07
 */

@Service
@Transactional
public class ServiceErrorServiceImpl extends DaoSupportImpl<ServiceError> implements ServiceErrorService{
	
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public List<ServiceError> getByApiId(Long apiId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(
				"FROM ServiceError s WHERE s.api.id=?")
				.setParameter(0, apiId)
				.list();
	}
	
}
