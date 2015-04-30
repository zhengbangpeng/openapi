package cn.edu.zju.ccnt.openapi.view.action;



import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.vcode.utils.VerifyCode;


/**
 * 
 * @author zheng
 * 2015年4月13日 下午9:23:46
 */
@Controller
@Scope("prototype")
public class VerifyCodeAction {
	
	public void getVerifyCode() throws Exception{
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();//获取一次性验证码图片
		// 该方法必须在getImage()方法之后来调用
//		System.out.println(vc.getText());//获取图片上的文本
		
		
		
		
		
		// 回写返回数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("image/jpeg;charset=UTF-8");
		VerifyCode.output(image, response.getOutputStream());//把图片写到指定流中
		
		// 把文本保存到session中，为LoginServlet验证做准备
		ServletActionContext.getRequest().getSession().setAttribute("vCode", vc.getText());
	}
}



