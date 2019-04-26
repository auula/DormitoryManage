package me.codegc.manage.enumeration;
/**
 * 请求状态枚举类
 * @author ding
 *
 */
public enum ActionStatus {
	
	LOGIN_ERROR(-1000,"账号和密码错误!"),
	LOGIN_SUCCESSFUL(1000,"登录成功！"),
	V_CODE_ERROR(-2000,"验证码错误！"),
	IDENTITY_TYPE_ID_ERROR(-3000,"身份类型错误！"),
	LIMITED_AUTHORITY(-4000,"权限错误!无相关操作权限！");
	
	
	private ActionStatus(int code,String mes) {
		this.code = code;
		this.message = mes;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private int code;
	private String message;
}
