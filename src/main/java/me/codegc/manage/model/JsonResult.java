package me.codegc.manage.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * httpAPI请求返回Json格式实体
 * 
 * @author DinGo
 *
 */
public class JsonResult implements Serializable {

	private static final long serialVersionUID = -3516782973138523502L;

	private int status;
	
	private String message;
	
	private Map<String, Object> result;

	public JsonResult(int status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.result = new HashMap<>();
	}

	public static JsonResult init(int code,String mes) {
		return new JsonResult(code, mes);
	}
	
	public JsonResult add(String key,Object value) {
		this.result.put(key, value);
		return this;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	
	
}
