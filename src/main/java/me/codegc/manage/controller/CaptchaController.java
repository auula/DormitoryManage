package me.codegc.manage.controller;

import java.awt.Font;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.utils.CaptchaUtil;

/**
 * 验证码处理器
 * @author ding
 *
 */
public class CaptchaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 使用第三方EasyCaptcha验证码库 生成gif验证码并且返回
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置宽、高、位数
        //CaptchaUtil.out(50, 25, 4, req, resp);
        
        
		// 设置请求头为输出图片类型
        CaptchaUtil.setHeader(resp);
        
        // 三个参数分别为宽、高、位数
        GifCaptcha Captcha = new GifCaptcha(50, 25, 4);
        
        // 设置字体
        Captcha.setFont(new Font("Verdana", Font.PLAIN, 18));  // 有默认字体，可以不用设置
        
        // 设置类型，纯数字、纯字母、字母数字混合
        Captcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
        // 验证码存入session
        req.getSession().setAttribute("_captcha", Captcha.text());
        
        // 输出图片流
        Captcha.out(resp.getOutputStream());
	}
	

}
