package cn.edu.zju.ccnt.openapi.util;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zju.ccnt.openapi.domain.Api;
import cn.edu.zju.ccnt.openapi.domain.Parameter;
import cn.edu.zju.ccnt.openapi.domain.Query;
import cn.edu.zju.ccnt.openapi.domain.ReturnParameter;
import cn.edu.zju.ccnt.openapi.domain.ServiceError;
import cn.edu.zju.ccnt.openapi.domain.SystemError;
import cn.edu.zju.ccnt.openapi.domain.Type;
import cn.edu.zju.ccnt.openapi.domain.User;

/**
 * 
 * @author zheng
 * 2015年3月18日 上午9:37:59
 */
@Component
public class Installer {
	
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 执行安装
	 */
	@Transactional
	public void install() {
		Session session = sessionFactory.getCurrentSession();
		//添加超级用户
		User user=new User();
		user.setUsername("zheng");
		user.setPassword(DigestUtils.md5Hex("1234"));
		user.setNickname("zheng");
		user.setUserType(0);
		user.setIsActive(1);
		user.setEmail("admin@qq.com");
		session.save(user);
		
		
		Type type;
		Api api=new Api();
		Query query1=new Query();
		Query query2=new Query();
		Parameter para1=new Parameter("cardno", "string", 1, "身份证号码", query1);
		Parameter para2=new Parameter("dtype", "string", 1, "返回数据格式：json或xml,默认json", query1);
		
		ReturnParameter rpara1=new ReturnParameter("area","string","籍贯",query1);
		ReturnParameter rpara2=new ReturnParameter("birthday","string","出生年月",query1);
		
		type=new Type("生活常用");
		type.setDes("这是生活常用分类");
		
		api.setName("身份证查询");
		api.setNum(1);
		api.setDes("身份证归属地信息查询");
		api.setPictureUrl("/img/2.png");
		api.setType(type);
		
		//插入菜谱大全api
		Api api2=new Api();
		api2.setName("菜谱大全");
		api2.setNum(0);
		api2.setDes("上万种菜色供您选择");
		api2.setPictureUrl("/img/6.png");
		api2.setType(type);
		session.save(api2);
		
		//插入常用快递api
		api2=new Api();
		api2.setName("常用快递");
		api2.setNum(0);
		api2.setDes("目前暂支持EMS、圆通、顺丰、申通、中通、韵达、天天，其他快递陆续添加中...");
		api2.setPictureUrl("/img/7.png");
		api2.setType(type);
		session.save(api2);
		
		//插入手机号码归属地api
		api2=new Api();
		api2.setName("手机号码归属地");
		api2.setNum(0);
		api2.setDes("查询手机号码的归属地信息");
		api2.setPictureUrl("/img/8.png");
		api2.setType(type);
		session.save(api2);
		
		//插入ip地址api
		api2=new Api();
		api2.setName("IP地址");
		api2.setNum(0);
		api2.setDes("根据查询的IP地址或者域名，查询该IP所属的区域");
		api2.setPictureUrl("/img/9.png");
		api2.setType(type);
		session.save(api2);
		
		//插入餐饮美食api
		api2=new Api();
		api2.setName("餐饮美食");
		api2.setNum(0);
		api2.setDes("提供周边美食餐厅检索");
		api2.setPictureUrl("/img/10.png");
		api2.setType(type);
		session.save(api2);
		
		//插入苹果序列号api
		api2=new Api();
		api2.setName("苹果序列号");
		api2.setNum(0);
		api2.setDes("苹果序列号查询、苹果产品信息查询");
		api2.setPictureUrl("/img/11.png");
		api2.setType(type);
		session.save(api2);
		
		ServiceError se1=new ServiceError("203801","请输入正确的15或18位身份证",api);
		ServiceError se2=new ServiceError("203802","错误的身份证或无结果",api);
		ServiceError se3=new ServiceError("203803","身份证校验位不正确",api);
		ServiceError se4=new ServiceError("203804","查询失败",api);
		
		type.setNum(7);
		
		query1.setApi(api);
		query1.setName("身份证信息查询");
		query1.setJsonExample("{\n\"resultcode\":\"200\",\n\"reason\":\"成功的返回\",\n\"result\":{\"area\":\"浙江省温州市平阳县\",\n\"sex\":\"男\",\n\"birthday\":\"1989年03月08日\"\n}\n}");
		query1.setQueryExample("http://apis.juhe.cn/idcard/index?key=您申请的KEY&cardno=330326198903081211");
		query1.setSupportType("JSON/XML");
		query1.setUrl("http://apis.juhe.cn/idcard/index");
		query1.setRequestType("GET");
		
		
		
		
		session.save(type);
		session.save(api);
		session.save(query1);
		session.save(para2);
		session.save(para1);
		session.save(rpara1);
		session.save(rpara2);
		
		session.save(se1);
		session.save(se2);
		session.save(se3);
		session.save(se4);
		
		
		//插入另一个分类(Type)
		type=new Type("天气预报");
		type.setDes("这是天气预报分类");
		
		api=new Api();
		api.setDes("全国天气查询API");
		api.setName("全国天气预报");
		api.setNum(2);
		api.setPictureUrl("/img/1.png");
		api.setType(type);
		
		//插入空气质量api
		api2=new Api();
		api2.setName("空气质量");
		api2.setNum(0);
		api2.setDes("城市空气质量、城市空气PM2.5指数、城市辐射指数");
		api2.setPictureUrl("/img/3.png");
		api2.setType(type);
		session.save(api2);
		
		//插入天气预报api
		api2=new Api();
		api2.setName("天气预报");
		api2.setNum(0);
		api2.setDes("全国天气预报，生活指数、实况、PM2.5等信息");
		api2.setPictureUrl("/img/4.png");
		api2.setType(type);
		session.save(api2);
		
		//插入水质量api
		api2=new Api();
		api2.setName("水质量");
		api2.setNum(0);
		api2.setDes("流域查询水质量，监测站点查询水质量 ");
		api2.setPictureUrl("/img/5.png");
		api2.setType(type);
		session.save(api2);
		
		type.setNum(4);
		
		
		
		query1=new Query();
		
		query1.setApi(api);
		query1.setName("根据城市名/id查询天气");
		query1.setJsonExample("{\n\"resultcode\":\"200\",\n\"reason\":\"成功的返回\",\n\"result\":{\"area\":\"浙江省温州市平阳县\",\n\"sex\":\"男\",\n\"birthday\":\"1989年03月08日\"\n}\n}");
		query1.setQueryExample("http://v.juhe.cn/weather/index?format=2&cityname=%E8%8B%8F%E5%B7%9E&key=您申请的KEY");
		query1.setSupportType("JSON/XML");
		query1.setUrl("http://v.juhe.cn/weather/index");
		query1.setRequestType("GET");
		
		para1=new Parameter("cityname", "string", 1, "城市名或城市ID，如：\"苏州\"", query1);
		para2=new Parameter("dtype", "string", 1, "返回数据格式：json或xml,默认json", query1);
		Parameter para3=new Parameter("format", "int", 0, " 	未来6天预报(future)两种返回格式，1或2，默认1", query1);
		
		//第二个query
		Parameter para4=new Parameter("dtype","string",0,"返回数据的格式,xml或json,默认json",query2);
		rpara1=new ReturnParameter("error_code","int","返回码",query2);
		rpara2=new ReturnParameter("reason", "string", "返回说明", query2);
		
		query2.setApi(api);
		query2.setName("天气种类及标识列表");
		query2.setJsonExample("{\n\"resultcode\":\"200\",\n\"reason\":\"成功的返回\",\n\"result\":{\"area\":\"浙江省温州市平阳县\",\n\"sex\":\"男\",\n\"birthday\":\"1989年03月08日\"\n}\n}");
		query2.setQueryExample("http://v.juhe.cn/weather/uni");
		query2.setSupportType("JSON/XML");
		query2.setUrl("http://v.juhe.cn/weather/index");
		query2.setRequestType("HHTP GET");
		
		
		ServiceError ser1=new ServiceError("203901","查询城市不能为空",api);
		ServiceError ser2=new ServiceError("203902","查询不到该城市的天气",api);
		ServiceError ser3=new ServiceError("203903","查询出错，请重试",api);
		ServiceError ser4=new ServiceError("203904","错误的GPS坐标",api);
		ServiceError ser5=new ServiceError("203904","GPS坐标解析出错，请确认提供的坐标正确（暂支持国内）",api);
		ServiceError ser6=new ServiceError("203904","IP地址错误",api);
		
		session.save(type);
		session.save(api);
		session.save(query1);
		session.save(para1);
		session.save(para2);
		session.save(para3);
		
		session.save(para4);
		session.save(rpara1);
		session.save(rpara2);
		session.save(query2);
		
		session.save(ser1);
		session.save(ser2);
		session.save(ser3);
		session.save(ser4);
		session.save(ser5);
		session.save(ser6);
		
		
		SystemError sy1=new SystemError("10001","错误的OPENID");
		SystemError sy2=new SystemError("10002","应用未审核超时，请提交认证");
		SystemError sy3=new SystemError("10003","未知的请求源");
		SystemError sy4=new SystemError("10004","被禁止的IP");
		SystemError sy5=new SystemError("10005","请求超过次数限制");
		session.save(sy1);
		session.save(sy2);
		session.save(sy3);
		session.save(sy4);
		session.save(sy5);	
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
	}
}
