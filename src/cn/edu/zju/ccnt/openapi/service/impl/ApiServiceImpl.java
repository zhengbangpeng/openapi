package cn.edu.zju.ccnt.openapi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.ccnt.openapi.base.DaoSupportImpl;
import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.service.ApiService;
/**
 * 
 * @author zheng
 * 2015年3月18日 下午5:14:43
 */
@Service
@Transactional
public class ApiServiceImpl extends DaoSupportImpl<Api> implements ApiService{
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public int getTotalNum() {
		// TODO Auto-generated method stub
		return ((Long) sessionFactory.getCurrentSession().createQuery(
				"select count(id) from Api").iterate().next()).intValue();
	}
	
	public static void main(String[] args) {
		
	}

	@Override
	public List<Api> getByTypeId(Long typeId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(
				"FROM Api a WHERE a.type.id=?")
				.setParameter(0, typeId)
				.list();
	}

	@Override
	public List<Api> getByItem(String item) {
		// TODO Auto-generated method stub
		String sql="from Api a where a.name like '%"+item+"%' or a.des like '%"+item+"%'";
		return sessionFactory.getCurrentSession().createQuery(
				sql)
				.list();
	}

}
