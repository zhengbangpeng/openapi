package cn.edu.zju.ccnt.openapi.service;

import cn.edu.zju.ccnt.openapi.base.DaoSupport;
import cn.edu.zju.ccnt.openapi.domain.User;

/**
 * 
 * @author zheng
 * 2015年4月13日 下午1:29:46
 */
public interface UserService extends DaoSupport<User>{
	//根据用户名查找用户
	User getByUsername(String username);
	
	//发送邮件
	void sendMail(User model);
	//根据用户名和密码查询用户
	User findByLoginNameAndPassword(String username, String password);
}
