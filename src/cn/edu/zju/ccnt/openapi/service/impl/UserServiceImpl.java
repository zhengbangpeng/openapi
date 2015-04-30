package cn.edu.zju.ccnt.openapi.service.impl;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Session;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.ccnt.openapi.base.DaoSupportImpl;
import cn.edu.zju.ccnt.openapi.domain.User;
import cn.edu.zju.ccnt.openapi.service.UserService;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

/**
 * 
 * @author zheng 2015年4月13日 下午1:30:55
 */
@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements
		UserService {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession()
				.createQuery("FROM User u WHERE u.username=?")
				.setParameter(0, username).uniqueResult();
	}

	@Override
	public void sendMail(User user) {
		// 把配置文件中的内容加载到prop中
		Properties prop = new Properties();

		try {
			prop.load(this.getClass().getClassLoader()
					.getResourceAsStream("email_template.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 登录邮件服务器，得到session
		String host = prop.getProperty("host");// 服务器主机名
		// System.out.println(host);
		final String name = prop.getProperty("username");// 登录用户名
		final String pass = prop.getProperty("password");// 登录密码
		// System.out.println("i ahere");
		Session session = null;
		session = MailUtils.createSession(host, name, pass);

		// System.out.println("i am here");
		/*
		 * 创建Mail对象
		 */
		String from = prop.getProperty("from");
		String to = user.getEmail();
		String subject = prop.getProperty("subject");
		// MessageForm.format方法会把第一个参数中的{0},使用第二个参数来替换
		String content = MessageFormat.format(prop.getProperty("content"),
				user.getUsername());
		Mail mail = new Mail(from, to, subject, content);

		// 发邮件

		try {
			MailUtils.send(session, mail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("发送邮件完成");
	}

	@Override
	public User findByLoginNameAndPassword(String username, String password) {
		// 使用密码的MD5摘要进行对比
		String md5Digest = DigestUtils.md5Hex(password);
		return (User) sessionFactory.getCurrentSession().createQuery(//
				"FROM User u WHERE u.username=? AND u.password=?")//
				.setParameter(0, username)//
				.setParameter(1, md5Digest)//
				.uniqueResult();
	}

}
