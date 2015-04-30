package cn.edu.zju.ccnt.openapi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.ccnt.openapi.base.DaoSupportImpl;
import cn.edu.zju.ccnt.openapi.domain.Type;
import cn.edu.zju.ccnt.openapi.service.TypeService;

/**
 * 
 * @author zheng
 * 2015年3月18日 上午9:34:30
 */
@Service
@Transactional
public class TypeServiceImpl extends DaoSupportImpl<Type> implements TypeService{
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<Type> getByItem(String item) {
		// TODO Auto-generated method stub
		String sql="from Type a where a.name like '%"+item+"%' or a.des like '%"+item+"%'";
		return sessionFactory.getCurrentSession().createQuery(
				sql)
				.list();
	}

}
