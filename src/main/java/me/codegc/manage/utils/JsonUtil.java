package me.codegc.manage.utils;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

/**
 * Json工具类
 * @author ding
 */
public class JsonUtil implements Serializable{
	private static Logger log = Logger.getLogger(JsonUtil.class);
	/**
	 * 序列号id
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * response相应输出json字符串
	 * @param response
	 * @param data 返回数据实体
	 */
	public static void outJson(HttpServletResponse response,Object data) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		try {
			response.getWriter().write(JSON.toJSONString(data));
		} catch (IOException e) {
			log.error("response相应输出json字符串发生异常 :" + e.getMessage());
		}
	}
}
