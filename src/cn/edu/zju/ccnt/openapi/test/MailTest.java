package cn.edu.zju.ccnt.openapi.test;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.Session;

import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

public class MailTest {
	public static void main(String[] args) {
		System.out.println("sendMail");
		//把配置文件中的内容加载到prop中
		Properties prop = new Properties();
		try {
			prop.load(new MailTest().getClass().getClassLoader().getResourceAsStream("email_template.properties"));
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}
		
		//登录邮件服务器，得到session
		String host = prop.getProperty("host");//服务器主机名
		System.out.println(host);
		String name = prop.getProperty("username");//登录用户名
		String pass = prop.getProperty("password");//登录密码
		System.out.println("i ahere");
		Session session=null;
		try{
		session = cn.itcast.mail.MailUtils.createSession(host, name, pass);
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		System.out.println("i am here");
		/*
		 * 创建Mail对象
		 */
		String from = prop.getProperty("from");
		String to = "971816095@qq.com";
		String subject = prop.getProperty("subject");
		// MessageForm.format方法会把第一个参数中的{0},使用第二个参数来替换
		String content = MessageFormat.format(prop.getProperty("content"),"zheng");
		Mail mail = new Mail(from, to, subject, content);
		
		//发邮件
		try {
			MailUtils.send(session, mail);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("完成");
	}

}
