package me.codegc.manage.model;

/**
 * 系统管理员用户
 * @author ding
 */

public class Admin extends ModelObject {

	public Admin(String account, String password, byte type_id) {
		super(account, password, type_id);
	}
	
}
