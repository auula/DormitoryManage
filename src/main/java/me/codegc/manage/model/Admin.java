package me.codegc.manage.model;

/**
 * 系统管理员用户
 * @author ding
 */

public class Admin extends ModelObject {

	
	public Admin(String account, String password, String usernName, String phoneNumber, String picURL, byte typeID) {
		super(account, password, usernName, phoneNumber, picURL, typeID);
	}

	
	
}
