package me.codegc.manage.model;
/**
 * 所有用户的父类
 * @author ding
 */
public class ModelObject {
	
	@Override
	public String toString() {
		return "ModelObject [account=" + account + ", password=" + password + ", type_id=" + type_id + "]";
	}
	private String account;
	
	private String password;
	
	private byte type_id;
	
	public ModelObject(String account, String password, byte type_id) {
		super();
		this.account = account;
		this.password = password;
		this.type_id = type_id;
	}
	
	

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte getType_id() {
		return type_id;
	}
	public void setType_id(byte type_id) {
		this.type_id = type_id;
	}
	
}
