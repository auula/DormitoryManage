package me.codegc.manage.model;
/**
 * 所有用户的父类
 * @author ding
 */
public class ModelObject {
	

	private String account;
	
	private String password;
	
	private String usernName;
	
	private String phoneNumber;
	
	private String picURL;
	
	
	private byte typeID;

	
	
	public ModelObject(String account, String password, String usernName, String phoneNumber, String picURL,
			byte typeID) {
		super();
		this.account = account;
		this.password = password;
		this.usernName = usernName;
		this.phoneNumber = phoneNumber;
		this.picURL = picURL;
		this.typeID = typeID;
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


	public String getUsernName() {
		return usernName;
	}


	public void setUsernName(String usernName) {
		this.usernName = usernName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPicURL() {
		return picURL;
	}


	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}


	public byte getTypeID() {
		return typeID;
	}


	public void setTypeID(byte typeID) {
		this.typeID = typeID;
	}
	
	
	
}
